package gliese832c.circulatorySystem.mainModContent.customEffects.effects;

import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffect;
import gliese832c.circulatorySystem.mainModContent.customEffects.CirculatoryCustomEffectDataType;
import net.minecraft.entity.player.EntityPlayer;

import java.util.ArrayList;

public class CustomEffectPassingOutBursts extends CirculatoryCustomEffect {
    public CustomEffectPassingOutBursts(String name, ArrayList<CirculatoryCustomEffectDataType> dataTypes) {
        super(name);
        this.dataTypes = dataTypes;
    }

    @Override
    public void applyEffect(EntityPlayer player, int level) {
        // TODO
    }

    @Override
    public void notApplyingEffect(EntityPlayer player) {

    }
}
