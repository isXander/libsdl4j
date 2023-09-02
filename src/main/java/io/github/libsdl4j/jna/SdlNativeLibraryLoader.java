package io.github.libsdl4j.jna;

import java.util.HashMap;
import java.util.Map;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import static com.sun.jna.Library.OPTION_CLASSLOADER;
import static com.sun.jna.Library.OPTION_STRING_ENCODING;

public final class SdlNativeLibraryLoader {

    public static final String SDL_LIBRARY_NAME = "SDL2";

    // This field keeps the reference to the loaded JNA library object to prevent it from being garbage collected.
    private static NativeLibrary libSDL2;

    private SdlNativeLibraryLoader() {
    }

    public static synchronized void registerNativeMethods(Class<?> nativeClass) {
        if (libSDL2 == null) {
            libSDL2 = loadLibSDL2();
        }
        Native.register(nativeClass, libSDL2);
    }

    public static void loadLibSDL2FromFilePathNow(String path) {
        if (libSDL2 != null)
            throw new IllegalStateException("libSDL2 is already loaded");

        libSDL2 = NativeLibrary.getInstance(path);
    }

    private static NativeLibrary loadLibSDL2() {
        Map<String, Object> options = new HashMap<>();
        options.put(OPTION_STRING_ENCODING, "UTF-8");
        options.put(OPTION_CLASSLOADER, SdlNativeLibraryLoader.class.getClassLoader());
        return NativeLibrary.getInstance(SDL_LIBRARY_NAME, options);
    }

    public static <T extends Library> T loadLibSDL2InterfaceInstance(Class<T> libraryInterface) {
        Map<String, Object> options = new HashMap<>();
        options.put(OPTION_STRING_ENCODING, "UTF-8");
        options.put(OPTION_CLASSLOADER, SdlNativeLibraryLoader.class.getClassLoader());
        return Native.load(SDL_LIBRARY_NAME, libraryInterface, options);
    }
}
