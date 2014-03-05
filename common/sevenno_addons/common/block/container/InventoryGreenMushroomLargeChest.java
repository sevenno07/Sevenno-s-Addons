package sevenno_addons.common.block.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryGreenMushroomLargeChest implements IInventory
{
    private String name;

    private IInventory upperChest;

    private IInventory lowerChest;

    public InventoryGreenMushroomLargeChest(String par1Str, IInventory par2IInventory, IInventory par3IInventory)
    {
        this.name = par1Str;

        if (par2IInventory == null)
        {
            par2IInventory = par3IInventory;
        }

        if (par3IInventory == null)
        {
            par3IInventory = par2IInventory;
        }

        this.upperChest = par2IInventory;
        this.lowerChest = par3IInventory;
    }

    public int getSizeInventory()
    {
        return this.upperChest.getSizeInventory() + this.lowerChest.getSizeInventory();
    }

    public boolean isPartOfLargeChest(IInventory par1IInventory)
    {
        return this.upperChest == par1IInventory || this.lowerChest == par1IInventory;
    }

    public ItemStack getStackInSlot(int par1)
    {
        return par1 >= this.upperChest.getSizeInventory() ? this.lowerChest.getStackInSlot(par1 - this.upperChest.getSizeInventory()) : this.upperChest.getStackInSlot(par1);
    }

    public ItemStack decrStackSize(int par1, int par2)
    {
        return par1 >= this.upperChest.getSizeInventory() ? this.lowerChest.decrStackSize(par1 - this.upperChest.getSizeInventory(), par2) : this.upperChest.decrStackSize(par1, par2);
    }

    public ItemStack getStackInSlotOnClosing(int par1)
    {
        return par1 >= this.upperChest.getSizeInventory() ? this.lowerChest.getStackInSlotOnClosing(par1 - this.upperChest.getSizeInventory()) : this.upperChest.getStackInSlotOnClosing(par1);
    }

    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        if (par1 >= this.upperChest.getSizeInventory())
        {
            this.lowerChest.setInventorySlotContents(par1 - this.upperChest.getSizeInventory(), par2ItemStack);
        }
        else
        {
            this.upperChest.setInventorySlotContents(par1, par2ItemStack);
        }
    }

    public int getInventoryStackLimit()
    {
        return this.upperChest.getInventoryStackLimit();
    }

    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.upperChest.isUseableByPlayer(par1EntityPlayer) && this.lowerChest.isUseableByPlayer(par1EntityPlayer);
    }

    public boolean isStackValidForSlot(int par1, ItemStack par2ItemStack)
    {
        return true;
    }

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		return false;
	}

	@Override
	public String getInventoryName()
	{
        return this.upperChest.hasCustomInventoryName() ? this.upperChest.getInventoryName() : (this.lowerChest.hasCustomInventoryName() ? this.lowerChest.getInventoryName() : this.name);
	}

	@Override
	public boolean hasCustomInventoryName()
	{
        return this.upperChest.hasCustomInventoryName() || this.lowerChest.hasCustomInventoryName();
	}

	@Override
	public void markDirty()
	{
        this.upperChest.markDirty();
        this.lowerChest.markDirty();
	}

	@Override
	public void openInventory()
	{
        this.upperChest.openInventory();
        this.lowerChest.openInventory();
	}

	@Override
	public void closeInventory()
	{
        this.upperChest.closeInventory();
        this.lowerChest.closeInventory();
	}
}