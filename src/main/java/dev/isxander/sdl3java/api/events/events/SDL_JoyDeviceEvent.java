package dev.isxander.sdl3java.api.events.events;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import dev.isxander.sdl3java.api.events.SDL_EventType;
import dev.isxander.sdl3java.api.joystick.SDL_JoystickID;
import org.intellij.lang.annotations.MagicConstant;

@Structure.FieldOrder({
        "type",
        "reserved",
        "timestamp",
        "which",
})
public final class SDL_JoyDeviceEvent extends Structure {
    @MagicConstant(intValues = {
            SDL_EventType.SDL_EVENT_JOYSTICK_ADDED,
            SDL_EventType.SDL_EVENT_JOYSTICK_REMOVED,
            SDL_EventType.SDL_EVENT_JOYSTICK_UPDATE_COMPLETE,
    })
    public int type;
    public int reserved;

    public long timestamp;

    public SDL_JoystickID which;

    public SDL_JoyDeviceEvent() {
    }

    public SDL_JoyDeviceEvent(Pointer p) {
        super(p);
    }
}
