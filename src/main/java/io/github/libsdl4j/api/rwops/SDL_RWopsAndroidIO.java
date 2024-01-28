package io.github.libsdl4j.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

@Structure.FieldOrder({
        "asset"
})
public final class SDL_RWopsAndroidIO extends Structure {

    public Pointer asset;

    public SDL_RWopsAndroidIO() {
    }

    public SDL_RWopsAndroidIO(Pointer p) {
        super(p);
    }
}
