package sevenno_addons.common.block.render;

import org.lwjgl.opengl.GL11;

import sevenno_addons.proxy.SAClientProxy;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderEnderBlock implements ISimpleBlockRenderingHandler
{	
    public IIcon overrideBlockTexture;
    public boolean renderAllFaces;
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
	{
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		int pass = SAClientProxy.renderPass == 0 ? 1 : 0;
		 
		Tessellator tess = Tessellator.instance;
		tess.setBrightness(block.getMixedBrightnessForBlock(world, x, y, z));
		tess.setColorOpaque_F(1, 1, 1);
		
//		float f = 0.1875F;
//	    this.setOverrideBlockTexture(this.getBlockIcon(Blocks.water));
		renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		renderer.renderStandardBlock(block, x, y, z);
//        this.renderAllFaces = true;
		
//		this.setOverrideBlockTexture(this.getBlockIcon(Blocks.obsidian));
		renderer.setRenderBounds(0.15D, 0.15D, 0.15D, 0.85D, 0.85D, 0.85D);
		renderer.renderStandardBlock(block, x, y, z);
//        this.renderAllFaces = false;
		
		return true;
	}
	
    public IIcon getBlockIcon(Block p_147745_1_)
    {
        return this.getIconSafe(p_147745_1_.getBlockTextureFromSide(1));
    }
    
    public void setOverrideBlockTexture(IIcon p_147757_1_)
    {
        this.overrideBlockTexture = p_147757_1_;
    }
    
    public IIcon getIconSafe(IIcon p_147758_1_)
    {
        if (p_147758_1_ == null)
        {
            p_147758_1_ = ((TextureMap)Minecraft.getMinecraft().getTextureManager().getTexture(TextureMap.locationBlocksTexture)).getAtlasSprite("missingno");
        }

        return (IIcon)p_147758_1_;
    }

	@Override
	public boolean shouldRender3DInInventory(int modelId)
	{
		return false;
	}

	@Override
	public int getRenderId()
	{
		return SAClientProxy.RenderEnderBlockID;
	}
}
