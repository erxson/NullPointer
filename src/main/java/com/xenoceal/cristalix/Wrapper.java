/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  dev.xdark.clientapi.entity.Entity
 *  dev.xdark.clientapi.entity.EntityPlayer
 *  dev.xdark.clientapi.entity.EntityPlayerSP
 *  dev.xdark.clientapi.game.Minecraft
 *  dev.xdark.clientapi.inventory.Container
 *  dev.xdark.clientapi.inventory.Inventory
 *  dev.xdark.clientapi.math.AxisAlignedBB
 *  dev.xdark.clientapi.math.BlockPos
 *  dev.xdark.clientapi.render.Tessellator
 *  dev.xdark.clientapi.texture.DynamicTexture
 *  dev.xdark.clientapi.util.EnumFacing
 *  dev.xdark.clientapi.util.EnumHand
 */
package com.xenoceal.cristalix;

import com.xenoceal.cristalix.Reflection;
import dev.xdark.clientapi.entity.Entity;
import dev.xdark.clientapi.entity.EntityPlayer;
import dev.xdark.clientapi.entity.EntityPlayerSP;
import dev.xdark.clientapi.game.Minecraft;
import dev.xdark.clientapi.inventory.Container;
import dev.xdark.clientapi.inventory.Inventory;
import dev.xdark.clientapi.math.AxisAlignedBB;
import dev.xdark.clientapi.math.BlockPos;
import dev.xdark.clientapi.render.Tessellator;
import dev.xdark.clientapi.texture.DynamicTexture;
import dev.xdark.clientapi.util.EnumFacing;
import dev.xdark.clientapi.util.EnumHand;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Set;

public final class Wrapper {
    public static Object getMinecraft() {
        return Reflection.invoke("getMinecraft", new Object[0]);
    }

    public static Object getWorld() {
        return Reflection.invoke("getWorld", Wrapper.getMinecraft());
    }

    public static List<EntityPlayer> getPlayerEntities() {
        return (List)Reflection.invoke("getPlayerEntities", Wrapper.getWorld());
    }

    public static Object getClientConnection() {
        return Reflection.invoke("getClientConnection", Wrapper.getMinecraft());
    }

    public static void sendPacket(Object object) {
        Reflection.invoke("sendPacket", Wrapper.getClientConnection(), object);
    }

    public static void attackEntity(EntityPlayer entityPlayer, Entity entity) {
        Reflection.invoke("attackEntity", new Object[]{((Minecraft)Wrapper.getMinecraft()).getPlayerController(), entityPlayer, entity});
    }

    public static float getFallDistance(Entity entity) {
        return ((Float)Reflection.invoke("getFallDistance", new Object[]{entity})).floatValue();
    }

    public static Object CPacketPlayer(boolean bl) {
        return Reflection.invoke("CPacketPlayer", bl);
    }

    public static int xorInt(int n) {
        return (Integer)Reflection.invoke("xorInt", n);
    }

    public static int xor() {
        return (Integer)Reflection.invoke("xor", new Object[0]);
    }

    public static void setOnGround(Entity entity, boolean bl) {
        Reflection.invoke("setOnGround", new Object[]{entity, Wrapper.xorInt((bl ? 1 : 0) ^ Wrapper.xor())});
    }

    public static void setJumpMovementFactor(Entity entity, float f) {
        Reflection.invoke("setJumpMovementFactor", new Object[]{entity, Wrapper.xorInt(Float.floatToRawIntBits(f) ^ Wrapper.xor())});
    }

    public static double getStaticPlayerX() {
        return (Double)Reflection.invoke("getStaticPlayerX", new Object[0]);
    }

    public static double getStaticPlayerY() {
        return (Double)Reflection.invoke("getStaticPlayerY", new Object[0]);
    }

    public static double getStaticPlayerZ() {
        return (Double)Reflection.invoke("getStaticPlayerZ", new Object[0]);
    }

    public static void drawOutlinedBB(Tessellator tessellator, AxisAlignedBB axisAlignedBB, float f, float f2, float f3, float f4) {
        Reflection.invoke("drawOutlinedBB", new Object[]{tessellator, axisAlignedBB, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
    }

    public static void drawFilledBB(Tessellator tessellator, AxisAlignedBB axisAlignedBB, float f, float f2, float f3, float f4) {
        Reflection.invoke("drawFilledBB", new Object[]{tessellator, axisAlignedBB, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)});
    }

    public static void swingArm(EntityPlayerSP entityPlayerSP, EnumHand enumHand) {
        Reflection.invoke("swingArm", new Object[]{entityPlayerSP, enumHand});
    }

    public static Inventory getLowerChestInventory(Container container) {
        return (Inventory)Reflection.invoke("getLowerChestInventory", new Object[]{container});
    }

    public static DynamicTexture DynamicTexture(BufferedImage bufferedImage) {
        return (DynamicTexture)Reflection.invoke("DynamicTexture", bufferedImage);
    }

    public static Object getMovementInput(EntityPlayerSP entityPlayerSP) {
        return Reflection.invoke("getMovementInput", new Object[]{entityPlayerSP});
    }

    public static float getMoveStrafe(EntityPlayerSP entityPlayerSP) {
        return Float.intBitsToFloat(Wrapper.xorInt((Integer)Reflection.invoke("getMoveStrafe", Wrapper.getMovementInput(entityPlayerSP)) ^ Wrapper.xor()));
    }

    public static float getMoveForward(EntityPlayerSP entityPlayerSP) {
        return Float.intBitsToFloat(Wrapper.xorInt((Integer)Reflection.invoke("getMoveForward", Wrapper.getMovementInput(entityPlayerSP)) ^ Wrapper.xor()));
    }

    public static Set<?> getTileEntities() {
        return (Set)Reflection.invoke("getTileEntities", Wrapper.getWorld());
    }

    public static BlockPos getTileEntityBlockPos(Object object) {
        return (BlockPos)Reflection.invoke("getTileEntityBlockPos", object);
    }

    public static void setCurBlockDamageMP(float f) {
        Reflection.invoke("setCurBlockDamageMP", new Object[]{((Minecraft)Wrapper.getMinecraft()).getPlayerController(), Wrapper.xorInt(Float.floatToRawIntBits(f) ^ Wrapper.xor())});
    }

    public static void setBlockHitDelay(int n) {
        Reflection.invoke("setBlockHitDelay", new Object[]{((Minecraft)Wrapper.getMinecraft()).getPlayerController(), Wrapper.xorInt(n ^ Wrapper.xor())});
    }

    public static double getRenderPosX() {
        return (Double)Reflection.invoke("getRenderPosX", new Object[]{((Minecraft)Wrapper.getMinecraft()).getEntityRenderManager()});
    }

    public static double getRenderPosY() {
        return (Double)Reflection.invoke("getRenderPosY", new Object[]{((Minecraft)Wrapper.getMinecraft()).getEntityRenderManager()});
    }

    public static double getRenderPosZ() {
        return (Double)Reflection.invoke("getRenderPosZ", new Object[]{((Minecraft)Wrapper.getMinecraft()).getEntityRenderManager()});
    }

    public static Set<?> getLoadedEntities() {
        return (Set)Reflection.invoke("getLoadedEntities", Wrapper.getWorld());
    }

    public static Object CPacketPlayerDigging(Object object, BlockPos blockPos, EnumFacing enumFacing) {
        return Reflection.invoke("CPacketPlayerDigging", new Object[]{object, blockPos, enumFacing});
    }

    public static Object START_DESTROY_BLOCK() {
        return Reflection.invoke("START_DESTROY_BLOCK", new Object[0]);
    }

    public static Object STOP_DESTROY_BLOCK() {
        return Reflection.invoke("STOP_DESTROY_BLOCK", new Object[0]);
    }

    public static double getDistanceToEntity(Entity entity, Entity entity2) {
        double d = entity.getX() - entity2.getX();
        double d2 = entity.getY() - entity2.getY();
        double d3 = entity.getZ() - entity2.getZ();
        return Math.sqrt(d * d + d2 * d2 + d3 * d3);
    }

    private Wrapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

