package sevenno_addons.common.block;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class StrangePlank2 extends Block
{
	public StrangePlank2() 
	{
		super(Material.wood);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}
}