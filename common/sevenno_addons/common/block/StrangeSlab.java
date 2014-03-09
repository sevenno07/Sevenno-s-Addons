package sevenno_addons.common.block;

import java.util.List;
import java.util.Random;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StrangeSlab extends BlockSlab
{
	public static final String[] StepTypes = new String[] {"StrangePlank"};

	public StrangeSlab(boolean isdouble)
	{
		super(isdouble, Material.wood);
		if(!this.field_150004_a)
		{
			this.setLightOpacity(0);
		}
	}

	@SideOnly(Side.CLIENT)
	private static boolean isBlockSingleSlab(StrangeSlab block)
	{
		return block.equals(SABlockList.StrangePlankSlab);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
	{
		return isBlockSingleSlab(this) ? new ItemStack(this) : new ItemStack(SABlockList.StrangePlankDoubleSlab);
	}

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune)
	{
		return Item.getItemFromBlock(SABlockList.StrangePlankSlab);
	}

	@Override
	protected ItemStack createStackedBlock(int metadata)
	{
		return new ItemStack(SABlockList.StrangePlankSlab, 2, metadata & 7);
	}

	@Override
	public String func_150002_b(int metadata)
	{
		if(metadata < 0 || metadata >= StepTypes.length)
		{
			metadata = 0;
		}

		return super.getUnlocalizedName() + "." + StepTypes[metadata];
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
	{
		if(!item.equals(Item.getItemFromBlock(SABlockList.StrangePlankDoubleSlab)))
		{
			for(int i = 0; i < StepTypes.length; i++)
			{
				list.add(new ItemStack(item, 1, i));
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return SABlockList.StrangePlank.getBlockTextureFromSide(side);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iiconRegister)
	{
	}
}