package sevenno_addons.common.block;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class ModStairs extends BlockStairs
{	
	public ModStairs(Block block, int metadata)
	{
        super(block, metadata);
        this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
        this.setLightOpacity(0);
    }
}