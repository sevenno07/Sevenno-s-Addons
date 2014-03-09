package sevenno_addons.common.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class StrangePlankWall extends BlockWall
{
	public StrangePlankWall(Block par2Block)
	{
		super(par2Block);
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativetabs, List list)
	{
		list.add(new ItemStack(item, 1, 0));
	}
	
	public IIcon getIcon(int par1, int par2)
	{
		return SABlockList.StrangePlank.getBlockTextureFromSide(par1);
	}
}