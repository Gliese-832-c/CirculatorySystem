package gliese832c.circulatorySystem.network;

import gliese832c.circulatorySystem.proxy.ClientProxy;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CirculatoryMessageHeartAttack implements IMessage {

    public CirculatoryMessageHeartAttack(){}

    private boolean heartAttack;
    private int heartAttackLevel;
    public CirculatoryMessageHeartAttack(boolean heartAttack, int heartAttackLevel) {
        this.heartAttack = heartAttack;
        this.heartAttackLevel = heartAttackLevel;
    }

    @Override public void toBytes(ByteBuf buf) {
        buf.writeBoolean(heartAttack);
        buf.writeInt(heartAttackLevel);
    }

    @Override public void fromBytes(ByteBuf buf) {
        heartAttack = buf.readBoolean();
        heartAttackLevel = buf.readInt();
    }



    public static class CirculatoryMessageHeartAttackHandler implements IMessageHandler<CirculatoryMessageHeartAttack, IMessage> {

        @Override
        public IMessage onMessage(CirculatoryMessageHeartAttack message, MessageContext ctx) {

            boolean heartAttack = message.heartAttack;
            int heartAttackLevel = message.heartAttackLevel;

            ClientProxy.clientProxyData.heartAttack = heartAttack;
            ClientProxy.clientProxyData.heartAttackLevel = heartAttackLevel;

            return null;
        }
    }
}