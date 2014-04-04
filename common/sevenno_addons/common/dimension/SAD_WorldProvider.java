package sevenno_addons.common.dimension;

import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import sevenno_addons.common.Sevenno_addons;
import sevenno_addons.common.block.SABlockList;
 
public class SAD_WorldProvider extends WorldProvider
{
        public void registerWorldChunkManager()
        {
//                this.worldChunkMgr = new SAD_WorldChunkManager(worldObj.getSeed(), terrainType);
                this.dimensionId = Sevenno_addons.dimID;
        }
        @Override
        public String getDimensionName()
        {
                // TODO Auto-generated method stub
                return "Draconnique Dimension";
        }
    public boolean isDaytime()
    {
        return true;
    }
        public int getAverageGroundLevel()
        {
                return 0;
        }
    public boolean getWorldHasVoidParticles()
    {
        return false;
    }
    public float getStarBrightness(float par1)
    {
        return 0.0F;
    }
        public boolean canCoordinateBeSpawn(int par1, int par2)
        {
                return this.worldObj.getTopBlock(par1, par2) == SABlockList.DGrass;
        }
        public String getSaveFolder()
        {
                return "DIMDragon";
        }
        @Override
        public IChunkProvider createChunkGenerator()
        {
                return new SAD_ChunkProvider(worldObj, worldObj.getSeed(), false);
        }
 
        @Override
        public Vec3 getSkyColor(Entity cameraEntity, float partialTicks)
        {
                return this.worldObj.getWorldVec3Pool().getVecFromPool(1.2, 0.2, 0.2);
        }
 
        @Override
        public boolean isSkyColored()
        {
                return true;
        }
    public boolean canDoLightning(Chunk chunk)
    {
        return true;
    }
    public boolean canDoRainSnowIce(Chunk chunk)
    {
        return true;
    }
    public float calculateCelestialAngle(long par1, float par3)
    {
        int j = (int)(par1 % 24000L);
        float f1 = ((float)j + par3) / 24000.0F - 0.25F;
 
        float f2 = f1;
        f1 = 1.0F - (float)((Math.cos((double)f1 * Math.PI) + 1.0D) / 2.0D);
        f1 = f2 + (f1 - f2) / 3.0F;
        return f1;
    }
}