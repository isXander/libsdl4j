package dev.isxander.sdl3java.api.iostream;

import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

/**
 * <p><b>Warning:</b> It is necessary to keep a reference to the callback object somewhere in your Java program,
 * otherwise JNA would dispose of the object (GC would clean it) and the callback function would no longer
 * be available for SDL library's C code to call.</p>
 *
 * <p>In case you did not keep the reference you would encounter an error like this:</p>
 * <p><code>JNA: callback object has been garbage collected</code></p>
 */
@FunctionalInterface
public interface SDL_IOCloseFunction extends Callback {

    /**
     * Close a file.
     *
     * @return 0 if successful or -1 on write error when flushing data.
     */
    boolean close(
            PointerByReference userdata);
}
