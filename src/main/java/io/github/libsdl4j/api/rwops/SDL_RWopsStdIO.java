package io.github.libsdl4j.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "autoclose",
        "fp"
})
public final class SDL_RWopsStdIO extends Structure {

    public boolean autoclose;
    public Pointer fp;

    public SDL_RWopsStdIO() {
    }

    public SDL_RWopsStdIO(Pointer p) {
        super(p);
    }
}
