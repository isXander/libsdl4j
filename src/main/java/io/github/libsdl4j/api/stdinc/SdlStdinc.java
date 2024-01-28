package io.github.libsdl4j.api.stdinc;

import com.sun.jna.CallbackReference;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import io.github.libsdl4j.jna.size_t;

/**
 * Definitions from file SDL_stdinc.h
 *
 * <p>This is a general header that includes C language support.</p>
 */
public final class SdlStdinc {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlStdinc.class);
    }

    private SdlStdinc() {
    }

    public static native Pointer SDL_malloc(
            size_t size);

    public static native Pointer SDL_calloc(
            int nmemb,
            size_t size);

    public static native Pointer SDL_realloc(
            Pointer mem,
            size_t size);

    public static native void SDL_free(
            Pointer mem);
}
