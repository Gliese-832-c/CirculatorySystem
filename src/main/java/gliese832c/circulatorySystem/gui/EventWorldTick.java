package gliese832c.circulatorySystem.gui;

import gliese832c.circulatorySystem.proxy.ClientProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import static gliese832c.circulatorySystem.systems.NBTHandler.getNBTall;

public class EventWorldTick {

    @SubscribeEvent
    public void WorldTickEvent(TickEvent.WorldTickEvent event) {
        // // Only run during end phase (post-vanilla)
        // if (event.phase != TickEvent.Phase.END)
        //     return;

        for (EntityPlayer player : event.world.playerEntities) {
            NBTTagCompound data = getNBTall(player);
            ClientProxy.data = data;
        }
    }
}