package sevenno_addons.common.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import sevenno_addons.common.block.SABlockList;
import sevenno_addons.common.item.SAItemList;
import cpw.mods.fml.common.registry.GameRegistry;

public class SARecipe
{
	//Workbench
	public static void loadRecipe()
	{
		//block
		GameRegistry.addRecipe(new ItemStack(SABlockList.GreenMushroomBlock_P, 1), new Object[]{"UXU", "VYV", "WZW", 'U', Items.sugar, 'V', SAItemList.StrangeSubstance, 'W', Items.emerald, 'Y', Blocks.red_mushroom, 'X', Blocks.brown_mushroom, 'Z', Blocks.glowstone});
		GameRegistry.addRecipe(new ItemStack(SABlockList.InvertedRedstoneLamp, 2), new Object[]{"XXX", "XYX", "XXX", 'X', Items.glowstone_dust, 'Y', Blocks.redstone_torch});
		GameRegistry.addRecipe(new ItemStack(SABlockList.WoodenBox, 12), new Object[]{"XYX", "Y Y", "XYX", 'X', Items.paper, 'Y', Blocks.planks});
		GameRegistry.addRecipe(new ItemStack(SABlockList.LightQuartzBlock, 2, 0), new Object[]{"X", "Y", 'X', Blocks.glowstone, 'Y', new ItemStack(Blocks.quartz_block, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(SABlockList.LightQuartzBlock, 2, 1), new Object[]{"X", "Y", 'X', Blocks.glowstone, 'Y', new ItemStack(Blocks.quartz_block, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SABlockList.LightQuartzBlock, 2, 2), new Object[]{"X", "Y", 'X', Blocks.glowstone, 'Y', new ItemStack(Blocks.quartz_block, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SABlockList.LightQuartzBlock, 1, 0), new Object[]{"Y", 'Y', new ItemStack(SABlockList.LightQuartzBlock, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(SABlockList.LightQuartzBlock, 1, 1), new Object[]{"Y", 'Y', new ItemStack(SABlockList.LightQuartzBlock, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(SABlockList.LightQuartzBlock, 1, 2), new Object[]{"Y", 'Y', new ItemStack(SABlockList.LightQuartzBlock, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(SABlockList.RefinedBedrockBlock, 1), new Object[]{"YYY", "YYY", "YYY", 'Y', SAItemList.BedrockIngot});
		
		
		//items
		GameRegistry.addRecipe(new ItemStack(SAItemList.CoalReed, 1), new Object[]{"WYW", " X ", "XZX", 'W', SAItemList.StrangeSubstance, 'X', new ItemStack(Items.dye, 1, 15), 'Y', Items.reeds, 'Z', Items.coal});
		GameRegistry.addRecipe(new ItemStack(SAItemList.IronReed, 1), new Object[]{"WYW", " X ", "XZX", 'W', SAItemList.StrangeSubstance, 'X', new ItemStack(Items.dye, 1, 15), 'Y', Items.reeds, 'Z', Items.iron_ingot});
		GameRegistry.addRecipe(new ItemStack(SAItemList.GoldReed, 1), new Object[]{"WYW", " X ", "XZX", 'W', SAItemList.StrangeSubstance, 'X', new ItemStack(Items.dye, 1, 15), 'Y', Items.reeds, 'Z', Items.gold_ingot});
		GameRegistry.addRecipe(new ItemStack(SAItemList.DiamondReed, 1), new Object[]{"WYW", " X ", "XZX", 'W', SAItemList.StrangeSubstance, 'X', new ItemStack(Items.dye, 1, 15), 'Y', Items.reeds, 'Z', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(SAItemList.EmeraldReed, 1), new Object[]{"WYW", " X ", "XZX", 'W', SAItemList.StrangeSubstance, 'X', new ItemStack(Items.dye, 1, 15), 'Y', Items.reeds, 'Z', Items.emerald});
		GameRegistry.addRecipe(new ItemStack(SAItemList.RedstoneReed, 1), new Object[]{"WYW", " X ", "XZX", 'W', SAItemList.StrangeSubstance, 'X', new ItemStack(Items.dye, 1, 15), 'Y', Items.reeds, 'Z', Items.redstone});
		GameRegistry.addRecipe(new ItemStack(SAItemList.LapisReed, 1), new Object[]{"WYW", " X ", "XZX", 'W', SAItemList.StrangeSubstance, 'X', new ItemStack(Items.dye, 1, 15), 'Y', Items.reeds, 'Z', new ItemStack(Items.dye, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(SAItemList.GlowstoneReed, 1), new Object[]{"WYW", " X ", "XZX", 'W', SAItemList.StrangeSubstance, 'X', new ItemStack(Items.dye, 1, 15), 'Y', Items.reeds, 'Z', Items.glowstone_dust});
		GameRegistry.addRecipe(new ItemStack(SAItemList.QuartzReed, 1), new Object[]{"WYW", " X ", "XZX", 'W', SAItemList.StrangeSubstance, 'X', new ItemStack(Items.dye, 1, 15), 'Y', Items.reeds, 'Z', Items.quartz});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Items.coal), new Object[]{ new ItemStack(SAItemList.CoalReed)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot), new Object[]{ new ItemStack(SAItemList.IronReed)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot), new Object[]{ new ItemStack(SAItemList.GoldReed)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond), new Object[]{ new ItemStack(SAItemList.DiamondReed)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.emerald), new Object[]{ new ItemStack(SAItemList.EmeraldReed)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.redstone), new Object[]{ new ItemStack(SAItemList.RedstoneReed)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 1, 4), new Object[]{ new ItemStack(SAItemList.LapisReed)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.glowstone_dust), new Object[]{ new ItemStack(SAItemList.GlowstoneReed)});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.quartz), new Object[]{ new ItemStack(SAItemList.QuartzReed)});
		
		GameRegistry.addRecipe(new ItemStack(SAItemList.ReinforcementGem, 1), new Object[]{" W ", "XYX", " Z ", 'W', SABlockList.RefinedBedrockBlock, 'X', SAItemList.BedrockPowder, 'Y', Items.emerald, 'Z', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(SAItemList.SuperPickaxe), new Object[]{"DGD", " P ", " P ", 'D', Blocks.diamond_block, 'G', Blocks.gold_block, 'P', Items.diamond_pickaxe});
		GameRegistry.addRecipe(new ItemStack(SAItemList.BedrockPickaxe), new Object[]{"BBB", " O ", " D ", 'B', (SABlockList.RefinedBedrockBlock), 'O', Blocks.obsidian, 'D', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(SAItemList.BedrockAxe), new Object[]{"BB ", "BO ", " D ", 'B', (SABlockList.RefinedBedrockBlock), 'O', Blocks.obsidian, 'D', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(SAItemList.BedrockShovel), new Object[]{" B ", " O ", " D ", 'B', (SABlockList.RefinedBedrockBlock), 'O', Blocks.obsidian, 'D', Items.diamond});
		GameRegistry.addRecipe(new ItemStack(SAItemList.BedrockSword), new Object[]{" B ", " B ", " D ", 'B', (SABlockList.RefinedBedrockBlock), 'D', Items.diamond});
		
		GameRegistry.addRecipe(new ItemStack(SAItemList.RDHelmet), new Object[]{"GGG", "GHG", 'G', (SAItemList.ReinforcementGem), 'H', Items.diamond_helmet});
		GameRegistry.addRecipe(new ItemStack(SAItemList.RDChestplate), new Object[]{"GHG", "GGG", "GGG", 'G', (SAItemList.ReinforcementGem), 'H', Items.diamond_chestplate});
		GameRegistry.addRecipe(new ItemStack(SAItemList.RDLeggings), new Object[]{"GGG", "GHG", "G G", 'G', (SAItemList.ReinforcementGem), 'H', Items.diamond_leggings});
		GameRegistry.addRecipe(new ItemStack(SAItemList.RDBoots), new Object[]{"G G", "GHG", 'G', (SAItemList.ReinforcementGem), 'H', Items.diamond_boots});
	}
	
	//smelting
	public static void loadSmelting()
	{
		GameRegistry.addSmelting(SAItemList.BedrockPowder, new ItemStack(SAItemList.BedrockIngot), 2.0F);
	}
}