package dev.isxander.sdl3java.api.hidapi;

import org.intellij.lang.annotations.MagicConstant;

public final class SDL_hid_device_info {
    public String path;
    public int vendor_id;
    public int product_id;
    public String serial_number;
    public short release_number;
    public String manufacturer_string;
    public String product_string;
    public short usage_page;
    public short usage;
    public int interface_number;
    public int interface_class;
    public int interface_subclass;
    public int interface_protocol;
    @MagicConstant(valuesFromClass = SDL_hid_bus_type.class)
    public byte bus_type;
}
