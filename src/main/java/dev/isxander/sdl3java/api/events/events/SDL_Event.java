package dev.isxander.sdl3java.api.events.events;

import com.sun.jna.Pointer;
import com.sun.jna.Union;
import dev.isxander.sdl3java.api.events.SDL_EventType;
import org.intellij.lang.annotations.MagicConstant;

import static dev.isxander.sdl3java.api.events.SDL_EventType.*;

public final class SDL_Event extends Union {
    @MagicConstant(valuesFromClass = SDL_EventType.class)
    public int type;

    public SDL_CommonEvent common;

    public SDL_JoyDeviceEvent jdevice;

    public SDL_GamepadDeviceEvent gdevice;

    public SDL_Event() {
    }

    public SDL_Event(Pointer p) {
        super(p);
    }

    @Override
    public void read() {
        readField("type");
        switch (type) {
            case SDL_EVENT_JOYSTICK_ADDED:
            case SDL_EVENT_JOYSTICK_REMOVED:
            case SDL_EVENT_JOYSTICK_UPDATE_COMPLETE:
                setType(SDL_JoyDeviceEvent.class);
                break;
            case SDL_EVENT_GAMEPAD_ADDED:
            case SDL_EVENT_GAMEPAD_REMOVED:
            case SDL_EVENT_GAMEPAD_REMAPPED:
            case SDL_EVENT_GAMEPAD_UPDATE_COMPLETE:
            case SDL_EVENT_GAMEPAD_STEAM_HANDLE_UPDATED:
                setType(SDL_GamepadDeviceEvent.class);
                break;
            default:
                setType(SDL_CommonEvent.class);
                break;
        }

        super.read();
    }
}
