package dev.isxander.sdl3java.api.platform;

import dev.isxander.sdl3java.jna.SdlNativeLibraryLoader;

public final class SdlPlatform {
    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlPlatform.class);
    }

    public static native String SDL_GetPlatform();
}
