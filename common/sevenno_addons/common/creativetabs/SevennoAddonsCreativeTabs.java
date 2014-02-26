package sevenno_addons.common.creativetabs;

import sevenno_addons.common.Sevenno_addons;
import net.minecraft.creativetab.CreativeTabs;

public class SevennoAddonsCreativeTabs
{
	public static CreativeTabs SACreativeTabsBlock;
//	public static CreativeTabs SACreativeTabsItem;
//	public static CreativeTabs SACreativeTabsArmor;
//	public static CreativeTabs SACreativeTabsTool;
//	public static CreativeTabs SACreativeTabsFood;
	
	public static void loadCreativeTab()
	{
		try
		{
			SACreativeTabsBlock = new SACreativeTabsBlock("SACreativeTabsBlock");
//			SACreativeTabsItem = new SACreativeTabsItem("SACreativeTabsItem");
//			SACreativeTabsArmor = new SACreativeTabsArmor("SACreativeTabsArmor");
//			SACreativeTabsTool = new SACreativeTabsTool("SACreativeTabsTool");
//			SACreativeTabsFood = new SACreativeTabsFood("SACreativeTabsFood");
		}
		catch(Exception ex)
		{
			Sevenno_addons.SAlog.severe("Erreur lors de l'initialisation des CreativeTabs!");	
		}
		Sevenno_addons.SAlog.info("Initialisation des CreativeTabs terminées!");
	}
}