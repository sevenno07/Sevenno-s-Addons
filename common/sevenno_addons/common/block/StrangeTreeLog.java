package sevenno_addons.common.block;

import java.util.Random;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StrangeTreeLog extends BlockLog
{
	private IIcon topIcon;

	public StrangeTreeLog()
	{
		super();
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}

	public Item idDropped(int side, Random random, int par3)
	{
		return Item.getItemFromBlock(this);
	}
	
	public Item getItemDropped(int par1, Random par2Random, int par3)
    {
		return Item.getItemFromBlock(SABlockList.StrangeTreeLog_N);
    }
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("sevenno_addons:strangeLog");
		topIcon = iconregister.registerIcon("sevenno_addons:strangeLog_top");
	}

	public IIcon getIcon(int side, int metadata)
	{
		int k = metadata & 12;
		return k == 0 && (side == 1 || side == 0) ? topIcon : (k == 4 && (side == 5 || side == 4) ? topIcon : (k == 8 && (side == 2 || side == 3) ? topIcon : blockIcon));
	}
}