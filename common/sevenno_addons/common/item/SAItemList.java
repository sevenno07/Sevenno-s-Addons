package sevenno_addons.common.item;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
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
	
	public static Item PurpleEnzymesBucket;
	public static Item StrangeSubstance;
	public static Item StrangeStick;
	
	public static Item Cherry;
	
	public static Item CondensedStrangeSubstance;
	
	//outils
	public static ToolMaterial SuperM = EnumHelper.addToolMaterial("SuperM", 3, 10000, 14.0F, 4, 30);
	public static ToolMaterial BedrockTools = EnumHelper.addToolMaterial("BedrockTools", 3, 1999999999, 16.0F, 7, 30);
	public static ToolMaterial StrangeTools = EnumHelper.addToolMaterial("StrangeTool", 1, 262, 4.0F, 1, 5);
	
	public static Item SuperPickaxe;
	public static Item BedrockPickaxe;
	public static Item BedrockAxe;
	public static Item BedrockShovel;
	public static Item BedrockSword;
	
	public static Item StrangeSword;
	public static Item StrangePickaxe;
	public static Item StrangeAxe;
	public static Item StrangeShovel;
	public static Item StrangeHoe;
	
	public static Item Separator;
	public static Item BlockChanger;
	public static Item Burin;
	
	public static Item test;
	
	//armors
	public static ArmorMaterial RDArmor = EnumHelper.addArmorMaterial("ReinforcedDiamondArmor", 64, new int[]{4, 7, 6, 4}, 50);
	public static ArmorMaterial MRoller = EnumHelper.addArmorMaterial("MRoller", 64, new int[]{2, 0, 0, 0}, 20);
	
	public static Item RDHelmet;
	public static Item RDChestplate;
	public static Item RDLeggings;
	public static Item RDBoots;
	
	public static Item mineroller2;
	public static Item mineroller;
	

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
			
			PurpleEnzymesBucket = new PurpleEnzymesBucket(SABlockList.blockPurpleDigestiveEnzymes).setUnlocalizedName("PurpleEnzymesBucket").setContainerItem(Items.bucket);
			StrangeSubstance = new StrangeSubstance().setUnlocalizedName("StrangeSubstance");
			StrangeStick = new StrangeStick().setUnlocalizedName("StrangeStick");
			
			Cherry = new Cherry(6, 20.0F, false).setUnlocalizedName("Cherry").setTextureName("sevenno_addons:Cherry");
			
			CondensedStrangeSubstance = new CondensedStrangeSubstance().setUnlocalizedName("CondensedStrangeSubstance");
			
			
			//tools
			SuperPickaxe = new SuperPickaxe(SuperM).setUnlocalizedName("Superpickaxe");
			
			BedrockPickaxe = new BedrockPickaxe(BedrockTools).setUnlocalizedName("BedrockPickaxe");
			BedrockAxe = new BedrockAxe(BedrockTools).setUnlocalizedName("BedrockAxe");
			BedrockShovel = new BedrockShovel(BedrockTools).setUnlocalizedName("BedrockShovel");
			BedrockSword = new BedrockSword(BedrockTools).setUnlocalizedName("BedrockSword");
			
			StrangeSword = new StrangeSword(StrangeTools).setUnlocalizedName("StrangeSword");
			StrangePickaxe = new StrangePickaxe(StrangeTools).setUnlocalizedName("StrangePickaxe");
			StrangeAxe = new StrangeAxe(StrangeTools).setUnlocalizedName("StrangeAxe");
			StrangeShovel = new StrangeShovel(StrangeTools).setUnlocalizedName("StrangeShovel");
			StrangeHoe = new StrangeHoe(StrangeTools).setUnlocalizedName("StrangeHoe");
			
			Separator = new Separator().setUnlocalizedName("Separator");
			BlockChanger = new BlockChanger().setUnlocalizedName("BlockChanger");
			Burin = new Burin().setUnlocalizedName("Burin");
			test = new test().setUnlocalizedName("test");
			
			//armors
			RDHelmet = new RDArmor(RDArmor, 0, 0).setUnlocalizedName("RDHelmet").setTextureName("sevenno_addons:ReinforcedDiamondHelmet");
			RDChestplate = new RDArmor(RDArmor, 0, 1).setUnlocalizedName("RDChestplate").setTextureName("sevenno_addons:ReinforcedDiamondChestplate");
			RDLeggings = new RDArmor(RDArmor, 0, 2).setUnlocalizedName("RDLeggings").setTextureName("sevenno_addons:ReinforcedDiamondLeggings");
			RDBoots = new RDArmor(RDArmor, 0, 3).setUnlocalizedName("RDBoots").setTextureName("sevenno_addons:ReinforcedDiamondBoots");
			
			mineroller2 = new mineroller(MRoller, 0, 2).setUnlocalizedName("MRoller2");
			mineroller = new mineroller(MRoller, 0, 3).setUnlocalizedName("MRoller").setTextureName("sevenno_addons:mineroller");
			
			
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
			
			GameRegistry.registerItem(PurpleEnzymesBucket, "Purple_Enzymes_Bucket");
			GameRegistry.registerItem(StrangeSubstance, "Strange_Substance");
			GameRegistry.registerItem(StrangeStick, "StrangeStick");
			
			GameRegistry.registerItem(Cherry, "Cherry");
			
			GameRegistry.registerItem(CondensedStrangeSubstance, "Condensed_Strange_Substance");
			
			//tools
			GameRegistry.registerItem(SuperPickaxe, "Strong_Pickaxe");
			
			GameRegistry.registerItem(BedrockPickaxe, "Bedrock_Pickaxe");
			GameRegistry.registerItem(BedrockAxe, "Bedrock_Axe");
			GameRegistry.registerItem(BedrockShovel, "Bedrock_Shovel");
			GameRegistry.registerItem(BedrockSword, "Bedrock_Sword");
			
			GameRegistry.registerItem(StrangeSword, "Strange_Sword");
			GameRegistry.registerItem(StrangePickaxe, "Strange_Pickaxe");
			GameRegistry.registerItem(StrangeAxe, "Strange_Axe");
			GameRegistry.registerItem(StrangeShovel, "Strange_Shovel");
			GameRegistry.registerItem(StrangeHoe, "Strange_Hoe");
			
			GameRegistry.registerItem(Separator, "Separator");
			GameRegistry.registerItem(BlockChanger, "Block_Changer");
			GameRegistry.registerItem(Burin, "Burin");
			GameRegistry.registerItem(test, "test");
			
			//armors
			GameRegistry.registerItem(RDHelmet, "RD_Helmet");
			GameRegistry.registerItem(RDChestplate, "RD_Chestplate");
			GameRegistry.registerItem(RDLeggings, "RD_Leggings");
			GameRegistry.registerItem(RDBoots, "RD_Boots");
			
			GameRegistry.registerItem(mineroller, "mine_roller");
			
			FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("purpleEnzymes", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(PurpleEnzymesBucket), FluidContainerRegistry.EMPTY_BUCKET);
			

		}catch(Exception ex)
		{
			Sevenno_addons.SAlog.severe("Erreur lors de l'initialisation des Items!");
		}
		Sevenno_addons.SAlog.info("Initialisation des Items terminés!");
	}
}