package gliese832c.circulatorySystem.mainModContent.statusTrackers;

import gliese832c.circulatorySystem.mainModContent.statusTrackers.statusTrackersRegistry.StatusTracker;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;

public class DamageSourceCirculatory extends DamageSource {

    public StatusTracker statusTracker;

    public DamageSourceCirculatory(String damageTypeIn, StatusTracker statusTracker) {
        super(damageTypeIn);
        this.statusTracker = statusTracker;
    }

    @Override
    public ITextComponent getDeathMessage(EntityLivingBase entityLivingBaseIn) {
        EntityLivingBase entitylivingbase = entityLivingBaseIn.getAttackingEntity();
        String s = "death." + this.damageType;
        String s1 = s + ".player";

        if (statusTracker.customDeathMessage == null) {
            if (entitylivingbase != null && I18n.canTranslate(s1)) {
                return new TextComponentTranslation(s1, entityLivingBaseIn.getDisplayName(), entitylivingbase.getDisplayName(), statusTracker.getName());
            } else {
                return new TextComponentTranslation(s, entityLivingBaseIn.getDisplayName(), statusTracker.getName());
            }
        } else {
            if (entitylivingbase != null && I18n.canTranslate(s1)) {
                return new TextComponentTranslation(statusTracker.customDeathMessage, entityLivingBaseIn.getDisplayName(), entitylivingbase.getDisplayName());
            } else {
                return new TextComponentTranslation(statusTracker.customDeathMessage, entityLivingBaseIn.getDisplayName());
            }
        }
    }
}
