package sevenno_addons.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
//import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;

public class DGrass extends Block implements IGrowable
{
    private static final Logger logger = LogManager.getLogger();
    @SideOnly(Side.CLIENT)
    private IIcon part_b;
    @SideOnly(Side.CLIENT)
    private IIcon part_M;
//    @SideOnly(Side.CLIENT)
//    private IIcon part_N;

    protected DGrass()
    {
        super(Material.grass);
        this.setTickRandomly(true);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return par1 == 1 ? this.part_b : (par1 == 0 ? SABlockList.DDirt.getBlockTextureFromSide(par1) : this.blockIcon);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if (!world.isRemote)
        {
            if (world.getBlockLightValue(x, y + 1, z) < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2)
            {
            	world.setBlock(x, y, z, SABlockList.DDirt);
            }
            else if (world.getBlockLightValue(x, y + 1, z) >= 9)
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = x + random.nextInt(3) - 1;
                    int j1 = y + random.nextInt(5) - 3;
                    int k1 = z + random.nextInt(3) - 1;
                    Block block = world.getBlock(i1, j1 + 1, k1);

                    if (world.getBlock(i1, j1, k1) == SABlockList.DDirt && world.getBlockMetadata(i1, j1, k1) == 0 && world.getBlockLightValue(i1, j1 + 1, k1) >= 4 && world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                    	world.setBlock(i1, j1, k1, SABlockList.DGrass);
                    }
                }
            }
        }
    }

    public Item getItemDropped(int par1, Random random, int par3)
    {
        return SABlockList.DDirt.getItemDropped(0, random, par3);
    }

    public boolean func_149851_a(World world, int x, int y, int z, boolean par5)
    {
        return true;
    }

    public boolean func_149852_a(World world, Random random, int x, int y, int z)
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int par5)
    {
        if (par5 == 1)
        {
            return this.part_b;
        }
        else if (par5 == 0)
        {
            return SABlockList.DDirt.getBlockTextureFromSide(par5);
        }
        else
        {
            Material material = blockAccess.getBlock(x, y + 1, z).getMaterial();
            return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.part_M;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister)
    {
        this.blockIcon = iconregister.registerIcon(this.getTextureName() + "_side");
        this.part_b = iconregister.registerIcon(this.getTextureName());
        this.part_M = iconregister.registerIcon(this.getTextureName() + "_side_snowed");
//        this.part_N = iconregister.registerIcon(this.getTextureName() + "_side_overlay");
    }

/*    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        double d0 = 0.5D;
        double d1 = 1.0D;
        return ColorizerGrass.getGrassColor(d0, d1);
    }*/

    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
/*    @SideOnly(Side.CLIENT)
    public int getRenderColor(int p_149741_1_)
    {
        return this.getBlockColor();
    }*/

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
/*    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_)
    {
        int l = 0;
        int i1 = 0;
        int j1 = 0;

        for (int k1 = -1; k1 <= 1; ++k1)
        {
            for (int l1 = -1; l1 <= 1; ++l1)
            {
                int i2 = p_149720_1_.getBiomeGenForCoords(p_149720_2_ + l1, p_149720_4_ + k1).getBiomeGrassColor(p_149720_2_ + l1, p_149720_3_, p_149720_4_ + k1);
                l += (i2 & 16711680) >> 16;
                i1 += (i2 & 65280) >> 8;
                j1 += i2 & 255;
            }
        }

        return (l / 9 & 255) << 16 | (i1 / 9 & 255) << 8 | j1 / 9 & 255;
    }*/

    @SideOnly(Side.CLIENT)
    public static IIcon getIconSideOverlay()
    {
        return (IIcon) SABlockList.DGrass;
    }

    public void func_149853_b(World world, Random random, int x, int y, int z)
    {
        int l = 0;

        while (l < 128)
        {
            int i1 = x;
            int j1 = y + 1;
            int k1 = z;
            int l1 = 0;

            while (true)
            {
                if (l1 < l / 16)
                {
                    i1 += random.nextInt(3) - 1;
                    j1 += (random.nextInt(3) - 1) * random.nextInt(3) / 2;
                    k1 += random.nextInt(3) - 1;

                    if (world.getBlock(i1, j1 - 1, k1) == SABlockList.DGrass && !world.getBlock(i1, j1, k1).isNormalCube())
                    {
                        ++l1;
                        continue;
                    }
                }
                else if (world.getBlock(i1, j1, k1).getMaterial() == Material.air)
                {
                    if (random.nextInt(8) != 0)
                    {
                        if (Blocks.tallgrass.canBlockStay(world, i1, j1, k1))
                        {
                        	world.setBlock(i1, j1, k1, Blocks.tallgrass, 1, 3);
                        }
                    }
                    else
                    {
                    	world.getBiomeGenForCoords(i1, k1).plantFlower(world, random, i1, j1, k1);
                    }
                }

                ++l;
                break;
            }
        }
    }
}