package dev.isxander.sdl3java.api.guid;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import dev.isxander.sdl3java.jna.JnaUtils;
import dev.isxander.sdl3java.jna.SdlNativeLibraryLoader;

public final class SdlGuid {
    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlGuid.class);
        SdlNativeLibraryLoader.registerNativeMethods(InternalNativeFunctions.class);
    }

    private SdlGuid() {
    }

    public static String SDL_GUIDToString(SDL_GUID guid) {
        SDL_GUID guidCopy = JnaUtils.copyStruct(guid);

        try (Memory pszGUID = new Memory(33)) {
            InternalNativeFunctions.SDL_GUIDToString(guidCopy, pszGUID, 33);
            return pszGUID.getString(0, "ASCII");
        }
    }

    public static native SDL_GUID SDL_StringToGUID(String pchGUID);

    private static final class InternalNativeFunctions {
        private InternalNativeFunctions() {
        }

        // pszGUID buffer in which to write the ASCII string
        // cbGUID the size of pszGUID, should be at least 33 bytes
        public static native void SDL_GUIDToString(SDL_GUID guid, Pointer pszGUID, int cbGUID);
    }
}
