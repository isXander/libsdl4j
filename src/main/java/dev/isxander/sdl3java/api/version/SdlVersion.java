package dev.isxander.sdl3java.api.version;

import dev.isxander.sdl3java.jna.SdlNativeLibraryLoader;

public final class SdlVersion {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlVersion.class);
    }

    private SdlVersion() {
    }

    public static SdlVersionRecord SDL_GetJavaBindingsVersion() {
        return new SdlVersionRecord(
                SdlVersionConst.SDL_MAJOR_VERSION,
                SdlVersionConst.SDL_MINOR_VERSION,
                SdlVersionConst.SDL_MICRO_VERSION
        );
    }

    public static native int SDL_GetVersion();
}
