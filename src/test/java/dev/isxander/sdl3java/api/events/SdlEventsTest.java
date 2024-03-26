package dev.isxander.sdl3java.api.events;

import org.junit.jupiter.api.Test;

import static dev.isxander.sdl3java.api.SdlInit.SDL_Init;
import static dev.isxander.sdl3java.api.SdlInit.SDL_Quit;
import static dev.isxander.sdl3java.api.events.SDL_EventType.SDL_EVENT_FIRST;
import static dev.isxander.sdl3java.api.events.SDL_EventType.SDL_EVENT_LAST;
import static dev.isxander.sdl3java.api.events.SdlEvents.SDL_FlushEvents;

public class SdlEventsTest {

    @Test
    public void control() {
        SDL_Init(0);

        SDL_FlushEvents(SDL_EVENT_FIRST, SDL_EVENT_LAST);

        SDL_Quit();
    }
}
