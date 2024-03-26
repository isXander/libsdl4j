package dev.isxander.sdl3java.api.platform;


import org.junit.jupiter.api.Test;

import static dev.isxander.sdl3java.api.SdlInit.*;
import static dev.isxander.sdl3java.api.platform.SdlPlatform.*;
import static org.junit.jupiter.api.Assertions.*;

public final class SdlPlatformTest {
    @Test
    void control() {
        SDL_Init(0);

        String platform = SDL_GetPlatform();
        assertNotNull(platform);
        assertFalse(platform.isEmpty());
        System.out.println(platform);

        SDL_Quit();
    }
}
