package sevenno_addons.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;

public class DDirt extends Block
{
	public DDirt() 
	{
        super(Material.ground);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}
}