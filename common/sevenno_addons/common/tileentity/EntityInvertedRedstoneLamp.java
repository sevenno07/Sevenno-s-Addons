package sevenno_addons.common.tileentity;

import sevenno_addons.common.block.SABlockList;
import net.minecraft.tileentity.TileEntity;

public class EntityInvertedRedstoneLamp extends TileEntity
{
	public void updateEntity()
	{
		if(this.worldObj.isBlockIndirectlyGettingPowered(xCoord, yCoord, zCoord))
		{
			if(this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord) != 1)
			{
				this.worldObj.setBlock(xCoord, yCoord, zCoord, SABlockList.InvertedRedstoneLamp, 1, 2);
			}
		}
		else
		{
			if(this.worldObj.getBlockMetadata(xCoord, yCoord, zCoord) != 0)
			{
				this.worldObj.setBlock(xCoord, yCoord, zCoord, SABlockList.InvertedRedstoneLamp, 0, 2);
			}
		}
	}
}