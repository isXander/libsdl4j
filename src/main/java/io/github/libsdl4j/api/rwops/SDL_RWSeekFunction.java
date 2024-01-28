package io.github.libsdl4j.api.rwops;

import com.sun.jna.Callback;
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
public interface SDL_RWSeekFunction extends Callback {

    /**
     * Seek to {@code offset} relative to {@code whence}, one of stdio's whence values:
     * RW_SEEK_SET, RW_SEEK_CUR, RW_SEEK_END
     *
     * @return the final offset in the data stream, or -1 on error.
     */
    long size(
            SDL_RWops context,
            long offset,
            @MagicConstant(valuesFromClass = SdlRWopsSeekType.class) int whence);
}
