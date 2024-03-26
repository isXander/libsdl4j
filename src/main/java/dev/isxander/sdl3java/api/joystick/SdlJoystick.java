package dev.isxander.sdl3java.api.joystick;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.ptr.ShortByReference;
import dev.isxander.sdl3java.api.properties.SDL_PropertiesID;
import dev.isxander.sdl3java.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

public final class SdlJoystick {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlJoystick.class);
    }

    private SdlJoystick() {
    }

    public static native void SDL_LockJoysticks();

    public static native void SDL_UnlockJoysticks();

    public static SDL_JoystickID[] SDL_GetJoysticks() {
        IntByReference count = new IntByReference();
        Pointer p = InternalNativeFunctions.SDL_GetJoysticks(count);

        if (p == null) {
            return new SDL_JoystickID[0];
        }

        SDL_JoystickID[] joysticks = new SDL_JoystickID[count.getValue()];

        for (int i = 0; i < joysticks.length; i++) {
            joysticks[i] = new SDL_JoystickID(p.getNativeLong((long) i * Native.getNativeSize(SDL_JoystickID.class)).longValue());
        }

        return joysticks;
    }

    public static native String SDL_GetJoystickInstanceName(SDL_JoystickID instance_id);

    public static native String SDL_GetJoystickInstancePath(SDL_JoystickID instance_id);

    public static native int SDL_GetJoystickInstancePlayerIndex(SDL_JoystickID instance_id);

    public static native SDL_JoystickGUID SDL_GetJoystickInstanceGUID(SDL_JoystickID instance_id);

    public static native short SDL_GetJoystickInstanceVendor(SDL_JoystickID instance_id);

    public static native short SDL_GetJoystickInstanceProduct(SDL_JoystickID instance_id);

    public static native short SDL_GetJoystickInstanceProductVersion(SDL_JoystickID instance_id);

    @MagicConstant(flagsFromClass = SDL_JoystickType.class)
    public static native int SDL_GetJoystickInstanceType(SDL_JoystickID instance_id);

    public static native SDL_Joystick SDL_OpenJoystick(SDL_JoystickID instance_id);

    public static native SDL_Joystick SDL_GetJoystickFromInstanceID(SDL_JoystickID instance_id);

    public static native SDL_Joystick SDL_GetJoystickFromPlayerIndex(int player_index);

    // TODO: virtual joysticks

    public static native SDL_PropertiesID SDL_GetJoystickProperties(SDL_Joystick joystick);

    public static native String SDL_GetJoystickName(SDL_Joystick joystick);

    public static native String SDL_GetJoystickPath(SDL_Joystick joystick);

    public static native int SDL_GetJoystickPlayerIndex(SDL_Joystick joystick);

    public static native int SDL_SetJoystickPlayerIndex(SDL_Joystick joystick, int player_index);

    public static native short SDL_GetJoystickVendor(SDL_Joystick joystick);

    public static native short SDL_GetJoystickProduct(SDL_Joystick joystick);

    public static native short SDL_GetJoystickProductVersion(SDL_Joystick joystick);

    public static native short SDL_GetJoystickFirmwareVersion(SDL_Joystick joystick);

    public static native String SDL_GetJoystickSerial(SDL_Joystick joystick);

    @MagicConstant(flagsFromClass = SDL_JoystickType.class)
    public static native int SDL_GetJoystickType(SDL_Joystick joystick);

    public static String SDL_GetJoystickGUIDString(SDL_JoystickGUID guid) {
        try (Memory textBuffer = new Memory(33L)) {
            InternalNativeFunctions.SDL_GetJoystickGUIDString(guid, textBuffer, 33);
            return textBuffer.getString(0L, "US_ASCII");
        }
    }

    public static native SDL_JoystickGUID SDL_GetJoystickGUIDFromString(String pchGUID);

    public static native void SDL_GetJoystickGUIDInfo(
            SDL_JoystickGUID guid,
            ShortByReference vendor,
            ShortByReference product,
            ShortByReference version,
            ShortByReference crc16);

    public static native boolean SDL_JoystickConnected(SDL_Joystick joystick);

    public static native SDL_JoystickID SDL_GetJoystickInstanceID(SDL_Joystick joystick);

    public static native int SDL_GetNumJoystickAxes(SDL_Joystick joystick);

    public static native int SDL_GetNumJoystickHats(SDL_Joystick joystick);

    public static native int SDL_GetNumJoystickButtons(SDL_Joystick joystick);

    public static native void SDL_SetJoystickEventsEnabled(boolean enabled);

    public static native boolean SDL_JoystickEventsEnabled();

    public static native void SDL_UpdateJoysticks();

    public static native short SDL_GetJoystickAxis(SDL_Joystick joystick, int axis);

    public static native boolean SDL_GetJoystickAxisInitialState(SDL_Joystick joystick, int axis, ShortByReference state);

    public static native byte SDL_GetJoystickHat(SDL_Joystick joystick, int hat);

    public static native byte SDL_GetJoystickButton(SDL_Joystick joystick, int button);

    public static native int SDL_RumbleJoystick(SDL_Joystick joystick, short low_frequency_rumble, short high_frequency_rumble, int duration_ms);

    public static native int SDL_RumbleJoystickTriggers(SDL_Joystick joystick, short left_rumble, short right_rumble, int duration_ms);

    public static native int SDL_SendJoystickEffect(SDL_Joystick joystick, Pointer data, int size);

    public static native void SDL_CloseJoystick(SDL_Joystick joystick);

    @MagicConstant(flagsFromClass = SDL_JoystickPowerLevel.class)
    public static native int SDL_GetJoystickPowerLevel(SDL_Joystick joystick);

    private static final class InternalNativeFunctions {
        static {
            SdlNativeLibraryLoader.registerNativeMethods(InternalNativeFunctions.class);
        }

        private InternalNativeFunctions() {
        }

        public static native Pointer SDL_GetJoysticks(IntByReference count);

        public static native void SDL_GetJoystickGUIDString(SDL_JoystickGUID guid, Pointer pszGUID, int cbGUID);
    }
}
