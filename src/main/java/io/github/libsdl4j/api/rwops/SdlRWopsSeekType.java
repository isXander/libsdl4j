package io.github.libsdl4j.api.rwops;

public final class SdlRWopsSeekType {

    /** Seek from the beginning of data */
    public static final int RW_SEEK_SET = 0;

    /** Seek relative to current read point */
    public static final int RW_SEEK_CUR = 1;

    /** Seek relative to the end of data */
    public static final int RW_SEEK_END = 2;

    private SdlRWopsSeekType() {
    }
}
