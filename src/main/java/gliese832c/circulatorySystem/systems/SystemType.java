package gliese832c.circulatorySystem.systems;

import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

import java.util.ArrayList;

public class SystemType {

    public String key;
    public String chatInfoMessage;
    public boolean dieOn100Percent;
    public ResourceLocation resourceLocation;
    public ArrayList<PotionEffectInfo> potionEffectData;

    public SystemType(String key, String chatInfoMessage, boolean dieOn100Percent, ResourceLocation resourceLocation, ArrayList<PotionEffectInfo> potionEffectData) {
        this.key = key;
        this.chatInfoMessage = chatInfoMessage;
        this.dieOn100Percent = dieOn100Percent;
        this.resourceLocation = resourceLocation;
        this.potionEffectData = potionEffectData;
    }

    public String getName() {
        return I18n.translateToLocal(chatInfoMessage);
    }
}