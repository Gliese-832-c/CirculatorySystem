package gliese832c.circulatorySystem.network;

import gliese832c.circulatorySystem.proxy.ClientProxy;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CirculatoryMessageTunnelVision implements IMessage {

    public CirculatoryMessageTunnelVision(){}

    private boolean tunnelVision;
    private int tunnelVisionLevel;
    public CirculatoryMessageTunnelVision(boolean tunnelVision, int tunnelVisionLevel) {
        this.tunnelVision = tunnelVision;
        this.tunnelVisionLevel = tunnelVisionLevel;
    }

    @Override public void toBytes(ByteBuf buf) {
        buf.writeBoolean(tunnelVision);
        buf.writeInt(tunnelVisionLevel);
    }

    @Override public void fromBytes(ByteBuf buf) {
        tunnelVision = buf.readBoolean();
        tunnelVisionLevel = buf.readInt();
    }



    public static class CirculatoryMessageTunnelVisionHandler implements IMessageHandler<CirculatoryMessageTunnelVision, IMessage> {

        @Override
        public IMessage onMessage(CirculatoryMessageTunnelVision message, MessageContext ctx) {

            boolean tunnelVision = message.tunnelVision;
            int tunnelVisionLevel = message.tunnelVisionLevel;

            ClientProxy.clientProxyData.isHavingTunnelVision = tunnelVision;
            ClientProxy.clientProxyData.tunnelVisionLevel = tunnelVisionLevel;

            /*if (player != null) player.sendMessage(new TextComponentString("Is having tunnel vision: " + tunnelVision + ";   Level: " + tunnelVisionLevel));

            //serverPlayer.getServerWorld().addScheduledTask(() -> {
            //    serverPlayer.inventory.addItemStackToInventory(new ItemStack(Items.DIAMOND, amount));
            //});*/

            return null;
        }
    }
}