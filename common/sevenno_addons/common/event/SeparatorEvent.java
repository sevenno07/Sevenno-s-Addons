package sevenno_addons.common.event;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import sevenno_addons.common.block.SABlockList;
import sevenno_addons.common.item.SAItemList;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class SeparatorEvent
{
	@SubscribeEvent
	public void onUseItem(PlayerInteractEvent event)
	{
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == SABlockList.GreenMushroomBlock && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.Separator)
			{
				event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, SABlockList.GreenMushroomBlock_N);
				{
					if(! event.entityPlayer.worldObj.isRemote)
					{
						event.entityPlayer.worldObj.spawnEntityInWorld(new EntityItem(event.entityPlayer.worldObj, (double)event.x + 0.5, (double)event.y + 0.5, (double)event.z + 0.5, new ItemStack(Items.glowstone_dust)));
					}
				}
			}
		}
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == SABlockList.YellowMushroomBlock && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.Separator)
			{
				event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, SABlockList.YellowMushroomBlock_N);
				{
					if(! event.entityPlayer.worldObj.isRemote)
					{
						event.entityPlayer.worldObj.spawnEntityInWorld(new EntityItem(event.entityPlayer.worldObj, (double)event.x + 0.5, (double)event.y + 0.5, (double)event.z + 0.5, new ItemStack(Items.glowstone_dust)));
					}
				}
			}
		}
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == SABlockList.PurpleMushroomBlock1 && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.Separator)
			{
				event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, SABlockList.PurpleMushroomBlock_N1);
				{
					if(! event.entityPlayer.worldObj.isRemote)
					{
						event.entityPlayer.worldObj.spawnEntityInWorld(new EntityItem(event.entityPlayer.worldObj, (double)event.x + 0.5, (double)event.y + 0.5, (double)event.z + 0.5, new ItemStack(Items.glowstone_dust)));
					}
				}
			}
		}
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == SABlockList.PurpleMushroomBlock2 && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.Separator)
			{
				event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, SABlockList.PurpleMushroomBlock_N2);
				{
					if(! event.entityPlayer.worldObj.isRemote)
					{
						event.entityPlayer.worldObj.spawnEntityInWorld(new EntityItem(event.entityPlayer.worldObj, (double)event.x + 0.5, (double)event.y + 0.5, (double)event.z + 0.5, new ItemStack(Items.glowstone_dust)));
					}
				}
			}
		}
	}
}