package sevenno_addons.common.block;

import java.util.List;
import java.util.Random;

import sevenno_addons.common.block.generation.GiantGreenMushroomGeneration;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GreenMushroomBlock_P extends BlockSapling
{
    public static final String[] WOOD_TYPES = new String[] {"sevenno_addons:GreenMushroomBlock_P"};
    
	protected GreenMushroomBlock_P()
	{
		super();
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}

	public void func_149878_d(World world, int x, int y, int z, Random random)
	{
		world.isAirBlock(x, y, z);
		Object obj = null;
		obj = new GiantGreenMushroomGeneration(false);
		if(!((WorldGenerator) (obj)).generate(world, random, x, y, z))
		{
			world.setBlock(x, y, z, this, 0, 4);
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativetabs, List list)
	{
		list.add(new ItemStack(item, 1, 0));
	}

	public void fertilize(World world, int x, int y, int z)
	{
		
	}
	public IIcon getIcon(int side, int metadata)
	{
	return blockIcon;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("sevenno_addons:greenMushroomBlock_P");
	}
}