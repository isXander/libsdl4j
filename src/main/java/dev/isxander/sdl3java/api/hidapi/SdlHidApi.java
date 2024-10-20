package dev.isxander.sdl3java.api.hidapi;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.WString;
import dev.isxander.sdl3java.jna.JnaUtils;
import dev.isxander.sdl3java.jna.SdlNativeLibraryLoader;
import dev.isxander.sdl3java.jna.StringRef;
import dev.isxander.sdl3java.jna.size_t;

import java.util.ArrayList;
import java.util.List;

public final class SdlHidApi {

    static {
        SdlNativeLibraryLoader.registerNativeMethods(SdlHidApi.class);
        SdlNativeLibraryLoader.registerNativeMethods(InternalNativeFunctions.class);
    }

    private SdlHidApi() {
    }

    public static native int SDL_hid_init();

    public static native int SDL_hid_exit();

    public static native long SDL_hid_device_change_count();

    public static List<SDL_hid_device_info> SDL_hid_enumerate(int vendor_id, int product_id) {
        SDL_hid_device_info_raw rawStruct = InternalNativeFunctions.SDL_hid_enumerate(vendor_id, product_id);

        if (rawStruct == null) {
            return null;
        }

        Pointer pointer = rawStruct.getPointer();

        // Convert the linked list to a Java list
        List<SDL_hid_device_info> list = new ArrayList<>();
        while (rawStruct != null) {
            SDL_hid_device_info info = rawStruct.toPublic();
            rawStruct = rawStruct.next;
            list.add(info);
        }

        InternalNativeFunctions.SDL_hid_free_enumeration(pointer);
        return list;
    }

    public static SDL_hid_device SDL_hid_open(int vendor_id, int product_id, String serial_number) {
        return InternalNativeFunctions.SDL_hid_open(vendor_id, product_id, new WString(serial_number));
    }

    public static native SDL_hid_device SDL_hid_open_path(String path);

    public static int SDL_hid_write(SDL_hid_device dev, byte[] data) {
        try (Memory buffer = JnaUtils.writeArrayToNativeMemory(data)) {
            return SDL_hid_write(dev, buffer, new size_t(data.length));
        }
    }

    public static native int SDL_hid_write(SDL_hid_device dev, Pointer data, size_t length);

    public static int SDL_hid_read_timeout(SDL_hid_device dev, byte[] data, int milliseconds) {
        try (Memory buffer = new Memory(data.length)) {
            int result = SDL_hid_read_timeout(dev, buffer, new size_t(data.length), milliseconds);
            buffer.read(0, data, 0, data.length);
            return result;
        }
    }

    public static native int SDL_hid_read_timeout(SDL_hid_device dev, Pointer data, size_t length, int milliseconds);

    public static int SDL_hid_read(SDL_hid_device dev, byte[] data) {
        try (Memory buffer = new Memory(data.length)) {
            int result = SDL_hid_read(dev, buffer, new size_t(buffer.size()));
            buffer.read(0L, data, 0, data.length);
            return result;
        }
    }

    public static native int SDL_hid_read(SDL_hid_device dev, Pointer data, size_t length);

    public static native int SDL_hid_set_nonblocking(SDL_hid_device dev, int nonblock);

    public static int SDL_hid_send_feature_report(SDL_hid_device dev, byte[] data) {
        try (Memory buffer = JnaUtils.writeArrayToNativeMemory(data)) {
            return SDL_hid_send_feature_report(dev, buffer, new size_t(buffer.size()));
        }
    }

    public static native int SDL_hid_send_feature_report(SDL_hid_device dev, Pointer data, size_t length);

    public static int SDL_hid_get_feature_report(SDL_hid_device dev, byte[] data) {
        int result;
        try (Memory buffer = new Memory(data.length)) {
            result = SDL_hid_get_feature_report(dev, buffer, new size_t(buffer.size()));
            buffer.read(0L, data, 0, data.length);
            return result;
        }
    }

    public static native int SDL_hid_get_feature_report(SDL_hid_device dev, Pointer data, size_t length);

    public static native void SDL_hid_close(SDL_hid_device dev);

    public static int SDL_hid_get_manufacturer_string(SDL_hid_device dev, StringRef text, int maxlen) {
        try (Memory buffer = new Memory(maxlen * 2L)) {
            int result = InternalNativeFunctions.SDL_hid_get_manufacturer_string(dev, buffer, new size_t(maxlen));
            text.setValue(buffer.getWideString(0L));
            return result;
        }
    }

    public static int SDL_hid_get_product_string(SDL_hid_device dev, StringRef text, int maxlen) {
        try (Memory buffer = new Memory(maxlen * 2L)) {
            int result = InternalNativeFunctions.SDL_hid_get_product_string(dev, buffer, new size_t(maxlen));
            text.setValue(buffer.getWideString(0L));
            return result;
        }
    }

    public static int SDL_hid_get_serial_number_string(SDL_hid_device dev, StringRef text, int maxlen) {
        try (Memory buffer = new Memory(maxlen * 2L)) {
            int result = InternalNativeFunctions.SDL_hid_get_serial_number_string(dev, buffer, new size_t(maxlen));
            text.setValue(buffer.getWideString(0L));
            return result;
        }
    }

    public static int SDL_hid_get_indexed_string(SDL_hid_device dev, int stringIndex, StringRef text, int maxlen) {
        try (Memory buffer = new Memory(maxlen * 2L)) {
            int result = InternalNativeFunctions.SDL_hid_get_indexed_string(dev, stringIndex, buffer, new size_t(maxlen));
            text.setValue(buffer.getWideString(0L));
            return result;
        }
    }

    public static SDL_hid_device_info SDL_hid_get_device_info(SDL_hid_device dev) {
        SDL_hid_device_info_raw rawStruct = InternalNativeFunctions.SDL_hid_get_device_info(dev);
        return rawStruct.toPublic();
    }

    public static int SDL_hid_get_report_descriptor(SDL_hid_device dev, byte[] buffer) {
        try (Memory memory = new Memory(buffer.length)) {
            int result = InternalNativeFunctions.SDL_hid_get_report_descriptor(dev, memory, new size_t(buffer.length));
            memory.read(0L, buffer, 0, buffer.length);
            return result;
        }
    }

    public static native void SDL_hid_ble_scan(boolean active);

    private static final class InternalNativeFunctions {
        private InternalNativeFunctions() {
        }

        public static native SDL_hid_device_info_raw SDL_hid_enumerate(int vendor_id, int product_id);

        public static native void SDL_hid_free_enumeration(Pointer enumeration);

        public static native SDL_hid_device SDL_hid_open(int vendor_id, int product_id, WString serial_number);

        public static native int SDL_hid_get_manufacturer_string(SDL_hid_device dev, Pointer text, size_t maxlen);

        public static native int SDL_hid_get_product_string(SDL_hid_device dev, Pointer text, size_t maxlen);

        public static native int SDL_hid_get_serial_number_string(SDL_hid_device dev, Pointer text, size_t maxlen);

        public static native int SDL_hid_get_indexed_string(SDL_hid_device dev, int stringIndex, Pointer text, size_t maxlen);

        public static native SDL_hid_device_info_raw SDL_hid_get_device_info(SDL_hid_device dev);

        public static native int SDL_hid_get_report_descriptor(SDL_hid_device dev, Pointer buffer, size_t buf_size);
    }
}
