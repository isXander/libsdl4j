package io.github.libsdl4j.api.rwops;

import com.sun.jna.Pointer;
import io.github.libsdl4j.api.properties.SDL_PropertiesID;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import io.github.libsdl4j.jna.size_t;
import org.intellij.lang.annotations.MagicConstant;

public final class SdlRWops {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlRWops.class);
    }

    private SdlRWops() {
    }

    public static native SDL_RWops SDL_RWFromFile(String file, String mode);

    public static native SDL_RWops SDL_RWFromMem(Pointer mem, size_t size);

    public static native SDL_RWops SDL_RWFromConstMem(Pointer mem, size_t size);

    public static native SDL_RWops SDL_CreateRW();

    public static native void SDL_DestroyRW(SDL_RWops context);

    public static native SDL_PropertiesID SDL_GetRWProperties(SDL_RWops context);

    public static native long SDL_RWsize(SDL_RWops context);

    public static native long SDL_RWseek(SDL_RWops context, long offset, @MagicConstant(valuesFromClass = SdlRWopsSeekType.class) int whence);

    public static native long SDL_RWtell(SDL_RWops context);

    public static native size_t SDL_RWread(SDL_RWops context, Pointer ptr, size_t size);

    public static native size_t SDL_RWwrite(SDL_RWops context, Pointer ptr, size_t size);

    // TODO: SDL_RWprintf

    // TODO: SDL_RWvprintf
}
