package dev.isxander.sdl3java.api.joystick;

import com.sun.jna.ptr.ShortByReference;
import org.junit.jupiter.api.Test;

import static dev.isxander.sdl3java.api.SdlInit.SDL_Init;
import static dev.isxander.sdl3java.api.SdlInit.SDL_Quit;
import static dev.isxander.sdl3java.api.SdlSubSystemConst.SDL_INIT_EVERYTHING;
import static dev.isxander.sdl3java.api.joystick.SdlJoystick.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class SdlJoystickTest {

    public static void main(String[] args) throws InterruptedException {
        SDL_Init(SDL_INIT_EVERYTHING);

        SDL_JoystickID[] joysticks = SDL_GetJoysticks();
        int joysticksCount = joysticks.length;
        System.out.println("Number of joysticks: " + joysticksCount);

        if (joysticksCount > 0) {
            SDL_JoystickID joystickID = joysticks[0];

            String joystickName = SDL_GetJoystickNameForID(joystickID);
            System.out.println("Joystick name: " + joystickName);

            SDL_JoystickGUID joystickGUID1 = SDL_GetJoystickGUIDForID(joystickID);
            System.out.println("Joystick GUID: " + joystickGUID1);

            SDL_Joystick joystick = SDL_OpenJoystick(joystickID);

            int axisCount = SDL_GetNumJoystickAxes(joystick);
            System.out.println("Number of available axis: " + axisCount);

            int hatsCount = SDL_GetNumJoystickHats(joystick);
            System.out.println("Number of available POV hats: " + hatsCount);

            int buttonsCount = SDL_GetNumJoystickButtons(joystick);
            System.out.println("Number of available buttons: " + buttonsCount);

            for (int axisNumber = 0; axisNumber < axisCount; axisNumber++) {
                ShortByReference state1 = new ShortByReference((short) 0);
                SDL_GetJoystickAxisInitialState(joystick, axisNumber, state1);
                System.out.println("Axis " + axisNumber + " initial state: " + state1.getValue());
            }

            for (int i = 0; i < 2000; i++) {
                System.out.printf("\rTime: %tT", System.currentTimeMillis());
                SDL_UnlockJoysticks();
                for (int axisNumber = 0; axisNumber < axisCount; axisNumber++) {
                    short state = SDL_GetJoystickAxis(joystick, axisNumber);
                    System.out.printf(", Axis %d: %s ", axisNumber, state);
                }
                for (int buttonNumber = 0; buttonNumber < buttonsCount; buttonNumber++) {
                    byte state = SDL_GetJoystickButton(joystick, buttonNumber);
                    System.out.printf(", Button %d: %s ", buttonNumber, state);
                }
                System.out.flush();
                Thread.sleep(10L);
            }
            System.out.println();

            SDL_CloseJoystick(joystick);
        }

        SDL_Quit();
    }
}
