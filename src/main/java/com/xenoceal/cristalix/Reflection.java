package com.xenoceal.cristalix;

import com.xenoceal.cristalix.utility.SneakyThrow;
import com.xenoceal.cristalix.utility.UnsafeUtil;
import java.awt.image.BufferedImage;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import sun.misc.Unsafe;

public final class Reflection {
    private static final MethodHandles.Lookup LOOKUP;
    private static final MethodHandle MH_CLASS_FN;
    private static final Map classes = new HashMap();
    private static final Map handles = new HashMap();

    public static void initialize() {
        try {
            addClass("Minecraft", "dQ");
            addClass("World", "adL"); 
            addClass("ClientConnection", "yq");
            addClass("Packet", "VV");
            addClass("Entity", "Nx");
            addClass("EntityPlayer", "QR");
            addClass("PlayerControllerMP", "yf");
            addClass("CPacketPlayer", "Xa");
            addClass("EntityLivingBase", "NR");
            addClass("TileEntityRendererDispatcher", "FK");
            addClass("RenderGlobal", "BW"); 
            addClass("Tessellator", "Cg");
            addClass("AxisAlignedBB", "acw");
            addClass("EntityPlayerSP", "tv");
            addClass("EnumHand", "abx");
            addClass("GuiChest", "vE");
            addClass("Inventory", "Sg");
            addClass("ContainerChest", "RH");
            addClass("DynamicTexture", "Hg");
            addClass("MovementInput", "abX");
            addClass("TileEntity", "aag");
            addClass("TileEntityChest", "aan");
            addClass("TileEntityEnderChest", "aaz");
            addClass("BlockPos", "acg");
            addClass("RenderManager", "FK");
            addClass("CPacketPlayerDigging", "Xi");
            addClass("Action", "Xg");
            addClass("EnumFacing", "abs");
            addHandle("getMinecraft", LOOKUP.findStatic(getClass("Minecraft"), "a", MethodType.methodType(getClass("Minecraft"))));
            addHandle("getWorld", LOOKUP.findGetter(getClass("Minecraft"), "j", Object.class));
            addHandle("getPlayerEntities", LOOKUP.findGetter(getClass("World"), "cB", Object.class));
            addHandle("getClientConnection", LOOKUP.findVirtual(getClass("Minecraft"), "a", MethodType.methodType(getClass("ClientConnection"))));
            addHandle("sendPacket", LOOKUP.findVirtual(getClass("ClientConnection"), "a", MethodType.methodType(Void.TYPE, getClass("Packet"))));
            addHandle("attackEntity", LOOKUP.findVirtual(getClass("PlayerControllerMP"), "a", MethodType.methodType(Void.TYPE, getClass("EntityPlayer"), getClass("Entity"))));
            addHandle("getFallDistance", LOOKUP.findGetter(getClass("Entity"), "ev", Float.TYPE));
            addHandle("CPacketPlayer", LOOKUP.findConstructor(getClass("CPacketPlayer"), MethodType.methodType(Void.TYPE, Boolean.TYPE)));
            addHandle("xorInt", LOOKUP.findStatic(findClass("auXX"), "a", MethodType.methodType(Integer.TYPE, Integer.TYPE)));
            addHandle("xor", LOOKUP.findStaticGetter(findClass("auXX"), "a", Integer.TYPE));
            addHandle("setOnGround", LOOKUP.findSetter(getClass("Entity"), "a", Integer.TYPE));
            addHandle("setJumpMovementFactor", LOOKUP.findSetter(getClass("EntityLivingBase"), "eL", Integer.TYPE));
            addHandle("getStaticPlayerX", LOOKUP.findStaticGetter(getClass("TileEntityRendererDispatcher"), "bb", Double.TYPE));
            addHandle("getStaticPlayerY", LOOKUP.findStaticGetter(getClass("TileEntityRendererDispatcher"), "bc", Double.TYPE));
            addHandle("getStaticPlayerZ", LOOKUP.findStaticGetter(getClass("TileEntityRendererDispatcher"), "bd", Double.TYPE));
            addHandle("drawOutlinedBB", LOOKUP.findStatic(getClass("RenderGlobal"), "a", MethodType.methodType(Void.TYPE, getClass("Tessellator"), getClass("AxisAlignedBB"), Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE)));
            addHandle("drawFilledBB", LOOKUP.findStatic(getClass("RenderGlobal"), "b", MethodType.methodType(Void.TYPE, getClass("Tessellator"), getClass("AxisAlignedBB"), Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE)));
            addHandle("swingArm", LOOKUP.findVirtual(getClass("EntityPlayerSP"), "b", MethodType.methodType(Void.TYPE, getClass("EnumHand"))));
            addHandle("getLowerChestInventory", LOOKUP.findGetter(getClass("ContainerChest"), "f", getClass("Inventory")));
            addHandle("DynamicTexture", LOOKUP.findConstructor(getClass("DynamicTexture"), MethodType.methodType(Void.TYPE, BufferedImage.class)));
            addHandle("getMovementInput", LOOKUP.findGetter(getClass("EntityPlayerSP"), "d", Object.class));
            addHandle("getMoveStrafe", LOOKUP.findGetter(getClass("MovementInput"), "gS", Integer.TYPE));
            addHandle("getMoveForward", LOOKUP.findGetter(getClass("MovementInput"), "K", Integer.TYPE));
            addHandle("getTileEntities", LOOKUP.findGetter(getClass("World"), "W", Object.class));
            addHandle("getTileEntityBlockPos", LOOKUP.findVirtual(getClass("TileEntity"), "f", MethodType.methodType(getClass("BlockPos"))));
            addHandle("setCurBlockDamageMP", LOOKUP.findSetter(getClass("PlayerControllerMP"), "ce", Integer.TYPE));
            addHandle("setBlockHitDelay", LOOKUP.findSetter(getClass("PlayerControllerMP"), "a", Integer.TYPE));
            addHandle("getRenderPosX", LOOKUP.unreflectGetter(getField(getClass("RenderManager"), "aT", Double.TYPE)));
            addHandle("getRenderPosY", LOOKUP.unreflectGetter(getField(getClass("RenderManager"), "aU", Double.TYPE)));
            addHandle("getRenderPosZ", LOOKUP.unreflectGetter(getField(getClass("RenderManager"), "aV", Double.TYPE)));
            addHandle("getLoadedEntities", LOOKUP.findGetter(getClass("World"), "V", Object.class));
            addHandle("CPacketPlayerDigging", LOOKUP.findConstructor(getClass("CPacketPlayerDigging"), MethodType.methodType(Void.TYPE, getClass("Action"), getClass("BlockPos"), getClass("EnumFacing"))));
            addHandle("START_DESTROY_BLOCK", LOOKUP.findStaticGetter(getClass("Action"), "START_DESTROY_BLOCK", getClass("Action")));
            addHandle("STOP_DESTROY_BLOCK", LOOKUP.findStaticGetter(getClass("Action"), "STOP_DESTROY_BLOCK", getClass("Action")));
        } catch (Throwable var1) {
            throw SneakyThrow.sneaky(var1);
        }
    }

    public static Object invoke(String var0, Object... var1) {
        try {
            MethodHandle var2 = (MethodHandle)handles.get(var0);
            return var2.invokeWithArguments(var1);
        } catch (Throwable var3) {
            throw SneakyThrow.sneaky(var3);
        }
    }

    private static Class findClass(String var0) {
        try {
            return (Class) MH_CLASS_FN.invoke(var0, true, ClassLoader.getSystemClassLoader());
        } catch (Throwable var2) {
            throw SneakyThrow.sneaky(var2);
        }
    }

    public static Class getClass(String var0) {
        return (Class) classes.get(var0);
    }

    private static void addClass(String var0, String var1) {
        try {
            classes.put(var0, findClass(var1));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static void addHandle(String var0, MethodHandle var1) {
        handles.put(var0, var1);
    }

    private static Field getField(Class var0, String var1, Class var2) {
        Field var3 = null;
        Field[] var4 = var0.getDeclaredFields();
        int var5 = var4.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Field var7 = var4[var6];
            if (var7.getName().equals(var1) && var7.getType() == var2) {
                var3 = var7;
                break;
            }
        }

        if (var3 != null) {
            var3.setAccessible(true);
        }

        return var3;
    }

    private Reflection() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    static {
        try {
            Unsafe var0 = UnsafeUtil.get();
            Field var1 = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
            var1.setAccessible(true);
            LOOKUP = (MethodHandles.Lookup)var0.getObject(var0.staticFieldBase(var1), var0.staticFieldOffset(var1));
            MH_CLASS_FN = LOOKUP.findStatic(Class.class, "forName", MethodType.methodType(Class.class, String.class, Boolean.TYPE, ClassLoader.class));
        } catch (Exception var2) {
            try {
                throw SneakyThrow.sneaky(var2);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }
}
