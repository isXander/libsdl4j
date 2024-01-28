package io.github.libsdl4j.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "data1",
        "data2"
})
public final class SDL_RWopsUnknownIO extends Structure {

    public Pointer data1;
    public Pointer data2;

    public SDL_RWopsUnknownIO() {
    }

    public SDL_RWopsUnknownIO(Pointer p) {
        super(p);
    }
}
