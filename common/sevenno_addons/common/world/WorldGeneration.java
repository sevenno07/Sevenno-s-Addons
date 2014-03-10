package sevenno_addons.common.world;

import java.util.Random;

import sevenno_addons.common.block.generation.StrangeGenTree;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneration implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.dimensionId)
		{
		case 0:
		this.generateSurface(world, chunkX * 16, chunkZ * 16, random);
		}
	}

	private void generateSurface(World world, int par2, int par3, Random random)
	{
		for(int i = 0; i < 0.00001; i++)
		{
			int Xcoord1 = par2 + random.nextInt(16);
			int Ycoord1 = random.nextInt(90);
			int Zcoord1 = par3 + random.nextInt(16);
			
			(new StrangeGenTree(false, 6, 0, 0, false)).generate(world, random, Xcoord1, Ycoord1, Zcoord1);
		}
	}	
}
