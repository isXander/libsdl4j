package io.github.libsdl4j.api.audio;

import com.sun.jna.IntegerType;

public class SDL_AudioFormat extends IntegerType {
    public SDL_AudioFormat() {
        this(0L);
    }

    public SDL_AudioFormat(long value) {
        super(2, value, true);
    }
}
