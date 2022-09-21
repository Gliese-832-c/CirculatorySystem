package gliese832c.circulatorySystem.gui;

import gliese832c.circulatorySystem.network.*;
import gliese832c.circulatorySystem.util.CirculatoryLogger;
import gliese832c.circulatorySystem.util.NBTHandler;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventPlayerStatusTrackers {

    @SubscribeEvent
    public void networkPacketEvent(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.player instanceof EntityPlayerMP) {
            NBTTagCompound playerStatusTrackers = NBTHandler.getNBTall(event.player);
            CirculatoryPacketHandler.CIRCULATORY_NETWORK_WRAPPER.sendTo(new CirculatoryMessagePlayerStatusTrackers(playerStatusTrackers), (EntityPlayerMP) event.player);
        }
    }
}