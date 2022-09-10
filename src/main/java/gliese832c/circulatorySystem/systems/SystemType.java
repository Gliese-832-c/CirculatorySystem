package gliese832c.circulatorySystem.systems;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class SystemType {

    public String key;
    public String chatInfoMessage;
    //public ItemStack item = new ItemStack(Items.APPLE);
    public ResourceLocation resourceLocation;

    public SystemType(String key, String chatInfoMessage, ResourceLocation resourceLocation) {
        this.key = key;
        this.chatInfoMessage = chatInfoMessage;
        this.resourceLocation = resourceLocation;
    }
}