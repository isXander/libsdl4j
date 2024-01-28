package io.github.libsdl4j.api;

import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

public final class SdlInit {

    private SdlInit() {
    }

    public static int SDL_Init(
            @MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags) {
        return InternalNativeFunctions.SDL_Init(flags);
    }

    public static int SDL_InitSubSystem(
            @MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags) {
        return InternalNativeFunctions.SDL_InitSubSystem(flags);
    }

    public static int SDL_QuitSubSystem(
            @MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags) {
        return InternalNativeFunctions.SDL_QuitSubSystem(flags);
    }

    public static int SDL_WasInit(
            @MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags) {
        return InternalNativeFunctions.SDL_WasInit(flags);
    }

    public static void SDL_Quit() {
        InternalNativeFunctions.SDL_Quit();
    }

    private static final class InternalNativeFunctions {
        static {
            SdlNativeLibraryLoader.registerNativeMethods(InternalNativeFunctions.class);
        }

        private InternalNativeFunctions() {
        }

        public static native int SDL_Init(
                @MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags);

        public static native int SDL_InitSubSystem(
                @MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags);

        public static native int SDL_QuitSubSystem(
                @MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags);

        public static native int SDL_WasInit(
                @MagicConstant(flagsFromClass = SdlSubSystemConst.class) int flags);

        public static native void SDL_Quit();
    }
}
