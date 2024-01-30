package io.github.libsdl4j.api.properties;

import org.junit.jupiter.api.Test;

import static io.github.libsdl4j.api.SdlInit.SDL_Init;
import static io.github.libsdl4j.api.SdlInit.SDL_Quit;
import static io.github.libsdl4j.api.properties.SdlProperties.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SdlPropertiesTest {

    @Test
    public void control() {
        SDL_Init(0);

        SDL_PropertiesID props = SDL_CreateProperties();
        SDL_SetBooleanProperty(props, "test", true);
        boolean value = SDL_GetBooleanProperty(props, "test", false);
        assertTrue(value);

        SDL_Quit();
    }
}
