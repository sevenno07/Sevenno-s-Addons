package sevenno_addons.common.block.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import sevenno_addons.common.block.MineralHarves1_SingleLoot;

public class ItemBlockMineralHarves1_SingleLoot extends ItemBlock
{
	
	public ItemBlockMineralHarves1_SingleLoot(Block block)
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
		if(metadata < MineralHarves1_SingleLoot.type.length && metadata >= 0)
		{
			return super.getUnlocalizedName() + "." + MineralHarves1_SingleLoot.type[metadata];
		}
		else
		{
			return getUnlocalizedName();
		}
	}
}