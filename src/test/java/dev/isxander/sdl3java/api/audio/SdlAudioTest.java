package dev.isxander.sdl3java.api.audio;

import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import dev.isxander.sdl3java.api.SdlTest;
import dev.isxander.sdl3java.api.iostream.SDL_IOStream;
import dev.isxander.sdl3java.api.iostream.SDL_IOStreamInterface;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static dev.isxander.sdl3java.api.SdlInit.*;
import static dev.isxander.sdl3java.api.SdlSubSystemConst.*;
import static dev.isxander.sdl3java.api.audio.SdlAudio.*;
import static dev.isxander.sdl3java.api.audio.SdlAudioConsts.SDL_AUDIO_DEVICE_DEFAULT_OUTPUT;
import static dev.isxander.sdl3java.api.error.SdlError.*;
import static dev.isxander.sdl3java.api.iostream.SdlIOStream.SDL_IOFromFile;
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
        if (!SDL_LoadWAV_IO(iostream, true, wavSpec, audioBuf, audioLen)) {
            System.out.println("SDL Error: " + SDL_GetError());
            fail("Failed to load WAV file");
        }
        SDL_AudioStream stream = SDL_CreateAudioStream(wavSpec, devSpec);
        assertNotNull(stream);

        controller = SDL_OpenAudioDevice(controller, devSpec);
        assertNotNull(controller);

        if (!SDL_BindAudioStream(controller, stream)) {
            System.out.println(SDL_GetError());
            fail();
        }

        if (!SDL_PutAudioStreamData(stream, audioBuf.getValue(), audioLen.getValue())) {
            System.out.println(SDL_GetError());
            fail();
        }

        Thread.sleep(10000);

        SDL_Quit();
    }
}
