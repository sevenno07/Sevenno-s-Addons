package sevenno_addons.common.block.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import sevenno_addons.common.block.RedstoneWire;
import sevenno_addons.common.block.SABlockList;
import sevenno_addons.proxy.SAClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RedstoneWireBlockRender implements ISimpleBlockRenderingHandler
{
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
	{
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int i, int j, int k, Block block, int modelId, RenderBlocks renderer)
	{
		{
			Tessellator tessellator = Tessellator.instance;
			int l = world.getBlockMetadata(i, j, k);
			IIcon icon = RedstoneWire.RedstoneWireIcon("cross");
			IIcon icon1 = RedstoneWire.RedstoneWireIcon("line");
			IIcon icon2 = RedstoneWire.RedstoneWireIcon("cross_overlay");
			IIcon icon3 = RedstoneWire.RedstoneWireIcon("line_overlay");
			tessellator.setBrightness(block.getMixedBrightnessForBlock(world, i, j, k));
			float f = 1.0F;
			float f1 = l / 15F;
			float f2 = f1 * 1.0F + 0.35F;
			float f3 = f1 * f1 * 0.2F + 0.0F;
			float f4 = f1 * f1 * 0.0F + 0.0F;
			if (l == 0)
			{
				f2 = 0.3F;
				f3 = 0.0F;
				f4 = 0.0F;
			}
			tessellator.setColorOpaque_F(f2, f3, f4);
			boolean flag = RedstoneWire.isPowerProviderOrWire(world, i - 1, j, k, 1) || !world.getBlock(i - 1, j, k).isNormalCube() && RedstoneWire.isPowerProviderOrWire(world, i - 1, j - 1, k, -1);
			boolean flag1 = RedstoneWire.isPowerProviderOrWire(world, i + 1, j, k, 3) || !world.getBlock(i + 1, j, k).isNormalCube() && RedstoneWire.isPowerProviderOrWire(world, i + 1, j - 1, k, -1);
			boolean flag2 = RedstoneWire.isPowerProviderOrWire(world, i, j, k - 1, 2) || !world.getBlock(i, j, k - 1).isNormalCube() && RedstoneWire.isPowerProviderOrWire(world, i, j - 1, k - 1, -1);
			boolean flag3 = RedstoneWire.isPowerProviderOrWire(world, i, j, k + 1, 0) || !world.getBlock(i, j, k + 1).isNormalCube() && RedstoneWire.isPowerProviderOrWire(world, i, j - 1, k + 1, -1);
			if (!world.getBlock(i, j + 1, k).isNormalCube())
			{
				if (world.getBlock(i - 1, j, k).isNormalCube() && RedstoneWire.isPowerProviderOrWire(world, i - 1, j + 1, k, -1))
				{
					flag = true;
				}
				if (world.getBlock(i + 1, j, k).isNormalCube() && RedstoneWire.isPowerProviderOrWire(world, i + 1, j + 1, k, -1))
				{
					flag1 = true;
				}
				if (world.getBlock(i, j, k - 1).isNormalCube() && RedstoneWire.isPowerProviderOrWire(world, i, j + 1, k - 1, -1))
				{
					flag2 = true;
				}
				if (world.getBlock(i, j, k + 1).isNormalCube() && RedstoneWire.isPowerProviderOrWire(world, i, j + 1, k + 1, -1))
				{
					flag3 = true;
				}
			}
			float f5 = i + 0;
			float f6 = i + 1;
			float f7 = k + 0;
			float f8 = k + 1;
			byte byte0 = 0;
			if ((flag || flag1) && !flag2 && !flag3)
			{
				byte0 = 1;
			}
			if ((flag2 || flag3) && !flag1 && !flag)
			{
				byte0 = 2;
			}
			if (byte0 == 0)
			{
				int j1 = 0;
				int k1 = 0;
				int l1 = 16;
				int i2 = 16;
				if (!flag)
				{
					f5 += 0.3125F;
				}
				if (!flag)
				{
					j1 += 5;
				}
				if (!flag1)
				{
					f6 -= 0.3125F;
				}
				if (!flag1)
				{
					l1 -= 5;
				}
				if (!flag2)
				{
					f7 += 0.3125F;
				}
				if (!flag2)
				{
					k1 += 5;
				}
				if (!flag3)
				{
					f8 -= 0.3125F;
				}
				if (!flag3)
				{
					i2 -= 5;
				}
				tessellator.addVertexWithUV(f6, j + 0.015625D, f8, icon.getInterpolatedU(l1), icon.getInterpolatedV(i2));
				tessellator.addVertexWithUV(f6, j + 0.015625D, f7, icon.getInterpolatedU(l1), icon.getInterpolatedV(k1));
				tessellator.addVertexWithUV(f5, j + 0.015625D, f7, icon.getInterpolatedU(j1), icon.getInterpolatedV(k1));
				tessellator.addVertexWithUV(f5, j + 0.015625D, f8, icon.getInterpolatedU(j1), icon.getInterpolatedV(i2));
//				tessellator.setColorOpaque_F(f, f, f);
				tessellator.addVertexWithUV(f6, j + 0.015625D, f8, icon2.getInterpolatedU(l1), icon2.getInterpolatedV(i2));
				tessellator.addVertexWithUV(f6, j + 0.015625D, f7, icon2.getInterpolatedU(l1), icon2.getInterpolatedV(k1));
				tessellator.addVertexWithUV(f5, j + 0.015625D, f7, icon2.getInterpolatedU(j1), icon2.getInterpolatedV(k1));
				tessellator.addVertexWithUV(f5, j + 0.015625D, f8, icon2.getInterpolatedU(j1), icon2.getInterpolatedV(i2));
			} else if (byte0 == 1)
			{
				tessellator.addVertexWithUV(f6, j + 0.015625D, f8, icon1.getMaxU(), icon1.getMaxV());
				tessellator.addVertexWithUV(f6, j + 0.015625D, f7, icon1.getMaxU(), icon1.getMinV());
				tessellator.addVertexWithUV(f5, j + 0.015625D, f7, icon1.getMinU(), icon1.getMinV());
				tessellator.addVertexWithUV(f5, j + 0.015625D, f8, icon1.getMinU(), icon1.getMaxV());
//				tessellator.setColorOpaque_F(f, f, f);
				tessellator.addVertexWithUV(f6, j + 0.015625D, f8, icon3.getMaxU(), icon3.getMaxV());
				tessellator.addVertexWithUV(f6, j + 0.015625D, f7, icon3.getMaxU(), icon3.getMinV());
				tessellator.addVertexWithUV(f5, j + 0.015625D, f7, icon3.getMinU(), icon3.getMinV());
				tessellator.addVertexWithUV(f5, j + 0.015625D, f8, icon3.getMinU(), icon3.getMaxV());
			} else
			{
				tessellator.addVertexWithUV(f6, j + 0.015625D, f8, icon1.getMaxU(), icon1.getMaxV());
				tessellator.addVertexWithUV(f6, j + 0.015625D, f7, icon1.getMinU(), icon1.getMaxV());
				tessellator.addVertexWithUV(f5, j + 0.015625D, f7, icon1.getMinU(), icon1.getMinV());
				tessellator.addVertexWithUV(f5, j + 0.015625D, f8, icon1.getMaxU(), icon1.getMinV());
//				tessellator.setColorOpaque_F(f, f, f);
				tessellator.addVertexWithUV(f6, j + 0.015625D, f8, icon3.getMaxU(), icon3.getMaxV());
				tessellator.addVertexWithUV(f6, j + 0.015625D, f7, icon3.getMinU(), icon3.getMaxV());
				tessellator.addVertexWithUV(f5, j + 0.015625D, f7, icon3.getMinU(), icon3.getMinV());
				tessellator.addVertexWithUV(f5, j + 0.015625D, f8, icon3.getMaxU(), icon3.getMinV());
			}
			if (!world.getBlock(i, j + 1, k).isNormalCube())
			{
				if (world.getBlock(i - 1, j, k).isNormalCube() && world.getBlock(i - 1, j + 1, k) == SABlockList.RedstoneWire)
				{
//					tessellator.setColorOpaque_F(f * f2, f * f3, f * f4);
					tessellator.addVertexWithUV(i + 0.015625D, j + 1 + 0.021875F, k + 1, icon1.getMaxU(), icon1.getMinV());
					tessellator.addVertexWithUV(i + 0.015625D, j + 0, k + 1, icon1.getMinU(), icon1.getMinV());
					tessellator.addVertexWithUV(i + 0.015625D, j + 0, k + 0, icon1.getMinU(), icon1.getMaxV());
					tessellator.addVertexWithUV(i + 0.015625D, j + 1 + 0.021875F, k + 0, icon1.getMaxU(), icon1.getMaxV());
//					tessellator.setColorOpaque_F(f, f, f);
					tessellator.addVertexWithUV(i + 0.015625D, j + 1 + 0.021875F, k + 1, icon3.getMaxU(), icon3.getMinV());
					tessellator.addVertexWithUV(i + 0.015625D, j + 0, k + 1, icon3.getMinU(), icon3.getMinV());
					tessellator.addVertexWithUV(i + 0.015625D, j + 0, k + 0, icon3.getMinU(), icon3.getMaxV());
					tessellator.addVertexWithUV(i + 0.015625D, j + 1 + 0.021875F, k + 0, icon3.getMaxU(), icon3.getMaxV());
				}
				if (world.getBlock(i + 1, j, k).isNormalCube() && world.getBlock(i + 1, j + 1, k) == SABlockList.RedstoneWire)
				{
//					tessellator.setColorOpaque_F(f * f2, f * f3, f * f4);
					tessellator.addVertexWithUV(i + 1 - 0.015625D, j + 0, k + 1, icon1.getMinU(), icon1.getMaxV());
					tessellator.addVertexWithUV(i + 1 - 0.015625D, j + 1 + 0.021875F, k + 1, icon1.getMaxU(), icon1.getMaxV());
					tessellator.addVertexWithUV(i + 1 - 0.015625D, j + 1 + 0.021875F, k + 0, icon1.getMaxU(), icon1.getMinV());
					tessellator.addVertexWithUV(i + 1 - 0.015625D, j + 0, k + 0, icon1.getMinU(), icon1.getMinV());
//					tessellator.setColorOpaque_F(f, f, f);
					tessellator.addVertexWithUV(i + 1 - 0.015625D, j + 0, k + 1, icon3.getMinU(), icon3.getMaxV());
					tessellator.addVertexWithUV(i + 1 - 0.015625D, j + 1 + 0.021875F, k + 1, icon3.getMaxU(), icon3.getMaxV());
					tessellator.addVertexWithUV(i + 1 - 0.015625D, j + 1 + 0.021875F, k + 0, icon3.getMaxU(), icon3.getMinV());
					tessellator.addVertexWithUV(i + 1 - 0.015625D, j + 0, k + 0, icon3.getMinU(), icon3.getMinV());
				}
				if (world.getBlock(i, j, k - 1).isNormalCube() && world.getBlock(i, j + 1, k - 1) == SABlockList.RedstoneWire)
				{
//					tessellator.setColorOpaque_F(f * f2, f * f3, f * f4);
					tessellator.addVertexWithUV(i + 1, j + 0, k + 0.015625D, icon1.getMinU(), icon1.getMaxV());
					tessellator.addVertexWithUV(i + 1, j + 1 + 0.021875F, k + 0.015625D, icon1.getMaxU(), icon1.getMaxV());
					tessellator.addVertexWithUV(i + 0, j + 1 + 0.021875F, k + 0.015625D, icon1.getMaxU(), icon1.getMinV());
					tessellator.addVertexWithUV(i + 0, j + 0, k + 0.015625D, icon1.getMinU(), icon1.getMinV());
//					tessellator.setColorOpaque_F(f, f, f);
					tessellator.addVertexWithUV(i + 1, j + 0, k + 0.015625D, icon3.getMinU(), icon3.getMaxV());
					tessellator.addVertexWithUV(i + 1, j + 1 + 0.021875F, k + 0.015625D, icon3.getMaxU(), icon3.getMaxV());
					tessellator.addVertexWithUV(i + 0, j + 1 + 0.021875F, k + 0.015625D, icon3.getMaxU(), icon3.getMinV());
					tessellator.addVertexWithUV(i + 0, j + 0, k + 0.015625D, icon3.getMinU(), icon3.getMinV());
				}
				if (world.getBlock(i, j, k + 1).isNormalCube() && world.getBlock(i, j + 1, k + 1) == SABlockList.RedstoneWire)
				{
//					tessellator.setColorOpaque_F(f * f2, f * f3, f * f4);
					tessellator.addVertexWithUV(i + 1, j + 1 + 0.021875F, k + 1 - 0.015625D, icon1.getMaxU(), icon1.getMinV());
					tessellator.addVertexWithUV(i + 1, j + 0, k + 1 - 0.015625D, icon1.getMinU(), icon1.getMinV());
					tessellator.addVertexWithUV(i + 0, j + 0, k + 1 - 0.015625D, icon1.getMinU(), icon1.getMaxV());
					tessellator.addVertexWithUV(i + 0, j + 1 + 0.021875F, k + 1 - 0.015625D, icon1.getMaxU(), icon1.getMaxV());
//					tessellator.setColorOpaque_F(f, f, f);
					tessellator.addVertexWithUV(i + 1, j + 1 + 0.021875F, k + 1 - 0.015625D, icon3.getMaxU(), icon3.getMinV());
					tessellator.addVertexWithUV(i + 1, j + 0, k + 1 - 0.015625D, icon3.getMinU(), icon3.getMinV());
					tessellator.addVertexWithUV(i + 0, j + 0, k + 1 - 0.015625D, icon3.getMinU(), icon3.getMaxV());
					tessellator.addVertexWithUV(i + 0, j + 1 + 0.021875F, k + 1 - 0.015625D, icon3.getMaxU(), icon3.getMaxV());
				}
			}
			return true;
		}
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return false;
	}

	@Override
	public int getRenderId()
	{
    	return SAClientProxy.redstoneWireID;
	}
}



/*import sevenno_addons.common.block.RedstoneWire;
import sevenno_addons.common.block.SABlockList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RedstoneWireBlockRender implements ISimpleBlockRenderingHandler
{
	    public IBlockAccess blockAccess;
    
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
	{
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        Tessellator tessellator = Tessellator.instance;
        RedstoneWire blockwire = (RedstoneWire)block;
		int l = blockwire.colorMultiplier(world, x, y, z);
        IIcon iicon = RedstoneWire.RedstoneWireIcon("redstoneWire_cross");
        IIcon iicon1 = RedstoneWire.RedstoneWireIcon("redstoneWire_line");
        IIcon iicon2 = RedstoneWire.RedstoneWireIcon("redstoneWire_cross_overlay");
        IIcon iicon3 = RedstoneWire.RedstoneWireIcon("redstoneWire_line_overlay");
		tessellator.setBrightness(blockwire.getMixedBrightnessForBlock(world, x, y, z));
        
        float f = (float)l / 15.0F;
        float f1 = f * 0.6F + 0.4F;

        if (l == 0)
        {
            f1 = 0.3F;
        }

        float f2 = f * f * 0.7F - 0.5F;
        float f3 = f * f * 0.6F - 0.7F;

        if (f2 < 0.0F)
        {
            f2 = 0.0F;
        }

        if (f3 < 0.0F)
        {
            f3 = 0.0F;
        }

        tessellator.setColorOpaque_F(f1, f2, f3);
        double d0 = 0.015625D;
        double d1 = 0.015625D;
        boolean flag = RedstoneWire.isPowerProviderOrWire(world, x - 1, y, z, 1) || !world.getBlock(x - 1, y, z).isBlockNormalCube() && RedstoneWire.isPowerProviderOrWire(world, x - 1, y - 1, z, -1);
        boolean flag1 = RedstoneWire.isPowerProviderOrWire(world, x + 1, y, z, 3) || !world.getBlock(x + 1, y, z).isBlockNormalCube() && RedstoneWire.isPowerProviderOrWire(world, x + 1, y - 1, z, -1);
        boolean flag2 = RedstoneWire.isPowerProviderOrWire(world, x, y, z - 1, 2) || !world.getBlock(x, y, z - 1).isBlockNormalCube() && RedstoneWire.isPowerProviderOrWire(world, x, y - 1, z - 1, -1);
        boolean flag3 = RedstoneWire.isPowerProviderOrWire(world, x, y, z + 1, 0) || !world.getBlock(x, y, z + 1).isBlockNormalCube() && RedstoneWire.isPowerProviderOrWire(world, x, y - 1, z + 1, -1);

        if (!world.getBlock(x, y + 1, z).isBlockNormalCube())
        {
            if (world.getBlock(x - 1, y, z).isBlockNormalCube() && RedstoneWire.isPowerProviderOrWire(world, x - 1, y + 1, z, -1))
            {
                flag = true;
            }

            if (world.getBlock(x + 1, y, z).isBlockNormalCube() && RedstoneWire.isPowerProviderOrWire(world, x + 1, y + 1, z, -1))
            {
                flag1 = true;
            }

            if (world.getBlock(x, y, z - 1).isBlockNormalCube() && RedstoneWire.isPowerProviderOrWire(world, x, y + 1, z - 1, -1))
            {
                flag2 = true;
            }

            if (world.getBlock(x, y, z + 1).isBlockNormalCube() && RedstoneWire.isPowerProviderOrWire(world, x, y + 1, z + 1, -1))
            {
                flag3 = true;
            }
        }

        float f4 = (float)(x + 0);
        float f5 = (float)(x + 1);
        float f6 = (float)(z + 0);
        float f7 = (float)(z + 1);
        int i1 = 0;

        if ((flag || flag1) && !flag2 && !flag3)
        {
            i1 = 1;
        }

        if ((flag2 || flag3) && !flag1 && !flag)
        {
            i1 = 2;
        }

        if (i1 == 0)
        {
            int j1 = 0;
            int k1 = 0;
            int l1 = 16;
            int i2 = 16;
            boolean flag4 = true;

            if (!flag)
            {
                f4 += 0.3125F;
            }

            if (!flag)
            {
                j1 += 5;
            }

            if (!flag1)
            {
                f5 -= 0.3125F;
            }

            if (!flag1)
            {
                l1 -= 5;
            }

            if (!flag2)
            {
                f6 += 0.3125F;
            }

            if (!flag2)
            {
                k1 += 5;
            }

            if (!flag3)
            {
                f7 -= 0.3125F;
            }

            if (!flag3)
            {
                i2 -= 5;
            }

            tessellator.addVertexWithUV((double)f5, (double)y + 0.015625D, (double)f7, (double)iicon.getInterpolatedU((double)l1), (double)iicon.getInterpolatedV((double)i2));
            tessellator.addVertexWithUV((double)f5, (double)y + 0.015625D, (double)f6, (double)iicon.getInterpolatedU((double)l1), (double)iicon.getInterpolatedV((double)k1));
            tessellator.addVertexWithUV((double)f4, (double)y + 0.015625D, (double)f6, (double)iicon.getInterpolatedU((double)j1), (double)iicon.getInterpolatedV((double)k1));
            tessellator.addVertexWithUV((double)f4, (double)y + 0.015625D, (double)f7, (double)iicon.getInterpolatedU((double)j1), (double)iicon.getInterpolatedV((double)i2));
            tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
            tessellator.addVertexWithUV((double)f5, (double)y + 0.015625D, (double)f7, (double)iicon2.getInterpolatedU((double)l1), (double)iicon2.getInterpolatedV((double)i2));
            tessellator.addVertexWithUV((double)f5, (double)y + 0.015625D, (double)f6, (double)iicon2.getInterpolatedU((double)l1), (double)iicon2.getInterpolatedV((double)k1));
            tessellator.addVertexWithUV((double)f4, (double)y + 0.015625D, (double)f6, (double)iicon2.getInterpolatedU((double)j1), (double)iicon2.getInterpolatedV((double)k1));
            tessellator.addVertexWithUV((double)f4, (double)y + 0.015625D, (double)f7, (double)iicon2.getInterpolatedU((double)j1), (double)iicon2.getInterpolatedV((double)i2));
        }
        else if (i1 == 1)
        {
            tessellator.addVertexWithUV((double)f5, (double)y + 0.015625D, (double)f7, (double)iicon1.getMaxU(), (double)iicon1.getMaxV());
            tessellator.addVertexWithUV((double)f5, (double)y + 0.015625D, (double)f6, (double)iicon1.getMaxU(), (double)iicon1.getMinV());
            tessellator.addVertexWithUV((double)f4, (double)y + 0.015625D, (double)f6, (double)iicon1.getMinU(), (double)iicon1.getMinV());
            tessellator.addVertexWithUV((double)f4, (double)y + 0.015625D, (double)f7, (double)iicon1.getMinU(), (double)iicon1.getMaxV());
            tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
            tessellator.addVertexWithUV((double)f5, (double)y + 0.015625D, (double)f7, (double)iicon3.getMaxU(), (double)iicon3.getMaxV());
            tessellator.addVertexWithUV((double)f5, (double)y + 0.015625D, (double)f6, (double)iicon3.getMaxU(), (double)iicon3.getMinV());
            tessellator.addVertexWithUV((double)f4, (double)y + 0.015625D, (double)f6, (double)iicon3.getMinU(), (double)iicon3.getMinV());
            tessellator.addVertexWithUV((double)f4, (double)y + 0.015625D, (double)f7, (double)iicon3.getMinU(), (double)iicon3.getMaxV());
        }
        else
        {
            tessellator.addVertexWithUV((double)f5, (double)y + 0.015625D, (double)f7, (double)iicon1.getMaxU(), (double)iicon1.getMaxV());
            tessellator.addVertexWithUV((double)f5, (double)y + 0.015625D, (double)f6, (double)iicon1.getMinU(), (double)iicon1.getMaxV());
            tessellator.addVertexWithUV((double)f4, (double)y + 0.015625D, (double)f6, (double)iicon1.getMinU(), (double)iicon1.getMinV());
            tessellator.addVertexWithUV((double)f4, (double)y + 0.015625D, (double)f7, (double)iicon1.getMaxU(), (double)iicon1.getMinV());
            tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
            tessellator.addVertexWithUV((double)f5, (double)y + 0.015625D, (double)f7, (double)iicon3.getMaxU(), (double)iicon3.getMaxV());
            tessellator.addVertexWithUV((double)f5, (double)y + 0.015625D, (double)f6, (double)iicon3.getMinU(), (double)iicon3.getMaxV());
            tessellator.addVertexWithUV((double)f4, (double)y + 0.015625D, (double)f6, (double)iicon3.getMinU(), (double)iicon3.getMinV());
            tessellator.addVertexWithUV((double)f4, (double)y + 0.015625D, (double)f7, (double)iicon3.getMaxU(), (double)iicon3.getMinV());
        }

        if (!world.getBlock(x, y + 1, z).isBlockNormalCube())
        {
            float f8 = 0.021875F;

            if (world.getBlock(x - 1, y, z).isBlockNormalCube() && world.getBlock(x - 1, y + 1, z) == Blocks.redstone_wire)
            {
                tessellator.setColorOpaque_F(f1, f2, f3);
                tessellator.addVertexWithUV((double)x + 0.015625D, (double)((float)(y + 1) + 0.021875F), (double)(z + 1), (double)iicon1.getMaxU(), (double)iicon1.getMinV());
                tessellator.addVertexWithUV((double)x + 0.015625D, (double)(y + 0), (double)(z + 1), (double)iicon1.getMinU(), (double)iicon1.getMinV());
                tessellator.addVertexWithUV((double)x + 0.015625D, (double)(y + 0), (double)(z + 0), (double)iicon1.getMinU(), (double)iicon1.getMaxV());
                tessellator.addVertexWithUV((double)x + 0.015625D, (double)((float)(y + 1) + 0.021875F), (double)(z + 0), (double)iicon1.getMaxU(), (double)iicon1.getMaxV());
                tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
                tessellator.addVertexWithUV((double)x + 0.015625D, (double)((float)(y + 1) + 0.021875F), (double)(z + 1), (double)iicon3.getMaxU(), (double)iicon3.getMinV());
                tessellator.addVertexWithUV((double)x + 0.015625D, (double)(y + 0), (double)(z + 1), (double)iicon3.getMinU(), (double)iicon3.getMinV());
                tessellator.addVertexWithUV((double)x + 0.015625D, (double)(y + 0), (double)(z + 0), (double)iicon3.getMinU(), (double)iicon3.getMaxV());
                tessellator.addVertexWithUV((double)x + 0.015625D, (double)((float)(y + 1) + 0.021875F), (double)(z + 0), (double)iicon3.getMaxU(), (double)iicon3.getMaxV());
            }

            if (world.getBlock(x + 1, y, z).isBlockNormalCube() && world.getBlock(x + 1, y + 1, z) == Blocks.redstone_wire)
            {
                tessellator.setColorOpaque_F(f1, f2, f3);
                tessellator.addVertexWithUV((double)(x + 1) - 0.015625D, (double)(y + 0), (double)(z + 1), (double)iicon1.getMinU(), (double)iicon1.getMaxV());
                tessellator.addVertexWithUV((double)(x + 1) - 0.015625D, (double)((float)(y + 1) + 0.021875F), (double)(z + 1), (double)iicon1.getMaxU(), (double)iicon1.getMaxV());
                tessellator.addVertexWithUV((double)(x + 1) - 0.015625D, (double)((float)(y + 1) + 0.021875F), (double)(z + 0), (double)iicon1.getMaxU(), (double)iicon1.getMinV());
                tessellator.addVertexWithUV((double)(x + 1) - 0.015625D, (double)(y + 0), (double)(z + 0), (double)iicon1.getMinU(), (double)iicon1.getMinV());
                tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
                tessellator.addVertexWithUV((double)(x + 1) - 0.015625D, (double)(y + 0), (double)(z + 1), (double)iicon3.getMinU(), (double)iicon3.getMaxV());
                tessellator.addVertexWithUV((double)(x + 1) - 0.015625D, (double)((float)(y + 1) + 0.021875F), (double)(z + 1), (double)iicon3.getMaxU(), (double)iicon3.getMaxV());
                tessellator.addVertexWithUV((double)(x + 1) - 0.015625D, (double)((float)(y + 1) + 0.021875F), (double)(z + 0), (double)iicon3.getMaxU(), (double)iicon3.getMinV());
                tessellator.addVertexWithUV((double)(x + 1) - 0.015625D, (double)(y + 0), (double)(z + 0), (double)iicon3.getMinU(), (double)iicon3.getMinV());
            }

            if (world.getBlock(x, y, z - 1).isBlockNormalCube() && world.getBlock(x, y + 1, z - 1) == Blocks.redstone_wire)
            {
                tessellator.setColorOpaque_F(f1, f2, f3);
                tessellator.addVertexWithUV((double)(x + 1), (double)(y + 0), (double)z + 0.015625D, (double)iicon1.getMinU(), (double)iicon1.getMaxV());
                tessellator.addVertexWithUV((double)(x + 1), (double)((float)(y + 1) + 0.021875F), (double)z + 0.015625D, (double)iicon1.getMaxU(), (double)iicon1.getMaxV());
                tessellator.addVertexWithUV((double)(x + 0), (double)((float)(y + 1) + 0.021875F), (double)z + 0.015625D, (double)iicon1.getMaxU(), (double)iicon1.getMinV());
                tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)z + 0.015625D, (double)iicon1.getMinU(), (double)iicon1.getMinV());
                tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
                tessellator.addVertexWithUV((double)(x + 1), (double)(y + 0), (double)z + 0.015625D, (double)iicon3.getMinU(), (double)iicon3.getMaxV());
                tessellator.addVertexWithUV((double)(x + 1), (double)((float)(y + 1) + 0.021875F), (double)z + 0.015625D, (double)iicon3.getMaxU(), (double)iicon3.getMaxV());
                tessellator.addVertexWithUV((double)(x + 0), (double)((float)(y + 1) + 0.021875F), (double)z + 0.015625D, (double)iicon3.getMaxU(), (double)iicon3.getMinV());
                tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)z + 0.015625D, (double)iicon3.getMinU(), (double)iicon3.getMinV());
            }

            if (world.getBlock(x, y, z + 1).isBlockNormalCube() && world.getBlock(x, y + 1, z + 1) == Blocks.redstone_wire)
            {
                tessellator.setColorOpaque_F(f1, f2, f3);
                tessellator.addVertexWithUV((double)(x + 1), (double)((float)(y + 1) + 0.021875F), (double)(z + 1) - 0.015625D, (double)iicon1.getMaxU(), (double)iicon1.getMinV());
                tessellator.addVertexWithUV((double)(x + 1), (double)(y + 0), (double)(z + 1) - 0.015625D, (double)iicon1.getMinU(), (double)iicon1.getMinV());
                tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)(z + 1) - 0.015625D, (double)iicon1.getMinU(), (double)iicon1.getMaxV());
                tessellator.addVertexWithUV((double)(x + 0), (double)((float)(y + 1) + 0.021875F), (double)(z + 1) - 0.015625D, (double)iicon1.getMaxU(), (double)iicon1.getMaxV());
                tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
                tessellator.addVertexWithUV((double)(x + 1), (double)((float)(y + 1) + 0.021875F), (double)(z + 1) - 0.015625D, (double)iicon3.getMaxU(), (double)iicon3.getMinV());
                tessellator.addVertexWithUV((double)(x + 1), (double)(y + 0), (double)(z + 1) - 0.015625D, (double)iicon3.getMinU(), (double)iicon3.getMinV());
                tessellator.addVertexWithUV((double)(x + 0), (double)(y + 0), (double)(z + 1) - 0.015625D, (double)iicon3.getMinU(), (double)iicon3.getMaxV());
                tessellator.addVertexWithUV((double)(x + 0), (double)((float)(y + 1) + 0.021875F), (double)(z + 1) - 0.015625D, (double)iicon3.getMaxU(), (double)iicon3.getMaxV());
            }
        }

        return true;
    }

	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return false;
	}

	@Override
	public int getRenderId()
	{
    	return SAClientProxy.redstoneWireID;
	}
}*/