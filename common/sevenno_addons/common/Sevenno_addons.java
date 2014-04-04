package sevenno_addons.common;

import sevenno_addons.common.block.PushButton_off;
import sevenno_addons.common.block.PushButton_on;
import sevenno_addons.common.block.SABlockList;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import sevenno_addons.common.dimension.SAD_WorldProvider;
import sevenno_addons.common.event.BlockChanger;
import sevenno_addons.common.event.BottleEvent;
import sevenno_addons.common.event.BucketEvent;
import sevenno_addons.common.event.Burin;
import sevenno_addons.common.event.SeparatorEvent;
//import sevenno_addons.common.event.PlayerRenderEvent;
import sevenno_addons.proxy.SACommonProxy;
import sevenno_addons.common.gui.GuiHandler;
import sevenno_addons.common.item.SAItemList;
import sevenno_addons.common.recipe.SARecipe;
import sevenno_addons.common.tileentity.SATEntityList;
import sevenno_addons.common.world.WorldGeneration;

import java.util.logging.Logger;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
//import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "sevenno_addons", name = "Sevenno's addons", version = "1.0.1")

public class Sevenno_addons
{
	public static int dimID;
	public int mainBiomeID;
	
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
		
		//TODO
	    Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	    try
	    {
	    	config.load();
	    	dimID = config.get("World", "Dimension ID", 4).getInt();
	        this.mainBiomeID = config.get("World", "Main Biome ID (MAX : 128)", 75).getInt();
	        config.save();
	    }
	    finally
	    {
	    	if (config.hasChanged())
	    	{
	    		config.save();
	    	}
	    }
	}

	@EventHandler
	public void load(FMLInitializationEvent event)
	{
//		SAEntityList.loadEntity();// Entity

		DimensionManager.registerProviderType(dimID, SAD_WorldProvider.class, false);
	    DimensionManager.registerDimension(dimID, dimID);
//		GameRegistry.registerWorldGenerator(new DragonWorldgenerator(), 0);
		
		proxy.registerRender();
		proxy.registerRenderEntity();
		
		MinecraftForge.EVENT_BUS.register(new BottleEvent());
		MinecraftForge.EVENT_BUS.register(new BucketEvent());
		MinecraftForge.EVENT_BUS.register(new SeparatorEvent());
		MinecraftForge.EVENT_BUS.register(new BlockChanger());
		MinecraftForge.EVENT_BUS.register(new Burin());
		// *1

		SATEntityList.loadTileEntity();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, GuiHandler);
		GameRegistry.registerWorldGenerator(new WorldGeneration(), 0);
	}

	@EventHandler
	public void modloaded(FMLPostInitializationEvent event)
	{
		SARecipe.loadRecipe();// Recipe
		SARecipe.loadSmelting();// Smelting
	}
}