package sevenno_addons.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import sevenno_addons.common.Sevenno_addons;
import sevenno_addons.common.block.SABlockList;
import cpw.mods.fml.common.registry.GameRegistry;

public class SAItemList
{
	public static Item CoalReed;
	public static Item IronReed;
	public static Item GoldReed;
	public static Item DiamondReed;
	public static Item EmeraldReed;
	public static Item RedstoneReed;
	public static Item LapisReed;
	public static Item GlowstoneReed;
	public static Item QuartzReed;
	
	public static Item RedstoneWire;

	public static void loadItem()
	{
		try
		{
			CoalReed = new CoalReed(SABlockList.CoalReedBlock).setUnlocalizedName("CoalReed").setTextureName("sevenno_addons:coalReed");
			IronReed = new IronReed(SABlockList.IronReedBlock).setUnlocalizedName("IronReed").setTextureName("sevenno_addons:ironReed");
			GoldReed = new GoldReed(SABlockList.GoldReedBlock).setUnlocalizedName("GoldReed").setTextureName("sevenno_addons:goldReed");
			DiamondReed = new DiamondReed(SABlockList.DiamondReedBlock).setUnlocalizedName("DiamondReed").setTextureName("sevenno_addons:diamondReed");
			EmeraldReed = new EmeraldReed(SABlockList.EmeraldReedBlock).setUnlocalizedName("EmeraldReed").setTextureName("sevenno_addons:emeraldReed");
			RedstoneReed = new RedstoneReed(SABlockList.RedstoneReedBlock).setUnlocalizedName("RedstoneReed").setTextureName("sevenno_addons:redstoneReed");
			LapisReed = new LapisReed(SABlockList.LapisReedBlock).setUnlocalizedName("LapisReed").setTextureName("sevenno_addons:lapisReed");
			GlowstoneReed = new GlowstoneReed(SABlockList.GlowstoneReedBlock).setUnlocalizedName("GlowstoneReed").setTextureName("sevenno_addons:glowstoneReed");
			QuartzReed = new QuartzReed(SABlockList.QuartzReedBlock).setUnlocalizedName("QuartzReed").setTextureName("sevenno_addons:quartzReed");
			
			RedstoneWire = new RedstoneWire(SABlockList.RedstoneWire).setUnlocalizedName("RedstoneWire").setTextureName("sevenno_addons:redstoneWire");
			
			
			//register
			GameRegistry.registerItem(CoalReed, "Coal_Reed");
			GameRegistry.registerItem(IronReed, "Iron_Reed");
			GameRegistry.registerItem(GoldReed, "Gold_Reed");
			GameRegistry.registerItem(DiamondReed, "Diamond_Reed");
			GameRegistry.registerItem(EmeraldReed, "Emerald_Reed");
			GameRegistry.registerItem(RedstoneReed, "Redstone_Reed");
			GameRegistry.registerItem(LapisReed, "Lapis_Reed");
			GameRegistry.registerItem(GlowstoneReed, "Glowstone_Reed");
			GameRegistry.registerItem(QuartzReed, "Quartz_Reed");
			
			GameRegistry.registerItem(RedstoneWire, "ItemRedstone_Wire");

		}catch(Exception ex)
		{
			Sevenno_addons.SAlog.severe("Erreur lors de l'initialisation des Items!");
		}
		Sevenno_addons.SAlog.info("Initialisation des Items terminés!");
	}
}