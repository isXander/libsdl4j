package dev.isxander.sdl3java.api.events;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import dev.isxander.sdl3java.api.events.events.SDL_Event;

@FunctionalInterface
public interface SDL_EventFilter extends Callback {
    boolean filterEvent(Pointer userData, SDL_Event event);
}
