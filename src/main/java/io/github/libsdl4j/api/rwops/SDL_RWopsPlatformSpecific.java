package io.github.libsdl4j.api.rwops;

import com.sun.jna.Pointer;
import com.sun.jna.Union;

public final class SDL_RWopsPlatformSpecific extends Union {

    public SDL_RWopsUnknownIO unknown;
    public SDL_RWopsWindowsIO windowsio;
    public SDL_RWopsStdIO stdio;
    public SDL_RWopsAndroidIO androidio;
    public SDL_RWopsMemoryIO mem;

    public SDL_RWopsPlatformSpecific() {
    }

    public SDL_RWopsPlatformSpecific(Pointer p) {
        super(p);
    }
}
