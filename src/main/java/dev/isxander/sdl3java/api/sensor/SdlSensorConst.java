package dev.isxander.sdl3java.api.sensor;

public final class SdlSensorConst {

    private SdlSensorConst() {
    }

    /**
     * A constant to represent standard gravity for accelerometer sensors.
     * <p>
     * The accelerometer returns the current acceleration in SI meters per second
     * squared. This measurement includes the force of gravity, so a device at
     * rest will have a value of SDL_STANDARD_GRAVITY away from the center of the
     * earth, which is a positive Y value.
     */
    public static final float SDL_STANDARD_GRAVITY = 9.80665f;


}
