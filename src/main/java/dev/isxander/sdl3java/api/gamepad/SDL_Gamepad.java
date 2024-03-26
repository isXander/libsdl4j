package dev.isxander.sdl3java.api.gamepad;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

/**
 * <p>The gamecontroller structure used to identify an SDL game controller.</p>
 */
public final class SDL_Gamepad extends PointerType {

    /**
     * The default constructor wraps a NULL pointer.
     */
    public SDL_Gamepad() {
        super();
    }

    /**
     * This constructor is typically used by {@link #fromNative} if generating
     * a new object instance.
     */
    public SDL_Gamepad(Pointer p) {
        super(p);
    }
}
