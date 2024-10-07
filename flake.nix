{
  description = "A Nix flake for Maven and JDK on Linux and macOS (nix-darwin)";

  inputs = {
    nixpkgs.url = "github:NixOS/nixpkgs/nixos-unstable"; # You can adjust this version/branch as needed
  };

  outputs = { self, nixpkgs }: {

    # Function to support Linux and macOS (Apple Silicon)
    packages = {
      x86_64-linux = let
        pkgs = import nixpkgs { system = "x86_64-linux"; };
      in {
        defaultPackage = pkgs.mkShell {
          buildInputs = [
            pkgs.maven
            pkgs.openjdk
          ];

          shellHook = ''
            echo "Maven and JDK have been added to the environment on Linux."
          '';
        };
      };

      aarch64-darwin = let
        pkgs = import nixpkgs { system = "aarch64-darwin"; };
      in {
        defaultPackage = pkgs.mkShell {
          buildInputs = [
            pkgs.maven
            pkgs.openjdk
          ];

          shellHook = ''
            echo "Maven and JDK have been added to the environment on macOS (Apple Silicon)."
          '';
        };
      };
    };

    # Default app for both platforms
    defaultApp = {
      type = "app";
      program = if builtins.currentSystem == "aarch64-darwin" then
        "${self.packages.aarch64-darwin.defaultPackage}/bin/mvn"
      else
        "${self.packages.x86_64-linux.defaultPackage}/bin/mvn";
    };

    # Development shells for both platforms
    devShells = {
      x86_64-linux = let
        pkgs = import nixpkgs { system = "x86_64-linux"; };
      in pkgs.mkShell {
        buildInputs = [
          pkgs.maven
          pkgs.openjdk
        ];

        shellHook = ''
          echo "Development shell with Maven and JDK on Linux."
        '';
      };

      aarch64-darwin = let
        pkgs = import nixpkgs { system = "aarch64-darwin"; };
      in pkgs.mkShell {
        buildInputs = [
          pkgs.maven
          pkgs.openjdk
        ];

        shellHook = ''
          echo "Development shell with Maven and JDK on macOS (Apple Silicon)."
        '';
      };
    };
  };
}

