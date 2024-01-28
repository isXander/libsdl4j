package io.github.libsdl4j.api.guid;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.UUID;

/**
 * An SDL_GUID is a 128-bit identifier for an input device that
 * identifies that device across runs of SDL programs on the same
 * platform. If the device is detached and then re-attached to a
 * different port, or if the base system is rebooted, the device
 * should still report the same GUID.
 *
 * <p>GUIDs are as precise as possible but are not guaranteed to
 * distinguish physically distinct but equivalent devices. For
 * example, two game controllers from the same vendor with the same
 * product ID and revision may have the same GUID.</p>
 *
 * <p>GUIDs may be platform-dependent (i.e., the same device may report
 * different GUIDs on different operating systems).</p>
 */
@Structure.FieldOrder({
        "leastSigBits",
        "mostSigBits"
})
public class SDL_GUID extends Structure implements Structure.ByValue {

    public long leastSigBits;
    public long mostSigBits;

    public SDL_GUID() {
    }

    public SDL_GUID(Pointer p) {
        super(p);
    }

    @Override
    public String toString() {
        return new UUID(mostSigBits, leastSigBits).toString();
    }

}
