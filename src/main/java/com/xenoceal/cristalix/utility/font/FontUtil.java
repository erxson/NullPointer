/*
 * Decompiled with CFR 0.150.
 */
package com.xenoceal.cristalix.utility.font;

import com.xenoceal.cristalix.NullPointer;
import com.xenoceal.cristalix.utility.SneakyThrow;
import java.awt.Font;
import java.util.Objects;

public final class FontUtil {
    public static Font getFontFromTTF(String string, float f, int n) {
        Font font;
        try {
            font = Font.createFont(n, Objects.requireNonNull(NullPointer.class.getResourceAsStream(string)));
            font = font.deriveFont(f);
        }
        catch (Throwable throwable) {
            throw SneakyThrow.sneaky(throwable);
        }
        return font;
    }

    private FontUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

