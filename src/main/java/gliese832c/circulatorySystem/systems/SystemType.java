package gliese832c.circulatorySystem.systems;

import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;

public class SystemType {

    public String key;
    public String chatInfoMessage;
    public boolean dieOn100Percent;
    public ResourceLocation resourceLocation;
    public ArrayList<PotionEffect> potionEffects;

    public SystemType(String key, String chatInfoMessage, boolean dieOn100Percent, ResourceLocation resourceLocation, ArrayList<PotionEffect> potionEffects) {
        this.key = key;
        this.chatInfoMessage = chatInfoMessage;
        this.dieOn100Percent = dieOn100Percent;
        this.resourceLocation = resourceLocation;
        this.potionEffects = potionEffects;
    }
}