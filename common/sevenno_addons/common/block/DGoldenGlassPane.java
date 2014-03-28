package sevenno_addons.common.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class DGoldenGlassPane extends BlockPane
{
	protected DGoldenGlassPane(String par2Str, String par3Str, Material par4Material, boolean par5)
	{
		super(par2Str, par3Str, par4Material, par5);
	}
	
	public int quantityDropped(Random par1Random)
    {
        return 0;
    }
	
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }
}