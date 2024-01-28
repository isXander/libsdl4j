package io.github.libsdl4j.api.joystick;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_JoystickType implements JnaEnum {

    public static final int SDL_JOYSTICK_TYPE_UNKNOWN = 0;
    public static final int SDL_JOYSTICK_TYPE_GAMEPAD = 1;
    public static final int SDL_JOYSTICK_TYPE_WHEEL = 2;
    public static final int SDL_JOYSTICK_TYPE_ARCADE_STICK = 3;
    public static final int SDL_JOYSTICK_TYPE_FLIGHT_STICK = 4;
    public static final int SDL_JOYSTICK_TYPE_DANCE_PAD = 5;
    public static final int SDL_JOYSTICK_TYPE_GUITAR = 6;
    public static final int SDL_JOYSTICK_TYPE_DRUM_KIT = 7;
    public static final int SDL_JOYSTICK_TYPE_ARCADE_PAD = 8;
    public static final int SDL_JOYSTICK_TYPE_THROTTLE = 9;

    private SDL_JoystickType() {
    }
}
