package gliese832c.circulatorySystem.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import static gliese832c.circulatorySystem.sound.CirculatorySounds.HEART_ATTACK;

public class CirculatoryMessageHeartAttackSound implements IMessage {

    public CirculatoryMessageHeartAttackSound() {}

    private int heartAttackLevel;
    public CirculatoryMessageHeartAttackSound(int heartAttackLevel) {
        this.heartAttackLevel = heartAttackLevel;
    }

    @Override public void toBytes(ByteBuf buf) {
        buf.writeInt(heartAttackLevel);
    }
    @Override public void fromBytes(ByteBuf buf) {
        heartAttackLevel = buf.readInt();
    }

    public static class CirculatoryMessageHeartAttackSoundHandler implements IMessageHandler<CirculatoryMessageHeartAttackSound, IMessage> {

        @Override
        public IMessage onMessage(CirculatoryMessageHeartAttackSound message, MessageContext ctx) {
            float volume = ((float) message.heartAttackLevel * 0.125f) + 0.5f;
            volume = Math.max(volume, 0.05f);
            volume = Math.min(volume, 1.0f);
            Minecraft.getMinecraft().world.playSound(Minecraft.getMinecraft().player, Minecraft.getMinecraft().player.getPosition(), HEART_ATTACK, SoundCategory.BLOCKS, volume, 1.0f);
            return null;
        }
    }
}