package genetical_modifier.common.block;

import genetical_modifier.common.Genetical_modifier;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class GMBlockList
{
	public static Block WoodenBox;
	public static Block InvertedRedstoneLamp;
	
	public static void loadBlock()
	{
		WoodenBox = new WoodenBox().setStepSound(Block.soundTypeWood).setHardness(0.5F).setBlockName("WoodenBox").setBlockTextureName("genetical_modifier:woodenBox");
		
		InvertedRedstoneLamp = new InvertedRedstoneLamp().setStepSound(Block.soundTypeGlass).setHardness(0.3F).setBlockName("InvertedRedstoneLamp");
		
		try
		{
			GameRegistry.registerBlock(WoodenBox, "Wooden_Box");
			GameRegistry.registerBlock(InvertedRedstoneLamp, ItemInvertedRedstoneLamp.class, "InvertedRedstoneLamp", "Inverted Redstone Lamp");
		}
		catch(Exception ex)
		{
			Genetical_modifier.GMlog.severe("Erreur lors de l'initialisation des Blocks!");
		}
		Genetical_modifier.GMlog.info("Initialisation des Blocks terminés!");
	}
}