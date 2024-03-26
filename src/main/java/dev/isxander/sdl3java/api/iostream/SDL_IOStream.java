package dev.isxander.sdl3java.api.iostream;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

public class SDL_IOStream extends PointerType {
    public SDL_IOStream() {
        super();
    }

    public SDL_IOStream(Pointer p) {
        super(p);
    }
}
