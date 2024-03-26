package dev.isxander.sdl3java.api.keyboard;

import org.junit.jupiter.api.Test;

import static dev.isxander.sdl3java.api.SdlInit.SDL_Init;
import static dev.isxander.sdl3java.api.SdlInit.SDL_Quit;
import static dev.isxander.sdl3java.api.keyboard.SdlKeyboard.SDL_StopTextInput;

public class SdlKeyboardTest {
    @Test
    public void control() {
        SDL_Init(0);
        SDL_StopTextInput();
        SDL_Quit();
    }
}
