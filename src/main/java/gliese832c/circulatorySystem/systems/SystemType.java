package gliese832c.circulatorySystem.systems;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class SystemType {

    public String key;
    public String chatInfoMessage;
    public int color;
    public ItemStack item = new ItemStack(Items.APPLE);

    public SystemType(String key, String chatInfoMessage, int color) {
        this.key = key;
        this.chatInfoMessage = chatInfoMessage;
        this.color = color;
    }
}