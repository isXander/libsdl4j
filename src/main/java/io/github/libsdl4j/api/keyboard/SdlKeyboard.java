package io.github.libsdl4j.api.keyboard;

import io.github.libsdl4j.api.rect.SDL_Rect;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;

public final class SdlKeyboard {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlKeyboard.class);
    }

    private SdlKeyboard() {
    }

    public static native void SDL_StartTextInput();

    public static native boolean SDL_TextInputActive();

    public static native void SDL_StopTextInput();

    public static native void SDL_ClearComposition();

    public static native boolean SDL_TextInputShown();

    public static native int SDL_SetTextInputRect(SDL_Rect rect);

    public static native boolean SDL_HasScreenKeyboardSupport();
}
