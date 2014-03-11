package sevenno_addons.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRail;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FlyingTrack extends BlockRail
{
    @SideOnly(Side.CLIENT)
    private IIcon field_150056_b;

    protected FlyingTrack()
    {
        super();
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        return par2 >= 6 ? this.field_150056_b : this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        super.registerBlockIcons(iconRegister);
        this.field_150056_b = iconRegister.registerIcon(this.getTextureName() + "_Turn");
    }

    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return true;
    }

    public void onBlockAdded(World world, int x, int y, int z)
    {
        if (!world.isRemote)
        {
            this.func_150052_a(world, x, y, z, true);

            if (this.field_150053_a)
            {
                this.onNeighborBlockChange(world, x, y, z, this);
            }
        }
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        if (!world.isRemote)
        {
            int l = world.getBlockMetadata(x, y, z);
            int i1 = l;

            if (this.field_150053_a)
            {
                i1 = l & 7;
            }
            
            else
            {
                this.func_150048_a(world, x, y, z, l, i1, block);
            }
        }
    }
}