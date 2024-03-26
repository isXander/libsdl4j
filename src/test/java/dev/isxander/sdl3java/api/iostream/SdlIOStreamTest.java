package dev.isxander.sdl3java.api.iostream;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import dev.isxander.sdl3java.api.SdlTest;
import dev.isxander.sdl3java.jna.size_t;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static dev.isxander.sdl3java.api.SdlInit.SDL_Init;
import static dev.isxander.sdl3java.api.SdlInit.SDL_Quit;
import static dev.isxander.sdl3java.api.SdlSubSystemConst.SDL_INIT_VIDEO;
import static dev.isxander.sdl3java.api.error.SdlError.SDL_GetError;
import static dev.isxander.sdl3java.api.iostream.SdlIOStream.*;
import static dev.isxander.sdl3java.api.iostream.SdlIOStream.SDL_LoadFile;
import static dev.isxander.sdl3java.api.stdinc.SdlStdinc.SDL_GetNumAllocations;
import static dev.isxander.sdl3java.api.stdinc.SdlStdinc.SDL_free;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public final class SdlIOStreamTest {
    @BeforeEach
    public void setUp() {
        SDL_Init(SDL_INIT_VIDEO);
    }

    @Test
    public void rwOpsShouldLoadFileContent() throws Exception {
        Path sampleFile = SdlTest.getSampleFile(this, "sample.txt");
        Memory buffer = new Memory(1024L);

        SDL_IOStream stream = SDL_IOFromFile(sampleFile.toString(), "rb");

        assertNotNull(stream, "Opening file " + sampleFile + " failed: " + SDL_GetError());
        try {
            size_t actualReadCount = SDL_ReadIO(stream, buffer, new size_t(buffer.size()));

            assertEquals(Files.size(sampleFile), actualReadCount.longValue());
            long offset = 0L;
            assertEquals('T', (char) (buffer.getByte(offset++)));
            assertEquals('h', (char) (buffer.getByte(offset++)));
            assertEquals('i', (char) (buffer.getByte(offset++)));
            assertEquals('s', (char) (buffer.getByte(offset++)));
            assertEquals(' ', (char) (buffer.getByte(offset++)));
            assertEquals('i', (char) (buffer.getByte(offset++)));
            assertEquals('s', (char) (buffer.getByte(offset)));
        } finally {
            SDL_CloseIO(stream);
        }
    }

    @Test
    public void rwOpsShouldReportCorrectFileSize() throws Exception {
        Path sampleFile = SdlTest.getSampleFile(this, "sample.txt");

        SDL_IOStream stream = SDL_IOFromFile(sampleFile.toString(), "rb");

        assertNotNull(stream, "Opening file " + sampleFile + " failed: " + SDL_GetError());
        try {
            long actualFileSize = SDL_GetIOSize(stream);
            assertEquals(Files.size(sampleFile), actualFileSize);
        } finally {
            SDL_CloseIO(stream);
        }
    }

    @Test
    public void LoadFileUsingRwOpsShouldGiveFileContent() throws Exception {
        Path sampleFile = SdlTest.getSampleFile(this, "sample.txt");

        SDL_IOStream stream = SDL_IOFromFile(sampleFile.toString(), "rb");
        var ops = new SDL_IOStreamInterface.ByReference();
        SDL_OpenIO(ops, null);

        assertNotNull(ops, "Opening file " + sampleFile + " failed: " + SDL_GetError());
        size_t.Ref actualReadCount = new size_t.Ref();
        Pointer buffer = SDL_LoadFile_IO(stream, actualReadCount, true);

        assertEquals(Files.size(sampleFile), actualReadCount.getValue().longValue());
        long offset = 0L;
        assertEquals('T', (char) (buffer.getByte(offset++)));
        assertEquals('h', (char) (buffer.getByte(offset++)));
        assertEquals('i', (char) (buffer.getByte(offset++)));
        assertEquals('s', (char) (buffer.getByte(offset++)));
        assertEquals(' ', (char) (buffer.getByte(offset++)));
        assertEquals('i', (char) (buffer.getByte(offset++)));
        assertEquals('s', (char) (buffer.getByte(offset)));
    }

    @Test
    public void LoadFileShouldGiveFileContent() throws Exception {
        Path sampleFile = SdlTest.getSampleFile(this, "sample.txt");
        int allocCount = SDL_GetNumAllocations();

        size_t.Ref actualReadCount = new size_t.Ref();
        Pointer buffer = SDL_LoadFile(sampleFile.toString(), actualReadCount);
        assertNotNull(buffer, "Failed to load file " + sampleFile + ": " + SDL_GetError());

        assertEquals(Files.size(sampleFile), actualReadCount.getValue().longValue());
        long offset = 0L;
        assertEquals('T', (char) (buffer.getByte(offset++)));
        assertEquals('h', (char) (buffer.getByte(offset++)));
        assertEquals('i', (char) (buffer.getByte(offset++)));
        assertEquals('s', (char) (buffer.getByte(offset++)));
        assertEquals(' ', (char) (buffer.getByte(offset++)));
        assertEquals('i', (char) (buffer.getByte(offset++)));
        assertEquals('s', (char) (buffer.getByte(offset)));

        assertEquals(allocCount + 1, SDL_GetNumAllocations());
        SDL_free(buffer);
        assertEquals(allocCount, SDL_GetNumAllocations());
    }

    @AfterEach
    public void tearDown() {
        SDL_Quit();
    }
}
