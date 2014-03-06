package sevenno_addons.common.item;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ReinforcementGem extends Item
{
    public ReinforcementGem()
    {
    	super();
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsItem);
    }
    
  	@SideOnly(Side.CLIENT)
  	public boolean hasEffect(ItemStack par1ItemStack)
  	{
  		return true;
  	}
    
  	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("sevenno_addons:ReinforcementGem");
 	}
}