package dev.isxander.sdl3java.api.gamepad;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.Union;
import org.intellij.lang.annotations.MagicConstant;

import static dev.isxander.sdl3java.api.gamepad.SDL_GamepadBindingType.*;

/**
 * Get the SDL joystick layer binding for this controller button/axis mapping
 */
@Structure.FieldOrder({
        "bindType",
        "value"
})
public final class SDL_GamepadBinding extends Structure {

    @MagicConstant(valuesFromClass = SDL_GamepadBindingType.class)
    public int inputType;
    public InputTypeValue input;

    @MagicConstant(valuesFromClass = SDL_GamepadBindingType.class)
    public int outputType;
    public OutputTypeValue output;


    public SDL_GamepadBinding() {
    }

    public SDL_GamepadBinding(Pointer p) {
        super(p);
    }

    @Override
    public void read() {
        readField("bindType");
        switch (inputType) {
            case SDL_GAMEPAD_BINDTYPE_BUTTON -> input.setType("button");
            case SDL_GAMEPAD_BINDTYPE_AXIS -> input.setType("axis");
            case SDL_GAMEPAD_BINDTYPE_HAT -> input.setType("hat");
            default -> throw new IllegalStateException("Invalid bind type: " + inputType);
        }
        switch (outputType) {
            case SDL_GAMEPAD_BINDTYPE_BUTTON -> output.setType("button");
            case SDL_GAMEPAD_BINDTYPE_AXIS -> output.setType("axis");
            default -> throw new IllegalStateException("Invalid bind type: " + outputType);
        }
        super.read();
    }

    public static final class InputTypeValue extends Union {

        public int button;
        public Axis axis;
        public Hat hat;

        public InputTypeValue() {
        }

        public InputTypeValue(Pointer p) {
            super(p);
        }
    }

    public static final class OutputTypeValue extends Union {

        @MagicConstant(valuesFromClass = SDL_GamepadBindingType.class)
        public int button;
        public Axis axis;
    }

    @FieldOrder({
            "axis",
            "axis_min",
            "axis_max",
    })
    public static final class Axis extends Structure {
        public int axis;
        public int axis_min;
        public int axis_max;

        public Axis() {
        }

        public Axis(Pointer p) {
            super(p);
        }
    }

    @FieldOrder({
            "hat",
            "hat_mask"
    })
    public static final class Hat extends Structure {

        public int hat;
        public int hat_mask;

        public Hat() {
        }

        public Hat(Pointer p) {
            super(p);
        }
    }
}
