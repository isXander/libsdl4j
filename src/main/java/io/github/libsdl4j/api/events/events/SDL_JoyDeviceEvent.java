package io.github.libsdl4j.api.events.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import io.github.libsdl4j.api.events.SDL_EventType;
import io.github.libsdl4j.api.joystick.SDL_JoystickID;
import org.intellij.lang.annotations.MagicConstant;

public final class SDL_JoyDeviceEvent extends Structure {
    @MagicConstant(intValues = {
            SDL_EventType.SDL_EVENT_JOYSTICK_ADDED,
            SDL_EventType.SDL_EVENT_JOYSTICK_REMOVED,
            SDL_EventType.SDL_EVENT_JOYSTICK_UPDATE_COMPLETE,
    })
    public int type;

    public int timestamp;

    public SDL_JoystickID which;

    public SDL_JoyDeviceEvent() {
    }

    public SDL_JoyDeviceEvent(Pointer p) {
        super(p);
    }
}
