package io.github.libsdl4j.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.ByteByReference;

@Structure.FieldOrder({
        "base",
        "here",
        "stop"
})
public final class SDL_RWopsMemoryIO extends Structure {

    public ByteByReference base;
    public ByteByReference here;
    public ByteByReference stop;

    public SDL_RWopsMemoryIO() {
    }

    public SDL_RWopsMemoryIO(Pointer p) {
        super(p);
    }
}
