package dev.isxander.sdl3java.api.version;

import org.junit.jupiter.api.Test;

import static dev.isxander.sdl3java.api.version.SdlVersion.SDL_GetJavaBindingsVersion;
import static dev.isxander.sdl3java.api.version.SdlVersion.SDL_GetVersion;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SdlVersionTest {

    @Test
    public void matchNativeToJava() {
        SdlVersionRecord nativeVersion = SdlVersionRecord.fromPacked(SDL_GetVersion());
        SdlVersionRecord javaVersion = SDL_GetJavaBindingsVersion();

        assertEquals(nativeVersion, javaVersion, "Native and Java bindings versions should match");
    }
}
