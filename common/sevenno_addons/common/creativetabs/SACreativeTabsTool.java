package sevenno_addons.common.creativetabs;

import sevenno_addons.common.item.SAItemList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SACreativeTabsTool extends CreativeTabs
{
	public SACreativeTabsTool(String name)
	{
		super(name);
	}

	@Override
	public Item getTabIconItem()
	{
		return SAItemList.SuperPickaxe;
	}
}
