package io.github.libsdl4j.api.iostream;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import io.github.libsdl4j.api.properties.SDL_PropertiesID;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import io.github.libsdl4j.jna.size_t;
import org.intellij.lang.annotations.MagicConstant;

public final class SdlIOStream {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlIOStream.class);
    }

    private SdlIOStream() {
    }

    public static native SDL_IOStream SDL_IOFromFile(String file, String mode);

    public static native SDL_IOStream SDL_IOFromMem(Pointer mem, size_t size);

    public static native SDL_IOStream SDL_IOFromConstMem(Pointer mem, size_t size);

    public static native SDL_IOStream SDL_IOFromDynamicMem();

    public static native SDL_IOStream SDL_OpenIO(SDL_IOStreamInterface.ByReference iface, Pointer userdata);

    public static native int SDL_CloseIO(SDL_IOStream context);

    public static native SDL_PropertiesID SDL_GetIOProperties(SDL_IOStream context);

    public static native @MagicConstant(valuesFromClass = SDL_IOStatus.class) int SDL_GetIOStatus(SDL_IOStream context);

    public static native long SDL_GetIOSize(SDL_IOStream context);

    public static native long SDL_SeekIO(SDL_IOStream context, long offset, @MagicConstant(valuesFromClass = SdlIOSeekType.class) int whence);

    public static native long SDL_TellIO(SDL_IOStream context);

    public static native size_t SDL_ReadIO(SDL_IOStream context, Pointer ptr, size_t size);

    public static native size_t SDL_WriteIO(SDL_IOStream context, Pointer ptr, size_t size);

    public static native Pointer SDL_LoadFile_IO(SDL_IOStream src, size_t.Ref datasize, boolean closeio);

    public static native Pointer SDL_LoadFile(String file, size_t.Ref datasize);


}
