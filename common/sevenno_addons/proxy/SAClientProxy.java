package sevenno_addons.proxy;

import sevenno_addons.common.block.render.RedstoneWireBlockRender;
import sevenno_addons.common.block.render.RenderEnderBlock;
import sevenno_addons.common.tileentity.TileEntityGreenMushroomChest;
import sevenno_addons.common.tileentity.TileEntityGreenMushroomChestRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

//import net.minecraftforge.common.MinecraftForge;

public class SAClientProxy extends SACommonProxy
{
	public static int redstoneWireID;
	public static int RenderEnderBlockID;
	
	public static int renderPass;
	
	@Override
	public void registerRender()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGreenMushroomChest.class, new TileEntityGreenMushroomChestRenderer());
		
		redstoneWireID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(redstoneWireID, new RedstoneWireBlockRender());
		
		RenderEnderBlockID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(RenderEnderBlockID, new RenderEnderBlock());
	}
	
	public void initSound()
	{
//		MinecraftForge.EVENT_BUS.register(new SASounds());
	}
	
	public void registerRenderEntity()
	{
	}
}