package sevenno_addons.common.block;

import sevenno_addons.common.Sevenno_addons;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class SABlockList
{
	public static Block WoodenBox;
	public static Block InvertedRedstoneLamp;
	public static Block LightQuartzblock;
	
	public static void loadBlock()
	{
		WoodenBox = new WoodenBox().setStepSound(Block.soundTypeWood).setHardness(0.5F).setBlockName("WoodenBox").setBlockTextureName("sevenno_addons:woodenBox");		
		InvertedRedstoneLamp = new InvertedRedstoneLamp().setStepSound(Block.soundTypeGlass).setHardness(0.3F).setBlockName("InvertedRedstoneLamp");
//		LightQuartzblock = new LightQuartzblock().setStepSound(Block.soundTypeStone).setLightLevel(1.0F).setHardness(0.5F).setBlockName("LightQuartzblock");
		
		
		try
		{
			GameRegistry.registerBlock(WoodenBox, "Wooden_Box");
			GameRegistry.registerBlock(InvertedRedstoneLamp, ItemInvertedRedstoneLamp.class, "InvertedRedstoneLamp", "Inverted Redstone Lamp");
			
		}
		catch(Exception ex)
		{
			Sevenno_addons.SAlog.severe("Erreur lors de l'initialisation des Blocks!");
		}
		Sevenno_addons.SAlog.info("Initialisation des Blocks terminés!");
	}
}