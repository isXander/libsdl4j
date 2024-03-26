package dev.isxander.sdl3java.api.properties;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

@FunctionalInterface
public interface SDL_EnumeratePropertiesCallback extends Callback {
    void callback(Pointer userdata, SDL_PropertiesID props, String name);
}
