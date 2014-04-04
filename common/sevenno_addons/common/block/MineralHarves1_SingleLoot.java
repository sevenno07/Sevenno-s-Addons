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

public class MineralHarves1_SingleLoot extends Block
{
	public static String[] type = new String[]{"Iron", "Tin", "Copper", "Silver"/*, "Gold", "Eliumite", "Vaccinium", "viridis", "subrufa"*/};
	
	private IIcon Iron;
	private IIcon Tin;
	private IIcon Copper;
	private IIcon Silver;
	
	public MineralHarves1_SingleLoot() 
	{
		super(Material.rock);
		this.setHarvestLevel("pickaxe", 1);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}
	
    public IIcon getIcon(int par1, int par2)
    {
		if(par2 == 0)
		{
			return par2 == 0 ? this.Iron : this.Iron;
		}
		if(par2 == 1)
		{
			return par2 == 1 ? this.Tin : this.Tin;
		}
		if(par2 == 2)
		{
			return par2 == 2 ? this.Copper : this.Copper;
		}
		if(par2 == 3)
		{
			return par2 == 3 ? this.Silver : this.Silver;
		}
		return blockIcon;
    }
	
    public void getSubBlocks(Item item, CreativeTabs creativetab, List list)
    {
    	list.add(new ItemStack(item, 1, 0));
    	list.add(new ItemStack(item, 1, 1));
    	list.add(new ItemStack(item, 1, 2));
    	list.add(new ItemStack(item, 1, 3));
    }

    public int damageDropped(int metadata)
    {
    	return metadata;
    }
    
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.Iron = iconRegister.registerIcon("sevenno_addons:DIron");
		this.Tin = iconRegister.registerIcon("sevenno_addons:DTin");
		this.Copper = iconRegister.registerIcon("sevenno_addons:DCopper");
		this.Silver = iconRegister.registerIcon("sevenno_addons:DSilver");
	}
}