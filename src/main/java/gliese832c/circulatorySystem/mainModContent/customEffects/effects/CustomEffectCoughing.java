package gliese832c.circulatorySystem.mainModContent.customEffects.effects;

import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffect;
import gliese832c.circulatorySystem.sound.CirculatorySounds;
import gliese832c.circulatorySystem.util.CirculatoryLogger;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class CustomEffectCoughing extends CirculatoryCustomEffect {

    public CustomEffectCoughing(String name) {
        super(name);
    }

    @Override
    public void applyEffect(EntityPlayer player, int level) {
        if (Math.random() > (1.0d - (0.0002d * (double) level))) {
            player.getEntityWorld().playSound(null, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), CirculatorySounds.COUGHING, SoundCategory.PLAYERS, 0.5f, 1.0f);
            player.sendMessage(new TextComponentString(I18n.translateToLocal("chat.circulatorysystem.coughing")));
        }
    }

    @Override
    public void notApplyingEffect(EntityPlayer player) {
        // Nothing!
    }
}
