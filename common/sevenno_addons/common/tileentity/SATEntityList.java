package sevenno_addons.common.tileentity;

import sevenno_addons.common.Sevenno_addons;
import cpw.mods.fml.common.registry.GameRegistry;

public class SATEntityList
{
	public static void loadTileEntity()
	{
		try
		{
			GameRegistry.registerTileEntity(EntityInvertedRedstoneLamp.class, "EntityInvertedRedstoneLamp");
			GameRegistry.registerTileEntity(TileEntityWoodenBoxGUI.class, "TileEntityWoodenBoxGUI");
		}
		catch(Exception ex)
		{
			Sevenno_addons.SAlog.severe("Erreur lors de l'initialisation des TileEntity's!");
		}
		Sevenno_addons.SAlog.info("Initialisation des TileEntity's terminés!");
	}
}
