package io.github.libsdl4j.api.events;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import io.github.libsdl4j.api.events.events.SDL_Event;
import io.github.libsdl4j.jna.SdlNativeLibraryLoader;
import io.github.libsdl4j.jna.size_t;
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

    public static native int SDL_PushEvent(SDL_Event event);

    public static native void SDL_SetEventFilter(SDL_EventFilter filter, Pointer userdata);

    public static native boolean SDL_GetEventFilter(PointerByReference filter, PointerByReference userdata);

    public static native int SDL_AddEventWatch(SDL_EventFilter filter, Pointer userdata);

    public static native void SDL_DelEventWatch(SDL_EventFilter filter, Pointer userdata);

    public static native void SDL_FilterEvents(SDL_EventFilter filter, Pointer userdata);

    public static native void SDL_SetEventEnabled(@MagicConstant(valuesFromClass = SDL_EventType.class) int type, boolean enabled);

    public static native boolean SDL_EventEnabled(@MagicConstant(valuesFromClass = SDL_EventType.class) int type);

    public static native int SDL_RegisterEvents(int numEvents);

    public static native Pointer SDL_AllocateEventMemory(size_t size);
}
