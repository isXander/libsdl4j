package io.github.libsdl4j.api.version;

import org.junit.jupiter.api.Test;

import static io.github.libsdl4j.api.version.SdlVersion.SDL_GetVersion;

public class SdlVersionTest {

    @Test
    public void control() {
        SDL_version ver = new SDL_version();
        SDL_GetVersion(ver);
        System.out.println(ver.major + "." + ver.minor + "." + ver.patch);
    }
}
