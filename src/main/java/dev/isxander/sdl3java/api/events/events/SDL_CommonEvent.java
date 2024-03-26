package dev.isxander.sdl3java.api.events.events;

import com.sun.jna.Structure;

@Structure.FieldOrder({
        "type",
        "timestamp"
})
public final class SDL_CommonEvent extends Structure {
    public int type;
    public int timestamp;

    public SDL_CommonEvent() {
    }

    public SDL_CommonEvent(com.sun.jna.Pointer p) {
        super(p);
    }
}
