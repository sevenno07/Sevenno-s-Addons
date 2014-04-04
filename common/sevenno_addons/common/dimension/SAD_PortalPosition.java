package sevenno_addons.common.dimension;

import net.minecraft.util.ChunkCoordinates;
 
public class SAD_PortalPosition extends ChunkCoordinates
{
	public long time;
	final SAD_Teleporter teleporter;
	
	public SAD_PortalPosition(SAD_Teleporter SAD_Teleporter, int x, int y, int z, long creationTime)
	{
		super(x, y, z);
		this.teleporter = SAD_Teleporter;
		this.time = creationTime;
	}
       
	@Override
	public int compareTo(Object o)
	{
		return 0;
	}
}