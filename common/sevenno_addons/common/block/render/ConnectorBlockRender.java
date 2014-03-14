package sevenno_addons.common.block.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import sevenno_addons.common.block.RedstoneWire;
import sevenno_addons.common.block.SABlockList;
import sevenno_addons.proxy.SAClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class ConnectorBlockRender implements ISimpleBlockRenderingHandler
{
	public Block canconnectblocks1;
	public Block canconnectblocks2;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
	{
		
	}
	
	public boolean canConnect1(IBlockAccess world, int x, int y, int z)
	{
	    Block block = world.getBlock(x, y, z);
	    return block == canconnectblocks1 || block == Blocks.tripwire_hook || block == Blocks.iron_door || block == Blocks.wooden_door || block == Blocks.fence_gate || block == Blocks.heavy_weighted_pressure_plate || block == Blocks.light_weighted_pressure_plate || block == Blocks.wooden_pressure_plate || block == Blocks.stone_pressure_plate || block == Blocks.trapped_chest || block == Blocks.trapdoor|| block == Blocks.wooden_button || block == Blocks.stone_button || block == Blocks.noteblock || block == Blocks.redstone_block || block == Blocks.unlit_redstone_torch || block == Blocks.redstone_torch || block == Blocks.dispenser || block == Blocks.dropper || block == Blocks.hopper || block == Blocks.sticky_piston || block == Blocks.piston || block == SABlockList.PushButton_on || block == SABlockList.PushButton_off || block == SABlockList.Connector_midle || block == SABlockList.Connector_on || block == SABlockList.Connector_midle2 || block == SABlockList.Connector_off || block == Blocks.redstone_wire || block == Blocks.lever || block == Blocks.redstone_lamp || block == Blocks.lit_redstone_lamp;
	}
	
	public boolean canConnect2(IBlockAccess world, int x, int y, int z)
	{
	    Block block = world.getBlock(x, y, z);
	    return block == canconnectblocks2 || block == Blocks.iron_door || block == Blocks.wooden_door || block == Blocks.heavy_weighted_pressure_plate || block == Blocks.light_weighted_pressure_plate || block == Blocks.wooden_pressure_plate || block == Blocks.stone_pressure_plate || block == Blocks.redstone_wire;
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
/*		
		Tessellator tessellator = Tessellator.instance;
		int l = world.getBlockMetadata(x, y, z);
		IIcon icon = RedstoneWire.RedstoneWireIcon("cross");
		IIcon icon1 = RedstoneWire.RedstoneWireIcon("line");
		IIcon icon2 = RedstoneWire.RedstoneWireIcon("cross_overlay");
		IIcon icon3 = RedstoneWire.RedstoneWireIcon("line_overlay");
		tessellator.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
		
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
		boolean flag = Connector.isPowerProviderOrWire(world, x - 1, y, z, 1);
		boolean flag1 = Connector.isPowerProviderOrWire(world, x + 1, y, z, 3);
		boolean flag2 = Connector.isPowerProviderOrWire(world, x, y, z - 1, 2);
		boolean flag3 = Connector.isPowerProviderOrWire(world, x, y, z + 1, 0);
		
		
		
		*/
		//if(canConnect(world, x, y + 1, z)
		{//midle
			renderer.setRenderBounds(0.44F, 0.44F, 0.44F, 0.56F, 0.56F, 0.56F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		if(canConnect1 (world, x , y, z - 1))
		{//north
			renderer.setRenderBounds(0.44F, 0.44F, 0.0F, 0.56F, 0.56F, 0.56F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		if(canConnect1 (world, x + 1, y, z))
		{//east
			renderer.setRenderBounds(0.44F, 0.44F, 0.44F, 1.0F, 0.56F, 0.56F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		if(canConnect1 (world, x, y, z + 1))
		{//south
			renderer.setRenderBounds(0.44F, 0.44F, 0.44F, 0.56F, 0.56F, 1.0F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		if(canConnect1 (world, x - 1, y, z))
		{//west
			renderer.setRenderBounds(0.0F, 0.44F, 0.44F, 0.56F, 0.56F, 0.56F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		if(canConnect1 (world, x, y + 1, z))
		{//up
			renderer.setRenderBounds(0.44F, 0.44F, 0.44F, 0.56F, 1.0F, 0.56F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		if(canConnect1 (world, x, y - 1, z))
		{//down
			renderer.setRenderBounds(0.44F, 0.0F, 0.44F, 0.56F, 0.56F, 0.56F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		//2*
		
		if(canConnect2 (world, x, y - 1, z))
		{//down
			renderer.setRenderBounds(0.44F, 0.0F, 0.44F, 0.56F, 0.56F, 0.56F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		if(canConnect2 (world, x , y, z - 1))
		{//north
			renderer.setRenderBounds(0.44F, 0.0F, 0.0F, 0.56F, 0.45F, 0.125F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		if(canConnect2 (world, x + 1, y, z))
		{//east
			renderer.setRenderBounds(0.875F, 0.0F, 0.44F, 1.0F, 0.45F, 0.56F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		if(canConnect2 (world, x, y, z + 1))
		{//south
			renderer.setRenderBounds(0.44F, 0.0F, 0.875F, 0.56F, 0.45F, 1.0F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		if(canConnect2 (world, x - 1, y, z))
		{//west
			renderer.setRenderBounds(0.0F, 0.0F, 0.44F, 0.125F, 0.56F, 0.56F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		return true;
	}


//	renderer.setRenderBounds(0.0F, 0.44F, 0.44F, 1.0F, 0.56F, 0.56F);
//	renderer.renderStandardBlock(block, x, y, z);
//	renderer.setRenderBounds(0.44F, 0.0F, 0.44F, 0.56F, 1.0F, 0.56F);
//	renderer.renderStandardBlock(block, x, y, z);
//	renderer.setRenderBounds(0.44F, 0.44F, 0.0F, 0.56F, 0.56F, 1.0F);
//	renderer.renderStandardBlock(block, x, y, z);
	
	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return false;
	}

	@Override
	public int getRenderId()
	{
    	return SAClientProxy.ConnectorBlockRenderID;
	}
}



/*import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import sevenno_addons.common.block.Connector;
import sevenno_addons.common.block.SABlockList;
import sevenno_addons.proxy.SAClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class ConnectorBlockRender implements ISimpleBlockRenderingHandler
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
			IIcon icon = Connector.ConnectorIcon("cross");
			IIcon icon1 = Connector.ConnectorIcon("line");
			IIcon icon2 = Connector.ConnectorIcon("cross_overlay");
			IIcon icon3 = Connector.ConnectorIcon("line_overlay");
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
			boolean flag = Connector.isPowerProviderOrWire(world, i - 1, j, k, 1) || !world.getBlock(i - 1, j, k).isNormalCube() && Connector.isPowerProviderOrWire(world, i - 1, j - 1, k, -1);
			boolean flag1 = Connector.isPowerProviderOrWire(world, i + 1, j, k, 3) || !world.getBlock(i + 1, j, k).isNormalCube() && Connector.isPowerProviderOrWire(world, i + 1, j - 1, k, -1);
			boolean flag2 = Connector.isPowerProviderOrWire(world, i, j, k - 1, 2) || !world.getBlock(i, j, k - 1).isNormalCube() && Connector.isPowerProviderOrWire(world, i, j - 1, k - 1, -1);
			boolean flag3 = Connector.isPowerProviderOrWire(world, i, j, k + 1, 0) || !world.getBlock(i, j, k + 1).isNormalCube() && Connector.isPowerProviderOrWire(world, i, j - 1, k + 1, -1);
			if (!world.getBlock(i, j + 1, k).isNormalCube())
			{
				if (world.getBlock(i - 1, j, k).isNormalCube() && Connector.isPowerProviderOrWire(world, i - 1, j + 1, k, -1))
				{
					flag = true;
				}
				if (world.getBlock(i + 1, j, k).isNormalCube() && Connector.isPowerProviderOrWire(world, i + 1, j + 1, k, -1))
				{
					flag1 = true;
				}
				if (world.getBlock(i, j, k - 1).isNormalCube() && Connector.isPowerProviderOrWire(world, i, j + 1, k - 1, -1))
				{
					flag2 = true;
				}
				if (world.getBlock(i, j, k + 1).isNormalCube() && Connector.isPowerProviderOrWire(world, i, j + 1, k + 1, -1))
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
				tessellator.setColorOpaque_F(f, f, f);
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
				tessellator.setColorOpaque_F(f, f, f);
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
				tessellator.setColorOpaque_F(f, f, f);
				tessellator.addVertexWithUV(f6, j + 0.015625D, f8, icon3.getMaxU(), icon3.getMaxV());
				tessellator.addVertexWithUV(f6, j + 0.015625D, f7, icon3.getMinU(), icon3.getMaxV());
				tessellator.addVertexWithUV(f5, j + 0.015625D, f7, icon3.getMinU(), icon3.getMinV());
				tessellator.addVertexWithUV(f5, j + 0.015625D, f8, icon3.getMaxU(), icon3.getMinV());
			}
			if (!world.getBlock(i, j + 1, k).isNormalCube())
			{
				if (world.getBlock(i - 1, j, k).isNormalCube() && world.getBlock(i - 1, j + 1, k) == SABlockList.RedstoneWire)
				{
					tessellator.setColorOpaque_F(f * f2, f * f3, f * f4);
					tessellator.addVertexWithUV(i + 0.015625D, j + 1 + 0.021875F, k + 1, icon1.getMaxU(), icon1.getMinV());
					tessellator.addVertexWithUV(i + 0.015625D, j + 0, k + 1, icon1.getMinU(), icon1.getMinV());
					tessellator.addVertexWithUV(i + 0.015625D, j + 0, k + 0, icon1.getMinU(), icon1.getMaxV());
					tessellator.addVertexWithUV(i + 0.015625D, j + 1 + 0.021875F, k + 0, icon1.getMaxU(), icon1.getMaxV());
					tessellator.setColorOpaque_F(f, f, f);
					tessellator.addVertexWithUV(i + 0.015625D, j + 1 + 0.021875F, k + 1, icon3.getMaxU(), icon3.getMinV());
					tessellator.addVertexWithUV(i + 0.015625D, j + 0, k + 1, icon3.getMinU(), icon3.getMinV());
					tessellator.addVertexWithUV(i + 0.015625D, j + 0, k + 0, icon3.getMinU(), icon3.getMaxV());
					tessellator.addVertexWithUV(i + 0.015625D, j + 1 + 0.021875F, k + 0, icon3.getMaxU(), icon3.getMaxV());
				}
				if (world.getBlock(i + 1, j, k).isNormalCube() && world.getBlock(i + 1, j + 1, k) == SABlockList.RedstoneWire)
				{
					tessellator.setColorOpaque_F(f * f2, f * f3, f * f4);
					tessellator.addVertexWithUV(i + 1 - 0.015625D, j + 0, k + 1, icon1.getMinU(), icon1.getMaxV());
					tessellator.addVertexWithUV(i + 1 - 0.015625D, j + 1 + 0.021875F, k + 1, icon1.getMaxU(), icon1.getMaxV());
					tessellator.addVertexWithUV(i + 1 - 0.015625D, j + 1 + 0.021875F, k + 0, icon1.getMaxU(), icon1.getMinV());
					tessellator.addVertexWithUV(i + 1 - 0.015625D, j + 0, k + 0, icon1.getMinU(), icon1.getMinV());
					tessellator.setColorOpaque_F(f, f, f);
					tessellator.addVertexWithUV(i + 1 - 0.015625D, j + 0, k + 1, icon3.getMinU(), icon3.getMaxV());
					tessellator.addVertexWithUV(i + 1 - 0.015625D, j + 1 + 0.021875F, k + 1, icon3.getMaxU(), icon3.getMaxV());
					tessellator.addVertexWithUV(i + 1 - 0.015625D, j + 1 + 0.021875F, k + 0, icon3.getMaxU(), icon3.getMinV());
					tessellator.addVertexWithUV(i + 1 - 0.015625D, j + 0, k + 0, icon3.getMinU(), icon3.getMinV());
				}
				if (world.getBlock(i, j, k - 1).isNormalCube() && world.getBlock(i, j + 1, k - 1) == SABlockList.RedstoneWire)
				{
					tessellator.setColorOpaque_F(f * f2, f * f3, f * f4);
					tessellator.addVertexWithUV(i + 1, j + 0, k + 0.015625D, icon1.getMinU(), icon1.getMaxV());
					tessellator.addVertexWithUV(i + 1, j + 1 + 0.021875F, k + 0.015625D, icon1.getMaxU(), icon1.getMaxV());
					tessellator.addVertexWithUV(i + 0, j + 1 + 0.021875F, k + 0.015625D, icon1.getMaxU(), icon1.getMinV());
					tessellator.addVertexWithUV(i + 0, j + 0, k + 0.015625D, icon1.getMinU(), icon1.getMinV());
					tessellator.setColorOpaque_F(f, f, f);
					tessellator.addVertexWithUV(i + 1, j + 0, k + 0.015625D, icon3.getMinU(), icon3.getMaxV());
					tessellator.addVertexWithUV(i + 1, j + 1 + 0.021875F, k + 0.015625D, icon3.getMaxU(), icon3.getMaxV());
					tessellator.addVertexWithUV(i + 0, j + 1 + 0.021875F, k + 0.015625D, icon3.getMaxU(), icon3.getMinV());
					tessellator.addVertexWithUV(i + 0, j + 0, k + 0.015625D, icon3.getMinU(), icon3.getMinV());
				}
				if (world.getBlock(i, j, k + 1).isNormalCube() && world.getBlock(i, j + 1, k + 1) == SABlockList.RedstoneWire)
				{
					tessellator.setColorOpaque_F(f * f2, f * f3, f * f4);
					tessellator.addVertexWithUV(i + 1, j + 1 + 0.021875F, k + 1 - 0.015625D, icon1.getMaxU(), icon1.getMinV());
					tessellator.addVertexWithUV(i + 1, j + 0, k + 1 - 0.015625D, icon1.getMinU(), icon1.getMinV());
					tessellator.addVertexWithUV(i + 0, j + 0, k + 1 - 0.015625D, icon1.getMinU(), icon1.getMaxV());
					tessellator.addVertexWithUV(i + 0, j + 1 + 0.021875F, k + 1 - 0.015625D, icon1.getMaxU(), icon1.getMaxV());
					tessellator.setColorOpaque_F(f, f, f);
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
    	return SAClientProxy.ConnectorBlockRenderID;
	}
}*/