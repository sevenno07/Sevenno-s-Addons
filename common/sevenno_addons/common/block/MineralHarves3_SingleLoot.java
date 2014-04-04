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

public class MineralHarves3_SingleLoot extends Block
{
	public static String[] type = new String[]{"Vaccinium", "viridis", "subrufa"};

	private IIcon Vaccinium;
	private IIcon viridis;
	private IIcon subrufa;
	
	public MineralHarves3_SingleLoot() 
	{
		super(Material.rock);
		this.setHarvestLevel("pickaxe", 3);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}
	
    public IIcon getIcon(int par1, int par2)
    {
		if(par2 == 0)
		{
			return par2 == 1 ? this.Vaccinium : this.Vaccinium;
		}
		if(par2 == 1)
		{
			return par2 == 2 ? this.viridis : this.viridis;
		}
		if(par2 == 2)
		{
			return par2 == 3 ? this.subrufa : this.subrufa;
		}
		return blockIcon;
    }
	
    public void getSubBlocks(Item item, CreativeTabs creativetab, List list)
    {
    	list.add(new ItemStack(item, 1, 0));
    	list.add(new ItemStack(item, 1, 1));
    	list.add(new ItemStack(item, 1, 2));
    }

    public int damageDropped(int metadata)
    {
    	return metadata;
    }
    
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.Vaccinium = iconRegister.registerIcon("sevenno_addons:DVaccinium");
		this.viridis = iconRegister.registerIcon("sevenno_addons:Dviridis");
		this.subrufa = iconRegister.registerIcon("sevenno_addons:Dsubrufa");
	}
}