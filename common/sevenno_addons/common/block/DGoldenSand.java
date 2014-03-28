package sevenno_addons.common.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import sevenno_addons.common.entity.GoldenParticleFX;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;

public class DGoldenSand extends BlockFalling
{    
	public DGoldenSand(Material material) 
	{
		super(material);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}
	
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);

        if (p_149734_5_.nextInt(10) == 0)
        {
        	Minecraft.getMinecraft().effectRenderer.addEffect(new GoldenParticleFX(p_149734_1_, (double)((float)p_149734_2_ + p_149734_5_.nextFloat()), (double)((float)p_149734_3_ + 1.1F), (double)((float)p_149734_4_ + p_149734_5_.nextFloat()), 0.0D, 0.0D, 0.0D));
//            Minecraft.getMinecraft().effectRenderer.addEffect(new GoldenParticleFX(p_149734_1_, 0.0D, 0.0D, 0.0D, maxX, maxX, maxX));
        }
    }
}