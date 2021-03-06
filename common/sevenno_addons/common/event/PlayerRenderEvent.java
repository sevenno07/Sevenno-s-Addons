/*package genetical_modifier.common.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.RenderPlayerEvent;

import org.lwjgl.opengl.GL11;

public class PlayerRenderEvent
{
	private ResourceLocation locationCape;
	private ThreadDownloadImageData downloadImageCape;

//	@ForgeSubscribe
	public void onPlayerRender(RenderPlayerEvent.Specials.Pre event)
	{
		AbstractClientPlayer player = (AbstractClientPlayer)event.entityPlayer;
		if(player.PERSISTED_NBT_TAG != null && !player.PERSISTED_NBT_TAG.isEmpty())
		{
			if(this.locationCape == null)
			{
				this.locationCape = getLocationCape(player.PERSISTED_NBT_TAG);
			}
			else if(this.downloadImageCape == null)
			{
				this.downloadImageCape = getDownloadImageCape(this.getLocationCape(player.PERSISTED_NBT_TAG), player.PERSISTED_NBT_TAG);
			}
			else
			{
				boolean flag = this.getTextureCape().isTextureUploaded();
				boolean flag1 = !player.isInvisible();
				boolean flag2 = !player.getHideCape();
				flag = event.renderCape && flag;
				float f6;

				if(flag && flag1 && flag2)
				{
					Minecraft.getMinecraft().renderEngine.bindTexture(this.getLocationCape(player.PERSISTED_NBT_TAG));
					GL11.glPushMatrix();
					GL11.glTranslatef(0.0F, 0.0F, 0.125F);
					double d0 = player.field_71091_bM + (player.field_71094_bP - player.field_71091_bM) * (double)event.partialRenderTick - (player.prevPosX + (player.posX - player.prevPosX) * (double)event.partialRenderTick);
					double d1 = player.field_71096_bN + (player.field_71095_bQ - player.field_71096_bN) * (double)event.partialRenderTick - (player.prevPosY + (player.posY - player.prevPosY) * (double)event.partialRenderTick);
					double d2 = player.field_71097_bO + (player.field_71085_bR - player.field_71097_bO) * (double)event.partialRenderTick - (player.prevPosZ + (player.posZ - player.prevPosZ) * (double)event.partialRenderTick);
					f6 = player.prevRenderYawOffset + (player.renderYawOffset - player.prevRenderYawOffset) * event.partialRenderTick;
					double d3 = (double)MathHelper.sin(f6 * (float)Math.PI / 180.0F);
					double d4 = (double)(-MathHelper.cos(f6 * (float)Math.PI / 180.0F));
					float f7 = (float)d1 * 10.0F;

					if(f7 < -6.0F)
					{
						f7 = -6.0F;
					}

					if(f7 > 32.0F)
					{
						f7 = 32.0F;
					}

					float f8 = (float)(d0 * d3 + d2 * d4) * 100.0F;
					float f9 = (float)(d0 * d4 - d2 * d3) * 100.0F;

					if(f8 < 0.0F)
					{
						f8 = 0.0F;
					}

					float f10 = player.prevCameraYaw + (player.cameraYaw - player.prevCameraYaw) * event.partialRenderTick;
					f7 += MathHelper.sin((player.prevDistanceWalkedModified + (player.distanceWalkedModified - player.prevDistanceWalkedModified) * event.partialRenderTick) * 6.0F) * 32.0F * f10;

					if(player.isSneaking())
					{
						f7 += 25.0F;
					}

					GL11.glRotatef(6.0F + f8 / 2.0F + f7, 1.0F, 0.0F, 0.0F);
					GL11.glRotatef(f9 / 2.0F, 0.0F, 0.0F, 1.0F);
					GL11.glRotatef(-f9 / 2.0F, 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
					ModelBiped modelBiped = new ModelBiped();
					modelBiped.renderCloak(0.0625F);
					GL11.glPopMatrix();
				}
			}
		}
	}

	public ThreadDownloadImageData getTextureCape()
	{
		return this.downloadImageCape;
	}

	public static ThreadDownloadImageData getDownloadImageCape(ResourceLocation resourceLocation, String playerName)
	{
		return getDownloadImage(resourceLocation, getCapeUrl(playerName), (ResourceLocation)null, (IImageBuffer)null);
	}

	private static ThreadDownloadImageData getDownloadImage(ResourceLocation res, String link, ResourceLocation defRes, IImageBuffer image)
	{
		TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
		Object object = texturemanager.getTexture(res);

		if(object == null)
		{
			object = new ThreadDownloadImageData(link, defRes, image);
			texturemanager.loadTexture(res, (ITextureObject)object);
		}

		return (ThreadDownloadImageData)object;
	}

	public static String getCapeUrl(String playerName)
	{
		return String.format("https://dl.dropboxusercontent.com/u/64149745/FFMT/sevenno07/cape_1.png", new Object[] {StringUtils.stripControlCodes(playerName)});
	}

	public static ResourceLocation getLocationCape(String playerName)
	{
		return new ResourceLocation("genetical_modifier" + "cloaks/" + StringUtils.stripControlCodes(playerName));
	}
}*/