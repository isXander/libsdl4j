package dev.isxander.sdl3java.api.keyboard;

import dev.isxander.sdl3java.api.SDL_bool;
import dev.isxander.sdl3java.api.rect.SDL_Rect;
import dev.isxander.sdl3java.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

public final class SdlKeyboard {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlKeyboard.class);
    }

    private SdlKeyboard() {
    }

    public static native void SDL_StartTextInput();

    @MagicConstant(valuesFromClass = SDL_bool.class)
    public static native int SDL_TextInputActive();

    public static native void SDL_StopTextInput();

    public static native void SDL_ClearComposition();

    public static native int SDL_SetTextInputRect(SDL_Rect rect);

    @MagicConstant(valuesFromClass = SDL_bool.class)
    public static native int SDL_HasScreenKeyboardSupport();
}
