package io.github.libsdl4j.api.rect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "x",
        "y"
})
public final class SDL_Point extends Structure {
    public int x;
    public int y;

    public SDL_Point() {
    }

    public SDL_Point(Pointer p) {
        super(p);
    }
}
