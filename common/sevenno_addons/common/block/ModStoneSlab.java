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

public class ModStoneSlab extends BlockSlab
{
	public static final String[] StepTypes = new String[] {"DCobblestone", "DStoneBrick1", "DStoneBrick2", "DStoneBrick3", "DStoneBrick4", "DGoldenSandstone1", "DGoldenSandstone2"};
	
	private IIcon DCobblestone;
	private IIcon DStoneBrick1;
	private IIcon DStoneBrick2;
	private IIcon DStoneBrick3;
	private IIcon DStoneBrick4;

	private IIcon DGoldenSandstone_top;
	private IIcon DGoldenSandstone_bottom;
	private IIcon DGoldenSandstone1;
	private IIcon DGoldenSandstone2;

	public ModStoneSlab(boolean isdouble)
	{
		super(isdouble, Material.rock);
		if(!this.field_150004_a)
		{
			this.setLightOpacity(0);
		}
	}

	@SideOnly(Side.CLIENT)
	private static boolean isBlockSingleSlab(ModStoneSlab block)
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
			return metadata == 0 ? this.DCobblestone : this.DCobblestone;
		}
		
		if (metadata == 1)
		{
			return metadata == 1 ? this.DStoneBrick1 : this.DStoneBrick1;
		}
		
		if (metadata == 2)
		{
			return metadata == 2 ? this.DStoneBrick2 : this.DStoneBrick2;
		}
		
		if (metadata == 3)
		{
			return metadata == 3 ? this.DStoneBrick3 : this.DStoneBrick3;
		}
		
		if (metadata == 4)
		{
			return metadata == 4 ? this.DStoneBrick4 : this.DStoneBrick4;
		}
		
		if (metadata == 5)
		{
			return metadata == 5 && side == 0 ? this.DGoldenSandstone_bottom : side == 1 ? this.DGoldenSandstone_top : this.DGoldenSandstone1;
		}
		
		if (metadata == 6)
		{
			return metadata == 6 && (side == 0 || side == 1) ? this.DGoldenSandstone_top : this.DGoldenSandstone2;
		}
		return blockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister)
	{
		this.DCobblestone = iconregister.registerIcon("sevenno_addons:dcobblestone");
		this.DStoneBrick1 = iconregister.registerIcon("sevenno_addons:DStoneBrick_1");
		this.DStoneBrick2 = iconregister.registerIcon("sevenno_addons:DStoneBrick_4");
		this.DStoneBrick3 = iconregister.registerIcon("sevenno_addons:DStoneBrick_5");
		this.DStoneBrick4 = iconregister.registerIcon("sevenno_addons:DStoneBrick_6");
		this.DGoldenSandstone_top = iconregister.registerIcon("sevenno_addons:DGoldenSandstone_top");
		this.DGoldenSandstone_bottom = iconregister.registerIcon("sevenno_addons:DGoldenSandstone_bottom");
		this.DGoldenSandstone1 = iconregister.registerIcon("sevenno_addons:DGoldenSandstone_normal");
		this.DGoldenSandstone2 = iconregister.registerIcon("sevenno_addons:DGoldenSandstone_brick");
	}
}