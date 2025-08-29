package dev.isxander.sdl3java.api.gamepad;

import dev.isxander.sdl3java.jna.JnaEnum;

/**
 * The list of axes available from a controller
 *
 * <p>Thumbstick axis values range from SDL_JOYSTICK_AXIS_MIN to SDL_JOYSTICK_AXIS_MAX,
 * and are centered within ~8000 of zero, though advanced UI will allow users to set
 * or autodetect the dead zone, which varies between controllers.</p>
 *
 * <p>Trigger axis values range from 0 to SDL_JOYSTICK_AXIS_MAX.</p>
 */
public final class SDL_GamepadAxis implements JnaEnum {

    public static final byte SDL_GAMEPAD_AXIS_INVALID  = -1;
    public static final byte SDL_GAMEPAD_AXIS_LEFTX = 0;
    public static final byte SDL_GAMEPAD_AXIS_LEFTY = 1;
    public static final byte SDL_GAMEPAD_AXIS_RIGHTX = 2;
    public static final byte SDL_GAMEPAD_AXIS_RIGHTY = 3;
    public static final byte SDL_GAMEPAD_AXIS_LEFT_TRIGGER = 4;
    public static final byte SDL_GAMEPAD_AXIS_RIGHT_TRIGGER = 5;
    public static final byte SDL_GAMEPAD_AXIS_COUNT = 6;

    public static String toString(int value) {
        return switch (value) {
            case SDL_GAMEPAD_AXIS_INVALID -> "SDL_GAMEPAD_AXIS_INVALID";
            case SDL_GAMEPAD_AXIS_LEFTX -> "SDL_GAMEPAD_AXIS_LEFTX";
            case SDL_GAMEPAD_AXIS_LEFTY -> "SDL_GAMEPAD_AXIS_LEFTY";
            case SDL_GAMEPAD_AXIS_RIGHTX -> "SDL_GAMEPAD_AXIS_RIGHTX";
            case SDL_GAMEPAD_AXIS_RIGHTY -> "SDL_GAMEPAD_AXIS_RIGHTY";
            case SDL_GAMEPAD_AXIS_LEFT_TRIGGER -> "SDL_GAMEPAD_AXIS_LEFT_TRIGGER";
            case SDL_GAMEPAD_AXIS_RIGHT_TRIGGER -> "SDL_GAMEPAD_AXIS_RIGHT_TRIGGER";
            case SDL_GAMEPAD_AXIS_COUNT -> "SDL_GAMEPAD_AXIS_COUNT";
            default -> "Unknown Axis";
        };
    }

    private SDL_GamepadAxis() {
    }
}
