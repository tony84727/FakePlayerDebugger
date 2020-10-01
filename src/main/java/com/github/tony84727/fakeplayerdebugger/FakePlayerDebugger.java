package com.github.tony84727.fakeplayerdebugger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(name = FakePlayerDebugger.NAME, version = FakePlayerDebugger.VERSION, modid = FakePlayerDebugger.MOD_ID)
public class FakePlayerDebugger {
    public static final String NAME = "Fake Player Debugger";
    public static final String VERSION = "1.0.0";
    public static final String MOD_ID = "fakeplayerdebugger";

    @Mod.EventHandler
    public static void init(FMLInitializationEvent e) {
        final Listener listener = new Listener();
        MinecraftForge.EVENT_BUS.register(listener);
    }
}
