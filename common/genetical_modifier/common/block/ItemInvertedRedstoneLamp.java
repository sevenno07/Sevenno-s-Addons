package genetical_modifier.common.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemInvertedRedstoneLamp extends ItemBlock
{
	public ItemInvertedRedstoneLamp(Block block)
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
		if(metadata > InvertedRedstoneLamp.type.length || metadata < 0)
		{
			metadata = 0;
		}
		return super.getUnlocalizedName() + "." + InvertedRedstoneLamp.type[metadata];
	}
}