package dev.isxander.sdl3java.api.keyboard;

import dev.isxander.sdl3java.jna.SdlNativeLibraryLoader;

public final class SdlKeyboard {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlKeyboard.class);
    }

    private SdlKeyboard() {
    }

    public static native boolean SDL_HasKeyboard();

    public static native void SDL_StartTextInput();

    public static native boolean SDL_TextInputActive();

    public static native void SDL_StopTextInput();

    public static native void SDL_ClearComposition();

    public static native boolean SDL_HasScreenKeyboardSupport();
}
