package sevenno_addons.common;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import sevenno_addons.common.block.SABlockList;
import sevenno_addons.common.item.SAItemList;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BlockChanger
{
	@SubscribeEvent
	public void onUseItem(PlayerInteractEvent event)
	{
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == Blocks.red_mushroom_block && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.BlockChanger)
			{
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, (event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) == 15 ? 0 : event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) + 1), 2);
			}
		}
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == Blocks.brown_mushroom_block && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.BlockChanger)
			{
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, (event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) == 15 ? 0 : event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) + 1), 2);
			}
		}
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == SABlockList.GreenMushroomBlock && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.BlockChanger)
			{
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, (event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) == 12 ? 0 : event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) + 1), 2);
			}
		}
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == SABlockList.GreenMushroomBlock_N && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.BlockChanger)
			{
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, (event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) == 12 ? 0 : event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) + 1), 2);
			}
		}
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == SABlockList.YellowMushroomBlock && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.BlockChanger)
			{
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, (event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) == 12 ? 0 : event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) + 1), 2);
			}
		}
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == SABlockList.YellowMushroomBlock_N && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.BlockChanger)
			{
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, (event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) == 12 ? 0 : event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) + 1), 2);
			}
		}
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == SABlockList.PurpleMushroomBlock1 && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.BlockChanger)
			{
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, (event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) == 12 ? 0 : event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) + 1), 2);
			}
		}
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == SABlockList.PurpleMushroomBlock2 && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.BlockChanger)
			{
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, (event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) == 9 ? 0 : event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) + 1), 2);
			}
		}
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == SABlockList.PurpleMushroomBlock_N1 && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.BlockChanger)
			{
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, (event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) == 12 ? 0 : event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) + 1), 2);
			}
		}
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == SABlockList.PurpleMushroomBlock_N2 && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.BlockChanger)
			{
				event.entityPlayer.worldObj.setBlockMetadataWithNotify(event.x, event.y, event.z, (event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) == 9 ? 0 : event.entityPlayer.worldObj.getBlockMetadata(event.x, event.y, event.z) + 1), 2);
			}
		}
	}
}