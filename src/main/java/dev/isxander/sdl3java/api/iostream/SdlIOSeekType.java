package dev.isxander.sdl3java.api.iostream;

public final class SdlIOSeekType {

    /** Seek from the beginning of data */
    public static final int SDL_IO_SEEK_SET = 0;

    /** Seek relative to current read point */
    public static final int SDL_IO_SEEK_CUR = 1;

    /** Seek relative to the end of data */
    public static final int SDL_IO_SEEK_END = 2;

    private SdlIOSeekType() {
    }
}
