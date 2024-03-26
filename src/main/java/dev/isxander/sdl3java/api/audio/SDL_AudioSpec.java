package dev.isxander.sdl3java.api.audio;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "format",
        "channels",
        "freq"
})
public class SDL_AudioSpec extends Structure {
    public SDL_AudioFormat format;
    public int channels;
    public int freq;

    public SDL_AudioSpec() {
        super();
    }

    public SDL_AudioSpec(Pointer p) {
        super(p);
    }

    public static class ByReference extends SDL_AudioSpec implements Structure.ByReference {
    }

    public static class ByValue extends SDL_AudioSpec implements Structure.ByValue {
    }
}
