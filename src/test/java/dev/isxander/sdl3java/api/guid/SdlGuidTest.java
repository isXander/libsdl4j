package dev.isxander.sdl3java.api.guid;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SdlGuidTest {
    @Test
    void zeros() {
        testGuid(new byte[16]);
    }

    @Test
    void ones() {
        byte[] data = new byte[16];
        Arrays.fill(data, (byte) 0xFF);
        testGuid(data);
    }

    @Test
    void random1() {
        testGuid(new byte[] {
                (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78,
                (byte) 0x9A, (byte) 0xBC, (byte) 0xDE, (byte) 0xF0,
                (byte) 0x01, (byte) 0x23, (byte) 0x45, (byte) 0x67,
                (byte) 0x89, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF
        });
    }

    @Test
    void random2() {
        testGuid(new byte[] {
                (byte) 0x01, (byte) 0x23, (byte) 0x45, (byte) 0x67,
                (byte) 0x89, (byte) 0xAB, (byte) 0xCD, (byte) 0xEF,
                (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78,
                (byte) 0x9A, (byte) 0xBC, (byte) 0xDE, (byte) 0xF0
        });
    }

    private void testGuid(byte[] data) {
        SDL_GUID guid = new SDL_GUID();
        guid.data = data;

        String guidString = SdlGuid.SDL_GUIDToString(guid);
        System.out.println("GUID: " + guidString);

        SDL_GUID newGuid = SdlGuid.SDL_StringToGUID(guidString);
        System.out.println("New GUID: " + Arrays.toString(newGuid.data));

        assertArrayEquals(guid.data, newGuid.data);
    }
}
