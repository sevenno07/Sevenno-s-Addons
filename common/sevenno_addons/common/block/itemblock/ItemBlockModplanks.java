package sevenno_addons.common.block.itemblock;

import sevenno_addons.common.block.Modplanks;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockModplanks extends ItemBlock
{
	
	public ItemBlockModplanks(Block block)
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
		if(metadata < Modplanks.woodes_types.length && metadata >= 0)
		{
			return super.getUnlocalizedName() + "." + Modplanks.woodes_types[metadata];
		}
		else
		{
			return getUnlocalizedName();
		}
	}
}