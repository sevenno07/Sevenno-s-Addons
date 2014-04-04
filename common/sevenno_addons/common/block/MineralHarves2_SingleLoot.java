package sevenno_addons.common.block;

import java.util.List;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class MineralHarves2_SingleLoot extends Block
{
	public static String[] type = new String[]{"Gold"};
	
	private IIcon Gold;
	
	public MineralHarves2_SingleLoot() 
	{
		super(Material.rock);
		this.setHarvestLevel("pickaxe", 2);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}
	
    public IIcon getIcon(int par1, int par2)
    {
		if(par2 == 0)
		{
			return par2 == 0 ? this.Gold : this.Gold;
		}
		return blockIcon;
    }
	
    public void getSubBlocks(Item item, CreativeTabs creativetab, List list)
    {
    	list.add(new ItemStack(item, 1, 0));
    }

    public int damageDropped(int metadata)
    {
    	return metadata;
    }
    
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.Gold = iconRegister.registerIcon("sevenno_addons:DGold");
	}
}