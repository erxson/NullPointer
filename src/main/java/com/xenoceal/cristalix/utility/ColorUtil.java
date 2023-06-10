/*
 * Decompiled with CFR 0.150.
 */
package com.xenoceal.cristalix.utility;

import java.awt.Color;

public enum ColorUtil {
    RECT_COLOR(new Color(0.0f, 0.0f, 0.0f, 0.75f)),
    BLUE_COLOR(new Color(0.0f, 0.65f, 1.0f, 1.0f));

    final int color;

    private ColorUtil(Color color) {
        this.color = color.getRGB();
    }

    public int getColor() {
        return this.color;
    }
}

