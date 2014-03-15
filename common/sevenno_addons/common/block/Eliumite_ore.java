package sevenno_addons.common.block;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class Eliumite_ore extends Block
{
	public Eliumite_ore() 
	{
		super(Material.rock);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
		this.setHarvestLevel("pickaxe", 3);
	}
}