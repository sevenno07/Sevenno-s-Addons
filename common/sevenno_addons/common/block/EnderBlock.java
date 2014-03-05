package sevenno_addons.common.block;

import java.util.Random;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import sevenno_addons.proxy.SAClientProxy;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EnderBlock extends BlockBreakable
{
    protected EnderBlock(Material par2Material, boolean par3)
    {
		super("glass", par2Material, par3);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}
	
    public int getRenderBlockPass()
    {
        return 1;
    }
    
    public int getRenderType()
    {
		return SAClientProxy.RenderEnderBlockID;
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        for (int l = 0; l < 3; ++l)
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
            p_149734_1_.spawnParticle("portal", d0, d1, d2, d3, d4, d5);
        }
    }

	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister)
	{
    	blockIcon = iconregister.registerIcon("sevenno_addons:EnderBlock_glass");
 	}
}