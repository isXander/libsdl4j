package io.github.libsdl4j.api.keyboard;

import org.junit.jupiter.api.Test;

import static io.github.libsdl4j.api.SdlInit.SDL_Init;
import static io.github.libsdl4j.api.SdlInit.SDL_Quit;
import static io.github.libsdl4j.api.keyboard.SdlKeyboard.SDL_StopTextInput;

public class SdlKeyboardTest {
    @Test
    public void control() {
        SDL_Init(0);
        SDL_StopTextInput();
        SDL_Quit();
    }
}
