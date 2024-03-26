package dev.isxander.sdl3java.api.iostream;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import dev.isxander.sdl3java.jna.size_t;
import org.intellij.lang.annotations.MagicConstant;

/**
 * <p><b>Warning:</b> It is necessary to keep a reference to the callback object somewhere in your Java program,
 * otherwise JNA would dispose of the object (GC would clean it) and the callback function would no longer
 * be available for SDL library's C code to call.</p>
 *
 * <p>In case you did not keep the reference you would encounter an error like this:</p>
 * <p><code>JNA: callback object has been garbage collected</code></p>
 */
@FunctionalInterface
public interface SDL_IOWriteFunction extends Callback {

    /**
     * Write exactly {@code num} objects each of {@code size} from the area
     * pointed at by {@code ptr} to data stream.
     *
     * @return the number of objects written, or 0 at error or end of file.
     */
    size_t write(
            PointerByReference userdata,
            Pointer ptr,
            size_t size,
            @MagicConstant(valuesFromClass = SDL_IOStatus.class) IntByReference status);
}
