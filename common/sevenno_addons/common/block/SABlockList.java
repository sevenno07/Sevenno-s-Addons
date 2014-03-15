package sevenno_addons.common.block;

import sevenno_addons.common.Sevenno_addons;
import sevenno_addons.common.block.itemblock.ItemBlockWaterTrack;
import sevenno_addons.common.block.itemblock.ItemBlockWaterTrackPowered;
import sevenno_addons.common.block.itemblock.ItemInvertedRedstoneLamp;
import sevenno_addons.common.block.itemblock.ItemLightQuartzBlock;
import sevenno_addons.common.block.itemblock.ItemStrangeSlab;
import sevenno_addons.common.block.itemblock.ItemStrangeSlab2;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.Loader;
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
	
	public static RedstoneWire RedstoneWire;
	
	public static Block EnderBlock;
	
	public static Block GreenMushroomBlock_P;
	public static Block GreenMushroomBlock;
	public static Block GreenMushroomBlock_N;
	public static Block YellowMushroomBlock_P;
	public static Block YellowMushroomBlock;
	public static Block YellowMushroomBlock_N;
	public static Block PurpleMushroomBlock_P;
	public static Block PurpleMushroomBlock1;
	public static Block PurpleMushroomBlock2;
	public static Block PurpleMushroomBlock_N1;
	public static Block PurpleMushroomBlock_N2;
	
	public static Fluid PurpleDigestiveEnzymes;
	public static Block blockPurpleDigestiveEnzymes;
	
	public static Block GreenMushroomChest;
	
	public static Block StrangeTree;
	public static Block StrangeTreeLog;
	public static Block StrangeTreeLog_N;
	public static Block StrangeTreeLeaves;
	
	public static Block StrangePlank;
	public static Block StrangePlank2;
	public static Block StrangePlankStairs;
	public static Block StrangePlankStairs2;
	public static Block StrangePlankFence;
	public static Block StrangePlankFence2;
	public static Block StrangePlankWall;
	public static Block StrangePlankWall2;
	public static Block StrangePlankSlab;
	public static Block StrangePlankDoubleSlab;
	public static Block StrangePlankSlab2;
	public static Block StrangePlankDoubleSlab2;
	
	public static Block WaterTrack;
	public static Block WaterTrackPowered;
	public static Block FlyingTrack;
	public static Block FlyingTrackPowered;
	
	public static Block PushButton_off;
	public static Block PushButton_on;
	
	public static Block Eliumite_ore;
	
	public static Fluid eliumite_gas;
	public static Block blockEliumite_gas;
	
	//!\addon/!\
	public static Block blockQuicksilver = null;
	public static Block blockSoulplasm = null;
	//!\addon/!\
	
	public static void loadBlock()
	{
		//liquides
		PurpleDigestiveEnzymes = new Fluid("purpleEnzymes").setDensity(4000).setViscosity(1000).setTemperature(288).setLuminosity(0).setUnlocalizedName("purpleEnzymes");
		FluidRegistry.registerFluid(PurpleDigestiveEnzymes);
		
		blockPurpleDigestiveEnzymes = new PurpleDigestiveEnzymes(PurpleDigestiveEnzymes, Material.water).setBlockName("PurpleDigestiveEnzymesStill");
		GameRegistry.registerBlock(blockPurpleDigestiveEnzymes, "PurpleDigestiveEnzymes");
		PurpleDigestiveEnzymes.setBlock(blockPurpleDigestiveEnzymes);
				
		
		eliumite_gas = new Fluid("eliumitegas").setDensity(-400).setViscosity(6000).setTemperature(74).setLuminosity(0).setUnlocalizedName("eliumitegas");
		FluidRegistry.registerFluid(eliumite_gas);
		
		blockEliumite_gas = new EliumiteGas(eliumite_gas, Material.vine).setBlockName("eliumite_gasStill");
		GameRegistry.registerBlock(blockEliumite_gas, "EliumiteGas");
		eliumite_gas.setBlock(blockEliumite_gas);
		
		//blocks
		InvertedRedstoneLamp = new InvertedRedstoneLamp().setStepSound(Block.soundTypeGlass).setHardness(0.3F).setBlockName("InvertedRedstoneLamp");
		WoodenBox = new WoodenBox().setStepSound(Block.soundTypeWood).setHardness(0.3F).setBlockName("WoodenBox").setBlockTextureName("sevenno_addons:woodenBox");
		LightQuartzBlock = new LightQuartzBlock().setStepSound(Block.soundTypeStone).setLightLevel(1.0F).setHardness(1.0F).setBlockName("LightQuartzBlock").setBlockTextureName("sevenno_addons:lightquartzblock");
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
		
		RedstoneWire = (sevenno_addons.common.block.RedstoneWire) new RedstoneWire().setBlockName("RedstoneWire").setBlockTextureName("sevenno_addons:redstoneWire");
		
		EnderBlock = new EnderBlock(Material.ice, false).setStepSound(Block.soundTypeGlass).setHardness(2.0F).setBlockName("EnderBlock");
		
		GreenMushroomBlock_P = new GreenMushroomBlock_P().setStepSound(Block.soundTypeGrass).setResistance(5.0F).setLightLevel(0.7F).setBlockName("GreenMushroomBlock_P");
		GreenMushroomBlock = new GreenMushroomBlock().setStepSound(Block.soundTypeWood).setHardness(2.0F).setResistance(5.0F).setLightLevel(0.7F).setBlockName("GreenMushroomBlock");
		GreenMushroomBlock_N = new GreenMushroomBlock_N().setStepSound(Block.soundTypeWood).setHardness(2.0F).setBlockName("GreenMushroomBlock_N");
		YellowMushroomBlock_P = new YellowMushroomBlock_P().setStepSound(Block.soundTypeGrass).setResistance(5.0F).setLightLevel(0.7F).setBlockName("YellowMushroomBlock_P");
		YellowMushroomBlock = new YellowMushroomBlock().setStepSound(Block.soundTypeWood).setHardness(2.0F).setResistance(5.0F).setLightLevel(0.7F).setBlockName("YellowMushroomBlock");
		YellowMushroomBlock_N = new YellowMushroomBlock_N().setStepSound(Block.soundTypeWood).setHardness(2.0F).setBlockName("YellowMushroomBlock_N");
		PurpleMushroomBlock_P = new PurpleMushroomBlock_P().setStepSound(Block.soundTypeGrass).setResistance(5.0F).setLightLevel(0.7F).setBlockName("PurpleMushroomBlock_P");
		PurpleMushroomBlock1 = new PurpleMushroomBlock1().setStepSound(Block.soundTypeWood).setHardness(3.0F).setResistance(5.0F).setLightLevel(0.7F).setBlockName("PurpleMushroomBlock1");
		PurpleMushroomBlock2 = new PurpleMushroomBlock2().setStepSound(Block.soundTypeWood).setHardness(3.0F).setResistance(5.0F).setLightLevel(0.7F).setBlockName("PurpleMushroomBlock2");
		PurpleMushroomBlock_N1 = new PurpleMushroomBlock_N1().setStepSound(Block.soundTypeWood).setHardness(3.0F).setResistance(5.0F).setBlockName("PurpleMushroomBlock_N1");
		PurpleMushroomBlock_N2 = new PurpleMushroomBlock_N2().setStepSound(Block.soundTypeWood).setHardness(3.0F).setResistance(5.0F).setBlockName("PurpleMushroomBlock_N2");
		
		GreenMushroomChest = new GreenMushroomChest().setStepSound(Block.soundTypeWood).setHardness(2.0F).setResistance(5.0F).setBlockName("GreenMushroomChest");
		
		StrangeTree = new StrangeTree().setStepSound(Block.soundTypeGrass).setBlockName("StrangeTree");
		StrangeTreeLog = new StrangeTreeLog().setStepSound(Block.soundTypeWood).setResistance(5.0F).setHardness(3.0F).setBlockName("StrangeTreeLog");
		StrangeTreeLog_N = new StrangeTreeLog_N().setStepSound(Block.soundTypeWood).setResistance(5.0F).setHardness(3.0F).setBlockName("StrangeTreeLog_N");
		StrangeTreeLeaves = new StrangeTreeLeaves().setStepSound(Block.soundTypeGrass).setResistance(5.0F).setHardness(0.2F).setBlockName("StrangeTreeLeaves");
		
		StrangePlank = new StrangePlank().setStepSound(Block.soundTypeWood).setResistance(5.0F).setHardness(3.0F).setBlockName("StrangePlank").setBlockTextureName("sevenno_addons:strangePlank");
		StrangePlank2 = new StrangePlank2().setStepSound(Block.soundTypeWood).setResistance(5.0F).setHardness(3.0F).setBlockName("StrangePlank2").setBlockTextureName("sevenno_addons:strangePlank2");
		StrangePlankStairs = new ModStairs(StrangePlank, 0).setStepSound(Block.soundTypeWood).setResistance(5.0F).setHardness(3.0F).setBlockName("StrangePlankStairs");
		StrangePlankStairs2 = new ModStairs2(StrangePlank2, 0).setStepSound(Block.soundTypeWood).setResistance(5.0F).setHardness(3.0F).setBlockName("StrangePlankStairs2");
		StrangePlankFence = new ModFence("sevenno_addons:strangePlank", Material.wood).setStepSound(Block.soundTypeWood).setHardness(2.0F).setResistance(5.0F).setBlockName("StrangePlankFence");
		StrangePlankFence2 = new ModFence("sevenno_addons:strangePlank2", Material.wood).setStepSound(Block.soundTypeWood).setHardness(2.0F).setResistance(5.0F).setBlockName("StrangePlankFence2");
		StrangePlankWall = new StrangePlankWall(StrangePlank).setResistance(5.0F).setHardness(3.0F).setBlockName("StrangePlankWall").setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
		StrangePlankWall2 = new StrangePlankWall2(StrangePlank2).setResistance(5.0F).setHardness(3.0F).setBlockName("StrangePlankWall2").setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
		StrangePlankSlab = new StrangeSlab(false).setStepSound(Block.soundTypeWood).setResistance(5.0F).setHardness(3.0F).setBlockName("StrangePlankSlab").setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
		StrangePlankDoubleSlab = new StrangeSlab(true).setStepSound(Block.soundTypeWood).setResistance(5.0F).setHardness(3.0F).setBlockName("StrangePlankDoubleSlab");
		StrangePlankSlab2 = new StrangeSlab2(false).setStepSound(Block.soundTypeWood).setResistance(5.0F).setHardness(3.0F).setBlockName("StrangePlankSlab2").setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
		StrangePlankDoubleSlab2 = new StrangeSlab2(true).setStepSound(Block.soundTypeWood).setResistance(5.0F).setHardness(3.0F).setBlockName("StrangePlankDoubleSlab2");
		
		WaterTrack = new WaterTrack().setStepSound(Block.soundTypeMetal).setHardness(0.7F).setResistance(5.0F).setBlockName("WaterTrack").setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock).setBlockTextureName("sevenno_addons:waterTrack");
		WaterTrackPowered = new WaterTrackPowered().setStepSound(Block.soundTypeMetal).setHardness(0.7F).setResistance(5.0F).setBlockName("WaterTrackPowered").setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock).setBlockTextureName("sevenno_addons:waterTrackPowered");
		FlyingTrack = new FlyingTrack().setStepSound(Block.soundTypeMetal).setHardness(0.7F).setResistance(5.0F).setBlockName("FlyingTrack").setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock).setBlockTextureName("sevenno_addons:flyingTrack");
		FlyingTrackPowered = new FlyingTrackPowered().setStepSound(Block.soundTypeMetal).setHardness(0.7F).setResistance(5.0F).setBlockName("FlyingTrackPowered").setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock).setBlockTextureName("sevenno_addons:flyingTrackPowered");
		
		PushButton_off = new PushButton_off().setStepSound(Block.soundTypeStone).setHardness(5.0F).setBlockName("PushButton_off").setBlockTextureName("sevenno_addons:pushbutton_off");
		PushButton_on = new PushButton_on().setStepSound(Block.soundTypeStone).setHardness(5.0F).setBlockName("PushButton_on").setBlockTextureName("sevenno_addons:pushbutton_on");
		
		Eliumite_ore = new Eliumite_ore().setStepSound(Block.soundTypeStone).setHardness(0.5F).setBlockName("Eliumite").setBlockTextureName("sevenno_addons:eliumite_ore");
		
		
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
			
			GameRegistry.registerBlock(RedstoneWire, "BlockRedstone_Wire");
			
			GameRegistry.registerBlock(EnderBlock, "Ender_Block");
			
			GameRegistry.registerBlock(GreenMushroomBlock_P, "Green_Mushroom");
			GameRegistry.registerBlock(GreenMushroomBlock, "Green_Mushroom_Block");
			GameRegistry.registerBlock(GreenMushroomBlock_N, "Green_Mushroom_BlockN");
			GameRegistry.registerBlock(YellowMushroomBlock_P, "Yellow_Mushroom");
			GameRegistry.registerBlock(YellowMushroomBlock, "Yellow_Mushroom_Block");
			GameRegistry.registerBlock(YellowMushroomBlock_N, "Yellow_Mushroom_BlockN");
			GameRegistry.registerBlock(PurpleMushroomBlock_P, "Purple_Mushroom");
			GameRegistry.registerBlock(PurpleMushroomBlock1, "Purple_Mushroom_Block_1");
			GameRegistry.registerBlock(PurpleMushroomBlock2, "Purple_Mushroom_Block_2");
			GameRegistry.registerBlock(PurpleMushroomBlock_N1, "Purple_Mushroom_BlockN1");
			GameRegistry.registerBlock(PurpleMushroomBlock_N2, "Purple_Mushroom_BlockN2");
			
			GameRegistry.registerBlock(GreenMushroomChest, "Green_Mushroom_Chest");
			
			GameRegistry.registerBlock(StrangeTree, "Strange_Tree");
			GameRegistry.registerBlock(StrangeTreeLog, "Strange_Tree_Log");
			GameRegistry.registerBlock(StrangeTreeLog_N, "Strange_Tree_LogN");
			GameRegistry.registerBlock(StrangeTreeLeaves, "Strange_Tree_Leaves");
			
			GameRegistry.registerBlock(StrangePlank, "Strange_Plank");
			GameRegistry.registerBlock(StrangePlank2, "Strange_Plank2");
			GameRegistry.registerBlock(StrangePlankStairs, "Strange_Stairs");
			GameRegistry.registerBlock(StrangePlankStairs2, "Strange_Stairs2");
			GameRegistry.registerBlock(StrangePlankFence, "Strange_Fence");
			GameRegistry.registerBlock(StrangePlankFence2, "Strange_Fence2");
			GameRegistry.registerBlock(StrangePlankWall, "Strange_PlankWall");
			GameRegistry.registerBlock(StrangePlankWall2, "Strange_PlankWall2");
			GameRegistry.registerBlock(StrangePlankSlab, ItemStrangeSlab.class, "StrangePlankSlab", "sevenno_addons");
			GameRegistry.registerBlock(StrangePlankDoubleSlab, ItemStrangeSlab.class, "StrangePlankDoubleSlab", "sevenno_addons");
			GameRegistry.registerBlock(StrangePlankSlab2, ItemStrangeSlab2.class, "StrangePlankSlab2", "sevenno_addons");
			GameRegistry.registerBlock(StrangePlankDoubleSlab2, ItemStrangeSlab2.class, "StrangePlankDoubleSlab2", "sevenno_addons");
			
			GameRegistry.registerBlock(WaterTrack, ItemBlockWaterTrack.class, "Water_Track");
			GameRegistry.registerBlock(WaterTrackPowered, ItemBlockWaterTrackPowered.class, "Water_Track_Powered");
			GameRegistry.registerBlock(FlyingTrack, "Flying_Track");
			GameRegistry.registerBlock(FlyingTrackPowered, "Flying_Track_Powered");
			
			GameRegistry.registerBlock(PushButton_off, "Push_Button_off");
			GameRegistry.registerBlock(PushButton_on, "Push_Button_on");
			
			GameRegistry.registerBlock(Eliumite_ore, "Eliumite_ore");
			
		}
		catch(Exception ex)
		{
			Sevenno_addons.SAlog.severe("Erreur lors de l'initialisation des Blocks!");
		}
		Sevenno_addons.SAlog.info("Initialisation des Blocks terminés!");
	
		if(Loader.isModLoaded("nether_plus"))
		{
			try
			{
				blockQuicksilver = (Block)Class.forName("nether_plus.common.block.NPBlockList").getField("blockQuicksilver").get(null);
				blockSoulplasm = (Block)Class.forName("nether_plus.common.block.NPBlockList").getField("blockSoulplasm").get(null);
			}
			catch(Exception ex)
			{
				Sevenno_addons.SAlog.severe("Erreur lors de l'initialisation de Nether_Plus");
			}
			Sevenno_addons.SAlog.info("Initialisation de Nether_Plus terminé");
		}
	}
}