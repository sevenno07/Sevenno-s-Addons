package sevenno_addons.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import sevenno_addons.common.item.SAItemList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CoalReedBlock extends Block implements IPlantable
{
    protected CoalReedBlock()
    {
        super(Material.plants);
        float f = 0.375F;
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
        this.setTickRandomly(true);
    }

    //Ticks the block if it's been scheduled

    public void updateTick(World world, int par2, int par3, int par4, Random random)
    {
        if (world.getBlock(par2, par3 - 1, par4) == SABlockList.CoalReedBlock || this.func_150170_e(world, par2, par3, par4))
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

    //Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z

    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        Block block = world.getBlock(x, y - 1, z);
    	if (block == this)
    	{
    		return block.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this);
    	}
    	return block == SABlockList.SPReedBooster;
    }
    
/*    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        Block block = world.getBlock(x, y - 1, z);
        return block.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this);
    }*/

    //Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
    //their own) Args: x, y, z, neighbor Block

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        this.func_150170_e(world, x, y, z);
    }

    protected final boolean func_150170_e(World world, int x, int y, int z)
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

    //Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.

    public boolean canBlockStay(World world, int x, int y, int z)
    {
        return this.canPlaceBlockAt(world, x, y, z);
    }

    public Item getItemDropped(int par1, Random random, int par3)
    {
        return SAItemList.CoalReed;
    }


    //Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
    //adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.

    public boolean isOpaqueCube()
    {
        return false;
    }


    //If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)

    public boolean renderAsNormalBlock()
    {
        return false;
    }


    //The type of render function that is called for this block

    public int getRenderType()
    {
        return 1;
    }


    //Gets an item for the block being called on. Args: world, x, y, z

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
        return SAItemList.CoalReed;
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