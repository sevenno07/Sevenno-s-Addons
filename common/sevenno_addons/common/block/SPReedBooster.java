package sevenno_addons.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SPReedBooster extends Block
{
    @SideOnly(Side.CLIENT)
	private IIcon icontop;

	public SPReedBooster() 
	{
		super(Material.rock);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}
	
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon("sevenno_addons:spReedBooster");
		icontop = iconRegister.registerIcon("sevenno_addons:spReedBooster_top");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		return side == 1 ? icontop : blockIcon;
	}
}