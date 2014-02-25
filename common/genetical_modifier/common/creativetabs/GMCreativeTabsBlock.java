package genetical_modifier.common.creativetabs;

import genetical_modifier.common.block.GMBlockList;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class GMCreativeTabsBlock extends CreativeTabs
{
	public GMCreativeTabsBlock(String name)
	{
		super(name);
	}

	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(GMBlockList.WoodenBox);
	}
}