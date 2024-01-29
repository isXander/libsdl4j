package io.github.libsdl4j.api.events;

import org.junit.jupiter.api.Test;

import static io.github.libsdl4j.api.SdlInit.SDL_Init;
import static io.github.libsdl4j.api.SdlInit.SDL_Quit;
import static io.github.libsdl4j.api.events.SDL_EventType.SDL_EVENT_FIRST;
import static io.github.libsdl4j.api.events.SDL_EventType.SDL_EVENT_LAST;
import static io.github.libsdl4j.api.events.SdlEvents.SDL_FlushEvents;

public class SdlEventsTest {

    @Test
    public void control() {
        SDL_Init(0);

        SDL_FlushEvents(SDL_EVENT_FIRST, SDL_EVENT_LAST);

        SDL_Quit();
    }
}
