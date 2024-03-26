package dev.isxander.sdl3java.api.error;

import dev.isxander.sdl3java.jna.SdlNativeLibraryLoader;

public final class SdlError {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlError.class);
    }

    private SdlError() {
    }

    public static native String SDL_GetError();

    public static native void SDL_ClearError();
}
