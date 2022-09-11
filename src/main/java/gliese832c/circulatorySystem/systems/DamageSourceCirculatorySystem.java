package gliese832c.circulatorySystem.systems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;

public class DamageSourceCirculatorySystem extends DamageSource {

    public SystemType systemType;

    public DamageSourceCirculatorySystem(String damageTypeIn, SystemType systemType) {
        super(damageTypeIn);
        this.systemType = systemType;
    }

    @Override
    public ITextComponent getDeathMessage(EntityLivingBase entityLivingBaseIn) {
        EntityLivingBase entitylivingbase = entityLivingBaseIn.getAttackingEntity();
        String s = "death." + this.damageType;
        String s1 = s + ".player";

        if (entitylivingbase != null && I18n.canTranslate(s1)) {
            return new TextComponentTranslation(s1, new Object[]{entityLivingBaseIn.getDisplayName(), entitylivingbase.getDisplayName(), systemType.getName()});
        } else {
            return new TextComponentTranslation(s, new Object[]{entityLivingBaseIn.getDisplayName(), systemType.getName()});
        }
    }
}
