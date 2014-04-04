package sevenno_addons.common.block.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import sevenno_addons.common.block.ModLogs;

public class ItemBlockModLogs extends ItemBlock
{
	
	public ItemBlockModLogs(Block block)
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
		if(metadata < ModLogs.types.length && metadata >= 0)
		{
			return super.getUnlocalizedName() + "." + ModLogs.types[metadata];
		}
		else
		{
			return getUnlocalizedName();
		}
	}
}