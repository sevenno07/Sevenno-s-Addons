package genetical_modifier.common.tileentity;

import genetical_modifier.common.block.GMBlockList;
import net.minecraft.tileentity.TileEntity;

public class EntityInvertedRedstoneLamp extends TileEntity
{
	public void updateEntity()
	{
		if(this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord))
		{
			if(this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord) != 1)
			{
				this.worldObj.setBlock(xCoord, yCoord, zCoord, GMBlockList.InvertedRedstoneLamp, 1, 2);
			}
		}
		else
		{
			if(this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord) != 0)
			{
				this.worldObj.setBlock(xCoord, yCoord, zCoord, GMBlockList.InvertedRedstoneLamp, 0, 2);
			}
		}
	}
}