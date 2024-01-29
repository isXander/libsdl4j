package io.github.libsdl4j.api.hidapi;

import io.github.libsdl4j.jna.JnaEnum;

public final class SDL_hid_bus_type implements JnaEnum {
    public static final byte SDL_HID_API_BUS_UNKNOWN = 0x00;
    public static final byte SDL_HID_API_BUS_USB = 0x01;
    public static final byte SDL_HID_API_BUS_BLUETOOTH = 0x02;
    public static final byte SDL_HID_API_BUS_I2C = 0x03;
    public static final byte SDL_HID_API_BUS_SPI = 0x04;
}
