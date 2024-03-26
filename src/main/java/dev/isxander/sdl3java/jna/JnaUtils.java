package dev.isxander.sdl3java.jna;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;

import java.util.List;

import static dev.isxander.sdl3java.api.stdinc.SdlStdinc.SDL_free;

public final class JnaUtils {

    public static String extractStringAndReleaseNativeSdlMemory(Pointer pointer) {
        if (Pointer.nativeValue(pointer) == 0L) {
            return null;
        }
        String result = pointer.getString(0L, "UTF-8");
        SDL_free(pointer);
        return result;
    }

    public static Memory writeArrayToNativeMemory(byte[] data) {
        if (data == null) {
            return null;
        }
        Memory memory = new Memory(data.length);
        memory.write(0L, data, 0, data.length);
        return memory;
    }

    public static Memory writeArrayToNativeMemory(short[] data) {
        if (data == null) {
            return null;
        }
        Memory memory = new Memory(data.length * 2L);
        memory.write(0L, data, 0, data.length);
        return memory;
    }

    public static Memory writeArrayToNativeMemory(int[] data) {
        if (data == null) {
            return null;
        }
        Memory memory = new Memory(data.length * 4L);
        memory.write(0L, data, 0, data.length);
        return memory;
    }

    public static Memory writeListToNativeMemory(List<? extends PojoStructure> objects) {
        long structSize = objects.get(0).size();
        Memory buffer = new Memory(objects.size() * structSize);
        long offset = 0;
        for (PojoStructure obj : objects) {
            obj.write(buffer, offset);
            offset += structSize;
        }
        return buffer;
    }

    public static void append(StringBuilder result, String name) {
        if (result.length() > 0) {
            result.append(" | ");
        }
        result.append(name);
    }

    public static String flagsUnknown(int value) {
        return "UNKNOWN(" + Integer.toBinaryString(value) + ")";
    }
}
