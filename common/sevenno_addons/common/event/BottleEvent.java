package sevenno_addons.common.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import sevenno_addons.common.block.SABlockList;
import sevenno_addons.common.item.SAItemList;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

public class BottleEvent
{
	@SubscribeEvent
	public void onUseItem(PlayerInteractEvent event)
	{
    	System.out.println("bla");
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == SABlockList.StrangeTreeLog && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == Items.glass_bottle)
			{
				event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, SABlockList.StrangeTreeLog_N);
				
				--event.entityPlayer.inventory.getCurrentItem().stackSize;
				if (!event.entityPlayer.inventory.addItemStackToInventory(new ItemStack(SAItemList.StrangeSubstance)))
				{
					event.entityPlayer.dropPlayerItemWithRandomChoice(new ItemStack(SAItemList.StrangeSubstance), false);
				}
			}
		}
		
		if(event.action == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z) == SABlockList.StrangeTreeLog_N && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == SAItemList.StrangeSubstance)
			{
				event.entityPlayer.worldObj.setBlock(event.x, event.y, event.z, SABlockList.StrangeTreeLog);
				
				--event.entityPlayer.inventory.getCurrentItem().stackSize;
				if (!event.entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle)))
				{
					event.entityPlayer.dropPlayerItemWithRandomChoice(new ItemStack(Items.glass_bottle), false);
				}
			}
		}
	}
}