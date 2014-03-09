package sevenno_addons.common.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class PurpleMushroomBlock_N2 extends Block
{
	
    @SideOnly(Side.CLIENT)
    private IIcon PMside;
    private IIcon PMbody;
	
	public PurpleMushroomBlock_N2() 
	{
		super(Material.wood);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}
		
		@SideOnly(Side.CLIENT)
		
	    public IIcon getIcon(int par1, int par2)
	    {
			if(par2 == 0)
			{
				return par2 == 0 && (par1 == 0 || par1 == 1 || par1 == 2 || par1 == 3 || par1 == 4 || par1 == 5) ? this.blockIcon : this.blockIcon;
			}
			if(par2 == 1)
			{
				return par2 == 1 && (par1 == 0 || par1 == 2 || par1 == 4) ? this.PMbody : this.blockIcon;
			}
			if(par2 == 2)
			{
				return par2 == 2 && (par1 == 0 || par1 == 2) ? this.PMbody : this.blockIcon;
			}
			if(par2 == 3)
			{
				return par2 == 3 && (par1 == 0 || par1 == 2 || par1 == 5) ? this.PMbody : this.blockIcon;
			}
			if(par2 == 4)
			{
				return par2 == 4 && (par1 == 0 || par1 == 4) ? this.PMbody : this.blockIcon;
			}
			if(par2 == 5)
			{
				return par2 == 5 && (par1 == 0) ? this.PMbody : this.blockIcon;
			}
			if(par2 == 6)
			{
				return par2 == 6 && (par1 == 0 || par1 == 5 ) ? this.PMbody : this.blockIcon;
			}
			if(par2 == 7)
			{
				return par2 == 7 && (par1 == 0 || par1 == 4 || par1 == 3) ? this.PMbody : this.blockIcon;
			}
			if(par2 == 8)
			{
				return par2 == 8 && (par1 == 0 || par1 == 3) ? this.PMbody : this.blockIcon;
			}
			if(par2 == 9)
			{
				return par2 == 9 && (par1 == 0 || par1 == 5 || par1 == 3) ? this.PMbody : this.blockIcon;
			}
			return blockIcon;
	    }

	    public void getSubBlocks(Item item, CreativeTabs creativetab, List list)
	    {
	    	list.add(new ItemStack(item, 1, 0));
	    }
	     
		public Item getItemDropped(int par1, Random par2Random, int par3)
	    {
			return Item.getItemFromBlock(SABlockList.PurpleMushroomBlock_N2);
	    }    

	    public Item itemPicked(World par1World, int par2, int par3, int par4)
	    {
	        return Item.getItemFromBlock(SABlockList.PurpleMushroomBlock_N2);
	    }
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon("sevenno_addons:purpleMushroomBlock_N");
		this.PMbody = iconRegister.registerIcon("sevenno_addons:purpleMushroomBlock_side");
		this.PMside = iconRegister.registerIcon("sevenno_addons:purpleMushroomBlock_body");
 	}
	
}