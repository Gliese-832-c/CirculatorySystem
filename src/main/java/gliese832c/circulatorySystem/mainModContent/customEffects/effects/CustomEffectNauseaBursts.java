package gliese832c.circulatorySystem.mainModContent.customEffects.effects;

import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;

import java.util.Objects;

public class CustomEffectNauseaBursts extends CirculatoryCustomEffect {
    public CustomEffectNauseaBursts(String name) {
        super(name);
    }

    @Override
    public void applyEffect(EntityPlayer player, int level) {
        if (Math.random() > 1 - (0.00001) * level) {
            int duration = 300 + (level * 100);
            player.addPotionEffect(new PotionEffect(Objects.requireNonNull(Potion.getPotionFromResourceLocation("minecraft:nausea")), duration, 0, true, false));
            player.sendMessage(new TextComponentString("§c" + I18n.translateToLocal("chat.circulatorysystem.nausea_burst")));
        }
    }

    @Override
    public void notApplyingEffect(EntityPlayer player) {

    }



    public static void causeNauseaBurst(EntityPlayer player) {
        int level = 4;
        int duration = 300 + (level * 100);
        player.addPotionEffect(new PotionEffect(Objects.requireNonNull(Potion.getPotionFromResourceLocation("minecraft:nausea")), duration, 0, true, false));
        player.sendMessage(new TextComponentString("§c" + I18n.translateToLocal("chat.circulatorysystem.nausea_burst")));
    }

    public static void causeNauseaBurst(EntityPlayer player, int level) {
        int duration = 300 + (level * 100);
        player.addPotionEffect(new PotionEffect(Objects.requireNonNull(Potion.getPotionFromResourceLocation("minecraft:nausea")), duration, 0, true, false));
        player.sendMessage(new TextComponentString("§c" + I18n.translateToLocal("chat.circulatorysystem.nausea_burst")));
    }
}
