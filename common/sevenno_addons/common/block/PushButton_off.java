package sevenno_addons.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import sevenno_addons.proxy.SAClientProxy;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PushButton_off extends Block
{
	public PushButton_off() 
	{
		super(Material.rock);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
        this.setBlockBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);
	}
    
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int par6, float par7, float par8, float par9)
	{
		if (entityplayer.worldObj.getBlock(x, y, z) == SABlockList.PushButton_off)
		{
			entityplayer.worldObj.setBlock(x, y, z, SABlockList.PushButton_on);
		}
        world.playSoundEffect((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "random.click", 0.3F, 0.6F);
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
		return SAClientProxy.RenderPushButton_offID;
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
        return 0;
    }
}