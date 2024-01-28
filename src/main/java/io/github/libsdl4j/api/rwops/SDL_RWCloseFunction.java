package io.github.libsdl4j.api.rwops;

import com.sun.jna.Callback;

/**
 * <p><b>Warning:</b> It is necessary to keep a reference to the callback object somewhere in your Java program,
 * otherwise JNA would dispose of the object (GC would clean it) and the callback function would no longer
 * be available for SDL library's C code to call.</p>
 *
 * <p>In case you did not keep the reference you would encounter an error like this:</p>
 * <p><code>JNA: callback object has been garbage collected</code></p>
 */
@FunctionalInterface
public interface SDL_RWCloseFunction extends Callback {

    /**
     * Close a file.
     *
     * @return 0 if successful or -1 on write error when flushing data.
     */
    int close(
            SDL_RWops context);
}
