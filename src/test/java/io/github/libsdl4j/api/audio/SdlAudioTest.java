package io.github.libsdl4j.api.audio;

import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import io.github.libsdl4j.api.SdlTest;
import io.github.libsdl4j.api.iostream.SDL_IOStream;
import io.github.libsdl4j.api.iostream.SDL_IOStreamInterface;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static io.github.libsdl4j.api.SdlInit.*;
import static io.github.libsdl4j.api.SdlSubSystemConst.*;
import static io.github.libsdl4j.api.audio.SdlAudio.*;
import static io.github.libsdl4j.api.audio.SdlAudioConsts.SDL_AUDIO_DEVICE_DEFAULT_OUTPUT;
import static io.github.libsdl4j.api.error.SdlError.*;
import static io.github.libsdl4j.api.iostream.SdlIOStream.SDL_IOFromFile;
import static org.junit.jupiter.api.Assertions.*;

public class SdlAudioTest {

    @Test
    public void control() throws Exception {
        SDL_Init(SDL_INIT_AUDIO);

        SDL_AudioDeviceID controller = SDL_AUDIO_DEVICE_DEFAULT_OUTPUT;

        SDL_AudioSpec.ByReference devSpec = new SDL_AudioSpec.ByReference();
        IntByReference sampleFrames = new IntByReference();
        SDL_GetAudioDeviceFormat(controller, devSpec, sampleFrames);

        Path sampleFile = SdlTest.getSampleFile(this, "test.wav");
        SDL_IOStream iostream = SDL_IOFromFile(sampleFile.toString(), "r");

        PointerByReference audioBuf = new PointerByReference();
        IntByReference audioLen = new IntByReference();
        SDL_AudioSpec.ByReference wavSpec = new SDL_AudioSpec.ByReference();
        if (SDL_LoadWAV_IO(iostream, true, wavSpec, audioBuf, audioLen) != 0) {
            System.out.println(SDL_GetError());
            fail();
        }
        SDL_AudioStream stream = SDL_CreateAudioStream(wavSpec, devSpec);
        assertNotNull(stream);

        controller = SDL_OpenAudioDevice(controller, devSpec);
        assertNotNull(controller);

        if (SDL_BindAudioStream(controller, stream) != 0) {
            System.out.println(SDL_GetError());
            fail();
        }

        if (SDL_PutAudioStreamData(stream, audioBuf.getValue(), audioLen.getValue()) != 0) {
            System.out.println(SDL_GetError());
            fail();
        }

        Thread.sleep(10000);

        SDL_Quit();
    }
}
