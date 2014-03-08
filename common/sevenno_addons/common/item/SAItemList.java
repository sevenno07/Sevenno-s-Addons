package sevenno_addons.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import sevenno_addons.common.Sevenno_addons;
import sevenno_addons.common.block.SABlockList;
import cpw.mods.fml.common.registry.GameRegistry;

public class SAItemList
{
	//items
	public static Item CoalReed;
	public static Item IronReed;
	public static Item GoldReed;
	public static Item DiamondReed;
	public static Item EmeraldReed;
	public static Item RedstoneReed;
	public static Item LapisReed;
	public static Item GlowstoneReed;
	public static Item QuartzReed;
	
	public static Item BedrockPowder;
	public static Item BedrockIngot;
	public static Item ReinforcementGem;
	
	public static Item RedstoneWire;
	
	//outils
	public static ToolMaterial SuperM = EnumHelper.addToolMaterial("SuperM", 3, 10000, 14.0F, 4, 30);
	public static ToolMaterial BedrockTools = EnumHelper.addToolMaterial("BedrockTools", 3, 1999999999, 16.0F, 7, 30);
	
	public static Item SuperPickaxe;
	public static Item BedrockPickaxe;
	public static Item BedrockAxe;
	public static Item BedrockShovel;
	public static Item BedrockSword;
	
	//armors
	public static ArmorMaterial RDArmor = EnumHelper.addArmorMaterial("ReinforcedDiamondArmor", 25, new int[]{4, 7, 6, 4}, 21);
	
	public static Item RDHelmet;
	public static Item RDChestplate;
	public static Item RDLeggings;
	public static Item RDBoots;
	

	public static void loadItem()
	{
		try
		{
			//items
			CoalReed = new CoalReed(SABlockList.CoalReedBlock).setUnlocalizedName("CoalReed").setTextureName("sevenno_addons:coalReed");
			IronReed = new IronReed(SABlockList.IronReedBlock).setUnlocalizedName("IronReed").setTextureName("sevenno_addons:ironReed");
			GoldReed = new GoldReed(SABlockList.GoldReedBlock).setUnlocalizedName("GoldReed").setTextureName("sevenno_addons:goldReed");
			DiamondReed = new DiamondReed(SABlockList.DiamondReedBlock).setUnlocalizedName("DiamondReed").setTextureName("sevenno_addons:diamondReed");
			EmeraldReed = new EmeraldReed(SABlockList.EmeraldReedBlock).setUnlocalizedName("EmeraldReed").setTextureName("sevenno_addons:emeraldReed");
			RedstoneReed = new RedstoneReed(SABlockList.RedstoneReedBlock).setUnlocalizedName("RedstoneReed").setTextureName("sevenno_addons:redstoneReed");
			LapisReed = new LapisReed(SABlockList.LapisReedBlock).setUnlocalizedName("LapisReed").setTextureName("sevenno_addons:lapisReed");
			GlowstoneReed = new GlowstoneReed(SABlockList.GlowstoneReedBlock).setUnlocalizedName("GlowstoneReed").setTextureName("sevenno_addons:glowstoneReed");
			QuartzReed = new QuartzReed(SABlockList.QuartzReedBlock).setUnlocalizedName("QuartzReed").setTextureName("sevenno_addons:quartzReed");
			
			BedrockPowder = new BedrockPowder().setUnlocalizedName("BedrockPowder");
			BedrockIngot = new BedrockIngot().setUnlocalizedName("BedrockIngot");
			ReinforcementGem = new ReinforcementGem().setUnlocalizedName("ReinforcementGem");
			
			RedstoneWire = new RedstoneWire(SABlockList.RedstoneWire).setUnlocalizedName("RedstoneWire").setTextureName("sevenno_addons:redstoneWire");
			
			//tools
			SuperPickaxe = new SuperPickaxe(SuperM).setUnlocalizedName("Superpickaxe");
			BedrockPickaxe = new BedrockPickaxe(BedrockTools).setUnlocalizedName("BedrockPickaxe");
			BedrockAxe = new BedrockAxe(BedrockTools).setUnlocalizedName("BedrockAxe");
			BedrockShovel = new BedrockShovel(BedrockTools).setUnlocalizedName("BedrockShovel");
			BedrockSword = new BedrockSword(BedrockTools).setUnlocalizedName("BedrockSword");
			
			//armors
			RDHelmet = new RDArmor(RDArmor, 0, 0).setUnlocalizedName("RDHelmet").setTextureName("sevenno_addons:ReinforcedDiamondHelmet");
			RDChestplate = new RDArmor(RDArmor, 0, 1).setUnlocalizedName("RDChestplate").setTextureName("sevenno_addons:ReinforcedDiamondChestplate");
			RDLeggings = new RDArmor(RDArmor, 0, 2).setUnlocalizedName("RDLeggings").setTextureName("sevenno_addons:ReinforcedDiamondLeggings");
			RDBoots = new RDArmor(RDArmor, 0, 3).setUnlocalizedName("RDBoots").setTextureName("sevenno_addons:ReinforcedDiamondBoots");
			
			
			//register
			//items
			GameRegistry.registerItem(CoalReed, "Coal_Reed");
			GameRegistry.registerItem(IronReed, "Iron_Reed");
			GameRegistry.registerItem(GoldReed, "Gold_Reed");
			GameRegistry.registerItem(DiamondReed, "Diamond_Reed");
			GameRegistry.registerItem(EmeraldReed, "Emerald_Reed");
			GameRegistry.registerItem(RedstoneReed, "Redstone_Reed");
			GameRegistry.registerItem(LapisReed, "Lapis_Reed");
			GameRegistry.registerItem(GlowstoneReed, "Glowstone_Reed");
			GameRegistry.registerItem(QuartzReed, "Quartz_Reed");
			
			GameRegistry.registerItem(BedrockPowder, "Bedrock_Powder");
			GameRegistry.registerItem(BedrockIngot, "Bedrock_Ingot");
			GameRegistry.registerItem(ReinforcementGem, "Reinforcement_Gem");
			
			GameRegistry.registerItem(RedstoneWire, "ItemRedstone_Wire");
			
			//tools
			GameRegistry.registerItem(SuperPickaxe, "Strong_Pickaxe");
			GameRegistry.registerItem(BedrockPickaxe, "Bedrock_Pickaxe");
			GameRegistry.registerItem(BedrockAxe, "Bedrock_Axe");
			GameRegistry.registerItem(BedrockShovel, "Bedrock_Shovel");
			GameRegistry.registerItem(BedrockSword, "Bedrock_Sword");
			
			//armors
			GameRegistry.registerItem(RDHelmet, "RD_Helmet");
			GameRegistry.registerItem(RDChestplate, "RD_Chestplate");
			GameRegistry.registerItem(RDLeggings, "RD_Leggings");
			GameRegistry.registerItem(RDBoots, "RD_Boots");
			

		}catch(Exception ex)
		{
			Sevenno_addons.SAlog.severe("Erreur lors de l'initialisation des Items!");
		}
		Sevenno_addons.SAlog.info("Initialisation des Items terminés!");
	}
}