package com.github.tony84727.fakeplayerdebugger;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Listener {
    private static void broadcastMessage(MinecraftServer server, ITextComponent message) {
        final PlayerList players =  server.getPlayerList();
        players.sendMessage(message);
    }

    @SubscribeEvent
    public void onPlayerEvent(PlayerEvent e) {
        final EntityPlayer player = e.getEntityPlayer();
        if (player == null) {
            return;
        }
        final MinecraftServer server = player.getServer();
        if (server == null) {
            return;
        }
        broadcastMessage(server, new TextComponentString(player.getGameProfile().getName()));
    }
}
