package io.github.libsdl4j.api.gamepad;

import io.github.libsdl4j.jna.JnaEnum;

/**
 * The list of buttons available from a controller
 */
public final class SDL_GamepadButton implements JnaEnum {

    public static final int SDL_GAMEPAD_BUTTON_INVALID = -1;
    public static final int SDL_GAMEPAD_BUTTON_SOUTH = 0;
    public static final int SDL_GAMEPAD_BUTTON_EAST = 1;
    public static final int SDL_GAMEPAD_BUTTON_WEST = 2;
    public static final int SDL_GAMEPAD_BUTTON_NORTH = 3;
    public static final int SDL_GAMEPAD_BUTTON_BACK = 4;
    public static final int SDL_GAMEPAD_BUTTON_GUIDE = 5;
    public static final int SDL_GAMEPAD_BUTTON_START = 6;
    public static final int SDL_GAMEPAD_BUTTON_LEFT_STICK = 7;
    public static final int SDL_GAMEPAD_BUTTON_RIGHT_STICK = 8;
    public static final int SDL_GAMEPAD_BUTTON_LEFT_SHOULDER = 9;
    public static final int SDL_GAMEPAD_BUTTON_RIGHT_SHOULDER = 10;
    public static final int SDL_GAMEPAD_BUTTON_DPAD_UP = 11;
    public static final int SDL_GAMEPAD_BUTTON_DPAD_DOWN = 12;
    public static final int SDL_GAMEPAD_BUTTON_DPAD_LEFT = 13;
    public static final int SDL_GAMEPAD_BUTTON_DPAD_RIGHT = 14;
    public static final int SDL_GAMEPAD_BUTTON_MISC1 = 15; /* Additional button (e.g. Xbox Series X share button, PS5 microphone button, Nintendo Switch Pro capture button, Amazon Luna microphone button) */
    public static final int SDL_GAMEPAD_BUTTON_RIGHT_PADDLE1 = 16; /* Upper or primary paddle, under your right hand (e.g. Xbox Elite paddle P1) */
    public static final int SDL_GAMEPAD_BUTTON_LEFT_PADDLE1 = 17; /* Upper or primary paddle, under your left hand (e.g. Xbox Elite paddle P3) */
    public static final int SDL_GAMEPAD_BUTTON_RIGHT_PADDLE2 = 18; /* Lower or secondary paddle, under your right hand (e.g. Xbox Elite paddle P2) */
    public static final int SDL_GAMEPAD_BUTTON_LEFT_PADDLE2 = 19; /* Lower or secondary paddle, under your left hand (e.g. Xbox Elite paddle P4) */
    public static final int SDL_GAMEPAD_BUTTON_TOUCHPAD = 20; /* PS4/PS5 touchpad button */
    public static final int SDL_GAMEPAD_BUTTON_MAX = 21;

    private SDL_GamepadButton() {
    }
}
