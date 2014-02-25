package genetical_modifier.common.tileentity;

import nether_plus.common.Nether_plus;
import cpw.mods.fml.common.registry.GameRegistry;

public class GMTEntityList
{
	public static void loadTileEntity()
	{
		try
		{
			GameRegistry.registerTileEntity(EntityInvertedRedstoneLamp.class, "EntityInvertedRedstoneLamp");
		}
		catch(Exception ex)
		{
		Nether_plus.NPlog.severe("Erreur lors de l'initialisation des TileEntity's!");
		}
		Nether_plus.NPlog.info("Initialisation des TileEntity's terminés!");
	}
}
