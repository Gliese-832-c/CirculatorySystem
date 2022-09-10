package gliese832c.circulatorySystem.block;

import gliese832c.circulatorySystem.tab.CirculatorySystemTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class CirculatorySystemBlock extends Block
{
	public CirculatorySystemBlock(Material material)
    {
        super(material);
        this.setCreativeTab(CirculatorySystemTabs.MAIN);
    }
}
