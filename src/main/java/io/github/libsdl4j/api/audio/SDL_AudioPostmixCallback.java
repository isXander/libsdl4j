package io.github.libsdl4j.api.audio;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

@FunctionalInterface
public interface SDL_AudioPostmixCallback extends Callback {
    void callback(Pointer userdata, SDL_AudioSpec spec, float[] buffer, int buflen);
}
