package sevenno_addons.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class RDArmor extends ItemArmor
{
	public RDArmor(ArmorMaterial armorMaterial, int type, int layer)
	{
		super(armorMaterial, type, layer);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsArmor);
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(stack.getItem().equals(SAItemList.RDLeggings))
		{
			return "sevenno_addons:textures/armor/RDArmor_2.png";
		}
		else
		{
			return "sevenno_addons:textures/armor/RDArmor_1.png";
		}
	}
	
	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		if(stack.getItem().equals(this) && repairItem.getItem() == SAItemList.ReinforcementGem)
		{
			return true;
		}
		return false;
	}
	
  	@SideOnly(Side.CLIENT)
  	public boolean hasEffect(ItemStack par1ItemStack)
  	{
  		return true;
  	}
}