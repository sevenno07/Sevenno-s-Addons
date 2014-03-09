package sevenno_addons.common.block;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class StrangePlank extends Block
{
	public StrangePlank() 
	{
		super(Material.wood);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}
}