package dev.isxander.sdl3java.api;

import dev.isxander.sdl3java.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

public final class SdlInit {
    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlInit.class);
    }

    private SdlInit() {
    }

    public static native boolean SDL_Init(@MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags);

    public static native boolean SDL_InitSubSystem(@MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags);

    public static native boolean SDL_QuitSubSystem(@MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags);

    @MagicConstant(flagsFromClass = SdlSubSystemConst.class)
    public static native int SDL_WasInit(@MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags);

    public static native void SDL_Quit();
}
