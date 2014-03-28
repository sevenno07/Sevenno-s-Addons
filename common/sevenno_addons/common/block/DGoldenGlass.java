package sevenno_addons.common.block;

import java.util.Random;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DGoldenGlass extends BlockBreakable
{
    protected DGoldenGlass(Material par2Material, boolean par3)
    {
		super("glass", par2Material, par3);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}

	public int quantityDropped(Random par1Random)
    {
        return 0;
    }
	
    public int getRenderBlockPass()
    {
        return 1;
    }
    
    protected boolean canSilkHarvest()
    {
        return true;
    }

	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister)
	{
        this.blockIcon = iconregister.registerIcon("sevenno_addons:dgoldenglass");
 	}
}