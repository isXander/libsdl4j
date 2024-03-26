package dev.isxander.sdl3java.api.events;

import dev.isxander.sdl3java.jna.JnaEnum;

public class SDL_EventType implements JnaEnum {
    public static final int SDL_EVENT_FIRST = 0; // Unused (do not remove)

    // Application events
    public static final int SDL_EVENT_QUIT = 0x100; // User-requested quit

    // These application events have special meaning on iOS, see README-ios.md for details
    public static final int SDL_EVENT_TERMINATING = SDL_EVENT_QUIT + 1; // The application is being terminated by the OS Called on iOS in applicationWillTerminate() Called on Android in onDestroy()
    public static final int SDL_EVENT_LOW_MEMORY = SDL_EVENT_TERMINATING + 1; // The application is low on memory, free memory if possible. Called on iOS in applicationDidReceiveMemoryWarning() Called on Android in onLowMemory()
    public static final int SDL_EVENT_WILL_ENTER_BACKGROUND = SDL_EVENT_LOW_MEMORY + 1; // The application is about to enter the background Called on iOS in applicationWillResignActive() Called on Android in onPause()
    public static final int SDL_EVENT_DID_ENTER_BACKGROUND = SDL_EVENT_WILL_ENTER_BACKGROUND + 1; // The application did enter the background and may not get CPU for some time Called on iOS in applicationDidEnterBackground() Called on Android in onPause()
    public static final int SDL_EVENT_WILL_ENTER_FOREGROUND = SDL_EVENT_DID_ENTER_BACKGROUND + 1; // The application is about to enter the foreground Called on iOS in applicationWillEnterForeground() Called on Android in onResume()
    public static final int SDL_EVENT_DID_ENTER_FOREGROUND = SDL_EVENT_WILL_ENTER_FOREGROUND + 1; // The application is now interactive Called on iOS in applicationDidBecomeActive() Called on Android in onResume()

    public static final int SDL_EVENT_LOCALE_CHANGED = SDL_EVENT_DID_ENTER_FOREGROUND + 1; // The user's locale preferences have changed.
    public static final int SDL_EVENT_SYSTEM_THEME_CHANGED = SDL_EVENT_LOCALE_CHANGED + 1; // The system theme changed

    // Display events
    // 0x150 was SDL_DISPLAYEVENT, reserve the number for sdl2-compat
    public static final int SDL_EVENT_DISPLAY_ORIENTATION = 0x151; // Display orientation has changed to data1
    public static final int SDL_EVENT_DISPLAY_ADDED = SDL_EVENT_DISPLAY_ORIENTATION + 1; // Display has been added to the system
    public static final int SDL_EVENT_DISPLAY_REMOVED = SDL_EVENT_DISPLAY_ADDED + 1; // Display has been removed from the system
    public static final int SDL_EVENT_DISPLAY_MOVED = SDL_EVENT_DISPLAY_REMOVED + 1; // Display has changed position
    public static final int SDL_EVENT_DISPLAY_CONTENT_SCALE_CHANGED = SDL_EVENT_DISPLAY_MOVED + 1; // Display has changed content scale
    public static final int SDL_EVENT_DISPLAY_FIRST = SDL_EVENT_DISPLAY_ORIENTATION;
    public static final int SDL_EVENT_DISPLAY_LAST = SDL_EVENT_DISPLAY_CONTENT_SCALE_CHANGED;

    // Window events
    // 0x200 was SDL_WINDOWEVENT, reserve the number for sdl2-compat
    // 0x201 was SDL_EVENT_SYSWM, reserve the number for sdl2-compat
    public static final int SDL_EVENT_WINDOW_SHOWN = 0x202; // Window has been shown
    public static final int SDL_EVENT_WINDOW_HIDDEN = SDL_EVENT_WINDOW_SHOWN + 1; // Window has been hidden
    public static final int SDL_EVENT_WINDOW_EXPOSED = SDL_EVENT_WINDOW_HIDDEN + 1; // Window has been exposed and should be redrawn
    public static final int SDL_EVENT_WINDOW_MOVED = SDL_EVENT_WINDOW_EXPOSED + 1; // Window has been moved to data1, data2
    public static final int SDL_EVENT_WINDOW_RESIZED = SDL_EVENT_WINDOW_MOVED + 1; // Window has been resized to data1xdata2
    public static final int SDL_EVENT_WINDOW_PIXEL_SIZE_CHANGED = SDL_EVENT_WINDOW_RESIZED + 1; // The pixel size of the window has changed to data1xdata2
    public static final int SDL_EVENT_WINDOW_MINIMIZED = SDL_EVENT_WINDOW_PIXEL_SIZE_CHANGED + 1; // Window has been minimized
    public static final int SDL_EVENT_WINDOW_MAXIMIZED = SDL_EVENT_WINDOW_MINIMIZED + 1; // Window has been maximized
    public static final int SDL_EVENT_WINDOW_RESTORED = SDL_EVENT_WINDOW_MAXIMIZED + 1; // Window has been restored to normal size and position
    public static final int SDL_EVENT_WINDOW_MOUSE_ENTER = SDL_EVENT_WINDOW_RESTORED + 1; // Window has gained mouse focus
    public static final int SDL_EVENT_WINDOW_MOUSE_LEAVE = SDL_EVENT_WINDOW_MOUSE_ENTER + 1; // Window has lost mouse focus
    public static final int SDL_EVENT_WINDOW_FOCUS_GAINED = SDL_EVENT_WINDOW_MOUSE_LEAVE + 1; // Window has gained keyboard focus
    public static final int SDL_EVENT_WINDOW_FOCUS_LOST = SDL_EVENT_WINDOW_FOCUS_GAINED + 1; // Window has lost keyboard focus
    public static final int SDL_EVENT_WINDOW_CLOSE_REQUESTED = SDL_EVENT_WINDOW_FOCUS_LOST + 1; // The window manager requests that the window be closed
    public static final int SDL_EVENT_WINDOW_TAKE_FOCUS = SDL_EVENT_WINDOW_CLOSE_REQUESTED + 1; // Window is being offered a focus (should SetWindowInputFocus() on itself or a subwindow, or ignore)
    public static final int SDL_EVENT_WINDOW_HIT_TEST = SDL_EVENT_WINDOW_TAKE_FOCUS + 1; // Window had a hit test that wasn't SDL_HITTEST_NORMAL
    public static final int SDL_EVENT_WINDOW_ICCPROF_CHANGED = SDL_EVENT_WINDOW_HIT_TEST + 1; // The ICC profile of the window's display has changed
    public static final int SDL_EVENT_WINDOW_DISPLAY_CHANGED = SDL_EVENT_WINDOW_ICCPROF_CHANGED + 1; // Window has been moved to display data1
    public static final int SDL_EVENT_WINDOW_DISPLAY_SCALE_CHANGED = SDL_EVENT_WINDOW_DISPLAY_CHANGED + 1; // Window display scale has been changed
    public static final int SDL_EVENT_WINDOW_OCCLUDED = SDL_EVENT_WINDOW_DISPLAY_SCALE_CHANGED + 1; // The window has been occluded
    public static final int SDL_EVENT_WINDOW_ENTER_FULLSCREEN = SDL_EVENT_WINDOW_OCCLUDED + 1; // The window has entered fullscreen mode
    public static final int SDL_EVENT_WINDOW_LEAVE_FULLSCREEN = SDL_EVENT_WINDOW_ENTER_FULLSCREEN + 1; // The window has left fullscreen mode
    public static final int SDL_EVENT_WINDOW_DESTROYED = SDL_EVENT_WINDOW_LEAVE_FULLSCREEN + 1; // The window with the associated ID is being or has been destroyed. If this message is being handled in an event watcher, the window handle is still valid and can still be used to retrieve any userdata associated with the window. Otherwise, the handle has already been destroyed and all resources associated with it are invalid
    public static final int SDL_EVENT_WINDOW_PEN_ENTER = SDL_EVENT_WINDOW_DESTROYED + 1; // Window has gained focus of the pressure-sensitive pen with ID "data1"
    public static final int SDL_EVENT_WINDOW_PEN_LEAVE = SDL_EVENT_WINDOW_PEN_ENTER + 1; // Window has lost focus of the pressure-sensitive pen with ID "data1"
    public static final int SDL_EVENT_WINDOW_FIRST = SDL_EVENT_WINDOW_SHOWN;
    public static final int SDL_EVENT_WINDOW_LAST = SDL_EVENT_WINDOW_PEN_LEAVE;

    // Keyboard events
    public static final int SDL_EVENT_KEY_DOWN = 0x300; // Key pressed
    public static final int SDL_EVENT_KEY_UP = SDL_EVENT_KEY_DOWN + 1; // Key released
    public static final int SDL_EVENT_TEXT_EDITING = SDL_EVENT_KEY_UP + 1; // Keyboard text editing (composition)
    public static final int SDL_EVENT_TEXT_INPUT = SDL_EVENT_TEXT_EDITING + 1; // Keyboard text input
    public static final int SDL_EVENT_KEYMAP_CHANGED = SDL_EVENT_TEXT_INPUT + 1; // Keymap changed due to a system event such as an input language or keyboard layout change.

    // Mouse events
    public static final int SDL_EVENT_MOUSE_MOTION = 0x400; // Mouse moved
    public static final int SDL_EVENT_MOUSE_BUTTON_DOWN = SDL_EVENT_MOUSE_MOTION + 1; // Mouse button pressed
    public static final int SDL_EVENT_MOUSE_BUTTON_UP = SDL_EVENT_MOUSE_BUTTON_DOWN + 1; // Mouse button released
    public static final int SDL_EVENT_MOUSE_WHEEL = SDL_EVENT_MOUSE_BUTTON_UP + 1; // Mouse wheel motion

    // Joystick events
    public static final int SDL_EVENT_JOYSTICK_AXIS_MOTION = 0x600; // Joystick axis motion
    public static final int SDL_EVENT_JOYSTICK_HAT_MOTION = 0x602; // Joystick hat position change
    public static final int SDL_EVENT_JOYSTICK_BUTTON_DOWN = SDL_EVENT_JOYSTICK_HAT_MOTION + 1; // Joystick button pressed
    public static final int SDL_EVENT_JOYSTICK_BUTTON_UP = SDL_EVENT_JOYSTICK_BUTTON_DOWN + 1; // Joystick button released
    public static final int SDL_EVENT_JOYSTICK_ADDED = SDL_EVENT_JOYSTICK_BUTTON_UP + 1; // A new joystick has been inserted into the system
    public static final int SDL_EVENT_JOYSTICK_REMOVED = SDL_EVENT_JOYSTICK_ADDED + 1; // An opened joystick has been removed
    public static final int SDL_EVENT_JOYSTICK_BATTERY_UPDATED = SDL_EVENT_JOYSTICK_REMOVED + 1; // Joystick battery level change
    public static final int SDL_EVENT_JOYSTICK_UPDATE_COMPLETE = SDL_EVENT_JOYSTICK_BATTERY_UPDATED + 1; // Joystick update is complete

    // Gamepad events
    public static final int SDL_EVENT_GAMEPAD_AXIS_MOTION = 0x650; // Gamepad axis motion
    public static final int SDL_EVENT_GAMEPAD_BUTTON_DOWN = SDL_EVENT_GAMEPAD_AXIS_MOTION + 1; // Gamepad button pressed
    public static final int SDL_EVENT_GAMEPAD_BUTTON_UP = SDL_EVENT_GAMEPAD_BUTTON_DOWN + 1; // Gamepad button released
    public static final int SDL_EVENT_GAMEPAD_ADDED = SDL_EVENT_GAMEPAD_BUTTON_UP + 1; // A new gamepad has been inserted into the system
    public static final int SDL_EVENT_GAMEPAD_REMOVED = SDL_EVENT_GAMEPAD_ADDED + 1; // An opened gamepad has been removed
    public static final int SDL_EVENT_GAMEPAD_REMAPPED = SDL_EVENT_GAMEPAD_REMOVED + 1; // The gamepad mapping was updated
    public static final int SDL_EVENT_GAMEPAD_TOUCHPAD_DOWN = SDL_EVENT_GAMEPAD_REMAPPED + 1; // Gamepad touchpad was touched
    public static final int SDL_EVENT_GAMEPAD_TOUCHPAD_MOTION = SDL_EVENT_GAMEPAD_TOUCHPAD_DOWN + 1; // Gamepad touchpad finger was moved
    public static final int SDL_EVENT_GAMEPAD_TOUCHPAD_UP = SDL_EVENT_GAMEPAD_TOUCHPAD_MOTION + 1; // Gamepad touchpad finger was lifted
    public static final int SDL_EVENT_GAMEPAD_SENSOR_UPDATE = SDL_EVENT_GAMEPAD_TOUCHPAD_UP + 1; // Gamepad sensor was updated
    public static final int SDL_EVENT_GAMEPAD_UPDATE_COMPLETE = SDL_EVENT_GAMEPAD_SENSOR_UPDATE + 1; // Gamepad update is complete
    public static final int SDL_EVENT_GAMEPAD_STEAM_HANDLE_UPDATED = SDL_EVENT_GAMEPAD_UPDATE_COMPLETE + 1; // Gamepad Steam handle has changed

    // Touch events
    public static final int SDL_EVENT_FINGER_DOWN = 0x700;
    public static final int SDL_EVENT_FINGER_UP = SDL_EVENT_FINGER_DOWN + 1;
    public static final int SDL_EVENT_FINGER_MOTION = SDL_EVENT_FINGER_UP + 1;


    // 0x800, 0x801, and 0x802 were the Gesture events from SDL2. Do not reuse these values! sdl2-compat needs them!

    // Clipboard events
    public static final int SDL_EVENT_CLIPBOARD_UPDATE = 0x900; // The clipboard or primary selection changed

    // Drag and drop events
    public static final int SDL_EVENT_DROP_FILE = 0x1000; // The system requests a file open
    public static final int SDL_EVENT_DROP_TEXT = SDL_EVENT_DROP_FILE + 1; // text/plain drag-and-drop event
    public static final int SDL_EVENT_DROP_BEGIN = SDL_EVENT_DROP_TEXT + 1; // A new set of drops is beginning (NULL filename)
    public static final int SDL_EVENT_DROP_COMPLETE = SDL_EVENT_DROP_BEGIN + 1; // Current set of drops is now complete (NULL filename)
    public static final int SDL_EVENT_DROP_POSITION = SDL_EVENT_DROP_COMPLETE + 1; // Position while moving over the window

    // Audio hotplug events
    public static final int SDL_EVENT_AUDIO_DEVICE_ADDED = 0x1100; // A new audio device is available
    public static final int SDL_EVENT_AUDIO_DEVICE_REMOVED = SDL_EVENT_AUDIO_DEVICE_ADDED + 1; // An audio device has been removed.
    public static final int SDL_EVENT_AUDIO_DEVICE_FORMAT_CHANGED = SDL_EVENT_AUDIO_DEVICE_REMOVED + 1; // An audio device's format has been changed by the system.

    // Sensor events
    public static final int SDL_EVENT_SENSOR_UPDATE = 0x1200; // A sensor was updated

    // Pressure-sensitive pen events
    public static final int SDL_EVENT_PEN_DOWN = 0x1300; // Pressure-sensitive pen touched drawing surface
    public static final int SDL_EVENT_PEN_UP = SDL_EVENT_PEN_DOWN + 1; // Pressure-sensitive pen stopped touching drawing surface
    public static final int SDL_EVENT_PEN_MOTION = SDL_EVENT_PEN_UP + 1; // Pressure-sensitive pen moved, or angle/pressure changed
    public static final int SDL_EVENT_PEN_BUTTON_DOWN = SDL_EVENT_PEN_MOTION + 1; // Pressure-sensitive pen button pressed
    public static final int SDL_EVENT_PEN_BUTTON_UP = SDL_EVENT_PEN_BUTTON_DOWN + 1; // Pressure-sensitive pen button released

    // Render events
    public static final int SDL_EVENT_RENDER_TARGETS_RESET = 0x2000; // The render targets have been reset and their contents need to be updated
    public static final int SDL_EVENT_RENDER_DEVICE_RESET = SDL_EVENT_RENDER_TARGETS_RESET + 1; // The device has been reset and all textures need to be recreated

    // Internal events
    public static final int SDL_EVENT_POLL_SENTINEL = 0x7F00; // Signals the end of an event poll cycle

    // Events SDL_EVENT_USER through SDL_EVENT_LAST are for your use, and should be allocated with SDL_RegisterEvents()
    public static final int SDL_EVENT_USER = 0x8000;

    // This last event is only for bounding internal arrays
    public static final int SDL_EVENT_LAST = 0xFFFF;
}
