package sevenno_addons.common.item;

import net.minecraft.item.ItemFood;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;

public class Cherry extends ItemFood
{

	public Cherry(int hunger, float duration, boolean wolf)
	{
		super(hunger, duration, wolf);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsItem);
	}
}