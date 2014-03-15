package sevenno_addons.proxy;

import java.util.Random;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
//import sevenno_addons.common.block.render.ConnectorBlockRender;
import sevenno_addons.common.block.render.RedstoneWireBlockRender;
import sevenno_addons.common.block.render.RenderEnderBlock;
import sevenno_addons.common.block.render.RenderPushButton_off;
import sevenno_addons.common.block.render.RenderPushButton_on;
import sevenno_addons.common.entity.GoldParticleFX;
import sevenno_addons.common.tileentity.TileEntityGreenMushroomChest;
import sevenno_addons.common.tileentity.TileEntityGreenMushroomChestRenderer;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

//import net.minecraftforge.common.MinecraftForge;

public class SAClientProxy extends SACommonProxy
{
	public static int redstoneWireID;
	public static int RenderEnderBlockID;
	public static int RenderPushButton_onID;
	public static int RenderPushButton_offID;
//	public static int ConnectorBlockRenderID;
	
	public static int renderPass;
	
	@Override
	public void registerRender()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGreenMushroomChest.class, new TileEntityGreenMushroomChestRenderer());
		
		redstoneWireID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(redstoneWireID, new RedstoneWireBlockRender());
		
		RenderEnderBlockID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(RenderEnderBlockID, new RenderEnderBlock());
		
		RenderPushButton_onID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(RenderPushButton_onID, new RenderPushButton_on());
		
		RenderPushButton_offID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(RenderPushButton_offID, new RenderPushButton_off());
		
//		ConnectorBlockRenderID = RenderingRegistry.getNextAvailableRenderId();
//		RenderingRegistry.registerBlockHandler(ConnectorBlockRenderID, new ConnectorBlockRender());
	}
	
	public void initSound()
	{
//		MinecraftForge.EVENT_BUS.register(new SASounds());
	}
	
	public void registerRenderEntity()
	{
	}
	
	//particles
    private static final ResourceLocation textures = new ResourceLocation("textures/particle/particles.png");
	
	public void spawnAltarParticles(World world, int x, int y, int z, Random rand)
	{
		int particleAmount = 50;
		
		for (int count = 0; count < particleAmount; count++)
		{
			EntityFX particles = new GoldParticleFX(world, x + rand.nextFloat(), y + (count > particleAmount / 2 ? 0.3F : 0.5F), z + rand.nextFloat(), 0.0D, 0.9D, 0.1D);

			FMLClientHandler.instance().getClient().renderEngine.bindTexture(textures);
		}
	}
}