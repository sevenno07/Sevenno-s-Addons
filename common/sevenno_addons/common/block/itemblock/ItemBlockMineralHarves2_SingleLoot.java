package sevenno_addons.common.block.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import sevenno_addons.common.block.MineralHarves2_SingleLoot;

public class ItemBlockMineralHarves2_SingleLoot extends ItemBlock
{
	
	public ItemBlockMineralHarves2_SingleLoot(Block block)
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
		if(metadata < MineralHarves2_SingleLoot.type.length && metadata >= 0)
		{
			return super.getUnlocalizedName() + "." + MineralHarves2_SingleLoot.type[metadata];
		}
		else
		{
			return getUnlocalizedName();
		}
	}
}