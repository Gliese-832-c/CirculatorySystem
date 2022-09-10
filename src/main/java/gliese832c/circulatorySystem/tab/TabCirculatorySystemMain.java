package gliese832c.circulatorySystem.tab;

//import gliese832c.geology.block.GeologyBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class TabCirculatorySystemMain extends CreativeTabs
{
    public TabCirculatorySystemMain()
    {
        super("circulatory_system.main");
    }

    @Override
    public ItemStack createIcon()
    {
        //return new ItemStack(GeologyBlocks.rockVolcanic);
        return new ItemStack(Blocks.FLOWER_POT);
    }
}
