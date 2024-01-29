package io.github.libsdl4j.api.events.events;

import com.sun.jna.Structure;
import io.github.libsdl4j.api.events.SDL_EventType;
import io.github.libsdl4j.api.joystick.SDL_JoystickID;
import org.intellij.lang.annotations.MagicConstant;

public final class SDL_GamepadDeviceEvent extends Structure {
    @MagicConstant(intValues = {
            SDL_EventType.SDL_EVENT_GAMEPAD_ADDED,
            SDL_EventType.SDL_EVENT_GAMEPAD_REMOVED,
            SDL_EventType.SDL_EVENT_GAMEPAD_REMAPPED,
            SDL_EventType.SDL_EVENT_GAMEPAD_UPDATE_COMPLETE,
            SDL_EventType.SDL_EVENT_GAMEPAD_STEAM_HANDLE_UPDATED,
    })
    public int type;

    public int timestamp;

    public SDL_JoystickID which;
}
