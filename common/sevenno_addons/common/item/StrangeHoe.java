package sevenno_addons.common.item;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class StrangeHoe extends ItemHoe
{
	public StrangeHoe(ToolMaterial toolmaterial)
	{
		super(toolmaterial);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsTool);
	}
	
	public boolean getIsRepairable(ItemStack stack, ItemStack outputstack)
	{
		return true;
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("sevenno_addons:strangeHoe");
 	}
}