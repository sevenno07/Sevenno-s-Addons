package sevenno_addons.common.creativetabs;

import sevenno_addons.common.item.SAItemList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SACreativeTabsItem extends CreativeTabs
{
	public SACreativeTabsItem(String name)
	{
		super(name);
	}

	@Override
	public Item getTabIconItem()
	{
		return SAItemList.CoalReed;
	}
}