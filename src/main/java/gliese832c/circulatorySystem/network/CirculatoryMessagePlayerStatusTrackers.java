package gliese832c.circulatorySystem.network;

import gliese832c.circulatorySystem.proxy.ClientProxy;
import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CirculatoryMessagePlayerStatusTrackers implements IMessage {

    public CirculatoryMessagePlayerStatusTrackers(){}

    private NBTTagCompound playerStatusTrackers;
    public CirculatoryMessagePlayerStatusTrackers(NBTTagCompound playerStatusTrackers) {
        this.playerStatusTrackers = playerStatusTrackers;
    }

    @Override public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, playerStatusTrackers);
    }

    @Override public void fromBytes(ByteBuf buf) {
        playerStatusTrackers = ByteBufUtils.readTag(buf);
    }



    public static class CirculatoryMessagePlayerStatusTrackersHandler implements IMessageHandler<CirculatoryMessagePlayerStatusTrackers, IMessage> {

        @Override
        public IMessage onMessage(CirculatoryMessagePlayerStatusTrackers message, MessageContext ctx) {
            ClientProxy.clientProxyData.playerStatusTrackers = message.playerStatusTrackers;
            return null;
        }
    }
}