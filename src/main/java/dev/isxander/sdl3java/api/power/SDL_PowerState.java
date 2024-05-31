package dev.isxander.sdl3java.api.power;

import dev.isxander.sdl3java.jna.JnaEnum;

public final class SDL_PowerState implements JnaEnum {
    /** Error determining power status */
    public static final int SDL_POWERSTATE_ERROR = -1;

    /** Cannot determine power status */
    public static final int SDL_POWERSTATE_UNKNOWN = 0;

    /** Not plugged in, running on the battery */
    public static final int SDL_POWERSTATE_ON_BATTERY = 1;

    /** Plugged in, no battery available */
    public static final int SDL_POWERSTATE_NO_BATTERY = 2;

    /** Plugged in, charging battery */
    public static final int SDL_POWERSTATE_CHARGING = 3;

    /** Plugged in, battery charged */
    public static final int SDL_POWERSTATE_CHARGED = 4;

    private SDL_PowerState() {
    }
}
