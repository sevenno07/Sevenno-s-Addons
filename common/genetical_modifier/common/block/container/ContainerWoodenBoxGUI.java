package genetical_modifier.common.block.container;

import genetical_modifier.common.tileentity.TileEntityWoodenBoxGUI;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

	public class ContainerWoodenBoxGUI extends Container
	{
		private TileEntityWoodenBoxGUI tileEntity;
		private int j;
		private int i;

		public ContainerWoodenBoxGUI(InventoryPlayer playerInventory, TileEntityWoodenBoxGUI teChest)
		{
			this.tileEntity = teChest;
				{
					this.addSlotToContainer(new Slot(teChest, j + i * 80, 80 + j * 86, 86 + i * 18));
				}
			this.bindPlayerInventory(playerInventory);
		}

		private void bindPlayerInventory(InventoryPlayer playerInventory)
		{
			int i;
			for(i = 0; i < 3; i++)
			{
				for(int j = 0; j < 9; j++)
				{
					this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 103 + i * 18 + 37));
				}
			}

			for(i = 0; i < 9; i++)
			{
				this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 161 + 37));
			}
		}

		@Override
		public boolean canInteractWith(EntityPlayer player)
		{
			return tileEntity.isUseableByPlayer(player);
		}

		public ItemStack transferStackInSlot(EntityPlayer player, int slotId)
		{
			ItemStack itemstack = null;
			Slot slot = (Slot)this.inventorySlots.get(slotId);

			if(slot != null && slot.getHasStack())
			{
				ItemStack itemstack1 = slot.getStack();
				itemstack = itemstack1.copy();

				if(slotId < 9)
				{
					if(!this.mergeItemStack(itemstack1, 9, this.inventorySlots.size(), true))
					{
						return null;
					}
				}
				else if(!this.mergeItemStack(itemstack1, 0, 9, false))
				{
					return null;
				}

				if(itemstack1.stackSize == 0)
				{
					slot.putStack((ItemStack)null);
				}
				else
				{
					slot.onSlotChanged();
				}
			}
			return itemstack;
		}
	}