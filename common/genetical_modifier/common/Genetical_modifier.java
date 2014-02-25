package genetical_modifier.common;

import genetical_modifier.common.block.GMBlockList;
import genetical_modifier.common.creativetabs.GeneticalModifierCreativeTabs;
import genetical_modifier.proxy.GMCommonProxy;
import genetical_modifier.common.gui.GuiHandler;
import genetical_modifier.common.tileentity.GMTEntityList;

import java.util.logging.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = "genetical_modifier", name = "Genetical modifier", version = "1.0.1")

public class Genetical_modifier
{
	@SidedProxy(clientSide = "genetical_modifier.proxy.GMClientProxy", serverSide = "genetical_modifier.proxy.GMCommonProxy")
	public static GMCommonProxy proxy;

	@Instance("genetical_modifier")
	public static Genetical_modifier instance;

	public static Logger GMlog = Logger.getLogger("Genetical_Modifier");

	protected static final GuiHandler GuiHandler = new GuiHandler();

	@EventHandler
	public void preload(FMLPreInitializationEvent event)
	{
		GeneticalModifierCreativeTabs.loadCreativeTab();// CreativeTab
		GMBlockList.loadBlock();// Block
//		GMItemList.loadItem();// Item
//		GMAchievements.loadAchievements();

		proxy.initSound();// Sound
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
//		GMEntityList.loadEntity();// Entity

		proxy.registerRender();
		proxy.registerRenderEntity();

		// *1

		GMTEntityList.loadTileEntity();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, GuiHandler);
	}

	@EventHandler
	public void modloaded(FMLPostInitializationEvent event)
	{
//		GMRecipe.loadRecipe();// Recipe
//		GMRecipe.loadSmelting();// Smelting
	}
}