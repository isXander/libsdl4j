package io.github.libsdl4j.api.events;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_eventaction implements JnaEnum {
    public static final byte SDL_ADDEVENT = 0;
    public static final byte SDL_PEEKEVENT = 1;
    public static final byte SDL_GETEVENT = 2;

    private SDL_eventaction() {
    }
}
