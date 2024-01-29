package io.github.libsdl4j.api.stdinc;

import com.sun.jna.Pointer;
import io.github.libsdl4j.jna.size_t;
import org.junit.jupiter.api.Test;

import static io.github.libsdl4j.api.stdinc.SdlStdinc.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SdlStdincTest {
    @Test
    public void allocationShouldNotCauseMemoryLeak() {
        int allocationCountBefore = SDL_GetNumAllocations();
        for (int i = 0; i < 1_000_000; i++) {
            Pointer memoryBlob = SDL_malloc(new size_t(65536));
            SDL_free(memoryBlob);
        }
        int allocationCountAfter = SDL_GetNumAllocations();
        assertEquals(0, allocationCountAfter - allocationCountBefore);
    }
}
