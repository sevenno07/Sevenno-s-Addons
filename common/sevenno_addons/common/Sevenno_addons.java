package sevenno_addons.common;

import sevenno_addons.common.block.SABlockList;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import sevenno_addons.common.event.BottleEvent;
//import sevenno_addons.common.event.PlayerRenderEvent;
import sevenno_addons.proxy.SACommonProxy;
import sevenno_addons.common.gui.GuiHandler;
import sevenno_addons.common.item.SAItemList;
import sevenno_addons.common.recipe.SARecipe;
import sevenno_addons.common.tileentity.SATEntityList;

import java.util.logging.Logger;





import net.minecraftforge.common.MinecraftForge;
//import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = "sevenno_addons", name = "Sevenno's addons", version = "1.0.1")

public class Sevenno_addons
{
	@SidedProxy(clientSide = "sevenno_addons.proxy.SAClientProxy", serverSide = "sevenno_addons.proxy.SACommonProxy")
	public static SACommonProxy proxy;
	
	@Instance("sevenno_addons")
	public static Sevenno_addons instance;

	public static Logger SAlog = Logger.getLogger("Sevenno_Addons");

	protected static final GuiHandler GuiHandler = new GuiHandler();

	@EventHandler
	public void preload(FMLPreInitializationEvent event)
	{
		SevennoAddonsCreativeTabs.loadCreativeTab();// CreativeTab
		SABlockList.loadBlock();// Block
		SAItemList.loadItem();// Item
//		SAAchievements.loadAchievements();

		proxy.initSound();// Sound
		
/*		if(event.getSide().isClient())
		{
			MinecraftForge.EVENT_BUS.register(new PlayerRenderEvent());
		}*/
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
//		SAEntityList.loadEntity();// Entity

		proxy.registerRender();
		proxy.registerRenderEntity();
		
		MinecraftForge.EVENT_BUS.register(new BottleEvent());
		// *1

		SATEntityList.loadTileEntity();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, GuiHandler);
	}

	@EventHandler
	public void modloaded(FMLPostInitializationEvent event)
	{
		SARecipe.loadRecipe();// Recipe
		SARecipe.loadSmelting();// Smelting
	}
}