package dev.isxander.sdl3java.api.version;

import org.junit.jupiter.api.Test;

import static dev.isxander.sdl3java.api.version.SdlVersion.SDL_GetVersion;

public class SdlVersionTest {

    @Test
    public void control() {
        SDL_version ver = new SDL_version();
        SDL_GetVersion(ver);
        System.out.println(ver.major + "." + ver.minor + "." + ver.patch);
    }
}
