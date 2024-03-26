package dev.isxander.sdl3java.api.joystick;

public final class SdlJoystickHatConst {
    private SdlJoystickHatConst() {
    }

    public static final byte SDL_HAT_CENTERED = 0x00;
    public static final byte SDL_HAT_UP = 0x01;
    public static final byte SDL_HAT_RIGHT = 0x02;
    public static final byte SDL_HAT_DOWN = 0x04;
    public static final byte SDL_HAT_LEFT = 0x08;
    public static final byte SDL_HAT_RIGHTUP = (byte) (SDL_HAT_RIGHT | SDL_HAT_UP);
    public static final byte SDL_HAT_RIGHTDOWN = (byte) (SDL_HAT_RIGHT | SDL_HAT_DOWN);
    public static final byte SDL_HAT_LEFTUP = (byte) (SDL_HAT_LEFT | SDL_HAT_UP);
    public static final byte SDL_HAT_LEFTDOWN = (byte) (SDL_HAT_LEFT | SDL_HAT_DOWN);
}
