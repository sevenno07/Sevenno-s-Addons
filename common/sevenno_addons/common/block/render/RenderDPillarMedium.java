package sevenno_addons.common.block.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import sevenno_addons.common.block.RedstoneWire;
import sevenno_addons.common.block.SABlockList;
import sevenno_addons.proxy.SAClientProxy;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderDPillarMedium implements ISimpleBlockRenderingHandler
{
	public Block canconnectblocks1;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;
		renderer.setRenderBounds(0.125F, 0.125F, 0.125F, 0.875F, 0.875F, 0.875F);
		this.renderInInventory(tessellator, renderer, block, metadata);
	}
	
	private void renderInInventory(Tessellator tessellator, RenderBlocks renderer, Block block, int metadata)
	{
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1F, 0.0F);
		renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(1, metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1F);
		renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1F, 0.0F, 0.0F);
		renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, metadata));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, metadata));
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
}
	
	public boolean canConnect1(IBlockAccess world, int x, int y, int z)
	{
	    Block block = world.getBlock(x, y, z);
	    return block == canconnectblocks1 || block == SABlockList.DStonebrickPillar;
	    // par2World.getBlock(i, j, k)  instanceof BlockLiquid
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		//if(canConnect(world, x, y + 1, z)
		{//midle
			renderer.setRenderBounds(0.125F, 0.125F, 0.125F, 0.875F, 0.875F, 0.875F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		if(canConnect1 (world, x , y, z - 1))
		{//north
			renderer.setRenderBounds(0.125F, 0.125F, 0.0F, 0.875F, 0.875F, 0.875F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		if(canConnect1 (world, x + 1, y, z))
		{//east
			renderer.setRenderBounds(0.125F, 0.125F, 0.125F, 1.0F, 0.875F, 0.875F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		if(canConnect1 (world, x, y, z + 1))
		{//south
			renderer.setRenderBounds(0.125F, 0.125F, 0.125F, 0.875F, 0.875F, 1.0F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		if(canConnect1 (world, x - 1, y, z))
		{//west
			renderer.setRenderBounds(0.0F, 0.125F, 0.125F, 0.875F, 0.875F, 0.875F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		if(canConnect1 (world, x, y + 1, z))
		{//up
			renderer.setRenderBounds(0.125F, 0.125F, 0.125F, 0.875F, 1.0F, 0.875F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		
		if(canConnect1 (world, x, y - 1, z))
		{//down
			renderer.setRenderBounds(0.125F, 0.0F, 0.125F, 0.875F, 0.875F, 0.875F);
			renderer.renderStandardBlock(block, x, y, z);
		}
		return true;
	}
	
	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return true;
	}

	@Override
	public int getRenderId()
	{
    	return SAClientProxy.RenderDPillarMediumID;
	}
}