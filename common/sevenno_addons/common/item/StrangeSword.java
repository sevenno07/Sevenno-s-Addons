package sevenno_addons.common.item;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StrangeSword extends ItemSword
{
	public StrangeSword(ToolMaterial toolmaterial)
	{
		super(toolmaterial);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsArmor);
	}
	
	public boolean getIsRepairable(ItemStack stack, ItemStack outputstack)
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("sevenno_addons:strangeSword");
 	}
}