package sevenno_addons.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import sevenno_addons.common.block.generation.CherrygeGenBigTree;
import sevenno_addons.common.block.generation.EbonygeGenBigTree;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DEbonyTree extends BlockSapling
{
	public DEbonyTree()
	{
		super();
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}
	
    protected boolean canPlaceBlockOn(Block Par1)
    {
        return Par1 == SABlockList.DDirt || Par1 == SABlockList.DGrass;
    }
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("sevenno_addons:ebonyTree");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		return blockIcon;
	}

    public void func_149878_d(World world, int x, int y, int z, Random random)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, random, x, y, z)) return;
        int l = world.getBlockMetadata(x, y, z) & 7;
        Object object = random.nextInt(10) == 0 ? new EbonygeGenBigTree(true) : new EbonygeGenBigTree(true);
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;

        switch (l)
        {
        case 0:
        default:
        	break;
        case 1:
        	
        		if (!flag)
        		{
                    return;
                }
        }

        Block block = Blocks.air;

        if (flag)
        {
        	world.setBlock(x + i1, y, z + j1, block, 0, 4);
        	world.setBlock(x + i1 + 1, y, z + j1, block, 0, 4);
        	world.setBlock(x + i1, y, z + j1 + 1, block, 0, 4);
        	world.setBlock(x + i1 + 1, y, z + j1 + 1, block, 0, 4);
        }
        else
        {
        	world.setBlock(x, y, z, block, 0, 4);
        }

        if (!((WorldGenerator)object).generate(world, random, x + i1, y, z + j1))
        {
            if (flag)
            {
            	world.setBlock(x + i1, y, z + j1, this, l, 4);
            	world.setBlock(x + i1 + 1, y, z + j1, this, l, 4);
            	world.setBlock(x + i1, y, z + j1 + 1, this, l, 4);
            	world.setBlock(x + i1 + 1, y, z + j1 + 1, this, l, 4);
            }
            else
            {
            	world.setBlock(x, y, z, this, l, 4);
            }
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
}