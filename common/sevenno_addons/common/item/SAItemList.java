package sevenno_addons.common.item;

import net.minecraft.item.Item;
import sevenno_addons.common.Sevenno_addons;
import sevenno_addons.common.block.SABlockList;
import cpw.mods.fml.common.registry.GameRegistry;

public class SAItemList
{
	public static Item CoalReed;

	public static void loadItem()
	{
		try
		{
			CoalReed = new CoalReed(SABlockList.CoalReedBlock,SABlockList.SPReedBooster).setUnlocalizedName("CoalReed");
			
			//register
			GameRegistry.registerItem(CoalReed, "Coal Reed");

		}catch(Exception ex)
		{
			Sevenno_addons.SAlog.severe("Erreur lors de l'initialisation des Items!");
		}
		Sevenno_addons.SAlog.info("Initialisation des Items terminés!");
	}
}