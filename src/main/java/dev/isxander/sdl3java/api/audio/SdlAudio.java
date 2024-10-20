package dev.isxander.sdl3java.api.audio;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import dev.isxander.sdl3java.api.iostream.SDL_IOStream;
import dev.isxander.sdl3java.api.properties.SDL_PropertiesID;
import dev.isxander.sdl3java.jna.SdlNativeLibraryLoader;
import org.jetbrains.annotations.Nullable;

public final class SdlAudio {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlAudio.class);
        SdlNativeLibraryLoader.registerNativeMethods(InternalNativeFunctions.class);
    }

    public static native int SDL_GetNumAudioDrivers();

    public static native String SDL_GetAudioDriver(int index);

    public static native String SDL_GetCurrentAudioDriver();

    public static SDL_AudioDeviceID[] SDL_GetAudioPlaybackDevices() {
        IntByReference count = new IntByReference();
        Pointer pointer = InternalNativeFunctions.SDL_GetAudioPlaybackDevices(count);

        return pointerToDevList(pointer, count);
    }

    public static SDL_AudioDeviceID[] SDL_GetAudioRecordingDevices() {
        IntByReference count = new IntByReference();
        Pointer pointer = InternalNativeFunctions.SDL_GetAudioRecordingDevices(count);

        return pointerToDevList(pointer, count);
    }

    public static native String SDL_GetAudioDeviceName(SDL_AudioDeviceID devid);

    public static native boolean SDL_GetAudioDeviceFormat(SDL_AudioDeviceID devid, SDL_AudioSpec.ByReference spec, IntByReference sampleFrames);

    public static native SDL_AudioDeviceID SDL_OpenAudioDevice(SDL_AudioDeviceID devid, SDL_AudioSpec.ByReference spec);

    public static native boolean SDL_PauseAudioDevice(SDL_AudioDeviceID dev);

    public static native boolean SDL_ResumeAudioDevice(SDL_AudioDeviceID dev);

    public static native boolean SDL_AudioDevicePaused(SDL_AudioDeviceID dev);

    public static native float SDL_GetAudioDeviceGain(SDL_AudioDeviceID devid);

    public static native void SDL_CloseAudioDevice(SDL_AudioDeviceID devid);

    public static boolean SDL_BindAudioStreams(SDL_AudioDeviceID devid, SDL_AudioStream[] streams) {
        long size = Native.getNativeSize(SDL_AudioStream.class);
        try (Memory memory = new Memory((long) streams.length * size)) {
            Pointer[] ps = new Pointer[streams.length];
            for (int i = 0; i < streams.length; i++) {
                ps[i] = streams[i].getPointer();
            }

            memory.write(0, ps, 0, streams.length);

            return InternalNativeFunctions.SDL_BindAudioStreams(devid, memory, streams.length);
        }
    }

    public static native boolean SDL_BindAudioStream(SDL_AudioDeviceID devid, SDL_AudioStream stream);

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

    public static native boolean SDL_GetAudioStreamFormat(SDL_AudioStream stream, SDL_AudioSpec.ByReference srcSpec, SDL_AudioSpec.ByReference dstSpec);

    public static native boolean SDL_SetAudioStreamFormat(SDL_AudioStream stream, @Nullable SDL_AudioSpec.ByValue srcSpec, @Nullable SDL_AudioSpec.ByValue dstSpec);

    public static native float SDL_GetAudioStreamFrequencyRatio(SDL_AudioStream stream);

    public static native boolean SDL_SetAudioStreamFrequencyRatio(SDL_AudioStream stream, float ratio);

    public static native float SDL_GetAudioStreamGain(SDL_AudioStream stream);

    public static native boolean SDL_SetAudioStreamGain(SDL_AudioStream stream, float gain);

    public static int[] SDL_GetAudioStreamInputChannelMap(SDL_AudioStream stream) {
        return getChannelMap(stream, InternalNativeFunctions::SDL_GetAudioStreamInputChannelMap);
    }

    public static int[] SDL_GetAudioStreamOutputChannelMap(SDL_AudioStream stream) {
        return getChannelMap(stream, InternalNativeFunctions::SDL_GetAudioStreamOutputChannelMap);
    }

    public static boolean SDL_SetAudioStreamInputChannelMap(SDL_AudioStream stream, int[] map) {
        return setChannelMap(stream, map, InternalNativeFunctions::SDL_SetAudioStreamInputChannelMap);
    }

    public static boolean SDL_SetAudioStreamOutputChannelMap(SDL_AudioStream stream, int[] map) {
        return setChannelMap(stream, map, InternalNativeFunctions::SDL_SetAudioStreamOutputChannelMap);
    }

    public static native boolean SDL_PutAudioStreamData(SDL_AudioStream stream, Pointer buf, int len);

    public static native int SDL_GetAudioStreamData(SDL_AudioStream stream, PointerByReference buf, int len);

    public static native int SDL_GetAudioStreamAvailable(SDL_AudioStream stream);

    public static native int SDL_GetAudioStreamQueued(SDL_AudioStream stream);

    public static native boolean SDL_FlushAudioStream(SDL_AudioStream stream);

    public static native boolean SDL_ClearAudioStream(SDL_AudioStream stream);

    public static native boolean SDL_PauseAudioStreamDevice(SDL_AudioStream stream);

    public static native boolean SDL_ResumeAudioStreamDevice(SDL_AudioStream stream);

    public static native boolean SDL_LockAudioStream(SDL_AudioStream stream);

    public static native boolean SDL_UnlockAudioStream(SDL_AudioStream stream);

    public static native boolean SDL_SetAudioStreamGetCallback(SDL_AudioStream stream, SDL_AudioStreamCallback callback, Pointer userdata);

    public static native boolean SDL_SetAudioStreamPutCallback(SDL_AudioStream stream, SDL_AudioStreamCallback callback, Pointer userdata);

    public static native void SDL_DestroyAudioStream(SDL_AudioStream stream);

    public static native SDL_AudioStream SDL_OpenAudioDeviceStream(SDL_AudioDeviceID devid, SDL_AudioSpec spec, SDL_AudioStreamCallback callback, Pointer userdata);

    public static native boolean SDL_SetAudioPostmixCallback(SDL_AudioDeviceID devid, SDL_AudioPostmixCallback callback, Pointer userdata);

    public static native boolean SDL_LoadWAV_IO(SDL_IOStream src, boolean closeio, SDL_AudioSpec spec, PointerByReference audioBuf, IntByReference audioLen);

    public static native boolean SDL_LoadWAV(String path, SDL_AudioSpec spec, PointerByReference audioBuf, IntByReference audioLen);

    public static native boolean SDL_MixAudio(PointerByReference dst, Pointer src, SDL_AudioFormat format, long len, float volume);

    public static native boolean SDL_ConvertAudioSamples(SDL_AudioSpec srcSpec, Pointer srcData, int srcLen, SDL_AudioSpec dstSpec, PointerByReference dstData, IntByReference dstLen);

    public static native int SDL_GetSilenceValueForFormat(SDL_AudioFormat format);

    private static SDL_AudioDeviceID[] pointerToDevList(Pointer pointer, IntByReference count) {
        if (pointer == null)
            return new SDL_AudioDeviceID[0];

        SDL_AudioDeviceID[] devs = new SDL_AudioDeviceID[count.getValue()];
        for (int i = 0; i < count.getValue(); i++) {
            devs[i] = new SDL_AudioDeviceID(pointer.getInt(i * 4L));
        }
        return devs;
    }

    @FunctionalInterface
    private interface ChannelMapGetter {
        Pointer getChannelMap(SDL_AudioStream stream, IntByReference count);
    }

    @FunctionalInterface
    private interface ChannelMapSetter {
        boolean setChannelMap(SDL_AudioStream stream, Pointer map, int count);
    }

    private static int[] getChannelMap(SDL_AudioStream stream, ChannelMapGetter getter) {
        IntByReference count = new IntByReference();
        Pointer channelMap = getter.getChannelMap(stream, count);
        if (channelMap == null)
            return null;

        int[] map = new int[count.getValue()];
        for (int i = 0; i < count.getValue(); i++) {
            map[i] = channelMap.getInt(i * 4L);
        }

        return map;
    }

    private static boolean setChannelMap(SDL_AudioStream stream, int[] map, ChannelMapSetter setter) {
        try (Memory memory = new Memory((long) map.length * 4)) {
            memory.write(0, map, 0, map.length);
            return setter.setChannelMap(stream, memory, map.length);
        }
    }

    private static final class InternalNativeFunctions {
        public static native Pointer SDL_GetAudioPlaybackDevices(IntByReference count);

        public static native Pointer SDL_GetAudioRecordingDevices(IntByReference count);

        public static native boolean SDL_BindAudioStreams(SDL_AudioDeviceID devid, Pointer streams, int numStreams);

        public static native void SDL_UnbindAudioStreams(Pointer streams, int numStreams);

        public static native Pointer SDL_GetAudioStreamInputChannelMap(SDL_AudioStream stream, IntByReference count);

        public static native Pointer SDL_GetAudioStreamOutputChannelMap(SDL_AudioStream stream, IntByReference count);

        public static native boolean SDL_SetAudioStreamInputChannelMap(SDL_AudioStream stream, Pointer map, int count);

        public static native boolean SDL_SetAudioStreamOutputChannelMap(SDL_AudioStream stream, Pointer map, int count);
    }
}
