package genetical_modifier.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import genetical_modifier.common.creativetabs.GeneticalModifierCreativeTabs;
import genetical_modifier.common.tileentity.EntityInvertedRedstoneLamp;

public class InvertedRedstoneLamp extends Block
{
	public static String[] type = new String[]{"redstone_lamp_off", "redstone_lamp_on"};
	private IIcon[] IconArray;
	
	public InvertedRedstoneLamp() 
	{
		super(Material.redstoneLight);
		this.setCreativeTab(GeneticalModifierCreativeTabs.GMCreativeTabsBlock);
	}
	
	public int getLightValue(IBlockAccess world, int x, int y, int z)
	{
		if(world.getBlockMetadata(x, y, z) == 0)
		{
			return 15;
		}
		return 0;
	}
	
	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		return new EntityInvertedRedstoneLamp();
	}
	
	public boolean hasTileEntity(int metadata)
	{
		return true;
	}
	
	public void registerBlockIcons(IIconRegister iconregister)
	{
		IconArray = new IIcon[type.length];
		for(int i = 0; i < type.length; i++)
		{
			IconArray[i] = iconregister.registerIcon("genetical_modifier:" + type[i]);
		}
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		return metadata < type.length && metadata >= 0 ? IconArray[metadata] : IconArray[0];
	}
}