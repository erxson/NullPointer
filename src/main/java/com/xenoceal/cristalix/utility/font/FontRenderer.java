/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  dev.xdark.clientapi.opengl.GlStateManager
 *  dev.xdark.clientapi.texture.DynamicTexture
 *  org.lwjgl.opengl.GL11
 */
package com.xenoceal.cristalix.utility.font;

import com.xenoceal.cristalix.Wrapper;
import com.xenoceal.cristalix.utility.font.CFont;
import dev.xdark.clientapi.opengl.GlStateManager;
import dev.xdark.clientapi.texture.DynamicTexture;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import org.lwjgl.opengl.GL11;

public final class FontRenderer
extends CFont {
    private final CFont.CharData[] boldChars = new CFont.CharData[256];
    private final CFont.CharData[] italicChars = new CFont.CharData[256];
    private final CFont.CharData[] boldItalicChars = new CFont.CharData[256];
    private final int[] colorCode = new int[32];
    private DynamicTexture texBold;
    private DynamicTexture texItalic;
    private DynamicTexture texItalicBold;

    public FontRenderer(Font font, boolean bl, boolean bl2) {
        super(font, bl, bl2);
        this.setupMinecraftColorCodes();
        this.setupBoldItalicIDs();
    }

    public float drawString(String string, float f, float f2, int n) {
        return this.drawString(string, f, f2, n, false);
    }

    public float drawString(String string, double d, double d2, int n) {
        return this.drawString(string, d, d2, n, false);
    }

    public float drawStringWithShadow(String string, float f, float f2, int n) {
        float f3 = this.drawString(string, (double)f + 1.0, (double)f2 + 0.5, n, true);
        return Math.max(f3, this.drawString(string, f, f2, n, false));
    }

    public float drawStringWithShadow(String string, double d, double d2, int n) {
        float f = this.drawString(string, d + 1.0, d2 + 0.5, n, true);
        return Math.max(f, this.drawString(string, d, d2, n, false));
    }

    public float drawCenteredString(String string, float f, float f2, int n) {
        return this.drawString(string, f - (float)this.getStringWidth(string) / 2.0f, f2, n);
    }

    public void drawCenteredString(String string, double d, double d2, int n) {
        this.drawString(string, d - (double)this.getStringWidth(string) / 2.0, d2, n);
    }

    public float drawCenteredStringWithShadow(String string, float f, float f2, int n) {
        float f3 = this.drawString(string, (double)f - (double)this.getStringWidth(string) / 2.0 + 0.45, (double)f2 + 0.5, n, true);
        return this.drawString(string, f - (float)this.getStringWidth(string) / 2.0f, f2, n);
    }

    public void drawStringWithOutline(String string, double d, double d2, int n) {
        this.drawString(string, d - 0.5, d2, 0);
        this.drawString(string, d + 0.5, d2, 0);
        this.drawString(string, d, d2 - 0.5, 0);
        this.drawString(string, d, d2 + 0.5, 0);
        this.drawString(string, d, d2, n);
    }

    public void drawCenteredStringWithOutline(String string, double d, double d2, int n) {
        this.drawCenteredString(string, d - 0.5, d2, 0);
        this.drawCenteredString(string, d + 0.5, d2, 0);
        this.drawCenteredString(string, d, d2 - 0.5, 0);
        this.drawCenteredString(string, d, d2 + 0.5, 0);
        this.drawCenteredString(string, d, d2, n);
    }

    public float drawCenteredStringWithShadow(String string, double d, double d2, int n) {
        float f = this.drawString(string, d - (double)this.getStringWidth(string) / 2.0 + 0.45, d2 + 0.5, n, true);
        return this.drawString(string, d - (double)this.getStringWidth(string) / 2.0, d2, n);
    }

    public float drawString(String string, double d, double d2, int n, boolean bl) {
        Object object = Wrapper.getMinecraft();
        d -= 1.0;
        if (string == null) {
            return 0.0f;
        }
        if (n == 0x20FFFFFF) {
            n = 0xFFFFFF;
        }
        if ((n & 0xFC000000) == 0) {
            n |= 0xFF000000;
        }
        if (bl) {
            n = (n & 0xFCFCFC) >> 2 | n & new Color(20, 20, 20, 200).getRGB();
        }
        CFont.CharData[] arrcharData = this.charData;
        float f = (float)(n >> 24 & 0xFF) / 255.0f;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        d *= 2.0;
        d2 = (d2 - 3.0) * 2.0;
        GL11.glPushMatrix();
        GlStateManager.scale((double)0.5, (double)0.5, (double)0.5);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc((int)770, (int)771);
        GlStateManager.color((float)((float)(n >> 16 & 0xFF) / 255.0f), (float)((float)(n >> 8 & 0xFF) / 255.0f), (float)((float)(n & 0xFF) / 255.0f), (float)f);
        int n2 = string.length();
        GlStateManager.enableTexture2D();
        GlStateManager.bindTexture((int)this.dynamicTexture.getGlTextureId());
        GL11.glBindTexture((int)3553, (int)this.dynamicTexture.getGlTextureId());
        for (int i = 0; i < n2; ++i) {
            char c = string.charAt(i);
            if (String.valueOf(c).equals("\u00a7") && i < n2) {
                int n3 = 21;
                try {
                    n3 = "0123456789abcdefklmnor".indexOf(string.charAt(i + 1));
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                if (n3 < 16) {
                    bl3 = false;
                    bl4 = false;
                    bl2 = false;
                    bl6 = false;
                    bl5 = false;
                    GlStateManager.bindTexture((int)this.dynamicTexture.getGlTextureId());
                    arrcharData = this.charData;
                    if (n3 < 0 || n3 > 15) {
                        n3 = 15;
                    }
                    if (bl) {
                        n3 += 16;
                    }
                    int n4 = this.colorCode[n3];
                    GlStateManager.color((float)((float)(n4 >> 16 & 0xFF) / 255.0f), (float)((float)(n4 >> 8 & 0xFF) / 255.0f), (float)((float)(n4 & 0xFF) / 255.0f), (float)f);
                } else if (n3 == 16) {
                    bl2 = true;
                } else if (n3 == 17) {
                    bl3 = true;
                    if (bl4) {
                        GlStateManager.bindTexture((int)this.texItalicBold.getGlTextureId());
                        arrcharData = this.boldItalicChars;
                    } else {
                        GlStateManager.bindTexture((int)this.texBold.getGlTextureId());
                        arrcharData = this.boldChars;
                    }
                } else if (n3 == 18) {
                    bl5 = true;
                } else if (n3 == 19) {
                    bl6 = true;
                } else if (n3 == 20) {
                    bl4 = true;
                    if (bl3) {
                        GlStateManager.bindTexture((int)this.texItalicBold.getGlTextureId());
                        arrcharData = this.boldItalicChars;
                    } else {
                        GlStateManager.bindTexture((int)this.texItalic.getGlTextureId());
                        arrcharData = this.italicChars;
                    }
                } else if (n3 == 21) {
                    bl3 = false;
                    bl4 = false;
                    bl2 = false;
                    bl6 = false;
                    bl5 = false;
                    GlStateManager.color((float)((float)(n >> 16 & 0xFF) / 255.0f), (float)((float)(n >> 8 & 0xFF) / 255.0f), (float)((float)(n & 0xFF) / 255.0f), (float)f);
                    GlStateManager.bindTexture((int)this.dynamicTexture.getGlTextureId());
                    arrcharData = this.charData;
                }
                ++i;
                continue;
            }
            if (c >= arrcharData.length || c < '\u0000') continue;
            GL11.glBegin((int)4);
            this.drawChar(arrcharData, c, (float)d, (float)d2);
            GL11.glEnd();
            if (bl5) {
                this.drawLine(d, d2 + (double)arrcharData[c].height / 2.0, d + (double)arrcharData[c].width - 8.0, d2 + (double)arrcharData[c].height / 2.0, 1.0f);
            }
            if (bl6) {
                this.drawLine(d, d2 + (double)arrcharData[c].height - 2.0, d + (double)arrcharData[c].width - 8.0, d2 + (double)arrcharData[c].height - 2.0, 1.0f);
            }
            d += (double)(arrcharData[c].width - 8);
        }
        GL11.glHint((int)3155, (int)4352);
        GL11.glPopMatrix();
        return (float)d / 2.0f;
    }

    @Override
    public int getStringWidth(String string) {
        if (string == null) {
            return 0;
        }
        int n = 0;
        CFont.CharData[] arrcharData = this.charData;
        boolean bl = false;
        boolean bl2 = false;
        int n2 = string.length();
        for (int i = 0; i < n2; ++i) {
            char c = string.charAt(i);
            if (String.valueOf(c).equals("\u00a7")) {
                int n3 = "0123456789abcdefklmnor".indexOf(c);
                if (n3 < 16) {
                    bl = false;
                    bl2 = false;
                } else if (n3 == 17) {
                    bl = true;
                    arrcharData = bl2 ? this.boldItalicChars : this.boldChars;
                } else if (n3 == 20) {
                    bl2 = true;
                    arrcharData = bl ? this.boldItalicChars : this.italicChars;
                } else if (n3 == 21) {
                    bl = false;
                    bl2 = false;
                    arrcharData = this.charData;
                }
                ++i;
                continue;
            }
            if (c >= arrcharData.length) continue;
            n += arrcharData[c].width - 8;
        }
        return n / 2;
    }

    public int getStringWidthCust(String string) {
        if (string == null) {
            return 0;
        }
        int n = 0;
        CFont.CharData[] arrcharData = this.charData;
        boolean bl = false;
        boolean bl2 = false;
        int n2 = string.length();
        for (int i = 0; i < n2; ++i) {
            char c = string.charAt(i);
            if (String.valueOf(c).equals("\u00c2\u00a7")) {
                int n3 = "0123456789abcdefklmnor".indexOf(c);
                if (n3 < 16) {
                    bl = false;
                    bl2 = false;
                } else if (n3 == 17) {
                    bl = true;
                    arrcharData = bl2 ? this.boldItalicChars : this.boldChars;
                } else if (n3 == 20) {
                    bl2 = true;
                    arrcharData = bl ? this.boldItalicChars : this.italicChars;
                } else if (n3 == 21) {
                    bl = false;
                    bl2 = false;
                    arrcharData = this.charData;
                }
                ++i;
                continue;
            }
            if (c >= arrcharData.length) continue;
            n += arrcharData[c].width - 8;
        }
        return n / 2;
    }

    @Override
    public void setFont(Font font) {
        super.setFont(font);
        this.setupBoldItalicIDs();
    }

    @Override
    public void setAntiAlias(boolean bl) {
        super.setAntiAlias(bl);
        this.setupBoldItalicIDs();
    }

    @Override
    public void setFractionalMetrics(boolean bl) {
        super.setFractionalMetrics(bl);
        this.setupBoldItalicIDs();
    }

    private void setupBoldItalicIDs() {
        this.texBold = this.setupTexture(this.font.deriveFont(1), this.antiAlias, this.fractionalMetrics, this.boldChars);
        this.texItalic = this.setupTexture(this.font.deriveFont(2), this.antiAlias, this.fractionalMetrics, this.italicChars);
        this.texItalicBold = this.setupTexture(this.font.deriveFont(3), this.antiAlias, this.fractionalMetrics, this.boldItalicChars);
    }

    private void drawLine(double d, double d2, double d3, double d4, float f) {
        GL11.glDisable((int)3553);
        GL11.glLineWidth((float)f);
        GL11.glBegin((int)1);
        GL11.glVertex2d((double)d, (double)d2);
        GL11.glVertex2d((double)d3, (double)d4);
        GL11.glEnd();
        GL11.glEnable((int)3553);
    }

    public List<String> wrapWords(String string, double d) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if ((double)this.getStringWidth(string) > d) {
            String[] arrstring = string.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            char c = '\uffff';
            for (String string2 : arrstring) {
                for (int i = 0; i < string2.toCharArray().length; ++i) {
                    char c2 = string2.toCharArray()[i];
                    if (!String.valueOf(c2).equals("\u00c2\u00a7") || i >= string2.toCharArray().length - 1) continue;
                    c = string2.toCharArray()[i + 1];
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                if ((double)this.getStringWidth(stringBuilder2.append((Object)stringBuilder).append(string2).append(" ").toString()) < d) {
                    stringBuilder.append(string2).append(" ");
                    continue;
                }
                arrayList.add(stringBuilder.toString());
                stringBuilder = new StringBuilder(c + string2 + " ");
            }
            if (stringBuilder.length() > 0) {
                if ((double)this.getStringWidth(stringBuilder.toString()) < d) {
                    arrayList.add(c + stringBuilder.toString() + " ");
                } else {
                    arrayList.addAll(this.formatString(stringBuilder.toString(), d));
                }
            }
        } else {
            arrayList.add(string);
        }
        return arrayList;
    }

    public List<String> formatString(String string, double d) {
        ArrayList<String> arrayList = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        char c = '\uffff';
        char[] arrc = string.toCharArray();
        for (int i = 0; i < arrc.length; ++i) {
            char c2 = arrc[i];
            if (String.valueOf(c2).equals("\u00c2\u00a7") && i < arrc.length - 1) {
                c = arrc[i + 1];
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            if ((double)this.getStringWidth(stringBuilder2.append(stringBuilder.toString()).append(c2).toString()) < d) {
                stringBuilder.append(c2);
                continue;
            }
            arrayList.add(stringBuilder.toString());
            stringBuilder = new StringBuilder(c + String.valueOf(c2));
        }
        if (stringBuilder.length() > 0) {
            arrayList.add(stringBuilder.toString());
        }
        return arrayList;
    }

    private void setupMinecraftColorCodes() {
        for (int i = 0; i < 32; ++i) {
            int n = (i >> 3 & 1) * 85;
            int n2 = (i >> 2 & 1) * 170 + n;
            int n3 = (i >> 1 & 1) * 170 + n;
            int n4 = (i & 1) * 170 + n;
            if (i == 6) {
                n2 += 85;
            }
            if (i >= 16) {
                n2 /= 4;
                n3 /= 4;
                n4 /= 4;
            }
            this.colorCode[i] = (n2 & 0xFF) << 16 | (n3 & 0xFF) << 8 | n4 & 0xFF;
        }
    }
}

