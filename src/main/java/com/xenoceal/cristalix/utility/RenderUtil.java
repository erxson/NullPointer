/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  dev.xdark.clientapi.opengl.GlStateManager
 *  dev.xdark.clientapi.render.BufferBuilder
 *  dev.xdark.clientapi.render.DefaultVertexFormats
 *  dev.xdark.clientapi.render.Tessellator
 */
package com.xenoceal.cristalix.utility;

import com.xenoceal.cristalix.NullPointer;
import dev.xdark.clientapi.opengl.GlStateManager;
import dev.xdark.clientapi.render.BufferBuilder;
import dev.xdark.clientapi.render.DefaultVertexFormats;
import dev.xdark.clientapi.render.Tessellator;

public final class RenderUtil {
    public static void drawRect(float f, float f2, float f3, float f4, int n) {
        float f5 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f6 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n & 0xFF) / 255.0f;
        Tessellator tessellator = NullPointer.INSTANCE.getApi().tessellator();
        BufferBuilder bufferBuilder = tessellator.getBufferBuilder();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate((int)770, (int)771, (int)1, (int)0);
        bufferBuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferBuilder.pos((double)f, (double)f4, 0.0).color((int)f6, (int)f7, (int)f8, (int)f5).endVertex();
        bufferBuilder.pos((double)f3, (double)f4, 0.0).color((int)f6, (int)f7, (int)f8, (int)f5).endVertex();
        bufferBuilder.pos((double)f3, (double)f2, 0.0).color((int)f6, (int)f7, (int)f8, (int)f5).endVertex();
        bufferBuilder.pos((double)f, (double)f2, 0.0).color((int)f6, (int)f7, (int)f8, (int)f5).endVertex();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    private RenderUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

