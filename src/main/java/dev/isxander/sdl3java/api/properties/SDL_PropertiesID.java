package dev.isxander.sdl3java.api.properties;

import com.sun.jna.IntegerType;

public class SDL_PropertiesID extends IntegerType {
    /**
     * Create a zero-valued signed IntegerType.
     */
    public SDL_PropertiesID() {
        this(0L);
    }

    /**
     * Create a signed IntegerType with the given value.
     */
    public SDL_PropertiesID(long value) {
        super(4, value, false);
    }
}
