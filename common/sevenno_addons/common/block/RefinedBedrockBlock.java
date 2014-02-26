package sevenno_addons.common.block;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RefinedBedrockBlock extends Block
{
	public RefinedBedrockBlock() 
	{
		super(Material.rock);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}
}