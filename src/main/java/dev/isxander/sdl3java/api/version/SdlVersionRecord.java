package dev.isxander.sdl3java.api.version;

import java.util.Objects;

public final class SdlVersionRecord {
    private final int major, minor, micro;

    public SdlVersionRecord(int major, int minor, int micro) {
        this.major = major;
        this.minor = minor;
        this.micro = micro;
    }

    public int major() {
        return major;
    }

    public int minor() {
        return minor;
    }

    public int micro() {
        return micro;
    }

    public int packed() {
        return major * 1000000 + minor * 1000 + micro;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SdlVersionRecord that = (SdlVersionRecord) o;
        return major == that.major && minor == that.minor && micro == that.micro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(major, minor, micro);
    }

    @Override
    public String toString() {
        return major + "." + minor + "." + micro;
    }

    public static SdlVersionRecord fromPacked(int packed) {
        return new SdlVersionRecord(
                unpackMajor(packed),
                unpackMinor(packed),
                unpackMicro(packed)
        );
    }

    public static int unpackMajor(int packed) {
        return packed / 1000000;
    }

    public static int unpackMinor(int packed) {
        return (packed / 1000) % 1000;
    }

    public static int unpackMicro(int packed) {
        return packed % 1000;
    }
}
