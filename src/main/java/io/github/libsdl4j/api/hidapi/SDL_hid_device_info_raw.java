package io.github.libsdl4j.api.hidapi;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

@Structure.FieldOrder({
        "path",
        "vendor_id",
        "product_id",
        "serial_number",
        "release_number",
        "manufacturer_string",
        "product_string",
        "usage_page",
        "usage",
        "interface_number",
        "interface_class",
        "interface_subclass",
        "interface_protocol",
        "bus_type",
        "next"
})
final class SDL_hid_device_info_raw extends Structure {
    public Pointer path;
    public int vendor_id;
    public int product_id;
    public Pointer serial_number;
    public short release_number;
    public Pointer manufacturer_string;
    public Pointer product_string;
    public short usage_page;
    public short usage;
    public int interface_number;
    public int interface_class;
    public int interface_subclass;
    public int interface_protocol;
    @MagicConstant(valuesFromClass = SDL_hid_bus_type.class)
    public byte bus_type;

    /** Pointer to the next type */
    public SDL_hid_device_info_raw next;

    public SDL_hid_device_info_raw() {
    }

    public SDL_hid_device_info_raw(Pointer pointer) {
        super(pointer);
    }

    public SDL_hid_device_info toPublic() {
        SDL_hid_device_info info = new SDL_hid_device_info();
        info.path = path.getString(0);
        info.vendor_id = vendor_id;
        info.product_id = product_id;
        info.serial_number = serial_number.getWideString(0);
        info.release_number = release_number;
        info.manufacturer_string = manufacturer_string.getWideString(0);
        info.product_string = product_string.getWideString(0);
        info.usage_page = usage_page;
        info.usage = usage;
        info.interface_number = interface_number;
        info.interface_class = interface_class;
        info.interface_subclass = interface_subclass;
        info.interface_protocol = interface_protocol;
        info.bus_type = bus_type;
        return info;
    }
}
