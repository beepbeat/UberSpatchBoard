/*
 * The MIT License
 *
 * Copyright 2017 Luca Corbatto.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.targodan.usb.config;

/**
 *
 * @author corbatto
 */
public enum OperatingSystem {
    WINDOWS, MAC, UNIX, SOLARIS;
    
    public static OperatingSystem getCurrent() {
        String osId = System.getProperty("os.name").toLowerCase();
        if(osId.contains("win")) {
            return WINDOWS;
        } else if(osId.contains("mac")) {
            return MAC;
        } else if(osId.contains("nix") || osId.contains("nux") || osId.contains("aix")) {
            return UNIX;
        } else if(osId.contains("sunos")) {
            return SOLARIS;
        } else {
            // Wat?
            throw new IllegalStateException("OS not supported.");
        }
    }
}
