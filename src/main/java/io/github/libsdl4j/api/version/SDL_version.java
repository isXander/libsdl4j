package io.github.libsdl4j.api.version;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

/**
 * Information about the version of SDL in use.
 *
 * <p>Represents the library's version as three levels: major revision
 * (increments with massive changes, additions, and enhancements),
 * minor revision (increments with backwards-compatible changes to the
 * major revision), and patchlevel (increments with fixes to the minor
 * revision).</p>
 *
 * @see SdlVersion#SDL_GetJavaBindingsVersion()
 * @see SdlVersion#SDL_GetNativeLibraryVersion()
 */
@Structure.FieldOrder({
        "major",
        "minor",
        "patch"
})
public final class SDL_version extends Structure {

    /** major version */
    public byte major;

    /** minor version */
    public byte minor;

    /** update version */
    public byte patch;

    public SDL_version() {
    }

    public SDL_version(Pointer p) {
        super(p);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SDL_version that = (SDL_version) o;

        if (major != that.major) return false;
        if (minor != that.minor) return false;
        return patch == that.patch;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) major;
        result = 31 * result + (int) minor;
        result = 31 * result + (int) patch;
        return result;
    }

    @Override
    public String toString() {
        return major + "." + minor + "." + patch;
    }
}
