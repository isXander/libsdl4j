package dev.isxander.sdl3java.api.gamepad;

import dev.isxander.sdl3java.jna.JnaEnum;

public final class SDL_GamepadBindingType implements JnaEnum {

    public static final int SDL_GAMEPAD_BINDTYPE_NONE = 0;
    public static final int SDL_GAMEPAD_BINDTYPE_BUTTON = 1;
    public static final int SDL_GAMEPAD_BINDTYPE_AXIS = 2;
    public static final int SDL_GAMEPAD_BINDTYPE_HAT = 3;

    // TODO: Generate public static String toString(int value)

    private SDL_GamepadBindingType() {
    }
}
