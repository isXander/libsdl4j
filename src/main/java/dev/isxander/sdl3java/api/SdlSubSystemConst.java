package dev.isxander.sdl3java.api;

import dev.isxander.sdl3java.jna.JnaEnum;

public final class SdlSubSystemConst implements JnaEnum {

    public static final int SDL_INIT_TIMER      = 0x00000001;
    public static final int SDL_INIT_AUDIO      = 0x00000010;
    public static final int SDL_INIT_VIDEO      = 0x00000020;
    public static final int SDL_INIT_JOYSTICK   = 0x00000200;
    public static final int SDL_INIT_HAPTIC     = 0x00001000;
    public static final int SDL_INIT_GAMEPAD    = 0x00002000;
    public static final int SDL_INIT_EVENTS     = 0x00004000;
    public static final int SDL_INIT_SENSOR     = 0x00008000;
    public static final int SDL_INIT_EVERYTHING = SDL_INIT_TIMER
            | SDL_INIT_AUDIO
            | SDL_INIT_VIDEO
            | SDL_INIT_EVENTS
            | SDL_INIT_JOYSTICK
            | SDL_INIT_HAPTIC
            | SDL_INIT_GAMEPAD
            | SDL_INIT_SENSOR;

    private SdlSubSystemConst() {
    }
}
