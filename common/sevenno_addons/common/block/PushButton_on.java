package sevenno_addons.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import sevenno_addons.proxy.SAClientProxy;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PushButton_on extends Block
{
	public PushButton_on() 
	{
		super(Material.rock);
        this.setBlockBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
	{
		if (entityplayer.worldObj.getBlock(x, y, z) == SABlockList.PushButton_on)
		{
			entityplayer.worldObj.setBlock(x, y, z, SABlockList.PushButton_off);
		}
        world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "random.click", 0.3F, 0.5F);
		return true;
	}
    
    public boolean renderAsNormalBlock()
    {
    	return false;
    }
    
    public boolean isOpaqueCube()
    {
    	return false;
    }
    
    public int getRenderType()
    {
		return SAClientProxy.RenderPushButton_onID;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
    {
    	return true;
    }
    
    public boolean canProvidePower()
    {
        return true;
    }

    public int isProvidingWeakPower(IBlockAccess blockAccess, int par1, int par2, int par3, int par4)
    {
        return 15;
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        for (int l = 0; l < 3; ++l)
        {
            double d6 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
            double d1 = (double)((float)p_149734_3_ + p_149734_5_.nextFloat());
            d6 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
            int i1 = p_149734_5_.nextInt(2) * 2 - 1;
            int j1 = p_149734_5_.nextInt(2) * 2 - 1;
            double d2 = (double)p_149734_4_ + 0.5D + 0.25D * (double)j1;
            double d0 = (double)p_149734_2_ + 0.5D + 0.25D * (double)i1;
            p_149734_1_.spawnParticle("reddust", d0, d1, d2, 0.0F, 0.0F, 0.0F);
        }
    }
    
	public Item getItemDropped(int par1, Random par2Random, int par3)
    {
		return Item.getItemFromBlock(SABlockList.PushButton_off);
    }
}