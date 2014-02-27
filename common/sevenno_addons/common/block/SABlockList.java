package sevenno_addons.common.block;

import sevenno_addons.common.Sevenno_addons;
import sevenno_addons.common.block.itemblock.ItemInvertedRedstoneLamp;
import sevenno_addons.common.block.itemblock.ItemLightQuartzBlock;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class SABlockList
{
	public static Block WoodenBox;
	public static Block InvertedRedstoneLamp;
	public static Block LightQuartzBlock;
	public static Block RefinedBedrockBlock;
	public static Block SPReedBooster;
	
	public static Block CoalReedBlock;
	public static Block IronReedBlock;
	public static Block GoldReedBlock;
	public static Block DiamondReedBlock;
	public static Block EmeraldReedBlock;
	public static Block RedstoneReedBlock;
	public static Block LapisReedBlock;
	public static Block GlowstoneReedBlock;
	public static Block QuartzReedBlock;
	
	public static void loadBlock()
	{
		InvertedRedstoneLamp = new InvertedRedstoneLamp().setStepSound(Block.soundTypeGlass).setHardness(0.3F).setBlockName("InvertedRedstoneLamp");
		WoodenBox = new WoodenBox().setStepSound(Block.soundTypeWood).setHardness(0.5F).setBlockName("WoodenBox").setBlockTextureName("sevenno_addons:woodenBox");
		LightQuartzBlock = new LightQuartzBlock().setStepSound(Block.soundTypeStone).setLightLevel(1.0F).setHardness(0.5F).setBlockName("LightQuartzBlock").setBlockTextureName("sevenno_addons:lightquartzblock");
		RefinedBedrockBlock = new RefinedBedrockBlock().setStepSound(Block.soundTypeStone).setHardness(5.0F).setBlockName("RefinedBedrockBlock").setBlockTextureName("sevenno_addons:refinedbedrockblock");
		SPReedBooster = new SPReedBooster().setStepSound(Block.soundTypeGlass).setHardness(2.0F).setBlockName("SPReedBooster");
		
		CoalReedBlock = new CoalReedBlock().setStepSound(Block.soundTypeGrass).setBlockName("SPReedBooster").setBlockTextureName("sevenno_addons:coalReedBlock");
		IronReedBlock = new IronReedBlock().setStepSound(Block.soundTypeGrass).setBlockName("SPReedBooster").setBlockTextureName("sevenno_addons:ironReedBlock");
		GoldReedBlock = new GoldReedBlock().setStepSound(Block.soundTypeGrass).setBlockName("SPReedBooster").setBlockTextureName("sevenno_addons:goldReedBlock");
		DiamondReedBlock = new DiamondReedBlock().setStepSound(Block.soundTypeGrass).setBlockName("SPReedBooster").setBlockTextureName("sevenno_addons:diamondReedBlock");
		EmeraldReedBlock = new EmeraldReedBlock().setStepSound(Block.soundTypeGrass).setBlockName("SPReedBooster").setBlockTextureName("sevenno_addons:emeraldReedBlock");
		RedstoneReedBlock = new RedstoneReedBlock().setStepSound(Block.soundTypeGrass).setBlockName("SPReedBooster").setBlockTextureName("sevenno_addons:redstoneReedBlock");
		LapisReedBlock = new LapisReedBlock().setStepSound(Block.soundTypeGrass).setBlockName("SPReedBooster").setBlockTextureName("sevenno_addons:lapisReedBlock");
		GlowstoneReedBlock = new GlowstoneReedBlock().setStepSound(Block.soundTypeGrass).setLightLevel(1.0F).setBlockName("SPReedBooster").setBlockTextureName("sevenno_addons:glowstoneReedBlock");
		QuartzReedBlock = new QuartzReedBlock().setStepSound(Block.soundTypeGrass).setBlockName("SPReedBooster").setBlockTextureName("sevenno_addons:quartzReedBlock");
		
		
		
		
		try
		{
			GameRegistry.registerBlock(WoodenBox, "Wooden_Box");
			GameRegistry.registerBlock(InvertedRedstoneLamp, ItemInvertedRedstoneLamp.class, "InvertedRedstoneLamp", "Inverted_Redstone_Lamp");
			GameRegistry.registerBlock(LightQuartzBlock, ItemLightQuartzBlock.class, "LightQuartzBlock", "Light_Quartz_Block");
			GameRegistry.registerBlock(RefinedBedrockBlock, "Refined_Bedrock_Block");
			GameRegistry.registerBlock(SPReedBooster, "SP_Reed_Booster");
			
			GameRegistry.registerBlock(CoalReedBlock, "Coal_Reed_Block");
			GameRegistry.registerBlock(IronReedBlock, "Iron_Reed_Block");
			GameRegistry.registerBlock(GoldReedBlock, "Gold_Reed_Block");
			GameRegistry.registerBlock(DiamondReedBlock, "Diamond_Reed_Block");
			GameRegistry.registerBlock(EmeraldReedBlock, "Emerald_Reed_Block");
			GameRegistry.registerBlock(RedstoneReedBlock, "Redstone_Reed_Block");
			GameRegistry.registerBlock(LapisReedBlock, "Lapis_Reed_Block");
			GameRegistry.registerBlock(GlowstoneReedBlock, "Glowstone_Reed_Block");
			GameRegistry.registerBlock(QuartzReedBlock, "Quartz_Reed_Block");
			
		}
		catch(Exception ex)
		{
			Sevenno_addons.SAlog.severe("Erreur lors de l'initialisation des Blocks!");
		}
		Sevenno_addons.SAlog.info("Initialisation des Blocks terminés!");
	}
}