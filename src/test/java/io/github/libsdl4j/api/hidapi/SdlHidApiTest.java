package io.github.libsdl4j.api.hidapi;

import org.junit.jupiter.api.Test;

import static io.github.libsdl4j.api.hidapi.SdlHidApi.*;

public class SdlHidApiTest {

    @Test
    public void control() {
        SDL_hid_init();

        SDL_hid_enumerate(0, 0);

        SDL_hid_exit();
    }
}
