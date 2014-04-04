package sevenno_addons.common.block;

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

public class ModWoodSlab extends BlockSlab
{
	public static final String[] StepTypes = new String[] {"cherry_planks", "ebony_planks"};
	
	private IIcon cherry_planks;
	private IIcon ebony_planks;

	public ModWoodSlab(boolean isdouble)
	{
		super(isdouble, Material.wood);
		if(!this.field_150004_a)
		{
			this.setLightOpacity(0);
		}
	}

	@SideOnly(Side.CLIENT)
	private static boolean isBlockSingleSlab(ModWoodSlab block)
	{
		return block.equals(SABlockList.ModStoneSlab);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
	{
		return isBlockSingleSlab(this) ? new ItemStack(this) : new ItemStack(SABlockList.ModStoneDoubleSlab);
	}

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune)
	{
		return Item.getItemFromBlock(SABlockList.ModStoneSlab);
	}

	@Override
	protected ItemStack createStackedBlock(int metadata)
	{
		return new ItemStack(SABlockList.ModStoneSlab, 2, metadata & 7);
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
		if(!item.equals(Item.getItemFromBlock(SABlockList.ModStoneDoubleSlab)))
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
		if (metadata == 0)
		{
			return metadata == 0 ? this.cherry_planks : this.cherry_planks;
		}
		
		if (metadata == 1)
		{
			return metadata == 1 ? this.ebony_planks : this.ebony_planks;
		}
		return blockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister)
	{
		this.cherry_planks = iconregister.registerIcon("sevenno_addons:planks_cherry");
		this.ebony_planks = iconregister.registerIcon("sevenno_addons:planks_ebony");
	}
}