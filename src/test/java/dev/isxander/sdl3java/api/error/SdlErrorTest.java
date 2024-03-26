package dev.isxander.sdl3java.api.error;

import org.junit.jupiter.api.Test;

import static dev.isxander.sdl3java.api.error.SdlError.SDL_ClearError;

public class SdlErrorTest {
    @Test
    public void control() {
        SDL_ClearError();
    }
}
