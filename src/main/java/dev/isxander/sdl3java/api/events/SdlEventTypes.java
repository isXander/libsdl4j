package dev.isxander.sdl3java.api.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import dev.isxander.sdl3java.api.gamepad.SDL_GamepadAxis;
import dev.isxander.sdl3java.api.gamepad.SDL_GamepadButton;
import dev.isxander.sdl3java.api.joystick.SDL_JoystickID;
import dev.isxander.sdl3java.api.power.SDL_PowerState;
import dev.isxander.sdl3java.api.sensor.SDL_SensorType;
import org.intellij.lang.annotations.MagicConstant;

/**
 * JNA mappings for SDL3 joystick/gamepad event structures, plus SDL_CommonEvent
 * and an SDL_Event union limited to the events defined here.
 *
 * <p>Type mappings:</p>
 * <ul>
 *   <li>SDL_EventType → {@code int} (annotated)</li>
 *   <li>SDL_SensorType / SDL_PowerState → {@code int} (annotated)</li>
 *   <li>SDL_GamepadAxis / SDL_GamepadButton → {@code byte} (annotated)</li>
 *   <li>SDL_JoystickID → {@code SDL_JoystickID} (your {@code IntegerType})</li>
 *   <li>Uint8 → {@code byte}, Sint16/Uint16 → {@code short}, Uint32/Sint32 → {@code int}, Uint64 → {@code long}, bool → {@code boolean}</li>
 * </ul>
 */
public final class SdlEventTypes {
    private SdlEventTypes() {}

    // ---------------------------------------------------
    // Common event header
    // ---------------------------------------------------

    /**
     * Fields shared by every event.
     *
     * <p>Since: SDL 3.2.0</p>
     */
    @Structure.FieldOrder({ "type", "reserved", "timestamp" })
    public static class SDL_CommonEvent extends Structure {
        /**
         * Event type, shared with all events.
         * Uint32 to cover user events not in the SDL_EventType enumeration.
         */
        @MagicConstant(valuesFromClass = SDL_EventType.class)
        public int type;
        public int reserved;
        /** In nanoseconds, populated using SDL_GetTicksNS(). */
        public long timestamp;

        public SDL_CommonEvent() {}
        public SDL_CommonEvent(long peer) { 
            super(new Pointer(peer)); 
            read(); 
        }

        public static class ByReference extends SDL_CommonEvent implements Structure.ByReference {}
        public static class ByValue extends SDL_CommonEvent implements Structure.ByValue {}
    }

    // ---------------------------------------------------
    // Joystick events
    // ---------------------------------------------------

    /**
     * Joystick axis motion event (event.jaxis.*)
     *
     * <p>Since: SDL 3.2.0</p>
     */
    @Structure.FieldOrder({
            "type", "reserved", "timestamp", "which",
            "axis", "padding1", "padding2", "padding3",
            "value", "padding4"
    })
    public static class SDL_JoyAxisEvent extends Structure {
        @MagicConstant(intValues = {
                SDL_EventType.SDL_EVENT_JOYSTICK_AXIS_MOTION
        })
        public int type;
        public int reserved;
        /** In nanoseconds, populated using SDL_GetTicksNS(). */
        public long timestamp;
        /** The joystick instance id. */
        public SDL_JoystickID which;
        /** The joystick axis index. */
        public byte axis;
        public byte padding1;
        public byte padding2;
        public byte padding3;
        /** The axis value (range: -32768 to 32767). */
        public short value;
        public short padding4;

        public SDL_JoyAxisEvent() {}
        public SDL_JoyAxisEvent(long peer) { super(new Pointer(peer)); read(); }

        public static class ByReference extends SDL_JoyAxisEvent implements Structure.ByReference {}
        public static class ByValue extends SDL_JoyAxisEvent implements Structure.ByValue {}
    }

    /**
     * Joystick trackball motion event (event.jball.*)
     *
     * <p>Since: SDL 3.2.0</p>
     */
    @Structure.FieldOrder({
            "type", "reserved", "timestamp", "which",
            "ball", "padding1", "padding2", "padding3",
            "xrel", "yrel"
    })
    public static class SDL_JoyBallEvent extends Structure {
        @MagicConstant(intValues = {
                SDL_EventType.SDL_EVENT_JOYSTICK_BALL_MOTION
        })
        public int type;
        public int reserved;
        /** In nanoseconds, populated using SDL_GetTicksNS(). */
        public long timestamp;
        /** The joystick instance id. */
        public SDL_JoystickID which;
        /** The joystick trackball index. */
        public byte ball;
        public byte padding1;
        public byte padding2;
        public byte padding3;
        /** The relative motion in the X direction. */
        public short xrel;
        /** The relative motion in the Y direction. */
        public short yrel;

        public SDL_JoyBallEvent() {}
        public SDL_JoyBallEvent(long peer) { super(new Pointer(peer)); read(); }

        public static class ByReference extends SDL_JoyBallEvent implements Structure.ByReference {}
        public static class ByValue extends SDL_JoyBallEvent implements Structure.ByValue {}
    }

    /**
     * Joystick hat position change event (event.jhat.*)
     *
     * <p>Since: SDL 3.2.0</p>
     */
    @Structure.FieldOrder({
            "type", "reserved", "timestamp", "which",
            "hat", "value", "padding1", "padding2"
    })
    public static class SDL_JoyHatEvent extends Structure {
        @MagicConstant(intValues = {
                SDL_EventType.SDL_EVENT_JOYSTICK_HAT_MOTION
        })
        public int type;
        public int reserved;
        /** In nanoseconds, populated using SDL_GetTicksNS(). */
        public long timestamp;
        /** The joystick instance id. */
        public SDL_JoystickID which;
        /** The joystick hat index. */
        public byte hat;
        /**
         * The hat position value (SDL_HAT_*). Zero means the POV is centred.
         */
        public byte value;
        public byte padding1;
        public byte padding2;

        public SDL_JoyHatEvent() {}
        public SDL_JoyHatEvent(long peer) { super(new Pointer(peer)); read(); }

        public static class ByReference extends SDL_JoyHatEvent implements Structure.ByReference {}
        public static class ByValue extends SDL_JoyHatEvent implements Structure.ByValue {}
    }

    /**
     * Joystick button event (event.jbutton.*)
     *
     * <p>Since: SDL 3.2.0</p>
     */
    @Structure.FieldOrder({
            "type", "reserved", "timestamp", "which",
            "button", "down", "padding1", "padding2"
    })
    public static class SDL_JoyButtonEvent extends Structure {
        @MagicConstant(intValues = {
                SDL_EventType.SDL_EVENT_JOYSTICK_BUTTON_DOWN,
                SDL_EventType.SDL_EVENT_JOYSTICK_BUTTON_UP
        })
        public int type;
        public int reserved;
        /** In nanoseconds, populated using SDL_GetTicksNS(). */
        public long timestamp;
        /** The joystick instance id. */
        public SDL_JoystickID which;
        /** The joystick button index. */
        public byte button;
        /** {@code true} if the button is pressed. */
        public boolean down;
        public byte padding1;
        public byte padding2;

        public SDL_JoyButtonEvent() {}
        public SDL_JoyButtonEvent(long peer) { super(new Pointer(peer)); read(); }

        public static class ByReference extends SDL_JoyButtonEvent implements Structure.ByReference {}
        public static class ByValue extends SDL_JoyButtonEvent implements Structure.ByValue {}
    }

    /**
     * Joystick device event (event.jdevice.*)
     *
     * <p>SDL will send JOYSTICK_ADDED events for devices already plugged in during {@code SDL_Init()}.</p>
     * <p>Since: SDL 3.2.0</p>
     */
    @Structure.FieldOrder({ "type", "reserved", "timestamp", "which" })
    public static class SDL_JoyDeviceEvent extends Structure {
        @MagicConstant(intValues = {
                SDL_EventType.SDL_EVENT_JOYSTICK_ADDED,
                SDL_EventType.SDL_EVENT_JOYSTICK_REMOVED,
                SDL_EventType.SDL_EVENT_JOYSTICK_UPDATE_COMPLETE
        })
        public int type;
        public int reserved;
        /** In nanoseconds, populated using SDL_GetTicksNS(). */
        public long timestamp;
        /** The joystick instance id. */
        public SDL_JoystickID which;

        public SDL_JoyDeviceEvent() {}
        public SDL_JoyDeviceEvent(long peer) { super(new Pointer(peer)); read(); }

        public static class ByReference extends SDL_JoyDeviceEvent implements Structure.ByReference {}
        public static class ByValue extends SDL_JoyDeviceEvent implements Structure.ByValue {}
    }

    /**
     * Joystick battery level change event (event.jbattery.*)
     *
     * <p>Since: SDL 3.2.0</p>
     */
    @Structure.FieldOrder({ "type", "reserved", "timestamp", "which", "state", "percent" })
    public static class SDL_JoyBatteryEvent extends Structure {
        @MagicConstant(intValues = {
                SDL_EventType.SDL_EVENT_JOYSTICK_BATTERY_UPDATED
        })
        public int type;
        public int reserved;
        /** In nanoseconds, populated using SDL_GetTicksNS(). */
        public long timestamp;
        /** The joystick instance id. */
        public SDL_JoystickID which;
        /** The joystick battery state. */
        @MagicConstant(valuesFromClass = SDL_PowerState.class)
        public int state; // SDL_PowerState
        /** The joystick battery percent remaining (or -1 if unknown). */
        public int percent;

        public SDL_JoyBatteryEvent() {}
        public SDL_JoyBatteryEvent(long peer) { super(new Pointer(peer)); read(); }

        public static class ByReference extends SDL_JoyBatteryEvent implements Structure.ByReference {}
        public static class ByValue extends SDL_JoyBatteryEvent implements Structure.ByValue {}
    }

    // ---------------------------------------------------
    // Gamepad events
    // ---------------------------------------------------

    /**
     * Gamepad axis motion event (event.gaxis.*)
     *
     * <p>Since: SDL 3.2.0</p>
     */
    @Structure.FieldOrder({
            "type", "reserved", "timestamp", "which",
            "axis", "padding1", "padding2", "padding3",
            "value", "padding4"
    })
    public static class SDL_GamepadAxisEvent extends Structure {
        @MagicConstant(intValues = {
                SDL_EventType.SDL_EVENT_GAMEPAD_AXIS_MOTION
        })
        public int type;
        public int reserved;
        /** In nanoseconds, populated using SDL_GetTicksNS(). */
        public long timestamp;
        /** The joystick instance id. */
        public SDL_JoystickID which;
        /** The gamepad axis. */
        @MagicConstant(valuesFromClass = SDL_GamepadAxis.class)
        public byte axis;
        public byte padding1;
        public byte padding2;
        public byte padding3;
        /** The axis value (range: -32768 to 32767). */
        public short value;
        public short padding4;

        public SDL_GamepadAxisEvent() {}
        public SDL_GamepadAxisEvent(long peer) { super(new Pointer(peer)); read(); }

        public static class ByReference extends SDL_GamepadAxisEvent implements Structure.ByReference {}
        public static class ByValue extends SDL_GamepadAxisEvent implements Structure.ByValue {}
    }

    /**
     * Gamepad button event (event.gbutton.*)
     *
     * <p>Since: SDL 3.2.0</p>
     */
    @Structure.FieldOrder({
            "type", "reserved", "timestamp", "which",
            "button", "down", "padding1", "padding2"
    })
    public static class SDL_GamepadButtonEvent extends Structure {
        @MagicConstant(intValues = {
                SDL_EventType.SDL_EVENT_GAMEPAD_BUTTON_DOWN,
                SDL_EventType.SDL_EVENT_GAMEPAD_BUTTON_UP
        })
        public int type;
        public int reserved;
        /** In nanoseconds, populated using SDL_GetTicksNS(). */
        public long timestamp;
        /** The joystick instance id. */
        public SDL_JoystickID which;
        /** The gamepad button. */
        @MagicConstant(valuesFromClass = SDL_GamepadButton.class)
        public byte button;
        /** {@code true} if the button is pressed. */
        public boolean down;
        public byte padding1;
        public byte padding2;

        public SDL_GamepadButtonEvent() {}
        public SDL_GamepadButtonEvent(long peer) { super(new Pointer(peer)); read(); }

        public static class ByReference extends SDL_GamepadButtonEvent implements Structure.ByReference {}
        public static class ByValue extends SDL_GamepadButtonEvent implements Structure.ByValue {}
    }

    /**
     * Gamepad device event (event.gdevice.*)
     *
     * <p>Joysticks that are supported gamepads receive both an SDL_JoyDeviceEvent and an SDL_GamepadDeviceEvent.
     * SDL will send GAMEPAD_ADDED events for joysticks already plugged in during {@code SDL_Init()} and recognised
     * as gamepads, and for devices that get mappings at runtime.</p>
     *
     * <p>Since: SDL 3.2.0</p>
     */
    @Structure.FieldOrder({ "type", "reserved", "timestamp", "which" })
    public static class SDL_GamepadDeviceEvent extends Structure {
        @MagicConstant(intValues = {
                SDL_EventType.SDL_EVENT_GAMEPAD_ADDED,
                SDL_EventType.SDL_EVENT_GAMEPAD_REMOVED,
                SDL_EventType.SDL_EVENT_GAMEPAD_REMAPPED,
                SDL_EventType.SDL_EVENT_GAMEPAD_UPDATE_COMPLETE,
                SDL_EventType.SDL_EVENT_GAMEPAD_STEAM_HANDLE_UPDATED
        })
        public int type;
        public int reserved;
        /** In nanoseconds, populated using SDL_GetTicksNS(). */
        public long timestamp;
        /** The joystick instance id. */
        public SDL_JoystickID which;

        public SDL_GamepadDeviceEvent() {}
        public SDL_GamepadDeviceEvent(long peer) {
            super(new Pointer(peer));
            read();
        }

        public static class ByReference extends SDL_GamepadDeviceEvent implements Structure.ByReference {}
        public static class ByValue extends SDL_GamepadDeviceEvent implements Structure.ByValue {}
    }

    /**
     * Gamepad touchpad event (event.gtouchpad.*)
     *
     * <p>Since: SDL 3.2.0</p>
     */
    @Structure.FieldOrder({
            "type", "reserved", "timestamp", "which",
            "touchpad", "finger", "x", "y", "pressure"
    })
    public static class SDL_GamepadTouchpadEvent extends Structure {
        @MagicConstant(intValues = {
                SDL_EventType.SDL_EVENT_GAMEPAD_TOUCHPAD_DOWN,
                SDL_EventType.SDL_EVENT_GAMEPAD_TOUCHPAD_MOTION,
                SDL_EventType.SDL_EVENT_GAMEPAD_TOUCHPAD_UP
        })
        public int type;
        public int reserved;
        /** In nanoseconds, populated using SDL_GetTicksNS(). */
        public long timestamp;
        /** The joystick instance id. */
        public SDL_JoystickID which;
        /** The index of the touchpad. */
        public int touchpad; // Sint32
        /** The index of the finger on the touchpad. */
        public int finger;   // Sint32
        /** Normalised in the range 0...1 with 0 being on the left. */
        public float x;
        /** Normalised in the range 0...1 with 0 being at the top. */
        public float y;
        /** Normalised in the range 0...1. */
        public float pressure;

        public SDL_GamepadTouchpadEvent() {}
        public SDL_GamepadTouchpadEvent(long peer) {
            super(new Pointer(peer));
            read();
        }

        public static class ByReference extends SDL_GamepadTouchpadEvent implements Structure.ByReference {}
        public static class ByValue extends SDL_GamepadTouchpadEvent implements Structure.ByValue {}
    }

    /**
     * Gamepad sensor event (event.gsensor.*)
     *
     * <p>Since: SDL 3.2.0</p>
     */
    @Structure.FieldOrder({
            "type", "reserved", "timestamp", "which",
            "sensor", "data", "sensor_timestamp"
    })
    public static class SDL_GamepadSensorEvent extends Structure {
        @MagicConstant(intValues = {
                SDL_EventType.SDL_EVENT_GAMEPAD_SENSOR_UPDATE
        })
        public int type;
        public int reserved;
        /** In nanoseconds, populated using SDL_GetTicksNS(). */
        public long timestamp;
        /** The joystick instance id. */
        public SDL_JoystickID which;
        /** The type of the sensor. */
        @MagicConstant(valuesFromClass = SDL_SensorType.class)
        public int sensor; // Sint32
        /** Up to 3 values from the sensor, as defined in SDL_sensor.h. */
        public float[] data = new float[3];
        /**
         * The timestamp of the sensor reading in nanoseconds,
         * not necessarily synchronised with the system clock.
         */
        public long sensor_timestamp;

        public SDL_GamepadSensorEvent() {}
        public SDL_GamepadSensorEvent(long peer) {
            super(new Pointer(peer));
            read();
        }

        public static class ByReference extends SDL_GamepadSensorEvent implements Structure.ByReference {}
        public static class ByValue extends SDL_GamepadSensorEvent implements Structure.ByValue {}
    }

    // ---------------------------------------------------
    // SDL_Event union (reduced to the events we defined)
    // ---------------------------------------------------

    /**
     * The structure for all events in SDL (reduced to included types).
     *
     * <p>The SDL_Event structure is the core of all event handling in SDL; this union
     * includes only the event structs declared in this file.</p>
     *
     * <p>Since: SDL 3.2.0</p>
     *
     * <p>ABI note: includes a 128-byte {@code padding} field to align with SDL’s
     * documented union size across compilers and architectures.</p>
     */
    public static class SDL_Event extends Union {
        /** Event type (Uint32 to cover user events not in SDL_EventType). */
        @MagicConstant(valuesFromClass = SDL_EventType.class)
        public int type;

        /** Common event data. */
        public SDL_CommonEvent common;

        // Joystick
        public SDL_JoyDeviceEvent jdevice;
        public SDL_JoyAxisEvent jaxis;
        public SDL_JoyBallEvent jball;
        public SDL_JoyHatEvent jhat;
        public SDL_JoyButtonEvent jbutton;
        public SDL_JoyBatteryEvent jbattery;

        // Gamepad
        public SDL_GamepadDeviceEvent gdevice;
        public SDL_GamepadAxisEvent gaxis;
        public SDL_GamepadButtonEvent gbutton;
        public SDL_GamepadTouchpadEvent gtouchpad;
        public SDL_GamepadSensorEvent gsensor;

        /**
         * ABI padding to force union size to match SDL's documented size.
         * (JNA will size the union to the largest field; this mirrors SDL’s
         * 128-byte guarantee.)
         */
        public byte[] padding = new byte[128];

        public SDL_Event() { super(); }
        public SDL_Event(long peer) {
            super(new Pointer(peer));
            read();
        }

        // Inside SDL3Events.SDL_Event (the Union) …

        private static Class<?> activeFor(final int t) {
            switch (t) {
                // -------- Joystick device / state --------
                case SDL_EventType.SDL_EVENT_JOYSTICK_ADDED:
                case SDL_EventType.SDL_EVENT_JOYSTICK_REMOVED:
                case SDL_EventType.SDL_EVENT_JOYSTICK_UPDATE_COMPLETE:
                    return SDL_JoyDeviceEvent.class;

                case SDL_EventType.SDL_EVENT_JOYSTICK_BATTERY_UPDATED:
                    return SDL_JoyBatteryEvent.class;

                // -------- Joystick inputs --------
                case SDL_EventType.SDL_EVENT_JOYSTICK_AXIS_MOTION:
                    return SDL_JoyAxisEvent.class;

                case SDL_EventType.SDL_EVENT_JOYSTICK_BALL_MOTION:
                    return SDL_JoyBallEvent.class;

                case SDL_EventType.SDL_EVENT_JOYSTICK_HAT_MOTION:
                    return SDL_JoyHatEvent.class;

                case SDL_EventType.SDL_EVENT_JOYSTICK_BUTTON_DOWN:
                case SDL_EventType.SDL_EVENT_JOYSTICK_BUTTON_UP:
                    return SDL_JoyButtonEvent.class;

                // -------- Gamepad device / mapping --------
                case SDL_EventType.SDL_EVENT_GAMEPAD_ADDED:
                case SDL_EventType.SDL_EVENT_GAMEPAD_REMOVED:
                case SDL_EventType.SDL_EVENT_GAMEPAD_REMAPPED:
                case SDL_EventType.SDL_EVENT_GAMEPAD_UPDATE_COMPLETE:
                case SDL_EventType.SDL_EVENT_GAMEPAD_STEAM_HANDLE_UPDATED:
                    return SDL_GamepadDeviceEvent.class;

                // -------- Gamepad inputs --------
                case SDL_EventType.SDL_EVENT_GAMEPAD_AXIS_MOTION:
                    return SDL_GamepadAxisEvent.class;

                case SDL_EventType.SDL_EVENT_GAMEPAD_BUTTON_DOWN:
                case SDL_EventType.SDL_EVENT_GAMEPAD_BUTTON_UP:
                    return SDL_GamepadButtonEvent.class;

                case SDL_EventType.SDL_EVENT_GAMEPAD_TOUCHPAD_DOWN:
                case SDL_EventType.SDL_EVENT_GAMEPAD_TOUCHPAD_MOTION:
                case SDL_EventType.SDL_EVENT_GAMEPAD_TOUCHPAD_UP:
                    return SDL_GamepadTouchpadEvent.class;

                case SDL_EventType.SDL_EVENT_GAMEPAD_SENSOR_UPDATE:
                    return SDL_GamepadSensorEvent.class;

                // -------- Fallback --------
                default:
                    return SDL_CommonEvent.class;
            }
        }

        @Override
        public void read() {
            // First, read the discriminator only
            readField("type");
            // Pick the correct view and then read the full struct
            setType(activeFor(this.type));
            super.read();
        }

        @Override
        public void write() {
            // Ensure the union view matches the current type before writing
            setType(activeFor(this.type));
            super.write();
        }
    }
}
