package sevenno_addons.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DStoneBrick extends Block
{
	
	public static String[] type = new String[]{"Line", "brick1", "brick2", "brick3", "brick4", "brick5", "brick6", "brick7", "brick8", "brick9", "brick10", "brick11", "brick12"};
	private IIcon[] IconArray;
	
    @SideOnly(Side.CLIENT)
    private IIcon Brick1;
    private IIcon Brick2;
    private IIcon Brick3;
    private IIcon Brick4;
    private IIcon Brick5;
    private IIcon Brick6;
    private IIcon Brick7;
    private IIcon Brick8;
    private IIcon Brick9;
    private IIcon Brick10;
    private IIcon Brick11;
    private IIcon Brick12_top;
    private IIcon Brick12_side;
    //Line
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
	
	public DStoneBrick()
	{
		super(Material.rock);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess blockaccess, int x, int y, int z, int side)
	{
		if (blockaccess.getBlockMetadata(x, y, z) == 11)
		{
			//X & Z
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z +1) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11)
				return side == 1 || side == 0 ? this.Cros : this.blockIcon2;
			//X & Y
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y +1, z) == 11 && blockaccess.getBlockMetadata(x, y -1, z) == 11)
				return side == 2 || side == 3 ? this.Cros : this.blockIcon2;
			//Y & Z
			if(blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y +1, z) == 11 && blockaccess.getBlockMetadata(x, y -1, z) == 11 && blockaccess.getBlockMetadata(x, y, z +1) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11)
				return side == 4 || side == 5 ? this.Cros : this.blockIcon2;
			
			//groove UP/DOWN
			if(blockaccess.getBlock(x , y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x , y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y +1, z) == 11 && blockaccess.getBlockMetadata(x, y -1, z) == 11 && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z +1) == 11)
				return side == 2 ? this.East : side == 4 ? this.East : this.Top;
			if(blockaccess.getBlock(x , y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x , y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y +1, z) == 11 && blockaccess.getBlockMetadata(x, y -1, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11)
				return side == 3 ? this.West : side == 5 ? this.West : this.Top;
			if(blockaccess.getBlock(x , y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x , y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y +1, z) == 11 && blockaccess.getBlockMetadata(x, y -1, z) == 11 && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11)
				return side == 3 ? this.East : side == 4 ? this.West : this.Top;
			if(blockaccess.getBlock(x , y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x , y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y +1, z) == 11 && blockaccess.getBlockMetadata(x, y -1, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z +1) == 11)
				return side == 2 ? this.West : side == 5 ? this.East : this.Top;
			
			//groove NORTH/SOUTH
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y, z +1) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11 && blockaccess.getBlockMetadata(x, y +1, z) == 11 && blockaccess.getBlockMetadata(x +1, y, z) == 11)
				return side == 0 ? this.East : side == 4 ? this.North : this.Top;
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y, z +1) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11 && blockaccess.getBlockMetadata(x, y +1, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11)
				return side == 0 ? this.West : side == 5 ? this.North : this.Top;
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y, z +1) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11 && blockaccess.getBlockMetadata(x, y -1, z) == 11 && blockaccess.getBlockMetadata(x +1, y, z) == 11)
				return side == 1 ? this.East : side == 4 ? this.South : this.Top;
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y, z +1) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11 && blockaccess.getBlockMetadata(x, y -1, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11)
				return side == 1 ? this.West : side == 5 ? this.South : this.Top;
			
			//groove EAST/WEST
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y +1, z) == 11 && blockaccess.getBlockMetadata(x, y, z +1) == 11)
				return side == 0 ? this.South : side == 2 ? this.North : this.Top;
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y +1, z) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11)
				return side == 0 ? this.North : side == 3 ? this.North : this.Top;
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y -1, z) == 11 && blockaccess.getBlockMetadata(x, y, z +1) == 11)
				return side == 1 ? this.South : side == 2 ? this.South : this.Top;
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y -1, z) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11)
				return side == 1 ? this.North : side == 3 ? this.South : this.Top;
			
			//X & Z
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11)
				return side == 1 || side == 0 ? this.North : this.blockIcon2;
			if(blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y, z -1) == 11 && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z +1) == 11)
				return side == 1 || side == 0 ? this.East : this.blockIcon2;
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z +1) == 11)
				return side == 1 || side == 0 ? this.South : this.blockIcon2;
			if(blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y, z -1) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z +1) == 11)
				return side == 1 || side == 0 ? this.West : this.blockIcon2;
			
			//X & Y
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y -1, z) == 11)
				return side == 2 || side == 3 ? this.South : this.blockIcon2;
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y -1, z) == 11 && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x, y +1, z) == 11)
				return side == 2 || side == 3 ? this.East : this.blockIcon;
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y +1, z) == 11)
				return side == 2 || side == 3 ? this.North : this.blockIcon2;
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y -1, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y +1, z) == 11)
				return side == 2 || side == 3 ? this.West : this.blockIcon;
			
			//Y & Z
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y, z +1) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11 && blockaccess.getBlockMetadata(x, y -1, z) == 11)
				return side == 4 || side == 5 ? this.South : this.blockIcon;
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y -1, z) == 11 && blockaccess.getBlockMetadata(x, y, z +1) == 11 && blockaccess.getBlockMetadata(x, y +1, z) == 11)
				return side == 4 || side == 5 ? this.East : this.blockIcon;
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y, z +1) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11 && blockaccess.getBlockMetadata(x, y +1, z) == 11)
				return side == 4 || side == 5 ? this.North : this.blockIcon;
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y -1, z) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11 && blockaccess.getBlockMetadata(x, y +1, z) == 11)
				return side == 4 || side == 5 ? this.West : this.blockIcon;

			//cornerUP
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y -1, z) == 11 && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z +1) == 11)
				return side == 1 ? this.UpLeft : side == 2 ? this.UpLeft : side == 4 ? this.UpLeft : this.Top;
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y -1, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11)
				return side == 1 ? this.DownRight : side == 3 ? this.UpRight : side == 5 ? this.UpRight : this.Top;
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y -1, z) == 11 && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11)
				return side == 1 ? this.DownLeft : side == 3 ? this.UpLeft : side == 4 ? this.UpRight : this.Top;
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y -1, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z +1) == 11)
				return side == 1 ? this.UpRight : side == 2 ? this.UpRight : side == 5 ? this.UpLeft : this.Top;
			
			//cornerDOWN
			if(blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y +1, z) == 11 && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z +1) == 11)
				return side == 1 ? this.DownLeft : side == 2 ? this.DownLeft : side == 4 ? this.DownLeft : this.Top;
			if(blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y +1, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11)
				return side == 1 ? this.UpRight : side == 3 ? this.DownRight : side == 5 ? this.DownRight : this.Top;
			if(blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y +1, z) == 11 && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11)
				return side == 1 ? this.UpLeft : side == 3 ? this.DownLeft : side == 4 ? this.DownRight : this.Top;
			if(blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y +1, z) == 11 && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z +1) == 11)
				return side == 1 ? this.DownRight : side == 2 ? this.DownRight : side == 5 ? this.DownLeft : this.Top;
			
			//X & Z
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z +1) == 11)
				return side == 1 || side == 0 ? this.UpLeft : this.blockIcon2;
			if(blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z +1) == 11)
				return side == 1 || side == 0 ? this.UpRight : this.blockIcon2;
			if(blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11)
				return side == 1 || side == 0 ? this.DownRight : this.blockIcon2;
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x, y, z -1) == 11)
				return side == 1 || side == 0 ? this.DownLeft : this.blockIcon2;
			
			//X & Y
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x, y +1, z) == 11)
				return side == 2 || side == 3 ? this.DownLeft : side == 0 ? this.blockIcon2 : this.blockIcon;
			if(blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y +1, z) == 11)
				return side == 2 || side == 3 ? this.DownRight : side == 0 ? this.blockIcon2 : this.blockIcon;
			if(blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x -1, y, z) == 11 && blockaccess.getBlockMetadata(x, y -1, z) == 11)
				return side == 2 || side == 3 ? this.UpRight : side == 1 ? this.blockIcon2 : this.blockIcon;
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x +1, y, z) == 11 && blockaccess.getBlockMetadata(x, y -1, z) == 11)
				return side == 2 || side == 3 ? this.UpLeft : side == 1 ? this.blockIcon2 : this.blockIcon;
			
			//Y & Z
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y, z +1) == 11 && blockaccess.getBlockMetadata(x, y +1, z) == 11)
				return side == 4 || side == 5 ? this.DownLeft : this.blockIcon;
			if(blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y, z -1) == 11 && blockaccess.getBlockMetadata(x, y +1, z) == 11)
				return side == 4 || side == 5 ? this.DownRight : this.blockIcon;
			if(blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y, z -1) == 11 && blockaccess.getBlockMetadata(x, y -1, z) == 11)
				return side == 4 || side == 5 ? this.UpRight : this.blockIcon;
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y, z +1) == 11 && blockaccess.getBlockMetadata(x, y -1, z) == 11)
				return side == 4 || side == 5 ? this.UpLeft : this.blockIcon;
			
			//X & Z
			if(blockaccess.getBlock(x +1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x +1, y, z) == 11)
				return side == 4 ? this.Top : this.blockIcon2;	
			if(blockaccess.getBlock(x -1, y, z) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x -1, y, z) == 11)
				return side == 5 ? this.Top : this.blockIcon2;
			if(blockaccess.getBlock(x, y, z +1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y, z +1) == 11)
				return side == 1 || side == 0 ? this.blockIcon : side == 2 ? this.Top : this.blockIcon2;
			if(blockaccess.getBlock(x, y, z -1) == SABlockList.DStoneBrick && blockaccess.getBlockMetadata(x, y, z -1) == 11)
				return side == 1 || side == 0 ? this.blockIcon : side == 3 ? this.Top : this.blockIcon2;
			
			//Z & Z
			if(blockaccess.getBlock(x, y +1, z) == SABlockList.DStoneBrick)
				return side == 0 ? this.Top : this.blockIcon;	
			if(blockaccess.getBlock(x, y -1, z) == SABlockList.DStoneBrick)
				return side == 1 ? this.Top : this.blockIcon;
			
			return side == 1 || side == 0 ? this.Top : this.blockIcon;
		}
		return this.getIcon(side, blockaccess.getBlockMetadata(x, y, z));
	}

	    public IIcon getIcon(int par1, int par2)
	    {
			if(par2 == 0)
			{
				return par2 == 0 ? this.Brick1 : this.Brick1;
			}
			if(par2 == 1)
			{
				return par2 == 1 && (par1 == 0 || par1 == 1) ? this.Brick1 : this.Brick2;
			}
			if(par2 == 2)
			{
				return par2 == 2 ? this.Brick3 : this.Brick3;
			}
			if(par2 == 3)
			{
				return par2 == 3 ? this.Brick4 : this.Brick4;
			}
			if(par2 == 4)
			{
				return par2 == 4 ? this.Brick5 : this.Brick5;
			}
			if(par2 == 5)
			{
				return par2 == 5 ? this.Brick6 : this.Brick6;
			}
			if(par2 == 6)
			{
				return par2 == 6 && (par1 == 0 || par1 == 1) ? this.Brick1 : this.Brick7;
			}
			if(par2 == 7)
			{
				return par2 == 7 && (par1 == 0 || par1 == 1) ? this.Brick1 : this.Brick8;
			}
			if(par2 == 8)
			{
				return par2 == 8 && (par1 == 0 || par1 == 1) ? this.Brick1 : this.Brick9;
			}
			if(par2 == 9)
			{
				return par2 == 9 && (par1 == 0 || par1 == 1) ? this.Brick1 : this.Brick10;
			}
			if(par2 == 10)
			{
				return par2 == 10 && (par1 == 0 || par1 == 1) ? this.Brick1 : this.Brick11;
			}
			if(par2 == 11)
			{
				return par2 == 11 && (par1 == 0 || par1 == 1) ? this.Top : this.blockIcon;
			}
			if(par2 == 12)
			{
				return par2 == 12 && (par1 == 0 || par1 == 1) ? this.Brick12_top : this.Brick12_side;
			}
			return blockIcon;
	    }
		
	    public void getSubBlocks(Item item, CreativeTabs creativetab, List list)
	    {
	    	list.add(new ItemStack(item, 1, 0));
	    	list.add(new ItemStack(item, 1, 1));
	    	list.add(new ItemStack(item, 1, 2));
	    	list.add(new ItemStack(item, 1, 3));
	    	list.add(new ItemStack(item, 1, 4));
	    	list.add(new ItemStack(item, 1, 5));
	    	list.add(new ItemStack(item, 1, 6));
	    	list.add(new ItemStack(item, 1, 7));
	    	list.add(new ItemStack(item, 1, 8));
	    	list.add(new ItemStack(item, 1, 9));
	    	list.add(new ItemStack(item, 1, 10));
	    	list.add(new ItemStack(item, 1, 11));
	    	list.add(new ItemStack(item, 1, 12));
	    }

	    public int damageDropped(int metadata)
	    {
	    	return metadata;
	    }
  
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		IconArray = new IIcon[type.length];
		for(int i = 0; i < type.length; i++)
		{
			this.Brick1 = iconRegister.registerIcon("sevenno_addons:DStoneBrick_1");
			this.Brick2 = iconRegister.registerIcon("sevenno_addons:DStoneBrick_2");
			this.Brick3 = iconRegister.registerIcon("sevenno_addons:DStoneBrick_3");
			this.Brick4 = iconRegister.registerIcon("sevenno_addons:DStoneBrick_4");
			this.Brick5 = iconRegister.registerIcon("sevenno_addons:DStoneBrick_5");
			this.Brick6 = iconRegister.registerIcon("sevenno_addons:DStoneBrick_6");
			this.Brick7 = iconRegister.registerIcon("sevenno_addons:DStoneBrick_7");
			this.Brick8 = iconRegister.registerIcon("sevenno_addons:DStoneBrick_8");
			this.Brick9 = iconRegister.registerIcon("sevenno_addons:DStoneBrick_9");
			this.Brick10 = iconRegister.registerIcon("sevenno_addons:DStoneBrick_10");
			this.Brick11 = iconRegister.registerIcon("sevenno_addons:DStoneBrick_11");
			this.Brick12_top = iconRegister.registerIcon("sevenno_addons:DStoneBrick_12_top");
			this.Brick12_side = iconRegister.registerIcon("sevenno_addons:DStoneBrick_12_side");
			//Line
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
}