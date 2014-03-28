package sevenno_addons.common.block;

import java.util.Random;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class DStone extends Block
{
	public DStone() 
	{
		super(Material.rock);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}
	
	public Item getItemDropped(int par1, Random par2Random, int par3)
    {
		return Item.getItemFromBlock(SABlockList.DCobblestone);
    }
}