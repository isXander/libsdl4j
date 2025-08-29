package dev.isxander.sdl3java.api.events;

import com.sun.jna.Native;
import com.sun.jna.Structure;
import org.junit.jupiter.api.Test;

import static dev.isxander.sdl3java.api.SdlInit.SDL_Init;
import static dev.isxander.sdl3java.api.SdlInit.SDL_Quit;
import static dev.isxander.sdl3java.api.events.SDL_EventType.SDL_EVENT_FIRST;
import static dev.isxander.sdl3java.api.events.SDL_EventType.SDL_EVENT_LAST;
import static dev.isxander.sdl3java.api.events.SdlEvents.SDL_FlushEvents;
import static dev.isxander.sdl3java.api.events.SdlEvents.SDL_PollEvent;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SdlEventsTest {

    public static class SDL_Event_ByValue extends SdlEventTypes.SDL_Event implements Structure.ByValue {
        public SDL_Event_ByValue() {
            super();
        }
    }

    @Test
    public void control() {
        SDL_Init(0);

        SDL_FlushEvents(SDL_EVENT_FIRST, SDL_EVENT_LAST);

        var event = new SdlEventTypes.SDL_Event();
        SDL_PollEvent(event);
        SDL_PollEvent(event);
        SDL_PollEvent(event);
        SDL_PollEvent(event);
        SDL_PollEvent(event);
        SDL_PollEvent(event);

        assertEquals(Native.getNativeSize(SDL_Event_ByValue.class), new SdlEventTypes.SDL_Event().padding.length);

        SDL_Quit();
    }
}
