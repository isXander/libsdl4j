package io.github.libsdl4j.api.rect;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "x", "y",
        "w", "h",
})
public final class SDL_Rect extends Structure {
    public int x, y;
    public int w, h;

    public SDL_Rect() {
    }

    public SDL_Rect(Pointer p) {
        super(p);
    }
}
