package dev.isxander.sdl3java.api.hints;

import dev.isxander.sdl3java.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

public final class SdlHints {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlHints.class);
    }

    private SdlHints() {
    }

    public static native boolean SDL_SetHintWithPriority(String name, String value, @MagicConstant(valuesFromClass = SDL_HintPriority.class) int priority);

    public static native boolean SDL_SetHint(String name, String value);

    public static native boolean SDL_ResetHint(String name);

    public static native void SDL_ResetHints();

    public static native String SDL_GetHint(String name);

    public static native boolean SDL_GetHintBoolean(String name, boolean defaultValue);
}
