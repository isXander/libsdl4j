package io.github.libsdl4j.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import java.util.HashMap;
import java.util.Map;

import static com.sun.jna.Library.OPTION_CLASSLOADER;
import static com.sun.jna.Library.OPTION_STRING_ENCODING;

public final class SdlNativeLibraryLoader {

    public static final String SDL_LIBRARY_NAME = "SDL3";

    // This field keeps the reference to the loaded JNA library object to prevent it from being garbage collected.
    private static NativeLibrary libSDL3;

    private SdlNativeLibraryLoader() {
    }

    public static synchronized void registerNativeMethods(Class<?> nativeClass) {
        if (libSDL3 == null) {
            libSDL3 = loadLibSDL3();
        }
        Native.register(nativeClass, libSDL3);
    }

    public static void loadLibSDL3FromFilePathNow(String path) {
        if (libSDL3 != null)
            throw new IllegalStateException("libSDL3 is already loaded");

        libSDL3 = NativeLibrary.getInstance(path);
    }

    private static NativeLibrary loadLibSDL3() {
        Map<String, Object> options = new HashMap<>();
        options.put(OPTION_STRING_ENCODING, "UTF-8");
        options.put(OPTION_CLASSLOADER, SdlNativeLibraryLoader.class.getClassLoader());
        return NativeLibrary.getInstance(SDL_LIBRARY_NAME, options);
    }

    public static <T extends Library> T loadLibSDL3InterfaceInstance(Class<T> libraryInterface) {
        Map<String, Object> options = new HashMap<>();
        options.put(OPTION_STRING_ENCODING, "UTF-8");
        options.put(OPTION_CLASSLOADER, SdlNativeLibraryLoader.class.getClassLoader());
        return Native.load(SDL_LIBRARY_NAME, libraryInterface, options);
    }
}
