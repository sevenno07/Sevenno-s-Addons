package sevenno_addons.common.block.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import sevenno_addons.common.block.DGoldenSandstone;

public class ItemBlockDGoldenSandstone extends ItemBlock
{
	
	public ItemBlockDGoldenSandstone(Block block)
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
		if(metadata < DGoldenSandstone.type.length && metadata >= 0)
		{
			return super.getUnlocalizedName() + "." + DGoldenSandstone.type[metadata];
		}
		else
		{
			return getUnlocalizedName();
		}
	}
}
