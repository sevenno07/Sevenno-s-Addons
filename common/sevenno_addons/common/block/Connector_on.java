package sevenno_addons.common.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import sevenno_addons.proxy.SAClientProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Connector_on extends Block
{	
	public Block getblock1 = (SABlockList.PushButton_off);
	public Block getblock2 = (SABlockList.Connector_midle);
	
	public Connector_on() 
	{
		super(Material.rock);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
        this.setBlockBounds(0.15F, 0.15F, 0.15F, 0.85F, 0.85F, 0.85F);
//		this.setTickRandomly(true);
	}
	
    public int getRenderType()
    {
    	return SAClientProxy.ConnectorBlockRenderID;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        return null;
    }
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		if(world.getBlock(x, y - 1, z) == getblock1 || world.getBlock(x, y + 1, z) == getblock1 || world.getBlock(x - 1, y, z) == getblock1 || world.getBlock(x + 1, y, z) == getblock1 || world.getBlock(x, y, z - 1) == getblock1 || world.getBlock(x, y, z + 1) == getblock1
		|| world.getBlock(x, y - 1, z) == getblock2 || world.getBlock(x, y + 1, z) == getblock2 || world.getBlock(x - 1, y, z) == getblock2 || world.getBlock(x + 1, y, z) == getblock2 || world.getBlock(x, y, z - 1) == getblock2 || world.getBlock(x, y, z + 1) == getblock2)
		{
			world.setBlock(x, y, z, SABlockList.Connector_midle);
		}
	}
	
    public void randomDisplayTick(World world, int x, int y, int z, Random random)
    {
		world.setBlock(x, y, z, SABlockList.Connector_on);
		{
			world.setBlock(x, y, z, SABlockList.Connector_midle2);
		}
    }
	
    public boolean renderAsNormalBlock()
    {
    	return false;
    }
    
    public boolean isOpaqueCube()
    {
    	return false;
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
}