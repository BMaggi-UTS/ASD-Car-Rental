{
  description = "A Nix flake for Maven and JDK";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable"; # Update to the desired version or branch
  };

  outputs = { self, nixpkgs }: {
    packages.x86_64-linux = let
      pkgs = import nixpkgs { system = "x86_64-linux"; };
    in {
      defaultPackage = pkgs.mkShell {
        buildInputs = [
          pkgs.maven
          pkgs.openjdk
        ];

        shellHook = ''
          echo "Maven and JDK have been added to the environment."
        '';
      };
    };

    # Optional: Default app or development environment
    defaultApp = {
      type = "app";
      program = "${self.packages.x86_64-linux.defaultPackage}/bin/mvn";
    };

    # Optional: Development shell
    devShells.x86_64-linux.default = let
      pkgs = import nixpkgs { system = "x86_64-linux"; };
    in pkgs.mkShell {
      buildInputs = [
        pkgs.maven
        pkgs.openjdk
      ];

      shellHook = ''
        echo "Development shell with Maven and JDK"
      '';
    };
  };
}

