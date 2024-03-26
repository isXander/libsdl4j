package io.github.libsdl4j.api.gamepad;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.sun.jna.ptr.FloatByReference;
import com.sun.jna.ptr.IntByReference;
import io.github.libsdl4j.api.iostream.SDL_IOStream;
import io.github.libsdl4j.api.joystick.SDL_Joystick;
import io.github.libsdl4j.api.joystick.SDL_JoystickGUID;
import io.github.libsdl4j.api.joystick.SDL_JoystickID;
import io.github.libsdl4j.api.joystick.SDL_JoystickPowerLevel;
import io.github.libsdl4j.api.properties.SDL_PropertiesID;
import io.github.libsdl4j.api.iostream.SDL_IOStreamInterface;
import io.github.libsdl4j.api.sensor.SDL_SensorType;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.iostream.SdlIOStream.SDL_IOFromFile;

public final class SdlGamepad {
    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlGamepad.class);
    }

    private SdlGamepad() {
    }

    public static native int SDL_AddGamepadMapping(String mapping);

    public static native int SDL_AddGamepadMappingsFromIO(SDL_IOStream src, boolean freesrc);

    public static int SDL_AddGamepadMappingsFromFile(String file) {
        return SDL_AddGamepadMappingsFromIO(SDL_IOFromFile(file, "rb"), true);
    }

    public static native int SDL_ReloadGamepadMappings();

    // TODO: String[] SDL_GetGamepadMappings(IntByReference count);

    public static native String SDL_GetGamepadMappingForGUID(SDL_JoystickGUID guid);

    public static native String SDL_GetGamepadMapping(SDL_Gamepad gamepad);

    public static native int SDL_SetGamepadMapping(SDL_JoystickID instance_id, String mapping);

    public static SDL_JoystickID[] SDL_GetGamepads() {
        IntByReference count = new IntByReference();
        Pointer p = InternalNativeFunctions.SDL_GetGamepads(count);

        if (p == null) {
            return new SDL_JoystickID[0];
        }

        SDL_JoystickID[] gamepads = new SDL_JoystickID[count.getValue()];

        for (int i = 0; i < gamepads.length; i++) {
            gamepads[i] = new SDL_JoystickID(p.getNativeLong((long) i * Native.getNativeSize(SDL_JoystickID.class)).longValue());
        }

        return gamepads;
    }

    public static native boolean SDL_IsGamepad(SDL_JoystickID instance_id);

    public static native String SDL_GetGamepadInstanceName(SDL_JoystickID instance_id);

    public static native String SDL_GetGamepadInstancePath(SDL_JoystickID instance_id);

    public static native int SDL_GetGamepadInstancePlayerIndex(SDL_JoystickID instance_id);

    public static native SDL_JoystickGUID SDL_GetGamepadInstanceGUID(SDL_JoystickID instance_id);

    public static native short SDL_GetGamepadInstanceVendor(SDL_JoystickID instance_id);

    public static native short SDL_GetGamepadInstanceProduct(SDL_JoystickID instance_id);

    public static native short SDL_GetGamepadInstanceProductVersion(SDL_JoystickID instance_id);

    @MagicConstant(valuesFromClass = SDL_GamepadType.class)
    public static native int SDL_GetGamepadInstanceType(SDL_JoystickID instance_id);

    @MagicConstant(valuesFromClass = SDL_GamepadType.class)
    public static native int SDL_GetRealGamepadInstanceType(SDL_JoystickID instance_id);

    public static native String SDL_GetGamepadInstanceMapping(SDL_JoystickID instance_id);

    public static native SDL_Gamepad SDL_OpenGamepad(SDL_JoystickID instance_id);

    public static native SDL_Gamepad SDL_GetGamepadFromInstanceID(SDL_JoystickID instance_id);

    public static native SDL_Gamepad SDL_GetGamepadFromPlayerIndex(int player_index);

    public static native SDL_PropertiesID SDL_GetGamepadProperties(SDL_Gamepad gamepad);

    public static native SDL_JoystickID SDL_GetGamepadInstanceID(SDL_Gamepad gamepad);

    public static native String SDL_GetGamepadName(SDL_Gamepad gamepad);

    public static native String SDL_GetGamepadPath(SDL_Gamepad gamepad);

    @MagicConstant(valuesFromClass = SDL_GamepadType.class)
    public static native int SDL_GetGamepadType(SDL_Gamepad gamepad);

    @MagicConstant(valuesFromClass = SDL_GamepadType.class)
    public static native int SDL_GetRealGamepadType(SDL_Gamepad gamepad);

    public static native int SDL_GetGamepadPlayerIndex(SDL_Gamepad gamepad);

    public static native int SDL_SetGamepadPlayerIndex(SDL_Gamepad gamepad, int player_index);

    public static native short SDL_GetGamepadVendor(SDL_Gamepad gamepad);

    public static native short SDL_GetGamepadProduct(SDL_Gamepad gamepad);

    public static native short SDL_GetGamepadProductVersion(SDL_Gamepad gamepad);

    public static native short SDL_GetGamepadFirmwareVersion(SDL_Gamepad gamepad);

    public static native String SDL_GetGamepadSerial(SDL_Gamepad gamepad);

    public static native long SDL_GetGamepadSteamHandle(SDL_Gamepad gamepad);

    @MagicConstant(valuesFromClass = SDL_JoystickPowerLevel.class)
    public static native int SDL_GetGamepadPowerLevel(SDL_Gamepad gamepad);

    public static native boolean SDL_GamepadConnected(SDL_Gamepad gamepad);

    public static native SDL_Joystick SDL_GetGamepadJoystick(SDL_Gamepad gamepad);

    public static native void SDL_SetGamepadEventsEnabled(boolean enabled);

    public static native boolean SDL_GamepadEventsEnabled();

    public static native SDL_GamepadBinding SDL_GetGamepadBindings(SDL_Gamepad gamepad, IntByReference count);

    public static native void SDL_UpdateGamepads();

    @MagicConstant(valuesFromClass = SDL_GamepadType.class)
    public static native int SDL_GetGamepadTypeFromString(String str);

    public static native String SDL_GetGamepadStringForType(@MagicConstant(valuesFromClass = SDL_GamepadType.class) int type);

    @MagicConstant(valuesFromClass = SDL_GamepadAxis.class)
    public static native int SDL_GetGamepadAxisFromString(String str);

    public static native String SDL_GetGamepadStringForAxis(@MagicConstant(valuesFromClass = SDL_GamepadAxis.class) int axis);

    public static native boolean SDL_GamepadHasAxis(SDL_Gamepad gamepad, @MagicConstant(valuesFromClass = SDL_GamepadAxis.class) int axis);

    public static native short SDL_GetGamepadAxis(SDL_Gamepad gamepad, @MagicConstant(valuesFromClass = SDL_GamepadAxis.class) int axis);

    @MagicConstant(valuesFromClass = SDL_GamepadButton.class)
    public static native int SDL_GetGamepadButtonFromString(String str);

    public static native String SDL_GetGamepadStringForButton(@MagicConstant(valuesFromClass = SDL_GamepadButton.class) int button);

    public static native boolean SDL_GamepadHasButton(SDL_Gamepad gamepad, @MagicConstant(valuesFromClass = SDL_GamepadButton.class) int button);

    public static native byte SDL_GetGamepadButton(SDL_Gamepad gamepad, @MagicConstant(valuesFromClass = SDL_GamepadButton.class) int button);

    @MagicConstant(valuesFromClass = SDL_GamepadButtonLabel.class)
    public static native int SDL_GetGamepadButtonLabelForType(@MagicConstant(valuesFromClass = SDL_GamepadType.class) int type, @MagicConstant(valuesFromClass = SDL_GamepadButton.class) int button);

    @MagicConstant(valuesFromClass = SDL_GamepadButtonLabel.class)
    public static native int SDL_GetGamepadButtonLabel(SDL_Gamepad gamepad, @MagicConstant(valuesFromClass = SDL_GamepadButton.class) int button);

    public static native int SDL_GetNumGamepadTouchpads(SDL_Gamepad gamepad);

    public static native int SDL_GetNumGamepadTouchpadFingers(SDL_Gamepad gamepad, int touchpad);

    public static native int SDL_GetGamepadTouchpadFinger(SDL_Gamepad gamepad, int touchpad, int finger, ByteByReference state, FloatByReference x, FloatByReference y, FloatByReference pressure);

    public static native boolean SDL_GamepadHasSensor(SDL_Gamepad gamepad, @MagicConstant(valuesFromClass = SDL_SensorType.class) int type);

    public static native int SDL_SetGamepadSensorEnabled(SDL_Gamepad gamepad, @MagicConstant(valuesFromClass = SDL_SensorType.class) int type, boolean enabled);

    public static native boolean SDL_GamepadSensorEnabled(SDL_Gamepad gamepad, @MagicConstant(valuesFromClass = SDL_SensorType.class) int type);

    public static native float SDL_GetGamepadSensorDataRate(SDL_Gamepad gamepad, @MagicConstant(valuesFromClass = SDL_SensorType.class) int type);

    public static native int SDL_GetGamepadSensorData(SDL_Gamepad gamepad, @MagicConstant(valuesFromClass = SDL_SensorType.class) int type, Pointer data, int num_values);

    public static native int SDL_RumbleGamepad(SDL_Gamepad gamepad, short low_frequency_rumble, short high_frequency_rumble, int duration_ms);

    public static native int SDL_RumbleGamepadTriggers(SDL_Gamepad gamepad, short left_rumble, short right_rumble, int duration_ms);

    public static native int SDL_SetGamepadLED(SDL_Gamepad gamepad, byte red, byte green, byte blue);

    public static native int SDL_SendGamepadEffect(SDL_Gamepad gamepad, Pointer data, int size);

    public static native void SDL_CloseGamepad(SDL_Gamepad gamepad);

    public static native String SDL_GetGamepadAppleSFSymbolsNameForButton(SDL_Gamepad gamepad, @MagicConstant(valuesFromClass = SDL_GamepadButton.class) int button);

    public static native String SDL_GetGamepadAppleSFSymbolsNameForAxis(SDL_Gamepad gamepad, @MagicConstant(valuesFromClass = SDL_GamepadAxis.class) int axis);

    private static final class InternalNativeFunctions {
        static {
            SdlNativeLibraryLoader.registerNativeMethods(InternalNativeFunctions.class);
        }

        private InternalNativeFunctions() {
        }

        public static native Pointer SDL_GetGamepads(IntByReference count);
    }
}
