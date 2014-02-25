package genetical_modifier.proxy;

import net.minecraftforge.common.MinecraftForge;
import nether_plus.client.audio.NPSounds;

public class GMClientProxy extends GMCommonProxy
{
	public static int shouldRenderPass;
	public static int renderStemModID;

	@Override
	public void registerRender()
	{
	}
	
	public void initSound()
	{
		MinecraftForge.EVENT_BUS.register(new NPSounds());
	}
	
	public void registerRenderEntity()
	{
	}
}