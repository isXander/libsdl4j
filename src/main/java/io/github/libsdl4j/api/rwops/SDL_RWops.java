package io.github.libsdl4j.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import org.intellij.lang.annotations.MagicConstant;

import static io.github.libsdl4j.api.rwops.SDL_RWopsType.SDL_RWOPS_JNIFILE;
import static io.github.libsdl4j.api.rwops.SDL_RWopsType.SDL_RWOPS_MEMORY;
import static io.github.libsdl4j.api.rwops.SDL_RWopsType.SDL_RWOPS_MEMORY_RO;
import static io.github.libsdl4j.api.rwops.SDL_RWopsType.SDL_RWOPS_STDFILE;
import static io.github.libsdl4j.api.rwops.SDL_RWopsType.SDL_RWOPS_UNKNOWN;
import static io.github.libsdl4j.api.rwops.SDL_RWopsType.SDL_RWOPS_WINFILE;

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
        "close",
        "type",
        "hidden"
})
public final class SDL_RWops extends Structure {

    /**
     * A function that knows how to figure out the size of the file in this rwops, or -1 if unknown
     */
    public SDL_RWSizeFunction size;

    /**
     * A function that knows how to seek to {@code offset} relative to {@code whence}, one of stdio's whence values:
     * RW_SEEK_SET, RW_SEEK_CUR, RW_SEEK_END
     */
    public SDL_RWSeekFunction seek;

    /**
     * A function that knows how to read up to {@code maxnum} objects each of {@code size} from the data
     * stream to the area pointed at by {@code ptr}.
     */
    public SDL_RWReadFunction read;

    /**
     * A function that knows how to write exactly {@code num} objects each of {@code size} from the area
     * pointed at by {@code ptr} to data stream.
     */
    public SDL_RWWriteFunction write;

    /**
     * A function that knows how to close a file.
     */
    public SDL_RWCloseFunction close;

    @MagicConstant(valuesFromClass = SDL_RWopsType.class)
    public int type;
    public SDL_RWopsPlatformSpecific hidden;

    public SDL_RWops() {
    }

    public SDL_RWops(Pointer p) {
        super(p);
    }

    @Override
    public void read() {
        readField("type");
        switch (type) {
            case SDL_RWOPS_WINFILE:
                hidden.setType(SDL_RWopsWindowsIO.class);
                break;
            case SDL_RWOPS_STDFILE:
                hidden.setType(SDL_RWopsStdIO.class);
                break;
            case SDL_RWOPS_JNIFILE:
                hidden.setType(SDL_RWopsAndroidIO.class);
                break;
            case SDL_RWOPS_MEMORY:
            case SDL_RWOPS_MEMORY_RO:
                hidden.setType(SDL_RWopsMemoryIO.class);
                break;
            case SDL_RWOPS_UNKNOWN:
            default:
                hidden.setType(SDL_RWopsUnknownIO.class);
                break;
        }
        super.read();
    }
}
