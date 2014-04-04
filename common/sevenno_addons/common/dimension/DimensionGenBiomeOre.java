package sevenno_addons.common.dimension;
     
import java.util.Random;
     

import sevenno_addons.common.block.SABlockList;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.init.Blocks;//TODO
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
     
public class DimensionGenBiomeOre extends BiomeGenBase
{
     
	public DimensionGenBiomeOre(int par1)
	{
		super(par1);
		this.spawnableMonsterList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.topBlock = SABlockList.DGrass;
		this.fillerBlock = SABlockList.DDirt;
		this.setBiomeName("DragonBiome");
	}
	public void generateTerrainBlocks(World world, Random random, Block[] block, byte[] par4, int par5, int par6, double par7)
	{
		this.generateBiomeTerrain(world, random, block, par4, par5, par6, par7);
	}
	
	public final void generateBiomeTerrain(World world, Random random, Block[] blocks, byte[] par4, int par5, int par6, double par7)
	{
		super.genBiomeTerrain(world, random, blocks, par4, par5, par6, par7);
		boolean flag = true;
		Block block = this.topBlock;
		byte b0 = (byte)(this.field_150604_aj & 255);
		Block block1 = this.fillerBlock;
		int k = -1;
		int l = (int)(par7 / 3.0D + 3.0D + random.nextDouble() * 0.25D);
		int i1 = par5 & 15;
		int j1 = par6 & 15;
		int k1 = blocks.length / 256;
     
		for (int l1 = 255; l1 >= 0; --l1)
		{
			int i2 = (j1 * 16 + i1) * k1 + l1;
     
			if (l1 <= 0 + random.nextInt(5))
			{
				blocks[i2] = Blocks.bedrock;
			}
			else
			{
				Block block2 = blocks[i2];
     
				if (block2 != null && block2.getMaterial() != Material.air)
				{
					if (block2 == SABlockList.DStone)
					{
						if (k == -1)
						{
							if (l <= 0)
							{
								block = null;
								b0 = 0;
								block1 = SABlockList.DStone;
							}
							else if (l1 >= 59 && l1 <= 64)
							{
								block = this.topBlock;
								b0 = (byte)(this.field_150604_aj & 255);
								block1 = this.fillerBlock;
							}
							
							if (l1 < 63 && (block == null || block.getMaterial() == Material.air))
							{
								if (this.getFloatTemperature(par5, l1, par6) < 0.15F)
								{
									block = Blocks.ice;
									b0 = 0;
								}
								else
								{
									block = Blocks.water;
									b0 = 0;
								}
							}
							
							k = l;
							
							if (l1 >= 62)
							{
								blocks[i2] = block;
								par4[i2] = b0;
							}
							else if (l1 < 56 - l)
							{
								block = null;
								block1 = SABlockList.DStone;
								blocks[i2] = SABlockList.DStone;
							}
							else
							{
								blocks[i2] = block1;
							}
						}
						else if (k > 0)
						{
							--k;
							blocks[i2] = block1;
     
							if (k == 0 && block1 == SABlockList.DGoldenSand)
							{
								k = random.nextInt(4) + Math.max(0, l1 - 63);
								block1 = SABlockList.DGoldenSandstone;
							}
						}
					}
				}
				else
				{
					k = -1;
				}
			}
		}
	}
}