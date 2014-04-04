package sevenno_addons.common.event;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import sevenno_addons.common.block.SABlockList;
import sevenno_addons.common.item.SAItemList;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class Burin
{
	@SubscribeEvent
	public void onUseItem(PlayerInteractEvent event)
	{
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == Blocks.stonebrick && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.Burin)
			{
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, (event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) == 3 ? 0 : event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) + 1), 2);
			}
		}
		
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == Blocks.sandstone && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.Burin)
			{
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, (event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) == 2 ? 0 : event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) + 1), 2);
			}
		}
		
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == Blocks.quartz_block && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.Burin)
			{
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, (event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) == 2 ? 0 : event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) + 1), 2);
			}
		}
		
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == SABlockList.LightQuartzBlock && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.Burin)
			{
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, (event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) == 2 ? 0 : event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) + 1), 2);
			}
		}
		
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == SABlockList.DStoneBrick && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.Burin)
			{
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, (event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) == 12 ? 0 : event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) + 1), 2);
			}
		}
		
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == SABlockList.DGoldenSandstone && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.Burin)
			{
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, (event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) == 3 ? 0 : event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) + 1), 2);
			}
		}
	}
}