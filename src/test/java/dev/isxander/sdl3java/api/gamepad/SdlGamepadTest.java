package dev.isxander.sdl3java.api.gamepad;

import dev.isxander.sdl3java.api.joystick.SDL_JoystickID;
import org.junit.jupiter.api.Test;

import static dev.isxander.sdl3java.api.SDL_bool.*;
import static dev.isxander.sdl3java.api.SdlInit.*;
import static dev.isxander.sdl3java.api.gamepad.SdlGamepad.*;

public class SdlGamepadTest {

    @Test
    public void control() {
        SDL_Init(0);
        SDL_UpdateGamepads();

        SDL_JoystickID[] gamepads = SDL_GetGamepads();
        if (gamepads.length > 0) {
            boolean isGamepad = SDL_IsGamepad(gamepads[0]) == SDL_TRUE;
            System.out.println(isGamepad);
        }

        SDL_Quit();
    }
}
