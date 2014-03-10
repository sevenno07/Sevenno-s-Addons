package sevenno_addons.common.item;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StrangeStick extends Item
{
    public StrangeStick()
    {
    	super();
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsItem);
    }
    
  	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("sevenno_addons:strangeStick");
 	}
}