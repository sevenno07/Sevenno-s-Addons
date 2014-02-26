package sevenno_addons.common.creativetabs;

import sevenno_addons.common.block.SABlockList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SACreativeTabsBlock extends CreativeTabs
{
	public SACreativeTabsBlock(String name)
	{
		super(name);
	}

	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(SABlockList.WoodenBox);
	}
}