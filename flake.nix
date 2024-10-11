{
  description = "A Nix flake for Maven and JDK on Linux and macOS (nix-darwin)";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable"; # You can adjust this version/branch as needed
  };

  outputs = { self, nixpkgs }: let

    # Define a helper function to create a shell environment
    mkDevShell = system: let
      pkgs = import nixpkgs { inherit system; };
    in pkgs.mkShell {
      buildInputs = [
        pkgs.maven
        pkgs.openjdk
      ];

      shellHook = ''
        echo "Maven and JDK have been added to the environment on ${system}."
      '';
    };

    # Define systems supported
    supportedSystems = [
      "x86_64-linux"
      "aarch64-darwin"
    ];

  in rec {
    # Packages for supported systems
    packages = builtins.listToAttrs (map (system: {
      name = system;
      value = {
        defaultPackage = mkDevShell system;
      };
    }) supportedSystems);

    # Default app, switching based on the current system
    defaultApp = {
      type = "app";
      program = "${self.packages.${builtins.currentSystem}.defaultPackage}/bin/mvn";
    };

    # Development shells for supported systems, with 'default' key for each system
    devShells = builtins.listToAttrs (map (system: {
      name = system;
      value = {
        default = mkDevShell system; # Explicitly define 'default'
      };
    }) supportedSystems);
  };
}

