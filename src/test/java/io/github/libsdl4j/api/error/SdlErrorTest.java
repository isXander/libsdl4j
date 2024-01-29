package io.github.libsdl4j.api.error;

import org.junit.jupiter.api.Test;

import static io.github.libsdl4j.api.error.SdlError.SDL_ClearError;

public class SdlErrorTest {
    @Test
    public void control() {
        SDL_ClearError();
    }
}
