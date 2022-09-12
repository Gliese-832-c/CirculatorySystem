package gliese832c.circulatorySystem.systems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;

public class DamageSourceCirculatory extends DamageSource {

    public SystemType systemType;

    public DamageSourceCirculatory(String damageTypeIn, SystemType systemType) {
        super(damageTypeIn);
        this.systemType = systemType;
    }

    @Override
    public ITextComponent getDeathMessage(EntityLivingBase entityLivingBaseIn) {
        EntityLivingBase entitylivingbase = entityLivingBaseIn.getAttackingEntity();
        String s = "death." + this.damageType;
        String s1 = s + ".player";

        if (systemType.customDeathMessage == null) {
            if (entitylivingbase != null && I18n.canTranslate(s1)) {
                return new TextComponentTranslation(s1, entityLivingBaseIn.getDisplayName(), entitylivingbase.getDisplayName(), systemType.getName());
            } else {
                return new TextComponentTranslation(s, entityLivingBaseIn.getDisplayName(), systemType.getName());
            }
        } else {
            if (entitylivingbase != null && I18n.canTranslate(s1)) {
                return new TextComponentTranslation(systemType.customDeathMessage, entityLivingBaseIn.getDisplayName(), entitylivingbase.getDisplayName());
            } else {
                return new TextComponentTranslation(systemType.customDeathMessage, entityLivingBaseIn.getDisplayName());
            }
        }
    }
}
