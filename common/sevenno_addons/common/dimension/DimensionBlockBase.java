package sevenno_addons.common.dimension;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import sevenno_addons.common.block.SABlockList;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
 
public class DimensionBlockBase extends Block
{
	public DimensionBlockBase(Material material)
	{
		super(material);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}
       
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		if(this == SABlockList.DStone)
		{
			return Item.getItemFromBlock(SABlockList.DCobblestone);
		}
		if(this == SABlockList.DCobblestone)
		{
			return Item.getItemFromBlock(SABlockList.DCobblestone);
		}
		if(this == SABlockList.DGrass)
		{
			return Item.getItemFromBlock(SABlockList.DDirt);
		}
		if(this == SABlockList.DDirt)
		{
			return Item.getItemFromBlock(SABlockList.DDirt);
		}
		if(this == SABlockList.DGoldenSandstone)
		{
			return Item.getItemFromBlock(SABlockList.DGoldenSandstone);
		}
		return null;
	}
}
