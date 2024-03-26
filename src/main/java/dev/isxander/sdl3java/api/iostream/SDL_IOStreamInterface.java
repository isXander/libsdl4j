package dev.isxander.sdl3java.api.iostream;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * This is a structure that holds references to functions for IO operations (read/write/seek).
 *
 * <p>It is advisable to keep a reference to this class forever (more precisely, as long as the callbacks are valid)
 * and reuse it to limit repeated creation of multiple JNA callback objects.</p>
 */
@Structure.FieldOrder({
        "size",
        "seek",
        "read",
        "write",
        "close"
})
public sealed class SDL_IOStreamInterface extends Structure {

    /**
     * A function that knows how to figure out the size of the file in this rwops, or -1 if unknown
     */
    public SDL_IOSizeFunction size;

    /**
     * A function that knows how to seek to {@code offset} relative to {@code whence}, one of stdio's whence values:
     * RW_SEEK_SET, RW_SEEK_CUR, RW_SEEK_END
     */
    public SDL_IOSeekFunction seek;

    /**
     * A function that knows how to read up to {@code maxnum} objects each of {@code size} from the data
     * stream to the area pointed at by {@code ptr}.
     */
    public SDL_IOReadFunction read;

    /**
     * A function that knows how to write exactly {@code num} objects each of {@code size} from the area
     * pointed at by {@code ptr} to data stream.
     */
    public SDL_IOWriteFunction write;

    /**
     * A function that knows how to close a file.
     */
    public SDL_IOCloseFunction close;

    public SDL_IOStreamInterface() {
    }

    public SDL_IOStreamInterface(Pointer p) {
        super(p);
    }

    public static final class ByReference extends SDL_IOStreamInterface implements Structure.ByReference {
    }

    public static final class ByValue extends SDL_IOStreamInterface implements Structure.ByValue {
    }
}
