package io.github.libsdl4j.api.gamepad;

import io.github.libsdl4j.api.joystick.SDL_JoystickID;
import org.junit.jupiter.api.Test;

import static io.github.libsdl4j.api.SdlInit.*;
import static io.github.libsdl4j.api.gamepad.SdlGamepad.*;

public class SdlGamepadTest {

    @Test
    public void control() {
        SDL_Init(0);
        SDL_UpdateGamepads();

        SDL_JoystickID[] gamepads = SDL_GetGamepads();
        if (gamepads.length > 0) {
            boolean isGamepad = SDL_IsGamepad(gamepads[0]);
            System.out.println(isGamepad);
        }

        SDL_Quit();
    }
}
