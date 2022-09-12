package gliese832c.circulatorySystem.systems;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class SystemType {

    public String key;
    public String chatInfoMessage;
    public boolean dieOn100Percent;
    public String customDeathMessage;
    public ResourceLocation resourceLocation;
    public ArrayList<EffectInfo> potionEffectData;

    public SystemType(String key, String chatInfoMessage, boolean dieOn100Percent, @Nullable String customDeathMessage, ResourceLocation resourceLocation, ArrayList<EffectInfo> potionEffectData) {
        this.key = key;
        this.chatInfoMessage = chatInfoMessage;
        this.dieOn100Percent = dieOn100Percent;
        this.customDeathMessage = customDeathMessage;
        this.resourceLocation = resourceLocation;
        this.potionEffectData = potionEffectData;
    }

    public String getName() {
        return I18n.translateToLocal(chatInfoMessage);
    }
}