package gliese832c.circulatorySystem.network;

import gliese832c.circulatorySystem.proxy.ClientProxy;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CirculatoryMessageTunnelVisionBurst implements IMessage {

    public CirculatoryMessageTunnelVisionBurst(){}

    private boolean tunnelVisionBurst;
    private int tunnelVisionBurstLevel;
    public CirculatoryMessageTunnelVisionBurst(boolean tunnelVisionBurst, int tunnelVisionBurstLevel) {
        this.tunnelVisionBurst = tunnelVisionBurst;
        this.tunnelVisionBurstLevel = tunnelVisionBurstLevel;
    }

    @Override public void toBytes(ByteBuf buf) {
        buf.writeBoolean(tunnelVisionBurst);
        buf.writeInt(tunnelVisionBurstLevel);
    }

    @Override public void fromBytes(ByteBuf buf) {
        tunnelVisionBurst = buf.readBoolean();
        tunnelVisionBurstLevel = buf.readInt();
    }



    public static class CirculatoryMessageTunnelVisionBurstHandler implements IMessageHandler<CirculatoryMessageTunnelVisionBurst, IMessage> {

        @Override
        public IMessage onMessage(CirculatoryMessageTunnelVisionBurst message, MessageContext ctx) {

            boolean tunnelVisionBurst = message.tunnelVisionBurst;
            int tunnelVisionBurstLevel = message.tunnelVisionBurstLevel;

            ClientProxy.clientProxyData.isHavingTunnelVisionBurst = tunnelVisionBurst;
            ClientProxy.clientProxyData.tunnelVisionBurstLevel = tunnelVisionBurstLevel;

            return null;
        }
    }
}