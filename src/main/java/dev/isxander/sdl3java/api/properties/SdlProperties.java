package dev.isxander.sdl3java.api.properties;

import com.sun.jna.Pointer;
import dev.isxander.sdl3java.jna.SdlNativeLibraryLoader;
import org.intellij.lang.annotations.MagicConstant;

public final class SdlProperties {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlProperties.class);
    }

    private SdlProperties() {
    }

    public static native SDL_PropertiesID SDL_GetGlobalProperties();

    public static native SDL_PropertiesID SDL_CreateProperties();

    public static native int SDL_LockProperties(SDL_PropertiesID props);

    public static native void SDL_UnlockProperties(SDL_PropertiesID props);

    public static native int SDL_SetPropertyWithCleanup(SDL_PropertiesID props, String name, Pointer value, SDL_CleanupCallback cleanup, Pointer userdata);

    public static native int SDL_SetProperty(SDL_PropertiesID props, String name, Pointer value);

    public static native int SDL_SetStringProperty(SDL_PropertiesID props, String name, String value);

    public static native int SDL_SetNumberProperty(SDL_PropertiesID props, String name, long value);

    public static native int SDL_SetFloatProperty(SDL_PropertiesID props, String name, float value);

    public static native int SDL_SetBooleanProperty(SDL_PropertiesID props, String name, boolean value);

    @MagicConstant(valuesFromClass = SDL_PropertyType.class)
    public static native int SDL_GetPropertyType(SDL_PropertiesID props, String name);

    public static native Pointer SDL_GetProperty(SDL_PropertiesID props, String name);

    public static native String SDL_GetStringProperty(SDL_PropertiesID props, String name,  String defaultValue);

    public static native long SDL_GetNumberProperty(SDL_PropertiesID props, String name, long defaultValue);

    public static native float SDL_GetFloatProperty(SDL_PropertiesID props, String name, float defaultValue);

    public static native boolean SDL_GetBooleanProperty(SDL_PropertiesID props, String name, boolean defaultValue);

    public static native int SDL_ClearProperty(SDL_PropertiesID props, String name);

    public static native int SDL_EnumerateProperties(SDL_PropertiesID props, SDL_EnumeratePropertiesCallback callback, Pointer userdata);

    public static native void SDL_DestroyProperties(SDL_PropertiesID props);

}
