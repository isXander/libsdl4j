package io.github.libsdl4j.api.audio;

import java.nio.ByteOrder;

public final class SdlAudioConsts {
    public static final int SDL_AUDIO_U8 = 0x0008;
    public static final int SDL_AUDIO_S8 = 0x8008;
    public static final int SDL_AUDIO_S16LE = 0x8010;
    public static final int SDL_AUDIO_S16BE = 0x9010;

    public static final int SDL_AUDIO_S32LE = 0x8020;
    public static final int SDL_AUDIO_S32BE = 0x9020;

    public static final int SDL_AUDIO_F32LE = 0x8120;
    public static final int SDL_AUDIO_F32BE = 0x9120;



    public static final int SDL_AUDIO_S16 = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN
            ? SDL_AUDIO_S16LE : SDL_AUDIO_S16BE;
    public static final int SDL_AUDIO_S32 = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN
            ? SDL_AUDIO_S32LE : SDL_AUDIO_S32BE;
    public static final int SDL_AUDIO_F32 = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN
            ? SDL_AUDIO_F32LE : SDL_AUDIO_F32BE;


    public static final SDL_AudioDeviceID SDL_AUDIO_DEVICE_DEFAULT_OUTPUT = new SDL_AudioDeviceID(0xFFFFFFFFL);
    public static final SDL_AudioDeviceID SDL_AUDIO_DEVICE_DEFAULT_CAPTURE = new SDL_AudioDeviceID(0xFFFFFFFEL);


    public static final int SDL_MIX_MAXVOLUME = 128;

}
