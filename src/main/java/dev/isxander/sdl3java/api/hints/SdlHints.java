package dev.isxander.sdl3java.api.hints;

import dev.isxander.sdl3java.api.SDL_bool;
import dev.isxander.sdl3java.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

public final class SdlHints {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlHints.class);
    }

    private SdlHints() {
    }

    @MagicConstant(valuesFromClass = SDL_bool.class)
    public static native int SDL_SetHintWithPriority(String name, String value, @MagicConstant(valuesFromClass = SDL_HintPriority.class) int priority);

    @MagicConstant(valuesFromClass = SDL_bool.class)
    public static native int SDL_SetHint(String name, String value);

    @MagicConstant(valuesFromClass = SDL_bool.class)
    public static native int SDL_ResetHint(String name);

    public static native void SDL_ResetHints();

    public static native String SDL_GetHint(String name);

    @MagicConstant(valuesFromClass = SDL_bool.class)
    public static native int SDL_GetHintBoolean(String name, boolean defaultValue);
}
