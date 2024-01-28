package io.github.libsdl4j.api.gamepad;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_GamepadType implements JnaEnum {

    public static final int SDL_GAMEPAD_TYPE_UNKNOWN = 0;
    public static final int SDL_GAMEPAD_TYPE_STANDARD = 1;
    public static final int SDL_GAMEPAD_TYPE_XBOX360 = 2;
    public static final int SDL_GAMEPAD_TYPE_XBOXONE = 3;
    public static final int SDL_GAMEPAD_TYPE_PS3 = 4;
    public static final int SDL_GAMEPAD_TYPE_PS4 = 5;
    public static final int SDL_GAMEPAD_TYPE_PS5 = 6;
    public static final int SDL_GAMEPAD_TYPE_NINTENDO_SWITCH_PRO = 7;
    public static final int SDL_GAMEPAD_TYPE_NINTENDO_SWITCH_JOYCON_LEFT = 8;
    public static final int SDL_GAMEPAD_TYPE_NINTENDO_SWITCH_JOYCON_RIGHT = 9;
    public static final int SDL_GAMEPAD_TYPE_NINTENDO_SWITCH_JOYCON_PAIR = 10;
    public static final int SDL_GAMEPAD_TYPE_MAX = 11;

    // TODO: Generate public static String toString(int value)

    private SDL_GamepadType() {
    }
}
