package sevenno_addons.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DGoldenSandstone extends Block
{

	public static String[] type = new String[]{"normal", "brick", "smooth", "carved"};
	private IIcon[] IconArray;
	
    @SideOnly(Side.CLIENT)
    private IIcon Top;
    private IIcon Bottom;
    private IIcon Normal;
    private IIcon Brick;
    private IIcon Smooth;
    private IIcon Carved;
	
	public DGoldenSandstone()
	{
		super(Material.rock);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
	}

    public IIcon getIcon(int par1, int par2)
    {
		if(par2 == 0)
		{
			return par2 == 0 && par1 == 0 ? this.Bottom : par1 == 1 ? this.Top : this.Normal;
		}
		if(par2 == 1)
		{
			return par2 == 1 && (par1 == 0 || par1 == 1) ? this.Top : this.Brick;
		}
		if(par2 == 2)
		{
			return par2 == 2 && (par1 == 0 || par1 == 1) ? this.Top : this.Smooth;
		}
		if(par2 == 3)
		{
			return par2 == 3 && (par1 == 0 || par1 == 1) ? this.Top : this.Carved;
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
    	IconArray = new IIcon[type.length];
    	for(int i = 0; i < type.length; i++)
    	{
    		this.Top = iconRegister.registerIcon("sevenno_addons:DGoldenSandstone_top");
    		this.Bottom = iconRegister.registerIcon("sevenno_addons:DGoldenSandstone_bottom");
    		this.Normal = iconRegister.registerIcon("sevenno_addons:DGoldenSandstone_normal");
    		this.Brick = iconRegister.registerIcon("sevenno_addons:DGoldenSandstone_brick");
    		this.Smooth = iconRegister.registerIcon("sevenno_addons:DGoldenSandstone_smooth");
    		this.Carved = iconRegister.registerIcon("sevenno_addons:DGoldenSandstone_carved");
    	}
    }
}
