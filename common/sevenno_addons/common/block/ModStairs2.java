package sevenno_addons.common.block;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class ModStairs2 extends BlockStairs
{	
	public ModStairs2(Block block, int metadata)
	{
        super(block, metadata);
        this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
        this.setLightOpacity(0);
    }
}