/*
 * Decompiled with CFR 0.152.
 *
 * Could not load the following classes:
 *  dev.xdark.clientapi.ClientApi
 *  dev.xdark.clientapi.block.Block
 *  dev.xdark.clientapi.block.material.Material
 *  dev.xdark.clientapi.block.state.BlockState
 *  dev.xdark.clientapi.entity.Entity
 *  dev.xdark.clientapi.entity.EntityArmorStand
 *  dev.xdark.clientapi.entity.EntityLivingBase
 *  dev.xdark.clientapi.entity.EntityPlayer
 *  dev.xdark.clientapi.entity.EntityPlayerSP
 *  dev.xdark.clientapi.entry.ModMain
 *  dev.xdark.clientapi.event.Event
 *  dev.xdark.clientapi.event.Listener
 *  dev.xdark.clientapi.event.chat.ChatSend
 *  dev.xdark.clientapi.event.entity.PlayerJump
 *  dev.xdark.clientapi.event.input.KeyPress
 *  dev.xdark.clientapi.event.lifecycle.GameLoop
 *  dev.xdark.clientapi.event.render.GuiOverlayRender
 *  dev.xdark.clientapi.event.render.RenderPass
 *  dev.xdark.clientapi.gui.Screen
 *  dev.xdark.clientapi.inventory.ClickType
 *  dev.xdark.clientapi.inventory.Container
 *  dev.xdark.clientapi.inventory.Inventory
 *  dev.xdark.clientapi.inventory.Slot
 *  dev.xdark.clientapi.math.AxisAlignedBB
 *  dev.xdark.clientapi.math.BlockPos
 *  dev.xdark.clientapi.math.RayTraceResult
 *  dev.xdark.clientapi.math.RayTraceResult$Type
 *  dev.xdark.clientapi.text.Text
 *  dev.xdark.clientapi.text.TextFormatting
 *  dev.xdark.clientapi.util.EnumFacing
 *  dev.xdark.clientapi.util.EnumHand
 *  dev.xdark.clientapi.world.World
 *  org.lwjgl.input.Keyboard
 *  org.lwjgl.opengl.GL11
 */
package com.xenoceal.cristalix;

import com.xenoceal.cristalix.event.EventHandler;
import com.xenoceal.cristalix.event.EventType;
import com.xenoceal.cristalix.module.Module;
import com.xenoceal.cristalix.utility.ColorUtil;
import com.xenoceal.cristalix.utility.TimerUtil;
import com.xenoceal.cristalix.utility.font.FontRenderer;
import com.xenoceal.cristalix.utility.font.FontUtil;
import dev.xdark.clientapi.ClientApi;
import dev.xdark.clientapi.block.Block;
import dev.xdark.clientapi.block.material.Material;
import dev.xdark.clientapi.block.state.BlockState;
import dev.xdark.clientapi.entity.Entity;
import dev.xdark.clientapi.entity.EntityArmorStand;
import dev.xdark.clientapi.entity.EntityLivingBase;
import dev.xdark.clientapi.entity.EntityPlayer;
import dev.xdark.clientapi.entity.EntityPlayerSP;
import dev.xdark.clientapi.entry.ModMain;
import dev.xdark.clientapi.event.Event;
import dev.xdark.clientapi.event.Listener;
import dev.xdark.clientapi.event.chat.ChatSend;
import dev.xdark.clientapi.event.entity.PlayerJump;
import dev.xdark.clientapi.event.input.KeyPress;
import dev.xdark.clientapi.event.lifecycle.GameLoop;
import dev.xdark.clientapi.event.render.GuiOverlayRender;
import dev.xdark.clientapi.event.render.RenderPass;
import dev.xdark.clientapi.gui.Screen;
import dev.xdark.clientapi.inventory.ClickType;
import dev.xdark.clientapi.inventory.Container;
import dev.xdark.clientapi.inventory.Inventory;
import dev.xdark.clientapi.inventory.Slot;
import dev.xdark.clientapi.math.AxisAlignedBB;
import dev.xdark.clientapi.math.BlockPos;
import dev.xdark.clientapi.math.RayTraceResult;
import dev.xdark.clientapi.text.Text;
import dev.xdark.clientapi.text.TextFormatting;
import dev.xdark.clientapi.util.EnumFacing;
import dev.xdark.clientapi.util.EnumHand;
import dev.xdark.clientapi.world.World;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public final class NullPointer
        implements ModMain,
        Listener {
    public static final NullPointer INSTANCE = new NullPointer();
    private ClientApi api;
    private final List<Module> modules = new ArrayList<Module>();
    private FontRenderer fontRenderer;

    public void load(ClientApi clientApi) {
        System.out.println("asdfcajsdiocfhoaicshdifcaiosudhofnoiacshdfnoiasdufhcansdifhacsodf");
        this.api = clientApi;
        try {
            Reflection.initialize();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        this.fontRenderer = new FontRenderer(FontUtil.getFontFromTTF("/font/videotype.ttf", 18.0f, 0), true, true);
        this.loadModules();
        GameLoop.BUS.register((Listener)this, arg_0 -> this.GameLoop(clientApi, arg_0), 1);
        KeyPress.BUS.register((Listener)this, arg_0 -> this.KeyPress(clientApi, arg_0), 1);
        GuiOverlayRender.BUS.register((Listener)this, arg_0 -> this.GuiOverlayRender(clientApi, arg_0), 1);
        RenderPass.BUS.register((Listener)this, arg_0 -> this.RenderPass(clientApi, arg_0), 1);
        PlayerJump.BUS.register((Listener)this, arg_0 -> this.PlayerJump(clientApi, arg_0), 1);
        ChatSend.BUS.register((Listener)this, arg_0 -> this.ChatSend(clientApi, arg_0), 1);
    }

    public ClientApi getApi() {
        return this.api;
    }

    public interface MyEventHandler {
        void handle(Module module, Event event);
    }

    private void loadModules() {
        final long[] longObject = new long[]{0L};
        final float[] floatObject = new float[]{0.3f};
        final double[] doubleObject = new double[]{1.0};
        final ArrayList<Object> objectArray = new ArrayList<>();
        final boolean[] booleanObjectArray = new boolean[]{false};
        final int[] intObjectArray = new int[]{0};
        final int[] intArray = new int[]{6};
        final long[] longArray = new long[]{250L};
        TimerUtil timerUtil = new TimerUtil();

        Module.Builder.builder().name("PlayerESP").enabled(false).key(21).handles(this::PlayerESP).build(this);
        Module.Builder.builder().name("AutoSprint").enabled(false).key(37).handles(this::AutoSprint).build(this);

        Module.Builder.builder().name("Killaura").enabled(false).key(19).handles((arg_0, arg_1) -> this.Killaura(longObject, arg_0, arg_1)).build(this);
        Module.Builder.builder().name("HitBoxes").enabled(false).key(35).handles((arg_0, arg_1) -> this.Hitboxes(floatObject, arg_0, arg_1), (arg_0, arg_1) -> NullPointer.lambda$loadModules$11(floatObject, arg_0, arg_1)).build(this);
        Module.Builder.builder().name("NoFall").enabled(false).key(49).handles(this::NoFall).build(this);
        Module.Builder.builder().name("Fly").enabled(false).key(33).handles((arg_0, arg_1) -> this.lambda$loadModules$13(floatObject, arg_0, arg_1), (arg_0, arg_1) -> NullPointer.lambda$loadModules$14(floatObject, arg_0, arg_1)).build(this);
        Module.Builder.builder().name("MultiJump").enabled(false).key(0).handles(this::MultiJump).build(this);

        Module.Builder.builder().name("TriggerBot").enabled(false).key(0).handles((arg_0, arg_1) -> this.TriggerBot(longObject, arg_0, arg_1)).build(this);
        Module.Builder.builder().name("ChestStealer").enabled(false).key(0).handles(this::ChestStealer).build(this);

        Module.Builder.builder().name("SpeedHack").enabled(false).key(47).handles((arg_0, arg_1) -> this.lambda$loadModules$18(doubleObject, arg_0, arg_1), (arg_0, arg_1) -> NullPointer.lambda$loadModules$19(doubleObject, arg_0, arg_1)).build(this);
        Module.Builder.builder().name("ChestESP").enabled(false).key(22).handles(this::ChestESP).build(this);
        Module.Builder.builder().name("FastBreak").enabled(false).key(0).handles(this::lambda$loadModules$21).build(this);

        Module.Builder.builder().name("MobAura").enabled(false).key(34).handles((arg_0, arg_1) -> this.MobAura(longObject, intObjectArray, arg_0, arg_1)).build(this);

        Module.Builder.builder().name("LongJump").enabled(false).key(37).handles((arg_0, arg_1) -> this.LJ(doubleObject, arg_0, arg_1), (arg_0, arg_1) -> NullPointer.LJKeypress(doubleObject, arg_0, arg_1)).build(this);

        Module.Builder.builder().name("Nuker").enabled(false).key(0).handles((arg_0, arg_1) -> this.Nuker(timerUtil, longArray, intArray, booleanObjectArray, objectArray, arg_0, arg_1), (arg_0, arg_1) -> this.commandsListener(booleanObjectArray, intArray, longArray, objectArray, arg_0, arg_1)).build(this);
    }


    public void addModule(Module module) {
        this.modules.add(module);
    }

    private void drawTextWithRect(String string, float f, float f2, int n) {
        this.api.overlayRenderer().drawRect((int)f, (int)f2, (int)f + this.fontRenderer.getStringWidth(string) + 3, (int)(f2 + (float)this.fontRenderer.getStringHeight(string)) + 4, ColorUtil.RECT_COLOR.getColor());
        this.fontRenderer.drawStringWithShadow(string, f + 2.0f, f2 + 2.0f, n);
    }

    private boolean hasPassed(long l, double d) {
        return (double)(this.getTime() - l) >= d;
    }

    private long getTime() {
        return System.nanoTime() / 1000000L;
    }

    public void unload() {
    }

    private void commandsListener(boolean[] blArray, int[] nArray, long[] lArray, ArrayList arrayList, Module module, Event event) {
        String string = ((ChatSend)event).getMessage();
        if (!string.startsWith(".nuker")) return;
        ((ChatSend)event).setCancelled(true);
        String[] stringArray = string.split(" ");
        String[] stringArray2 = new String[stringArray.length - 1];
        System.arraycopy(stringArray, 1, stringArray2, 0, stringArray2.length);
        if (stringArray2.length < 1) {
            this.api.chat().printChatMessage(Text.of((Object[])new Object[]{"Usage: .nuker <savefloor|radius|delay|add|clear> <value>", TextFormatting.RED}));
            return;
        }
        switch (stringArray2[0]) {
            case "savefloor": {
                if (stringArray2.length < 2) {
                    return;
                }
                blArray[0] = Boolean.parseBoolean(stringArray2[1]);
                break;
            }
            case "radius": {
                if (stringArray2.length < 2) {
                    return;
                }
                nArray[0] = Math.max(Integer.parseInt(stringArray2[1]), 0);
                break;
            }
            case "delay": {
                if (stringArray2.length < 2) {
                    return;
                }
                lArray[0] = Math.max(Long.parseLong(stringArray2[1]), 0L);
                break;
            }
            case "add": {
                BlockPos blockPos;
                Block block;
                World world = this.api.minecraft().getWorld();
                RayTraceResult rayTraceResult = this.api.minecraft().getMouseOver();
                if (rayTraceResult == null || rayTraceResult.getPos() == null || (block = world.getBlockState((blockPos = rayTraceResult.getPos()).getX(), blockPos.getY(), blockPos.getZ()).getBlock()) == null || arrayList.contains(block.getId())) break;
                arrayList.add(block.getId());
                this.getApi().chat().printChatMessage(Text.of((Object[])new Object[]{"Added block: [ " + block.getLocalizedName() + " ]", TextFormatting.GREEN}));
                break;
            }
            case "clear": {
                this.api.chat().printChatMessage(Text.of((Object[])new Object[]{"Removed " + arrayList.size() + " blocks", TextFormatting.GREEN}));
                arrayList.clear();
                return;
            }
        }
        this.api.chat().printChatMessage(Text.of((Object[])new Object[]{"Successfully!", TextFormatting.GREEN}));
    }

    private void Nuker(TimerUtil var1, long[] var2, int[] var3, boolean[] var4, ArrayList var5, Module var6, Event var7) {
        EntityPlayerSP var8 = this.api.minecraft().getPlayer();
        var1.setTimeout(var2[0]);
        if (var1.isTimeReached()) {
            for(int var9 = var3[0]; var9 >= -var3[0]; --var9) {
                for(int var10 = var3[0]; var10 >= -var3[0]; --var10) {
                    for(int var11 = -var3[0]; var11 <= var3[0]; ++var11) {
                        int var12 = (int)var8.getX() + var9;
                        int var13 = (int)var8.getY() + var11;
                        int var14 = (int)var8.getZ() + var10;
                        if ((double)var13 >= var8.getY() || !var4[0]) {
                            BlockState var15 = this.api.minecraft().getWorld().getBlockState(var12, var13, var14);
                            Block var16 = var15.getBlock();
                            if (var16.getMaterial() != Material.AIR && var5.contains(var16.getId())) {
                                Wrapper.sendPacket(Wrapper.CPacketPlayerDigging(Wrapper.START_DESTROY_BLOCK(), BlockPos.of(var12, var13, var14), EnumFacing.DOWN));
                                Wrapper.sendPacket(Wrapper.CPacketPlayerDigging(Wrapper.STOP_DESTROY_BLOCK(), BlockPos.of(var12, var13, var14), EnumFacing.DOWN));
                            }
                        }
                    }
                }
            }
        }

    }


    private static void LJKeypress(double[] dArray, Module module, Event event) {
        switch (((KeyPress)event).getKey()) {
            case 200: {
                dArray[0] = dArray[0] + 0.1;
                break;
            }
            case 208: {
                dArray[0] = dArray[0] - (dArray[0] > 0.1 ? 0.1 : 0.0);
                break;
            }
        }
    }

    private void LJ(double[] dArray, Module module, Event event) {
        EntityPlayerSP entityPlayerSP = this.api.minecraft().getPlayer();
        double d = (double)(entityPlayerSP.getRotationYaw() / 180.0f) * Math.PI;
        double d2 = Math.cos(d);
        double d3 = Math.sin(d);
        entityPlayerSP.setMotionX(-d3 * dArray[0]);
        entityPlayerSP.setMotionZ(d2 * dArray[0]);
    }

    private void MobAura(long[] lArray, int[] nArray, Module module, Event event) {
        EntityPlayerSP entityPlayerSP = this.api.minecraft().getPlayer();
        if (!this.hasPassed(lArray[0], 50.0)) {
            return;
        }
        for (Object obj : Wrapper.getLoadedEntities()) {
            if (nArray[0] > 8) break;
            if (obj == null || obj == entityPlayerSP || !(obj instanceof EntityLivingBase) || obj instanceof EntityArmorStand || obj instanceof EntityPlayer || !(Wrapper.getDistanceToEntity((Entity)entityPlayerSP, (Entity)obj) <= 7.0)) continue;
            Wrapper.attackEntity((EntityPlayer)entityPlayerSP, (Entity)obj);
            nArray[0] = nArray[0] + 1;
        }
        nArray[0] = 0;
        lArray[0] = this.getTime();
    }

    private void lambda$loadModules$21(Module module, Event event) {
        RayTraceResult rayTraceResult = this.api.minecraft().getMouseOver();
        if (rayTraceResult == null) return;
        if (rayTraceResult.getPos() == null) return;
        BlockPos blockPos = rayTraceResult.getPos();
        Block block = this.api.minecraft().getWorld().getBlockState(blockPos.getX(), blockPos.getY(), blockPos.getZ()).getBlock();
        if (block == null) {
            return;
        }
        Wrapper.setBlockHitDelay(0);
        Wrapper.setCurBlockDamageMP(1.0f);
    }

    private void ChestESP(Module module, Event event) {
        Iterator<?> iterator = Wrapper.getTileEntities().iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj == null || !Reflection.getClass("TileEntityChest").isInstance(obj) && !Reflection.getClass("TileEntityEnderChest").isInstance(obj)) continue;
            int n = Reflection.getClass("TileEntityChest").isInstance(obj) ? Color.ORANGE.getRGB() : Color.MAGENTA.getRGB();
            float f = (float)(n >> 16 & 0xFF) / 255.0f;
            float f2 = (float)(n >> 8 & 0xFF) / 255.0f;
            float f3 = (float)(n & 0xFF) / 255.0f;
            BlockPos blockPos = Wrapper.getTileEntityBlockPos(obj);
            double d = (double)blockPos.getX() - Wrapper.getStaticPlayerX();
            double d2 = (double)blockPos.getY() - Wrapper.getStaticPlayerY();
            double d3 = (double)blockPos.getZ() - Wrapper.getStaticPlayerZ();
            AxisAlignedBB axisAlignedBB = AxisAlignedBB.of((double)d, (double)d2, (double)d3, (double)(d + 1.0), (double)(d2 + 1.0), (double)(d3 + 1.0));
            GL11.glPushMatrix();
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glDisable((int)3553);
            GL11.glEnable((int)2848);
            GL11.glDisable((int)2929);
            GL11.glDepthMask((boolean)false);
            GL11.glLineWidth((float)2.0f);
            Wrapper.drawOutlinedBB(this.api.tessellator(), axisAlignedBB, f, f2, f3, 1.0f);
            Wrapper.drawFilledBB(this.api.tessellator(), axisAlignedBB, f, f2, f3, 0.2f);
            GL11.glDisable((int)2848);
            GL11.glEnable((int)3553);
            GL11.glEnable((int)2929);
            GL11.glDepthMask((boolean)true);
            GL11.glDisable((int)3042);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPopMatrix();
        }
    }

    private static void lambda$loadModules$19(double[] dArray, Module module, Event event) {
        switch (((KeyPress)event).getKey()) {
            case 200: {
                dArray[0] = dArray[0] + 0.1;
                break;
            }
            case 208: {
                dArray[0] = dArray[0] - (dArray[0] > 0.1 ? 0.1 : 0.0);
                break;
            }
        }
    }

    private void lambda$loadModules$18(double[] dArray, Module module, Event event) {
        EntityPlayerSP entityPlayerSP = this.api.minecraft().getPlayer();
        float f = Wrapper.getMoveForward(entityPlayerSP);
        float f2 = Wrapper.getMoveStrafe(entityPlayerSP);
        float f3 = entityPlayerSP.getRotationYaw();
        if (f == 0.0f && f2 == 0.0f) {
            entityPlayerSP.setMotionX(0.0);
            entityPlayerSP.setMotionZ(0.0);
        } else if (f != 0.0f) {
            if (f2 >= 1.0f) {
                f3 += f > 0.0f ? -35.0f : 35.0f;
                f2 = 0.0f;
            } else if (f2 <= -1.0f) {
                f3 += f > 0.0f ? 35.0f : -35.0f;
                f2 = 0.0f;
            }
            if (f > 0.0f) {
                f = 1.0f;
            } else if (f < 0.0f) {
                f = -1.0f;
            }
        }
        double d = Math.cos(Math.toRadians(f3 + 90.0f));
        double d2 = Math.sin(Math.toRadians(f3 + 90.0f));
        entityPlayerSP.setMotionX((double)f * dArray[0] * d + (double)f2 * dArray[0] * d2);
        entityPlayerSP.setMotionZ((double)f * dArray[0] * d2 - (double)f2 * dArray[0] * d);
    }

    private void ChestStealer(Module module, Event event) {
        EntityPlayerSP entityPlayerSP = this.api.minecraft().getPlayer();
        Container container = entityPlayerSP.getOpenContainer();
        if (container == null) return;
        if (!Reflection.getClass("ContainerChest").isInstance(container)) return;
        Inventory inventory = Wrapper.getLowerChestInventory(container);
        int n = 0;
        while (true) {
            if (n >= inventory.getSizeInventory()) {
                Screen screen = this.api.minecraft().currentScreen();
                if (screen == null) return;
                if (!Reflection.getClass("GuiChest").isInstance(screen)) return;
                entityPlayerSP.closeScreen();
                return;
            }
            Slot slot = (Slot)container.getSlots().get(n);
            if (slot.getStack() != null) {
                this.api.minecraft().getPlayerController().windowClick(container.getWindowId(), n, 0, ClickType.QUICK_MOVE);
            }
            ++n;
        }
    }

    private void TriggerBot(long[] lArray, Module module, Event event) {
        if (!this.hasPassed(lArray[0], 50.0)) {
            return;
        }
        EntityPlayerSP entityPlayerSP = this.api.minecraft().getPlayer();
        RayTraceResult rayTraceResult = this.api.minecraft().getMouseOver();
        if (rayTraceResult != null && rayTraceResult.getType() == RayTraceResult.Type.ENTITY) {
            Wrapper.attackEntity((EntityPlayer)entityPlayerSP, rayTraceResult.getEntity());
            Wrapper.swingArm(entityPlayerSP, EnumHand.MAIN_HAND);
        }
        lArray[0] = this.getTime();
    }

    private void MultiJump(Module module, Event event) {
        if (!Keyboard.isKeyDown((int)57)) return;
        Wrapper.setOnGround((Entity)this.api.minecraft().getPlayer(), true);
    }

    private static void lambda$loadModules$14(float[] fArray, Module module, Event event) {
        switch (((KeyPress)event).getKey()) {
            case 200: {
                fArray[0] = fArray[0] + 0.1f;
                break;
            }
            case 208: {
                fArray[0] = fArray[0] - (fArray[0] > 0.1f ? 0.1f : 0.0f);
                break;
            }
        }
    }

    private void lambda$loadModules$13(float[] fArray, Module module, Event event) {
        EntityPlayerSP entityPlayerSP = this.api.minecraft().getPlayer();
        Wrapper.setOnGround((Entity)entityPlayerSP, false);
        Wrapper.setJumpMovementFactor((Entity)entityPlayerSP, fArray[0]);
        entityPlayerSP.setMotionX(0.0);
        entityPlayerSP.setMotionY(-0.1);
        entityPlayerSP.setMotionZ(0.0);
        if (Keyboard.isKeyDown((int)57)) {
            entityPlayerSP.setMotionY(0.5);
        } else {
            if (!Keyboard.isKeyDown((int)42)) return;
            entityPlayerSP.setMotionY(-0.5);
        }
    }

    private void NoFall(Module module, Event event) {
        EntityPlayerSP entityPlayerSP = this.api.minecraft().getPlayer();
        if (!(Wrapper.getFallDistance((Entity)entityPlayerSP) > 2.0f)) return;
        Wrapper.sendPacket(Wrapper.CPacketPlayer(true));
    }

    private static void lambda$loadModules$11(float[] fArray, Module module, Event event) {
        switch (((KeyPress)event).getKey()) {
            case 200: {
                fArray[0] = fArray[0] + 0.1f;
                break;
            }
            case 208: {
                fArray[0] = fArray[0] - (fArray[0] > 0.3f ? 0.1f : 0.0f);
                break;
            }
        }
    }

    private void Hitboxes(float[] fArray, Module module, Event event) {
        EntityPlayerSP entityPlayerSP = this.api.minecraft().getPlayer();
        Iterator<EntityPlayer> iterator = Wrapper.getPlayerEntities().iterator();
        while (iterator.hasNext()) {
            EntityPlayer entityPlayer = iterator.next();
            if (entityPlayer == null || entityPlayer == entityPlayerSP) continue;
            entityPlayer.setEntityBoundingBox(AxisAlignedBB.of((double)(entityPlayer.getX() - (double)fArray[0]), (double)entityPlayer.getEntityBoundingBox().getMinY(), (double)(entityPlayer.getZ() - (double)fArray[0]), (double)(entityPlayer.getX() + (double)fArray[0]), (double)entityPlayer.getEntityBoundingBox().getMaxY(), (double)(entityPlayer.getZ() + (double)fArray[0])));
        }
    }

    private void Killaura(long[] lArray, Module module, Event event) {
        if (!this.hasPassed(lArray[0], 50.0)) {
            return;
        }
        EntityPlayerSP entityPlayerSP = this.api.minecraft().getPlayer();
        Iterator<EntityPlayer> iterator = Wrapper.getPlayerEntities().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                lArray[0] = this.getTime();
                return;
            }
            EntityPlayer entityPlayer = iterator.next();
            if (entityPlayer == null || entityPlayer == entityPlayerSP || !(Wrapper.getDistanceToEntity((Entity)entityPlayerSP, (Entity)entityPlayer) <= 7.0)) continue;
            Wrapper.attackEntity((EntityPlayer)entityPlayerSP, (Entity)entityPlayer);
        }
    }

    private void AutoSprint(Module module, Event event) {
        if (this.api.minecraft().currentScreen() != null) {
            return;
        }
        if (!Keyboard.isKeyDown((int)17)) return;
        this.api.minecraft().getPlayer().setSprinting(true);
    }

    private void PlayerESP(Module module, Event event) {
        EntityPlayerSP entityPlayerSP = this.api.minecraft().getPlayer();
        float f = ((RenderPass)event).getPartialTicks();
        Iterator<EntityPlayer> iterator = Wrapper.getPlayerEntities().iterator();
        while (iterator.hasNext()) {
            EntityPlayer entityPlayer = iterator.next();
            if (entityPlayer == null || entityPlayer == entityPlayerSP) continue;
            float f2 = 0.37f;
            float f3 = Math.min(entityPlayer.getHealth(), 20.0f) / 10.0f;
            double d = entityPlayer.getLastX() + (entityPlayer.getX() - entityPlayer.getLastX()) * (double)f - Wrapper.getStaticPlayerX();
            double d2 = entityPlayer.getLastY() + (entityPlayer.getY() - entityPlayer.getLastY()) * (double)f - Wrapper.getStaticPlayerY();
            double d3 = entityPlayer.getLastZ() + (entityPlayer.getZ() - entityPlayer.getLastZ()) * (double)f - Wrapper.getStaticPlayerZ();
            GL11.glPushMatrix();
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glDisable((int)3553);
            GL11.glEnable((int)2848);
            GL11.glDisable((int)2929);
            GL11.glDepthMask((boolean)false);
            GL11.glLineWidth((float)2.0f);
            GL11.glTranslated((double)d, (double)d2, (double)d3);
            GL11.glRotatef((float)(-entityPlayer.getRotationYaw()), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glTranslated((double)(-d), (double)(-d2), (double)(-d3));
            Wrapper.drawOutlinedBB(this.api.tessellator(), AxisAlignedBB.of((double)(d - (double)0.37f), (double)d2, (double)(d3 - (double)0.37f), (double)(d + (double)0.37f), (double)(d2 + (double)f3), (double)(d3 + (double)0.37f)), 0.5f, 1.0f, 0.5f, 1.0f);
            Wrapper.drawFilledBB(this.api.tessellator(), AxisAlignedBB.of((double)(d - (double)0.37f), (double)d2, (double)(d3 - (double)0.37f), (double)(d + (double)0.37f), (double)(d2 + (double)f3), (double)(d3 + (double)0.37f)), 0.5f, 1.0f, 0.5f, 0.55f);
            GL11.glDisable((int)2848);
            GL11.glEnable((int)3553);
            GL11.glEnable((int)2929);
            GL11.glDepthMask((boolean)true);
            GL11.glDisable((int)3042);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPopMatrix();
        }
    }

    private void ChatSend(ClientApi var1, ChatSend var2) {
        String var3 = var2.getMessage();
        Iterator var4 = this.modules.iterator();

        Iterator var6;
        while(var4.hasNext()) {
            Module var5 = (Module)var4.next();
            var6 = var5.getHandlers().iterator();

            while(var6.hasNext()) {
                EventHandler var7 = (EventHandler)var6.next();
                if (var7.type() == EventType.CHAT_SEND) {
                    var5.invoke(var2, var7);
                }
            }
        }

        if (var3.startsWith(".")) {
            var2.setCancelled(true);
            String[] var8 = var3.substring(1).split(" ");
            String[] var9 = new String[var8.length - 1];
            System.arraycopy(var8, 1, var9, 0, var9.length);
            if (var8[0].equalsIgnoreCase("bind")) {
                if (var9.length != 2) {
                    var1.chat().printChatMessage(Text.of(new Object[]{"Usage: .bind <module> <key>", TextFormatting.RED}));
                    return;
                }

                var6 = this.modules.iterator();

                while(var6.hasNext()) {
                    Module var10 = (Module)var6.next();
                    if (var10.getName().equalsIgnoreCase(var9[0])) {
                        var10.setKey(Keyboard.getKeyIndex(var9[1].toUpperCase()));
                        var1.chat().printChatMessage(Text.of(new Object[]{"Successfully!", TextFormatting.GREEN}));
                        break;
                    }
                }
            }
        }

    }


    /*
     * Unable to fully structure code
     */
    private void PlayerJump(ClientApi var1, PlayerJump var2) {
        EntityPlayerSP var3 = var1.minecraft().getPlayer();
        World var4 = var1.minecraft().getWorld();
        if (var3 != null && var4 != null) {
            Iterator var5 = this.modules.iterator();

            while(true) {
                Module var6;
                do {
                    if (!var5.hasNext()) {
                        return;
                    }

                    var6 = (Module)var5.next();
                } while(!var6.isEnabled());

                Iterator var7 = var6.getHandlers().iterator();

                while(var7.hasNext()) {
                    EventHandler var8 = (EventHandler)var7.next();
                    if (var8.type() == EventType.PLAYER_JUMP) {
                        var6.invoke(var2, var8);
                    }
                }
            }
        }
    }


    /*
     * Unable to fully structure code
     */
    private void RenderPass(ClientApi var1, RenderPass var2) {
        EntityPlayerSP var3 = var1.minecraft().getPlayer();
        World var4 = var1.minecraft().getWorld();
        if (var3 != null && var4 != null) {
            Iterator var5 = this.modules.iterator();

            while(true) {
                Module var6;
                do {
                    if (!var5.hasNext()) {
                        return;
                    }

                    var6 = (Module)var5.next();
                } while(!var6.isEnabled());

                Iterator var7 = var6.getHandlers().iterator();

                while(var7.hasNext()) {
                    EventHandler var8 = (EventHandler)var7.next();
                    if (var8.type() == EventType.RENDER_PASS) {
                        var6.invoke(var2, var8);
                    }
                }
            }
        }
    }


    private void GuiOverlayRender(ClientApi clientApi, GuiOverlayRender guiOverlayRender) {
        EntityPlayerSP entityPlayerSP = clientApi.minecraft().getPlayer();
        World world = clientApi.minecraft().getWorld();
        if (entityPlayerSP == null) return;
        if (world == null) {
            return;
        }
        this.modules.sort(this::lambda$null$2);
        this.drawTextWithRect("NullPointer 1.3 | vk.com/xenoceal", 2.0f, 26.0f, ColorUtil.BLUE_COLOR.getColor());
        int n = 1;
        Iterator<Module> iterator = this.modules.iterator();
        while (iterator.hasNext()) {
            Module module = iterator.next();
            this.drawTextWithRect(module.getName() + " [" + Keyboard.getKeyName((int)module.getKey()) + "]", 2.0f, 26.0f + 11.0f * (float)n, module.isEnabled() ? -16733696 : -43691);
            ++n;
        }
    }

    private int lambda$null$2(Module module, Module module2) {
        return Integer.compare(this.fontRenderer.getStringWidth(module2.getName() + " [" + Keyboard.getKeyName((int)module2.getKey()) + "]"), this.fontRenderer.getStringWidth(module.getName() + " [" + Keyboard.getKeyName((int)module.getKey()) + "]"));
    }

    private void KeyPress(ClientApi clientApi, KeyPress keyPress) {
        EntityPlayerSP entityPlayerSP = clientApi.minecraft().getPlayer();
        World world = clientApi.minecraft().getWorld();
        if (entityPlayerSP == null) return;
        if (world == null) {
            return;
        }
        if (clientApi.minecraft().currentScreen() != null) {
            return;
        }
        Iterator<Module> iterator = this.modules.iterator();
        while (iterator.hasNext()) {
            Module module = iterator.next();
            if (module.isEnabled()) {
                for (EventHandler eventHandler : module.getHandlers()) {
                    if (eventHandler.type() != EventType.KEY_PRESS) continue;
                    module.invoke((Event)keyPress, eventHandler);
                }
            }
            if (module.getKey() != keyPress.getKey()) continue;
            module.toggle();
        }
    }

    /*
     * Unable to fully structure code
     */
    private void GameLoop(ClientApi var1, GameLoop var2) {
        EntityPlayerSP var3 = var1.minecraft().getPlayer();
        World var4 = var1.minecraft().getWorld();
        if (var3 != null && var4 != null) {
            Iterator var5 = this.modules.iterator();

            while(true) {
                Module var6;
                do {
                    if (!var5.hasNext()) {
                        return;
                    }

                    var6 = (Module)var5.next();
                } while(!var6.isEnabled());

                Iterator var7 = var6.getHandlers().iterator();

                while(var7.hasNext()) {
                    EventHandler var8 = (EventHandler)var7.next();
                    if (var8.type() == EventType.GAME_LOOP) {
                        var6.invoke(var2, var8);
                    }
                }
            }
        }
    }

}
