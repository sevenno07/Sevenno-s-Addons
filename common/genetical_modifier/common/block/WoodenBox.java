package genetical_modifier.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import genetical_modifier.common.Genetical_modifier;
import genetical_modifier.common.creativetabs.GeneticalModifierCreativeTabs;
import genetical_modifier.common.tileentity.TileEntityWoodenBoxGUI;

public class WoodenBox extends BlockContainer
{
	public WoodenBox() 
	{
		super(Material.wood);
		this.setCreativeTab(GeneticalModifierCreativeTabs.GMCreativeTabsBlock);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2)
	{
		return new TileEntityWoodenBoxGUI();
	}
	
/*	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
        	TileEntityWoodenBoxGUI tileentityfour = (TileEntityWoodenBoxGUI)world.getTileEntity(x, y, z);

            if (tileentityfour != null)
            {
                player.openGui(Genetical_modifier.instance, 1, world, x, y, z);
            }
            return true;
        }
    }*/
	
/*	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if(world.isRemote)
        {
            return true;
        }
        else
        {
            player.openGui(Genetical_modifier.instance, 0, world, x, y, z);
            return true;
        }
    }*/
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{	
		if(world.getBlockMetadata(x, y, z) == 0)
		{
			player.openGui(Genetical_modifier.instance, 0, world, x, y, z);
			return true;
		}
		return false;
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if(te != null && stack.getItemDamage() == 0 && te instanceof TileEntityWoodenBoxGUI && stack.hasDisplayName())
		{
			((TileEntityWoodenBoxGUI)te).setCustomGuiName(stack.getDisplayName());
		}
	}
	
	public void breakBlock(World world, int x, int y, int z, Block side, int metadata)
	{
		if(metadata == 0)
		{
			dropContainerItem(world, x, y, z);
		}
		super.breakBlock(world, x, y, z, side, metadata);
	}

	protected void dropContainerItem(World world, int x, int y, int z)
	{
		TileEntityWoodenBoxGUI woodenbox = (TileEntityWoodenBoxGUI)world.getTileEntity(x, y, z);
		
		if (woodenbox != null)
		{
			for (int slotId = 0; slotId < woodenbox.getSizeInventory(); slotId++)
			{
				ItemStack stack = woodenbox.getStackInSlot(slotId);
				
				if (stack != null)
				{
					float f = world.rand.nextFloat() * 0.8F + 0.1F;
					float f1 = world.rand.nextFloat() * 0.8F + 0.1F;
					EntityItem entityitem;

					for (float f2 = world.rand.nextFloat() * 0.8F + 0.1F; stack.stackSize > 0; world.spawnEntityInWorld(entityitem))
					{
						int k1 = world.rand.nextInt(21) + 10;

						if (k1 > stack.stackSize)
						{
							k1 = stack.stackSize;
						}

						stack.stackSize -= k1;
						entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(stack.getItem(), k1, stack.getItemDamage()));
						float f3 = 0.05F;
						entityitem.motionX = (double)((float)world.rand.nextGaussian() * f3);
						entityitem.motionY = (double)((float)world.rand.nextGaussian() * f3 + 0.2F);
						entityitem.motionZ = (double)((float)world.rand.nextGaussian() * f3);

						if (stack.hasTagCompound())
						{
							entityitem.getEntityItem().setTagCompound((NBTTagCompound)stack.getTagCompound().copy());
						}
					}
				}
			}
		}
	}
}