package dev.isxander.sdl3java.api.sensor;

import dev.isxander.sdl3java.jna.JnaEnum;

/**
 * The different sensors defined by SDL.
 * <p>
 * Additional sensors may be available, using platform dependent semantics.
 * <p>
 * <a href="https://developer.android.com/reference/android/hardware/SensorEvent.html#values">Here are the additional Android sensors</a>
 *
 * <h3>Accelerometer sensor notes</h3>
 * The accelerometer returns the current acceleration in <strong>SI meters per second</strong>
 * squared. This measurement includes the force of gravity, so a device at
 * rest will have an value of {@link SdlSensorConst#SDL_STANDARD_GRAVITY} away from the center of the
 * earth, which is a positive Y value.
 * <ul>
 *     <li><code>values[0]</code>: Acceleration on the x-axis</li>
 *     <li><code>values[1]</code>: Acceleration on the y-axis</li>
 *     <li><code>values[2]</code>: Acceleration on the z-axis</li>
 * </ul>
 *
 * For phones and tablets held in natural orientation and game controllers
 * held in front of you, the axes are defined as follows:
 * <pre>
 * - -X ... +X : left ... right
 * - -Y ... +Y : bottom ... top
 * - -Z ... +Z : farther ... closer
 * </pre>
 * The accelerometer axis data is not changed when the device is rotated.
 *
 * <h3>Gyroscope sensor notes</h3>
 * The gyroscope returns the current rate of rotation in <strong>radians per second</strong>.
 * The rotation is positive in the counter-clockwise direction. That is, an
 * observer looking from a positive location on one of the axes would see
 * positive rotation on that axis when it appeared to be rotating
 * counter-clockwise.
 * <ul>
 *     <li><code>values[0]</code>: Angular speed around the x-axis (pitch)</li>
 *     <li><code>values[1]</code>: Angular speed around the y-axis (yaw)</li>
 *     <li><code>values[2]</code>: Angular speed around the z-axis (roll)</li>
 * </ul>
 *
 * For phones and tablets held in natural orientation and game controllers
 * held in front of you, the axes are defined as follows:
 * <pre>
 * - -X ... +X : left ... right
 * - -Y ... +Y : bottom ... top
 * - -Z ... +Z : farther ... closer
 * </pre>
 * The gyroscope axis data is not changed when the device is rotated.
 */
public final class SDL_SensorType implements JnaEnum {

    /**
     * Returned for an invalid sensor
     */
    public static final int SDL_SENSOR_INVALID = -1;

    /**
     * Unknown sensor type
     */
    public static final int SDL_SENSOR_UNKNOWN = 0;

    /**
     * Accelerometer
     */
    public static final int SDL_SENSOR_ACCEL = 1;

    /**
     * Gyroscope
     */
    public static final int SDL_SENSOR_GYRO = 2;

    /**
     * Accelerometer for left Joy-Con controller and Wii nunchuk
     */
    public static final int SDL_SENSOR_ACCEL_L = 3;

    /**
     * Gyroscope for left Joy-Con controller
     */
    public static final int SDL_SENSOR_GYRO_L = 4;

    /**
     * Accelerometer for right Joy-Con controller
     */
    public static final int SDL_SENSOR_ACCEL_R = 5;

    /**
     * Gyroscope for right Joy-Con controller
     */
    public static final int SDL_SENSOR_GYRO_R = 6;

    public static final int SDL_SENSOR_COUNT = 7;

    private SDL_SensorType() {
    }
}
