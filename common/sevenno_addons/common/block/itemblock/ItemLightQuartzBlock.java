package sevenno_addons.common.block.itemblock;

import sevenno_addons.common.block.LightQuartzBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemLightQuartzBlock extends ItemBlock
{

	public ItemLightQuartzBlock(Block block)
	{
		super(block);
		this.setHasSubtypes(true);
	}
	public int getMetadata(int metadata)
	{
		return metadata;
	}
	public String getUnlocalizedName(ItemStack stack)
	{
		int metadata = stack.getItemDamage();
		if(metadata > LightQuartzBlock.type_a.length || metadata < 0)
		{
			metadata = 0;
		}
		return super.getUnlocalizedName() + "." + LightQuartzBlock.type_a[metadata];
	}
}
