package io.github.libsdl4j.api.audio;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

public class SDL_AudioStream extends PointerType {
    public SDL_AudioStream() {
        super();
    }

    public SDL_AudioStream(Pointer pointer) {
        super(pointer);
    }
}
