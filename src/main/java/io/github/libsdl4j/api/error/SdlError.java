package io.github.libsdl4j.api.error;

import io.github.libsdl4j.jna.SdlNativeLibraryLoader;

public final class SdlError {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlError.class);
    }

    private SdlError() {
    }

    public static native String SDL_GetError();

    public static native void SDL_ClearError();
}
