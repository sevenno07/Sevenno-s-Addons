package sevenno_addons.common.block;

import java.util.List;
import java.util.Random;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import sevenno_addons.common.entity.GoldParticleFX;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StrangeTreeLeaves extends BlockLeaves implements IShearable
	{
	private IIcon fastIcon;

	public StrangeTreeLeaves()
	{
		super();
		this.setTickRandomly(true);
		this.setLightOpacity(1);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister)
	{
		blockIcon = iconregister.registerIcon("sevenno_addons:strangeLeaves");
		fastIcon = iconregister.registerIcon("sevenno_addons:strangeLeaves_opaque");
	}
	
    protected void GoldenAppleDrop(World world, int x, int y, int z, int par5, int par6)
    {
        if (world.rand.nextInt(par6) == 0)
        {
            this.dropBlockAsItem(world, x, y, z, new ItemStack(Items.golden_apple, 1, 0));
        }
    }
    
    protected void GoldenAppleDropS(World world, int x, int y, int z, int par5, int par6)
    {
        if (world.rand.nextInt(par6) == 0)
        {
            this.dropBlockAsItem(world, x, y, z, new ItemStack(Items.golden_apple, 1, 1));
        }
    }

	@SideOnly(Side.CLIENT)
	public int getBlockColor()
	{
		return -1;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderColor(int par1)
	{
		return -1;
	}

	public boolean isOpaqueCube()
	{
		return Blocks.leaves.isOpaqueCube();
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess blockaccess, int x, int y, int z, int side)
	{
		return !this.isOpaqueCube() ? true : super.shouldSideBeRendered(blockaccess, x, y, z, side);
	}

	public IIcon getIcon(int side, int metadata)
	{
		return(isOpaqueCube() ? fastIcon : blockIcon);
	}

	public int quantityDropped(Random random)
	{
		return random.nextInt(20) == 0 ? 1 : 0;
	}

	public Item idDropped(int metadata, Random random, int par3)
	{
		return Item.getItemFromBlock(SABlockList.StrangeTree);
	}

	public void getSubBlocks(Item par1, CreativeTabs creativeTabs, List list)
	{
		list.add(new ItemStack(par1, 1, 0));
	}

    public void dropBlockAsItemWithChance(World world, int x, int y, int z, int par5, float par6, int par7)
    {
        if (!world.isRemote)
        {
        	
			byte var8 = 30;

			if((par5 & 3) == 3)
			{
				var8 = 40;
			}

			if(world.rand.nextInt(var8) == 0)
			{
				Item var9 = this.idDropped(par5, world.rand, par7);
				this.dropBlockAsItem(world, x, y, z, new ItemStack(var9, 1, this.damageDropped(par5)));
			}	
        	
            int j1 = this.func_150123_b(par5);

            j1 = 400;//TODO

            if (par7 > 0)
            {
                j1 -= 10 << par7;

                if (j1 < 40)
                {
                    j1 = 40;
                }
            }

            this.GoldenAppleDrop(world, x, y, z, par5, j1);
        }
        int j2 = this.func_150123_b(par5);

        j2 = 1000;//TODO

        if (par7 > 0)
        {
        	j2 -= 10 << par7;

            if (j2 < 40)
            {
            	j2 = 40;
            }
        }

        this.GoldenAppleDropS(world, x, y, z, par5, j2);
    }
	
    public void randomDisplayTick(World world, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        for (int l = 0; l < 1; ++l)
        {
            double d6 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
            double d1 = (double)((float)p_149734_3_ + p_149734_5_.nextFloat());
            d6 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = p_149734_5_.nextInt(2) * 2 - 1;
            int j1 = p_149734_5_.nextInt(2) * 2 - 1;
            d3 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.125D;
            d4 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.125D;
            d5 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.125D;
            double d2 = (double)p_149734_4_ + 0.5D + 0.25D * (double)j1;
            d5 = (double)(p_149734_5_.nextFloat() * 1.0F * (float)j1);
            double d0 = (double)p_149734_2_ + 0.5D + 0.25D * (double)i1;
            d3 = (double)(p_149734_5_.nextFloat() * 1.0F * (float)i1);
            Minecraft.getMinecraft().effectRenderer.addEffect(new GoldParticleFX(world, d0, d1, d2, d3, d4, d5));
        }
    }

	public int colorMultiplier(IBlockAccess blockaccess, int x, int y, int z)
	{
		return -1;
	}

	@Override
	public String[] func_150125_e()
	{
		return null;
	}
}