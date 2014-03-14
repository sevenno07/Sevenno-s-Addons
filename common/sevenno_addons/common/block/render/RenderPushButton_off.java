package sevenno_addons.common.block.render;

import org.lwjgl.opengl.GL11;

import sevenno_addons.proxy.SAClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderPushButton_off implements ISimpleBlockRenderingHandler
{

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
	{
		Tessellator tessellator = Tessellator.instance;
		renderer.setRenderBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);
		this.renderInInventory(tessellator, renderer, block, metadata);
		renderer.setRenderBounds(0.15F, 0.375F, 0.375F, 0.85F, 0.625F, 0.625F);
		this.renderInInventory(tessellator, renderer, block, metadata);
		renderer.setRenderBounds(0.375F, 0.15F, 0.375F, 0.625F, 0.85F, 0.625F);
		this.renderInInventory(tessellator, renderer, block, metadata);
		renderer.setRenderBounds(0.375F, 0.375F, 0.15F, 0.625F, 0.625F, 0.85F);
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

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		renderer.setRenderBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);
		renderer.renderStandardBlock(block, x, y, z);
		renderer.setRenderBounds(0.15F, 0.375F, 0.375F, 0.85F, 0.625F, 0.625F);
		renderer.renderStandardBlock(block, x, y, z);
		renderer.setRenderBounds(0.375F, 0.15F, 0.375F, 0.625F, 0.85F, 0.625F);
		renderer.renderStandardBlock(block, x, y, z);
		renderer.setRenderBounds(0.375F, 0.375F, 0.15F, 0.625F, 0.625F, 0.85F);
		renderer.renderStandardBlock(block, x, y, z);
		
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return true;
	}

	@Override
	public int getRenderId()
	{
		return SAClientProxy.RenderPushButton_offID;
	}
}