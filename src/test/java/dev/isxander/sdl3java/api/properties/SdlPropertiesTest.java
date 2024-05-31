package dev.isxander.sdl3java.api.properties;

import org.junit.jupiter.api.Test;

import static dev.isxander.sdl3java.api.SDL_bool.*;
import static dev.isxander.sdl3java.api.SdlInit.SDL_Init;
import static dev.isxander.sdl3java.api.SdlInit.SDL_Quit;
import static dev.isxander.sdl3java.api.properties.SdlProperties.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SdlPropertiesTest {

    @Test
    public void control() {
        SDL_Init(0);

        SDL_PropertiesID props = SDL_CreateProperties();
        SDL_SetBooleanProperty(props, "test", true);
        boolean value = SDL_GetBooleanProperty(props, "test", false) == SDL_TRUE;
        assertTrue(value);

        SDL_Quit();
    }
}
