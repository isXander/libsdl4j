package dev.isxander.sdl3java.api.events;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import dev.isxander.sdl3java.api.SDL_bool;
import dev.isxander.sdl3java.api.events.events.SDL_Event;
import dev.isxander.sdl3java.jna.SdlNativeLibraryLoader;
import dev.isxander.sdl3java.jna.size_t;
import org.intellij.lang.annotations.MagicConstant;

public final class SdlEvents {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlEvents.class);
    }

    private SdlEvents() {
    }

    public static native void SDL_PumpEvents();

    public static native int SDL_PeepEvents(Pointer events, int numEvents, @MagicConstant(valuesFromClass = SDL_eventaction.class) int action, @MagicConstant(valuesFromClass = SDL_EventType.class) int minType, @MagicConstant(valuesFromClass = SDL_EventType.class) int maxType);

    @MagicConstant(valuesFromClass = SDL_bool.class)
    public static native int SDL_HasEvent(@MagicConstant(valuesFromClass = SDL_EventType.class) int type);

    @MagicConstant(valuesFromClass = SDL_bool.class)
    public static native int SDL_HasEvents(@MagicConstant(valuesFromClass = SDL_EventType.class) int minType, @MagicConstant(valuesFromClass = SDL_EventType.class) int maxType);

    public static native void SDL_FlushEvent(@MagicConstant(valuesFromClass = SDL_EventType.class) int type);

    public static native void SDL_FlushEvents(@MagicConstant(valuesFromClass = SDL_EventType.class) int minType, @MagicConstant(valuesFromClass = SDL_EventType.class) int maxType);

    @MagicConstant(valuesFromClass = SDL_bool.class)
    public static native int SDL_PollEvent(SDL_Event event);

    @MagicConstant(valuesFromClass = SDL_bool.class)
    public static native int SDL_WaitEvent(SDL_Event event);

    @MagicConstant(valuesFromClass = SDL_bool.class)
    public static native int SDL_WaitEventTimeout(SDL_Event event, int timeout);

    public static native int SDL_PushEvent(SDL_Event event);

    public static native void SDL_SetEventFilter(SDL_EventFilter filter, Pointer userdata);

    @MagicConstant(valuesFromClass = SDL_bool.class)
    public static native int SDL_GetEventFilter(PointerByReference filter, PointerByReference userdata);

    public static native int SDL_AddEventWatch(SDL_EventFilter filter, Pointer userdata);

    public static native void SDL_DelEventWatch(SDL_EventFilter filter, Pointer userdata);

    public static native void SDL_FilterEvents(SDL_EventFilter filter, Pointer userdata);

    public static native void SDL_SetEventEnabled(@MagicConstant(valuesFromClass = SDL_EventType.class) int type, boolean enabled);

    @MagicConstant(valuesFromClass = SDL_bool.class)
    public static native int SDL_EventEnabled(@MagicConstant(valuesFromClass = SDL_EventType.class) int type);

    public static native int SDL_RegisterEvents(int numEvents);

    public static native Pointer SDL_AllocateEventMemory(size_t size);
}
