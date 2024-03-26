package dev.isxander.sdl3java.api.properties;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

@FunctionalInterface
public interface SDL_CleanupCallback extends Callback {
    void cleanup(Pointer userdata, Pointer value);
}
