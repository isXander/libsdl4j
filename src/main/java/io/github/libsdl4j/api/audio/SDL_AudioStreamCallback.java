package io.github.libsdl4j.api.audio;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

@FunctionalInterface
public interface SDL_AudioStreamCallback extends Callback {
    void callback(Pointer userdata, SDL_AudioStream stream, int additionalAmount, int totalAmount);
}
