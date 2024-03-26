package dev.isxander.sdl3java.api.hidapi;

import org.junit.jupiter.api.Test;

import static dev.isxander.sdl3java.api.hidapi.SdlHidApi.*;

public class SdlHidApiTest {

    @Test
    public void control() {
        SDL_hid_init();

        SDL_hid_exit();
    }
}
