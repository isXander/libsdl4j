package dev.isxander.sdl3java.api.events;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;

@FunctionalInterface
public interface SDL_EventFilter extends Callback {
    boolean filterEvent(Pointer userData, SdlEventTypes.SDL_Event event);
}
