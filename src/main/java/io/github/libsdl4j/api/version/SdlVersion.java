package io.github.libsdl4j.api.version;

import io.github.libsdl4j.jna.SdlNativeLibraryLoader;

public final class SdlVersion {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlVersion.class);
    }

    private SdlVersion() {
    }

    public static SDL_version SDL_GetJavaBindingsVersion() {
        SDL_version ver = new SDL_version();
        ver.major = 3;
        ver.minor = 0;
        ver.patch = 0;
        return ver;
    }

    public static native void SDL_GetVersion(SDL_version ver);
}
