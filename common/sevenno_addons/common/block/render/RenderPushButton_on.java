package sevenno_addons.common.block.render;

import sevenno_addons.proxy.SAClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderPushButton_on implements ISimpleBlockRenderingHandler
{

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
	{
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		renderer.setRenderBounds(0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F);
		renderer.renderStandardBlock(block, x, y, z);
		renderer.setRenderBounds(0.20F, 0.375F, 0.375F, 0.80F, 0.625F, 0.625F);
		renderer.renderStandardBlock(block, x, y, z);
		renderer.setRenderBounds(0.375F, 0.20F, 0.375F, 0.625F, 0.80F, 0.625F);
		renderer.renderStandardBlock(block, x, y, z);
		renderer.setRenderBounds(0.375F, 0.375F, 0.20F, 0.625F, 0.625F, 0.80F);
		renderer.renderStandardBlock(block, x, y, z);
		
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return false;
	}

	@Override
	public int getRenderId()
	{
		return SAClientProxy.RenderPushButton_onID;
	}
}
