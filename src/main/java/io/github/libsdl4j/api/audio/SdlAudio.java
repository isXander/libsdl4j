package io.github.libsdl4j.api.audio;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import io.github.libsdl4j.api.properties.SDL_PropertiesID;
import io.github.libsdl4j.api.rwops.SDL_RWops;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public final class SdlAudio {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlAudio.class);
    }

    public static native int SDL_GetNumAudioDrivers();

    public static native String SDL_GetAudioDriver(int index);

    public static native String SDL_GetCurrentAudioDriver();

    public static SDL_AudioDeviceID[] SDL_GetAudioOutputDevices() {
        IntByReference count = new IntByReference();
        Pointer pointer = InternalNativeFunctions.SDL_GetAudioOutputDevices(count);

        if (pointer == null) {
            return new SDL_AudioDeviceID[0];
        }

        SDL_AudioDeviceID[] deviceIds = new SDL_AudioDeviceID[count.getValue()];
        pointerToArray(pointer, count, deviceIds, SDL_AudioDeviceID::new, SDL_AudioDeviceID.class);

        return deviceIds;
    }

    public static SDL_AudioDeviceID[] SDL_GetAudioCaptureDevices() {
        IntByReference count = new IntByReference();
        Pointer pointer = InternalNativeFunctions.SDL_GetAudioCaptureDevices(count);

        if (pointer == null) {
            return new SDL_AudioDeviceID[0];
        }

        SDL_AudioDeviceID[] deviceIds = new SDL_AudioDeviceID[count.getValue()];
        pointerToArray(pointer, count, deviceIds, SDL_AudioDeviceID::new, SDL_AudioDeviceID.class);

        return deviceIds;
    }

    public static native String SDL_GetAudioDeviceName(SDL_AudioDeviceID devid);

    public static native int SDL_GetAudioDeviceFormat(SDL_AudioDeviceID devid, SDL_AudioSpec.ByReference spec, IntByReference sampleFrames);

    public static native SDL_AudioDeviceID SDL_OpenAudioDevice(SDL_AudioDeviceID devid, SDL_AudioSpec.ByReference spec);

    public static native int SDL_PauseAudioDevice(SDL_AudioDeviceID dev);

    public static native int SDL_ResumeAudioDevice(SDL_AudioDeviceID dev);

    public static native boolean SDL_AudioDevicePaused(SDL_AudioDeviceID dev);

    public static native void SDL_CloseAudioDevice(SDL_AudioDeviceID devid);

    public static void SDL_BindAudioStreams(SDL_AudioDeviceID devid, SDL_AudioStream[] streams) {
        long size = Native.getNativeSize(SDL_AudioStream.class);
        try (Memory memory = new Memory((long) streams.length * size)) {
            Pointer[] ps = new Pointer[streams.length];
            for (int i = 0; i < streams.length; i++) {
                ps[i] = streams[i].getPointer();
            }

            memory.write(0, ps, 0, streams.length);

            InternalNativeFunctions.SDL_BindAudioStreams(devid, memory, streams.length);
        }
    }

    public static native int SDL_BindAudioStream(SDL_AudioDeviceID devid, SDL_AudioStream stream);

    public static void SDL_UnbindAudioStreams(SDL_AudioStream[] streams) {
        long size = Native.getNativeSize(SDL_AudioStream.class);
        try (Memory memory = new Memory((long) streams.length * size)) {
            Pointer[] ps = new Pointer[streams.length];
            for (int i = 0; i < streams.length; i++) {
                ps[i] = streams[i].getPointer();
            }

            memory.write(0, ps, 0, streams.length);

            InternalNativeFunctions.SDL_UnbindAudioStreams(memory, streams.length);
        }
    }

    public static native void SDL_UnbindAudioStream(SDL_AudioStream stream);

    public static native SDL_AudioDeviceID SDL_GetAudioStreamDevice(SDL_AudioStream stream);

    public static native SDL_AudioStream SDL_CreateAudioStream(SDL_AudioSpec srcSpec, SDL_AudioSpec dstSpec);

    public static native SDL_PropertiesID SDL_GetAudioStreamProperties(SDL_AudioStream stream);

    public static native int SDL_GetAudioStreamFormat(SDL_AudioStream stream, SDL_AudioSpec.ByReference srcSpec, SDL_AudioSpec.ByReference dstSpec);

    public static native int SDL_SetAudioStreamFormat(SDL_AudioStream stream, @Nullable SDL_AudioSpec.ByValue srcSpec, @Nullable SDL_AudioSpec.ByValue dstSpec);

    public static native float SDL_GetAudioStreamFrequencyRatio(SDL_AudioStream stream);

    public static native int SDL_SetAudioStreamFrequencyRatio(SDL_AudioStream stream, float ratio);

    public static native int SDL_PutAudioStreamData(SDL_AudioStream stream, Pointer buf, int len);

    public static native int SDL_GetAudioStreamData(SDL_AudioStream stream, PointerByReference buf, int len);

    public static native int SDL_GetAudioStreamAvailable(SDL_AudioStream stream);

    public static native int SDL_GetAudioStreamQueued(SDL_AudioStream stream);

    public static native int SDL_FlushAudioStream(SDL_AudioStream stream);

    public static native int SDL_ClearAudioStream(SDL_AudioStream stream);

    public static native int SDL_LockAudioStream(SDL_AudioStream stream);

    public static native int SDL_SetAudioStreamGetCallback(SDL_AudioStream stream, SDL_AudioStreamCallback callback, Pointer userdata);

    public static native int SDL_SetAudioStreamPutCallback(SDL_AudioStream stream, SDL_AudioStreamCallback callback, Pointer userdata);

    public static native void SDL_DestroyAudioStream(SDL_AudioStream stream);

    public static native SDL_AudioStream SDL_OpenAudioDeviceStream(SDL_AudioDeviceID devid, SDL_AudioSpec spec, SDL_AudioStreamCallback callback, Pointer userdata);

    public static native int SDL_SetAudioPostmixCallback(SDL_AudioDeviceID devid, SDL_AudioPostmixCallback callback, Pointer userdata);

    public static native int SDL_LoadWAV_RW(SDL_RWops src, boolean freesrc, SDL_AudioSpec spec, PointerByReference audioBuf, IntByReference audioLen);

    public static native int SDL_LoadWAV(String path, SDL_AudioSpec spec, PointerByReference audioBuf, IntByReference audioLen);

    public static native int SDL_MixAudioFormat(PointerByReference dst, Pointer src, SDL_AudioFormat format, long len, int volume);

    public static native int SDL_ConvertAudioSamples(SDL_AudioSpec srcSpec, Pointer srcData, int srcLen, SDL_AudioSpec dstSpec, PointerByReference dstData, IntByReference dstLen);

    public static native int SDL_GetSilenceValueForFormat(SDL_AudioFormat format);

    private static <T> void pointerToArray(Pointer pointer, IntByReference count, T[] target, Function<Long, T> constructor, Class<T> clazz) {
        for (int i = 0; i < count.getValue(); i++) {
            target[i] = constructor.apply(pointer.getNativeLong((long) i * Native.getNativeSize(clazz)).longValue());
        }
    }

    private static final class InternalNativeFunctions {
        static {
            SdlNativeLibraryLoader.registerNativeMethods(InternalNativeFunctions.class);
        }

        public static native Pointer SDL_GetAudioOutputDevices(IntByReference count);

        public static native Pointer SDL_GetAudioCaptureDevices(IntByReference count);

        public static native int SDL_BindAudioStreams(SDL_AudioDeviceID devid, Pointer streams, int numStreams);

        public static native void SDL_UnbindAudioStreams(Pointer streams, int numStreams);
    }
}
