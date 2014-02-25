package genetical_modifier.common.creativetabs;

import genetical_modifier.common.Genetical_modifier;
import net.minecraft.creativetab.CreativeTabs;

public class GeneticalModifierCreativeTabs
{
	public static CreativeTabs GMCreativeTabsBlock;
//	public static CreativeTabs GMCreativeTabsItem;
//	public static CreativeTabs GMCreativeTabsArmor;
//	public static CreativeTabs GMCreativeTabsTool;
//	public static CreativeTabs GMCreativeTabsFood;
	
	public static void loadCreativeTab()
	{
		try
		{
			GMCreativeTabsBlock = new GMCreativeTabsBlock("GmCreativeTabsBlock");
//			GMCreativeTabsItem = new GMCreativeTabsItem("GMCreativeTabsItem");
//			GMCreativeTabsArmor = new GMCreativeTabsArmor("GMCreativeTabsArmor");
//			GMCreativeTabsTool = new GMCreativeTabsTool("GMCreativeTabsTool");
//			GMCreativeTabsFood = new GMCreativeTabsFood("GMCreativeTabsFood");
		}
		catch(Exception ex)
		{
			Genetical_modifier.GMlog.severe("Erreur lors de l'initialisation des CreativeTabs!");	
		}
		Genetical_modifier.GMlog.info("Initialisation des CreativeTabs terminées!");
	}
}