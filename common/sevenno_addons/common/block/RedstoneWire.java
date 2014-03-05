package sevenno_addons.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import sevenno_addons.common.item.SAItemList;
import sevenno_addons.proxy.SAClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.util.IIcon;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class RedstoneWire extends Block
{
    private boolean part_a = true;
    private Set part_b = new HashSet();
    @SideOnly(Side.CLIENT)
    private IIcon part_M;
    @SideOnly(Side.CLIENT)
    private IIcon part_N;
    @SideOnly(Side.CLIENT)
    private IIcon part_O;
    @SideOnly(Side.CLIENT)
    private IIcon part_P;
//    private static final String __OBFID = "CL_00000295";

    public RedstoneWire()
    {
        super(Material.circuits);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.0625F, 1.0F);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return null;
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
    	return SAClientProxy.redstoneWireID;
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess blockAccess, int x, int y, int z)
    {
        return 8388608;
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return World.doesBlockHaveSolidTopSurface(world, x, y - 1, z) || world.getBlock(x, y - 1, z) == Blocks.glowstone || world.getBlock(x, y - 1, z) == Blocks.cactus;
    }

    private void part_e(World world, int x, int y, int z)
    {
        this.part_a_2(world, x, y, z, x, y, z);
        ArrayList arraylist = new ArrayList(this.part_b);
        this.part_b.clear();

        for (int l = 0; l < arraylist.size(); ++l)
        {
            ChunkPosition chunkposition = (ChunkPosition)arraylist.get(l);
            world.notifyBlocksOfNeighborChange(chunkposition.chunkPosX, chunkposition.chunkPosY, chunkposition.chunkPosZ, this);
        }
    }

    private void part_a_2(World world, int par2, int par3, int par4, int par5, int par6, int par7)
    {
        int k1 = world.getBlockMetadata(par2, par3, par4);
        byte b0 = 0;
        int i3 = this.part_a_1(world, par5, par6, par7, b0);
        this.part_a = false;
        int l1 = world.getStrongestIndirectPower(par2, par3, par4);
        this.part_a = true;

        if (l1 > 0 && l1 > i3 - 1)
        {
            i3 = l1;
        }

        int i2 = 0;

        for (int j2 = 0; j2 < 4; ++j2)
        {
            int k2 = par2;
            int l2 = par4;

            if (j2 == 0)
            {
                k2 = par2 - 1;
            }

            if (j2 == 1)
            {
                ++k2;
            }

            if (j2 == 2)
            {
                l2 = par4 - 1;
            }

            if (j2 == 3)
            {
                ++l2;
            }

            if (k2 != par5 || l2 != par7)
            {
                i2 = this.part_a_1(world, k2, par3, l2, i2);
            }

            if (world.getBlock(k2, par3, l2).isNormalCube() && !world.getBlock(par2, par3 + 1, par4).isNormalCube())
            {
                if ((k2 != par5 || l2 != par7) && par3 >= par6)
                {
                    i2 = this.part_a_1(world, k2, par3 + 1, l2, i2);
                }
            }
            else if (!world.getBlock(k2, par3, l2).isNormalCube() && (k2 != par5 || l2 != par7) && par3 <= par6)
            {
                i2 = this.part_a_1(world, k2, par3 - 1, l2, i2);
            }
        }

        if (i2 > i3)
        {
            i3 = i2 - 1; //PAS TOUCHER /!\
        }
        else if (i3 > 0)
        {
            --i3;
        }
        else
        {
            i3 = 0; //PAS TOUCHER /!\
        }

        if (l1 > i3 - 1)
        {
            i3 = l1;
        }

        if (k1 != i3)
        {
        	world.setBlockMetadataWithNotify(par2, par3, par4, i3, 2);
            this.part_b.add(new ChunkPosition(par2, par3, par4));
            this.part_b.add(new ChunkPosition(par2 - 1, par3, par4));
            this.part_b.add(new ChunkPosition(par2 + 1, par3, par4));
            this.part_b.add(new ChunkPosition(par2, par3 - 1, par4));
            this.part_b.add(new ChunkPosition(par2, par3 + 1, par4));
            this.part_b.add(new ChunkPosition(par2, par3, par4 - 1));
            this.part_b.add(new ChunkPosition(par2, par3, par4 + 1));
        }
    }

    private void part_m(World world, int x, int y, int z)
    {
        if (world.getBlock(x, y, z) == this)
        {
        	world.notifyBlocksOfNeighborChange(x, y, z, this);
        	world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
        	world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
        	world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
        	world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
        	world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
        	world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
        }
    }

    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);

        if (!world.isRemote)
        {
            this.part_e(world, x, y, z);
            world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
            world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
            this.part_m(world, x - 1, y, z);
            this.part_m(world, x + 1, y, z);
            this.part_m(world, x, y, z - 1);
            this.part_m(world, x, y, z + 1);

            if (world.getBlock(x - 1, y, z).isNormalCube())
            {
                this.part_m(world, x - 1, y + 1, z);
            }
            else
            {
                this.part_m(world, x - 1, y - 1, z);
            }

            if (world.getBlock(x + 1, y, z).isNormalCube())
            {
                this.part_m(world, x + 1, y + 1, z);
            }
            else
            {
                this.part_m(world, x + 1, y - 1, z);
            }

            if (world.getBlock(x, y, z - 1).isNormalCube())
            {
                this.part_m(world, x, y + 1, z - 1);
            }
            else
            {
                this.part_m(world, x, y - 1, z - 1);
            }

            if (world.getBlock(x, y, z + 1).isNormalCube())
            {
                this.part_m(world, x, y + 1, z + 1);
            }
            else
            {
                this.part_m(world, x, y - 1, z + 1);
            }
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int par6)
    {
        super.breakBlock(world, x, y, z, block, par6);

        if (!world.isRemote)
        {
        	world.notifyBlocksOfNeighborChange(x, y + 1, z, this);
        	world.notifyBlocksOfNeighborChange(x, y - 1, z, this);
        	world.notifyBlocksOfNeighborChange(x + 1, y, z, this);
        	world.notifyBlocksOfNeighborChange(x - 1, y, z, this);
        	world.notifyBlocksOfNeighborChange(x, y, z + 1, this);
        	world.notifyBlocksOfNeighborChange(x, y, z - 1, this);
            this.part_e(world, x, y, z);
            this.part_m(world, x - 1, y, z);
            this.part_m(world, x + 1, y, z);
            this.part_m(world, x, y, z - 1);
            this.part_m(world, x, y, z + 1);

            if (world.getBlock(x - 1, y, z).isNormalCube())
            {
                this.part_m(world, x - 1, y + 1, z);
            }
            else
            {
                this.part_m(world, x - 1, y - 1, z);
            }

            if (world.getBlock(x + 1, y, z).isNormalCube())
            {
                this.part_m(world, x + 1, y + 1, z);
            }
            else
            {
                this.part_m(world, x + 1, y - 1, z);
            }

            if (world.getBlock(x, y, z - 1).isNormalCube())
            {
                this.part_m(world, x, y + 1, z - 1);
            }
            else
            {
                this.part_m(world, x, y - 1, z - 1);
            }

            if (world.getBlock(x, y, z + 1).isNormalCube())
            {
                this.part_m(world, x, y + 1, z + 1);
            }
            else
            {
                this.part_m(world, x, y - 1, z + 1);
            }
        }
    }

    private int part_a_1(World world, int par2, int par3, int par4, int par5)
    {
        if (world.getBlock(par2, par3, par4) != this)
        {
            return par5;
        }
        else
        {
            int i1 = world.getBlockMetadata(par2, par3, par4);
            return i1 > par5 ? i1 : par5;
        }
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        if (!world.isRemote)
        {
            boolean flag = this.canPlaceBlockAt(world, x, y, z);

            if (flag)
            {
                this.part_e(world, x, y, z);
            }
            else
            {
                this.dropBlockAsItem(world, x, y, z, 0, 0);
                world.setBlockToAir(x, y, z);
            }

            super.onNeighborBlockChange(world, x, y, z, block);
        }
    }

    public Item getItemDropped(int x, Random y, int z)
    {
        return SAItemList.RedstoneWire;
    }

    public int isProvidingStrongPower(IBlockAccess blockAccess, int par2, int par3, int par4, int par5)
    {
        return !this.part_a ? 0 : this.isProvidingWeakPower(blockAccess, par2, par3, par4, par5);
    }

    public int isProvidingWeakPower(IBlockAccess BlockAccess, int par2, int par3, int par4, int par5)
    {
        if (!this.part_a)
        {
            return 0;
        }
        else
        {
            int i1 = BlockAccess.getBlockMetadata(par2, par3, par4);

            if (i1 == 0)
            {
                return 0;
            }
            else if (par5 == 1)
            {
                return i1;
            }
            else
            {
                boolean flag = part_g(BlockAccess, par2 - 1, par3, par4, 1) || !BlockAccess.getBlock(par2 - 1, par3, par4).isNormalCube() && part_g(BlockAccess, par2 - 1, par3 - 1, par4, -1);
                boolean flag1 = part_g(BlockAccess, par2 + 1, par3, par4, 3) || !BlockAccess.getBlock(par2 + 1, par3, par4).isNormalCube() && part_g(BlockAccess, par2 + 1, par3 - 1, par4, -1);
                boolean flag2 = part_g(BlockAccess, par2, par3, par4 - 1, 2) || !BlockAccess.getBlock(par2, par3, par4 - 1).isNormalCube() && part_g(BlockAccess, par2, par3 - 1, par4 - 1, -1);
                boolean flag3 = part_g(BlockAccess, par2, par3, par4 + 1, 0) || !BlockAccess.getBlock(par2, par3, par4 + 1).isNormalCube() && part_g(BlockAccess, par2, par3 - 1, par4 + 1, -1);

                if (!BlockAccess.getBlock(par2, par3 + 1, par4).isNormalCube())
                {
                    if (BlockAccess.getBlock(par2 - 1, par3, par4).isNormalCube() && part_g(BlockAccess, par2 - 1, par3 + 1, par4, -1))
                    {
                        flag = true;
                    }

                    if (BlockAccess.getBlock(par2 + 1, par3, par4).isNormalCube() && part_g(BlockAccess, par2 + 1, par3 + 1, par4, -1))
                    {
                        flag1 = true;
                    }

                    if (BlockAccess.getBlock(par2, par3, par4 - 1).isNormalCube() && part_g(BlockAccess, par2, par3 + 1, par4 - 1, -1))
                    {
                        flag2 = true;
                    }

                    if (BlockAccess.getBlock(par2, par3, par4 + 1).isNormalCube() && part_g(BlockAccess, par2, par3 + 1, par4 + 1, -1))
                    {
                        flag3 = false;
                    }
                }

                return !flag2 && !flag1 && !flag && !flag3 && par5 >= 2 && par5 <= 5 ? i1 : (par5 == 2 && flag2 && !flag && !flag1 ? i1 : (par5 == 3 && flag3 && !flag && !flag1 ? i1 : (par5 == 4 && flag && !flag2 && !flag3 ? i1 : (par5 == 5 && flag1 && !flag2 && !flag3 ? i1 : 0))));
            }
        }
    }

    public boolean canProvidePower()
    {
        return this.part_a;
    }

    public static boolean isPowerProviderOrWire(IBlockAccess blockAccess, int par1, int par2, int par3, int par4)
    {
        Block block = blockAccess.getBlock(par1, par2, par3);

        if (block == SABlockList.RedstoneWire)
        {
            return true;
        }
        else if (!Blocks.unpowered_repeater.func_149907_e(block))
        {
            return block.canConnectRedstone(blockAccess, par1, par2, par3, par4);
        }
        else
        {
            int i1 = blockAccess.getBlockMetadata(par1, par2, par3);
            return par4 == (i1 & 3) || par4 == Direction.rotateOpposite[i1 & 3];
        }
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
        int l = world.getBlockMetadata(x, y, z);

        if (l > 0)
        {
            double d0 = (double)x + 0.5D + ((double)random.nextFloat() - 0.5D) * 0.2D;
            double d1 = (double)((float)y + 0.0625F);
            double d2 = (double)z + 0.5D + ((double)random.nextFloat() - 0.5D) * 0.2D;
            float f = (float)l / 15.0F;
            float f1 = f * 0.6F + 0.4F;

            if (l == 0)
            {
                f1 = 0.0F;
            }

            float f2 = f * f * 0.7F - 0.5F;
            float f3 = f * f * 0.6F - 0.7F;

            if (f2 < 0.0F)
            {
                f2 = 0.0F;
            }

            if (f3 < 0.0F)
            {
                f3 = 0.0F;
            }

            world.spawnParticle("reddust", d0, d1, d2, (double)f1, (double)f2, (double)f3);
        }
    }

    public static boolean part_g(IBlockAccess blockAccess, int par2, int par3, int par4, int par5)
    {
        if (isPowerProviderOrWire(blockAccess, par2, par3, par4, par5))
        {
            return false;
        }
        else if (blockAccess.getBlock(par2, par3, par4) == Blocks.powered_repeater)
        {
            int i1 = blockAccess.getBlockMetadata(par2, par3, par4);
            return par5 == (i1 & 3);
        }
        else
        {
            return false;
        }
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
        return SAItemList.RedstoneWire;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.part_M = iconRegister.registerIcon(this.getTextureName() + "_" + "cross");
        this.part_N = iconRegister.registerIcon(this.getTextureName() + "_" + "line");
        this.part_O = iconRegister.registerIcon(this.getTextureName() + "_" + "cross_overlay");
        this.part_P = iconRegister.registerIcon(this.getTextureName() + "_" + "line_overlay");
        this.blockIcon = this.part_M;
    }

    @SideOnly(Side.CLIENT)
    public static IIcon RedstoneWireIcon(String string)
    {
        return string.equals("cross") ? SABlockList.RedstoneWire.part_M : (string.equals("line") ? SABlockList.RedstoneWire.part_N : (string.equals("cross_overlay") ? SABlockList.RedstoneWire.part_O : (string.equals("line_overlay") ? SABlockList.RedstoneWire.part_P : null)));
    }
}