package gliese832c.circulatorySystem.tab;

import gliese832c.circulatorySystem.item.CirculatoryItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabCirculatoryMain extends CreativeTabs
{
    public TabCirculatoryMain()
    {
        super("circulatory_system.main");
    }

    @Override
    public ItemStack createIcon()
    {
        return new ItemStack(CirculatoryItems.pill);
    }
}
