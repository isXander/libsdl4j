package dev.isxander.sdl3java.api.events;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import dev.isxander.sdl3java.api.events.events.SDL_Event;
import dev.isxander.sdl3java.jna.NativeInt;
import dev.isxander.sdl3java.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

public final class SdlEvents {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlEvents.class);
    }

    private SdlEvents() {
    }

    public static native void SDL_PumpEvents();

    public static native int SDL_PeepEvents(Pointer events, int numEvents, @MagicConstant(valuesFromClass = SDL_eventaction.class) int action, @MagicConstant(valuesFromClass = SDL_EventType.class) int minType, @MagicConstant(valuesFromClass = SDL_EventType.class) int maxType);

    public static native boolean SDL_HasEvent(@MagicConstant(valuesFromClass = SDL_EventType.class) int type);

    public static native boolean SDL_HasEvents(@MagicConstant(valuesFromClass = SDL_EventType.class) int minType, @MagicConstant(valuesFromClass = SDL_EventType.class) int maxType);

    public static native void SDL_FlushEvent(@MagicConstant(valuesFromClass = SDL_EventType.class) int type);

    public static native void SDL_FlushEvents(@MagicConstant(valuesFromClass = SDL_EventType.class) int minType, @MagicConstant(valuesFromClass = SDL_EventType.class) int maxType);

    public static native boolean SDL_PollEvent(SDL_Event event);

    public static native boolean SDL_WaitEvent(SDL_Event event);

    public static native boolean SDL_WaitEventTimeout(SDL_Event event, int timeout);

    public static native boolean SDL_PushEvent(SDL_Event event);

    public static native void SDL_SetEventFilter(SDL_EventFilter filter, Pointer userdata);

    public static native boolean SDL_GetEventFilter(PointerByReference filter, PointerByReference userdata);

    public static native boolean SDL_AddEventWatch(SDL_EventFilter filter, Pointer userdata);

    public static native void SDL_RemoveEventWatch(SDL_EventFilter filter, Pointer userdata);

    public static native void SDL_FilterEvents(SDL_EventFilter filter, Pointer userdata);

    public static native void SDL_SetEventEnabled(@MagicConstant(valuesFromClass = SDL_EventType.class) int type, boolean enabled);

    public static native boolean SDL_EventEnabled(@MagicConstant(valuesFromClass = SDL_EventType.class) int type);

    @NativeInt(NativeInt.Type.UINT32)
    public static native int SDL_RegisterEvents(int numEvents);
}
