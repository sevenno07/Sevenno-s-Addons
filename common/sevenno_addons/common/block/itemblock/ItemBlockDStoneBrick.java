package sevenno_addons.common.block.itemblock;

import sevenno_addons.common.block.DStoneBrick;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockDStoneBrick extends ItemBlock
{
	
	public ItemBlockDStoneBrick(Block block)
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
		if(metadata < DStoneBrick.type.length && metadata >= 0)
		{
			return super.getUnlocalizedName() + "." + DStoneBrick.type[metadata];
		}
		else
		{
			return getUnlocalizedName();
		}
	}
}
