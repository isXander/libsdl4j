package dev.isxander.sdl3java.api.joystick;

import com.sun.jna.IntegerType;

/**
 * This is a unique ID for a joystick for the time it is connected to the system,
 * and is never reused for the lifetime of the application. If the joystick is
 * disconnected and reconnected, it will get a new ID.
 *
 * <p>The ID value starts at 0 and increments from there. The value -1 is an invalid ID.</p>
 */
public final class SDL_JoystickID extends IntegerType {
    /**
     * The size of the native type (Uint32), which is 4 bytes.
     */
    public static final int SIZE = 4;

    /**
     * Create a zero-valued signed IntegerType.
     */
    public SDL_JoystickID() {
        this(0L);
    }

    /**
     * Constructor that takes a Java long to initialize the value.
     * @param value The initial value for the joystick ID.
     */
    public SDL_JoystickID(long value) {
        super(SIZE, value, false);
    }
}
