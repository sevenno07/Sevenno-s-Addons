package sevenno_addons.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import sevenno_addons.proxy.SAClientProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DStonebrickPillar extends Block
{
    private IIcon blockIcon2;
    private IIcon Top;
    private IIcon UpLeft;
    private IIcon UpRight;
    private IIcon DownLeft;
    private IIcon DownRight;
    private IIcon Cros;
    private IIcon North;
    private IIcon East;
    private IIcon South;
    private IIcon West;
	
	public DStonebrickPillar()
	{
		super(Material.rock);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
        this.setBlockBounds(0.125F, 0.125F, 0.125F, 0.875F, 0.875F, 0.875F);
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
		return SAClientProxy.RenderDPillarMediumID;
    }
    
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess blockaccess, int x, int y, int z, int side)
	{
		{
			//X & Z
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar)
				return side == 1 || side == 0 ? this.Cros : this.blockIcon2;
			//X & Y
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar)
				return side == 2 || side == 3 ? this.Cros : this.blockIcon2;
			//Y & Z
			if(blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar)
				return side == 4 || side == 5 ? this.Cros : this.blockIcon2;
			
			//groove UP/DOWN
			if(blockaccess.getBlock(x , y +1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x , y -1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar)
				return side == 2 ? this.East : side == 4 ? this.East : this.Top;
			if(blockaccess.getBlock(x , y +1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x , y -1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar)
				return side == 3 ? this.West : side == 5 ? this.West : this.Top;
			if(blockaccess.getBlock(x , y +1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x , y -1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar)
				return side == 3 ? this.East : side == 4 ? this.West : this.Top;
			if(blockaccess.getBlock(x , y +1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x , y -1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar)
				return side == 2 ? this.West : side == 5 ? this.East : this.Top;
			
			//groove NORTH/SOUTH
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar)
				return side == 0 ? this.East : side == 4 ? this.North : this.Top;
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar)
				return side == 0 ? this.West : side == 5 ? this.North : this.Top;
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar)
				return side == 1 ? this.East : side == 4 ? this.South : this.Top;
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar)
				return side == 1 ? this.West : side == 5 ? this.South : this.Top;
			
			//groove EAST/WEST
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar)
				return side == 0 ? this.South : side == 2 ? this.North : this.Top;
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar)
				return side == 0 ? this.North : side == 3 ? this.North : this.Top;
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar)
				return side == 1 ? this.South : side == 2 ? this.South : this.Top;
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar)
				return side == 1 ? this.North : side == 3 ? this.South : this.Top;
			
			//X & Z
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar)
				return side == 1 || side == 0 ? this.North : this.blockIcon2;
			if(blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar)
				return side == 1 || side == 0 ? this.East : this.blockIcon2;
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar)
				return side == 1 || side == 0 ? this.South : this.blockIcon2;
			if(blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar)
				return side == 1 || side == 0 ? this.West : this.blockIcon2;
			
			//X & Y
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar)
				return side == 2 || side == 3 ? this.South : this.blockIcon2;
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar)
				return side == 2 || side == 3 ? this.East : this.blockIcon;
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar)
				return side == 2 || side == 3 ? this.North : this.blockIcon2;
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar)
				return side == 2 || side == 3 ? this.West : this.blockIcon;
			
			//Y & Z
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar)
				return side == 4 || side == 5 ? this.South : this.blockIcon;
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar)
				return side == 4 || side == 5 ? this.East : this.blockIcon;
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar)
				return side == 4 || side == 5 ? this.North : this.blockIcon;
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar)
				return side == 4 || side == 5 ? this.West : this.blockIcon;

			//cornerUP
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar)
				return side == 1 ? this.UpLeft : side == 2 ? this.UpLeft : side == 4 ? this.UpLeft : this.Top;
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar)
				return side == 1 ? this.DownRight : side == 3 ? this.UpRight : side == 5 ? this.UpRight : this.Top;
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar)
				return side == 1 ? this.DownLeft : side == 3 ? this.UpLeft : side == 4 ? this.UpRight : this.Top;
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar)
				return side == 1 ? this.UpRight : side == 2 ? this.UpRight : side == 5 ? this.UpLeft : this.Top;
			
			//cornerDOWN
			if(blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar)
				return side == 1 ? this.DownLeft : side == 2 ? this.DownLeft : side == 4 ? this.DownLeft : this.Top;
			if(blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar)
				return side == 1 ? this.UpRight : side == 3 ? this.DownRight : side == 5 ? this.DownRight : this.Top;
			if(blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar)
				return side == 1 ? this.UpLeft : side == 3 ? this.DownLeft : side == 4 ? this.DownRight : this.Top;
			if(blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar)
				return side == 1 ? this.DownRight : side == 2 ? this.DownRight : side == 5 ? this.DownLeft : this.Top;
			
			//X & Z
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar)
				return side == 1 || side == 0 ? this.UpLeft : this.blockIcon2;
			if(blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar)
				return side == 1 || side == 0 ? this.UpRight : this.blockIcon2;
			if(blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar)
				return side == 1 || side == 0 ? this.DownRight : this.blockIcon2;
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar)
				return side == 1 || side == 0 ? this.DownLeft : this.blockIcon2;
			
			//X & Y
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar)
				return side == 2 || side == 3 ? this.DownLeft : side == 0 ? this.blockIcon2 : this.blockIcon;
			if(blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar)
				return side == 2 || side == 3 ? this.DownRight : side == 0 ? this.blockIcon2 : this.blockIcon;
			if(blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar)
				return side == 2 || side == 3 ? this.UpRight : side == 1 ? this.blockIcon2 : this.blockIcon;
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar)
				return side == 2 || side == 3 ? this.UpLeft : side == 1 ? this.blockIcon2 : this.blockIcon;
			
			//Y & Z
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar)
				return side == 4 || side == 5 ? this.DownLeft : this.blockIcon;
			if(blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar)
				return side == 4 || side == 5 ? this.DownRight : this.blockIcon;
			if(blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar)
				return side == 4 || side == 5 ? this.UpRight : this.blockIcon;
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar && blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar)
				return side == 4 || side == 5 ? this.UpLeft : this.blockIcon;
			
			//X & Z
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStonebrickPillar)
				return side == 4 ? this.Top : this.blockIcon2;	
			if(blockaccess.getBlock(x -1, y, z) == SABlockList.DStonebrickPillar)
				return side == 5 ? this.Top : this.blockIcon2;
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStonebrickPillar)
				return side == 1 || side == 0 ? this.blockIcon : side == 2 ? this.Top : this.blockIcon2;
			if(blockaccess.getBlock(x, y, z -1) == SABlockList.DStonebrickPillar)
				return side == 1 || side == 0 ? this.blockIcon : side == 3 ? this.Top : this.blockIcon2;
			
			//Z & Z
			if(blockaccess.getBlock(x, y +1, z) == SABlockList.DStonebrickPillar)
				return side == 0 ? this.Top : this.blockIcon;	
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStonebrickPillar)
				return side == 1 ? this.Top : this.blockIcon;
		}
		return side == 1 || side == 0 ? this.Top : this.blockIcon;
	}
	
    public IIcon getIcon(int par1, int par2)
    {
		if(par2 == 0)
		{
			return par2 == 0 && (par1 == 0 || par1 == 1) ? this.Top : this.blockIcon;
		}
		return blockIcon;
    }

	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("sevenno_addons:DStoneBrickLines_SouthNorth");
		this.blockIcon2 = iconRegister.registerIcon("sevenno_addons:DStoneBrickLines_EastWeast");
		this.Top = iconRegister.registerIcon("sevenno_addons:DStoneBrickLines_top");
		this.UpLeft = iconRegister.registerIcon("sevenno_addons:DStoneBrickLines_upLeft");
		this.UpRight = iconRegister.registerIcon("sevenno_addons:DStoneBrickLines_upRight");
		this.DownLeft = iconRegister.registerIcon("sevenno_addons:DStoneBrickLines_downLeft");
		this.DownRight = iconRegister.registerIcon("sevenno_addons:DStoneBrickLines_downRight");
		this.Cros = iconRegister.registerIcon("sevenno_addons:DStoneBrickLines_cros");
		this.North = iconRegister.registerIcon("sevenno_addons:DStoneBrickLines_north");
		this.East = iconRegister.registerIcon("sevenno_addons:DStoneBrickLines_east");
		this.South = iconRegister.registerIcon("sevenno_addons:DStoneBrickLines_south");
		this.West = iconRegister.registerIcon("sevenno_addons:DStoneBrickLines_west");
	}
}