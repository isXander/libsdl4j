package io.github.libsdl4j.api.audio;

import com.sun.jna.IntegerType;

public class SDL_AudioDeviceID extends IntegerType {
    public SDL_AudioDeviceID() {
        this(0L);
    }

    public SDL_AudioDeviceID(long value) {
        super(4, value, true);
    }
}
