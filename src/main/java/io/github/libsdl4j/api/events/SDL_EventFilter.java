package io.github.libsdl4j.api.events;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import io.github.libsdl4j.api.events.events.SDL_Event;

@FunctionalInterface
public interface SDL_EventFilter extends Callback {
    int filterEvent(Pointer userData, SDL_Event event);
}
