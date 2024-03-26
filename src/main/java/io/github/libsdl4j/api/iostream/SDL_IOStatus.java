package io.github.libsdl4j.api.iostream;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_IOStatus implements JnaEnum {
    public static final int SDL_IO_STATUS_READY = 0;
    public static final int SDL_IO_STATUS_ERROR = 1;
    public static final int SDL_IO_STATUS_EOF = 2;
    public static final int SDL_IO_STATUS_NOT_READY = 3;
    public static final int SDL_IO_STATUS_READONLY = 4;
    public static final int SDL_IO_STATUS_WRITEONLY = 5;
}
