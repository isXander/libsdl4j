package io.github.libsdl4j.api.endian;

import org.intellij.lang.annotations.MagicConstant;

import java.nio.ByteOrder;

public final class SdlEndianConst {

    public static final int SDL_LIL_ENDIAN = 1234;
    public static final int SDL_BIG_ENDIAN = 4321;

    @MagicConstant(intValues = {SDL_LIL_ENDIAN, SDL_BIG_ENDIAN})
    public static final int SDL_BYTEORDER;

    static {
        if (ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN)) {
            SDL_BYTEORDER = SDL_BIG_ENDIAN;
        } else {
            SDL_BYTEORDER = SDL_LIL_ENDIAN;
        }
    }

    public static String toString(
            @MagicConstant(intValues = {SDL_LIL_ENDIAN, SDL_BIG_ENDIAN}) int value) {
        return switch (value) {
            case SDL_LIL_ENDIAN -> "SDL_LIL_ENDIAN";
            case SDL_BIG_ENDIAN -> "SDL_BIG_ENDIAN";
            default -> "UNKNOWN";
        };
    }

    private SdlEndianConst() {
    }
}
