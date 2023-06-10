/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  dev.xdark.clientapi.texture.DynamicTexture
 *  org.lwjgl.opengl.GL11
 */
package com.xenoceal.cristalix.utility.font;

import com.xenoceal.cristalix.Wrapper;
import dev.xdark.clientapi.texture.DynamicTexture;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import org.lwjgl.opengl.GL11;

public class CFont {
    protected final float imgSize = 512.0f;
    protected final CharData[] charData = new CharData[256];
    protected Font font;
    protected boolean antiAlias;
    protected boolean fractionalMetrics;
    protected int fontHeight = -1;
    protected DynamicTexture dynamicTexture;

    public CFont(Font font, boolean bl, boolean bl2) {
        this.font = font;
        this.antiAlias = bl;
        this.fractionalMetrics = bl2;
        this.dynamicTexture = this.setupTexture(font, bl, bl2, this.charData);
    }

    public DynamicTexture setupTexture(Font font, boolean bl, boolean bl2, CharData[] arrcharData) {
        BufferedImage bufferedImage = this.generateFontImage(font, bl, bl2, arrcharData);
        try {
            return Wrapper.DynamicTexture(bufferedImage);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    protected BufferedImage generateFontImage(Font font, boolean bl, boolean bl2, CharData[] arrcharData) {
        this.getClass();
        int n = 512;
        BufferedImage bufferedImage = new BufferedImage(n, n, 2);
        Graphics2D graphics2D = (Graphics2D)bufferedImage.getGraphics();
        graphics2D.setFont(font);
        graphics2D.setColor(new Color(255, 255, 255, 0));
        graphics2D.fillRect(0, 0, n, n);
        graphics2D.setColor(Color.WHITE);
        graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, bl2 ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, bl ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, bl ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        for (int i = 0; i < arrcharData.length; ++i) {
            char c = (char)i;
            CharData charData = new CharData(this);
            Rectangle2D rectangle2D = fontMetrics.getStringBounds(String.valueOf(c), graphics2D);
            charData.width = rectangle2D.getBounds().width + 8;
            charData.height = rectangle2D.getBounds().height;
            if (n3 + charData.width >= n) {
                n3 = 0;
                n4 += n2;
                n2 = 0;
            }
            if (charData.height > n2) {
                n2 = charData.height;
            }
            CharData.access$002(charData, n3);
            CharData.access$102(charData, n4);
            if (charData.height > this.fontHeight) {
                this.fontHeight = charData.height;
            }
            arrcharData[i] = charData;
            graphics2D.drawString(String.valueOf(c), n3 + 2, n4 + fontMetrics.getAscent());
            n3 += charData.width;
        }
        return bufferedImage;
    }

    public void drawChar(CharData[] arrcharData, char c, float f, float f2) {
        try {
            this.drawQuad(f, f2, arrcharData[c].width, arrcharData[c].height, CharData.access$000(arrcharData[c]), CharData.access$100(arrcharData[c]), arrcharData[c].width, arrcharData[c].height);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    protected void drawQuad(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = f5 / 512.0f;
        float f10 = f6 / 512.0f;
        float f11 = f7 / 512.0f;
        float f12 = f8 / 512.0f;
        GL11.glTexCoord2f((float)(f9 + f11), (float)f10);
        GL11.glVertex2d((double)(f + f3), (double)f2);
        GL11.glTexCoord2f((float)f9, (float)f10);
        GL11.glVertex2d((double)f, (double)f2);
        GL11.glTexCoord2f((float)f9, (float)(f10 + f12));
        GL11.glVertex2d((double)f, (double)(f2 + f4));
        GL11.glTexCoord2f((float)f9, (float)(f10 + f12));
        GL11.glVertex2d((double)f, (double)(f2 + f4));
        GL11.glTexCoord2f((float)(f9 + f11), (float)(f10 + f12));
        GL11.glVertex2d((double)(f + f3), (double)(f2 + f4));
        GL11.glTexCoord2f((float)(f9 + f11), (float)f10);
        GL11.glVertex2d((double)(f + f3), (double)f2);
    }

    public int getStringHeight(String string) {
        return this.getHeight();
    }

    public int getHeight() {
        return (this.fontHeight - 8) / 2;
    }

    public int getStringWidth(String string) {
        int n = 0;
        for (char c : string.toCharArray()) {
            if (c >= this.charData.length) continue;
            n += this.charData[c].width - 8;
        }
        return n / 2;
    }

    public boolean isAntiAlias() {
        return this.antiAlias;
    }

    public void setAntiAlias(boolean bl) {
        if (this.antiAlias != bl) {
            this.antiAlias = bl;
            this.dynamicTexture = this.setupTexture(this.font, bl, this.fractionalMetrics, this.charData);
        }
    }

    public boolean isFractionalMetrics() {
        return this.fractionalMetrics;
    }

    public Font getFont() {
        return this.font;
    }

    public void setFont(Font font) {
        this.font = font;
        this.dynamicTexture = this.setupTexture(font, this.antiAlias, this.fractionalMetrics, this.charData);
    }

    public void setFractionalMetrics(boolean bl) {
        if (this.fractionalMetrics != bl) {
            this.fractionalMetrics = bl;
            this.dynamicTexture = this.setupTexture(this.font, this.antiAlias, bl, this.charData);
        }
    }

    protected final class CharData {
        int width;
        int height;
        private int storedX;
        private int storedY;
        final CFont this$0;

        protected CharData(CFont cFont) {
            this.this$0 = cFont;
        }

        static int access$002(CharData charData, int n) {
            charData.storedX = n;
            return charData.storedX;
        }

        static int access$102(CharData charData, int n) {
            charData.storedY = n;
            return charData.storedY;
        }

        static int access$000(CharData charData) {
            return charData.storedX;
        }

        static int access$100(CharData charData) {
            return charData.storedY;
        }
    }
}

