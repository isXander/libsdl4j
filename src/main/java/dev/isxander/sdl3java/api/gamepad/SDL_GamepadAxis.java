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

    public static final int SDL_GAMEPAD_AXIS_INVALID  = -1;
    public static final int SDL_GAMEPAD_AXIS_LEFTX = 0;
    public static final int SDL_GAMEPAD_AXIS_LEFTY = 1;
    public static final int SDL_GAMEPAD_AXIS_RIGHTX = 2;
    public static final int SDL_GAMEPAD_AXIS_RIGHTY = 3;
    public static final int SDL_GAMEPAD_AXIS_LEFT_TRIGGER = 4;
    public static final int SDL_GAMEPAD_AXIS_RIGHT_TRIGGER = 5;
    public static final int SDL_GAMEPAD_AXIS_MAX = 6;

    // TODO: Generate public static String toString(int value)

    private SDL_GamepadAxis() {
    }
}
