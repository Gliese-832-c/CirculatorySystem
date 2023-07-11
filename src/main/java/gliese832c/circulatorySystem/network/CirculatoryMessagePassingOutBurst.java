package gliese832c.circulatorySystem.network;

import gliese832c.circulatorySystem.proxy.ClientProxy;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CirculatoryMessagePassingOutBurst implements IMessage {

    public CirculatoryMessagePassingOutBurst(){}

    private boolean passedOut;
    public CirculatoryMessagePassingOutBurst(boolean passedOut) {
        this.passedOut = passedOut;
    }

    @Override public void toBytes(ByteBuf buf) {
        buf.writeBoolean(passedOut);
    }

    @Override public void fromBytes(ByteBuf buf) {
        passedOut = buf.readBoolean();
    }



    public static class CirculatoryMessagePassingOutBurstHandler implements IMessageHandler<CirculatoryMessagePassingOutBurst, IMessage> {

        @Override
        public IMessage onMessage(CirculatoryMessagePassingOutBurst message, MessageContext ctx) {

            boolean passedOut = message.passedOut;

            ClientProxy.clientProxyData.isPassedOut = passedOut;

            return null;
        }
    }
}