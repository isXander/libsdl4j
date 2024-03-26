package dev.isxander.sdl3java.api.properties;

import dev.isxander.sdl3java.jna.JnaEnum;

public final class SDL_PropertyType implements JnaEnum {
    public static final int SDL_PROPERTY_TYPE_INVALID = 0;
    public static final int SDL_PROPERTY_TYPE_POINTER = 1;
    public static final int SDL_PROPERTY_TYPE_STRING = 2;
    public static final int SDL_PROPERTY_TYPE_NUMBER = 3;
    public static final int SDL_PROPERTY_TYPE_FLOAT = 4;
    public static final int SDL_PROPERTY_TYPE_BOOLEAN = 5;
}
