package sevenno_addons.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import sevenno_addons.common.item.SAItemList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class QuartzReedBlock extends Block implements IPlantable
{
    protected QuartzReedBlock()
    {
        super(Material.plants);
        float f = 0.375F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
        this.setTickRandomly(true);
    }

    public void updateTick(World world, int par2, int par3, int par4, Random random)
    {
        if (world.getBlock(par2, par3 - 1, par4) == SABlockList.QuartzReedBlock || this.checkBlockCoordValid(world, par2, par3, par4))
        {
            if (world.isAirBlock(par2, par3 + 1, par4))
            {
                int l;

                for (l = 1; world.getBlock(par2, par3 - l, par4) == this; ++l)
                {
                    ;
                }

                if (l < 3)
                {
                    int i1 = world.getBlockMetadata(par2, par3, par4);

                    if (i1 == 15)
                    {
                    	world.setBlock(par2, par3 + 1, par4, this);
                    	world.setBlockMetadataWithNotify(par2, par3, par4, 0, 4);
                    }
                    else
                    {
                    	world.setBlockMetadataWithNotify(par2, par3, par4, i1 + 1, 4);
                    }
                }
            }
        }
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        Block block = world.getBlock(x, y - 1, z);
    	if (block == this)
    	{
    		return block == SABlockList.QuartzReedBlock;
    	}
    	return block == SABlockList.SPReedBooster;
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        this.checkBlockCoordValid(world, x, y, z);
    }

    protected final boolean checkBlockCoordValid(World world, int x, int y, int z)
    {
        if (!this.canBlockStay(world, x, y, z))
        {
            this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
            world.setBlockToAir(x, y, z);
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean canBlockStay(World world, int x, int y, int z)
    {
        return this.canPlaceBlockAt(world, x, y, z);
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
    
    public Item getItemDropped(int par1, Random random, int par3)
    {
        return SAItemList.QuartzReed;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
        return SAItemList.QuartzReed;
    }
    
    @Override
    public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
    {
        return EnumPlantType.Beach;
    }

    @Override
    public Block getPlant(IBlockAccess world, int x, int y, int z)
    {
        return this;
    }

    @Override
    public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
    {
        return world.getBlockMetadata(x, y, z);
    }
}