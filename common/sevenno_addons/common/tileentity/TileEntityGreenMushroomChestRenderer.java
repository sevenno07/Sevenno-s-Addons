package sevenno_addons.common.tileentity;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import sevenno_addons.common.block.GreenMushroomChest;
import cpw.mods.fml.common.FMLLog;

public class TileEntityGreenMushroomChestRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation SINGLE = new ResourceLocation("sevenno_addons", "textures/blocks/container/greenMushroomChest.png");
    private static final ResourceLocation DOUBLE = new ResourceLocation("sevenno_addons", "textures/blocks/container/greenMushroomChest_double.png");
	
    private ModelChest chestModel = new ModelChest();

    private ModelChest largeChestModel = new ModelLargeChest();
    
    public void renderTileEntityGreenMushroomChestAt(TileEntityGreenMushroomChest par1TileEntityGreenMushroomChest, double par2, double par4, double par6, float par8)
    {
    int i;

    if (!par1TileEntityGreenMushroomChest.hasWorldObj())
    {
        i = 0;
    }
    else
    {
        Block block = par1TileEntityGreenMushroomChest.getBlockType();
        i = par1TileEntityGreenMushroomChest.getBlockMetadata();

        if (block instanceof GreenMushroomChest && i == 0)
        {
            try
            {
                ((GreenMushroomChest)block).unifyAdjacentChests(par1TileEntityGreenMushroomChest.getWorldObj(), par1TileEntityGreenMushroomChest.xCoord, par1TileEntityGreenMushroomChest.yCoord, par1TileEntityGreenMushroomChest.zCoord);
            }
            catch (ClassCastException e)
            {
                FMLLog.severe("Attempted to render a chest at %d,  %d, %d that was not a chest",
                        par1TileEntityGreenMushroomChest.xCoord, par1TileEntityGreenMushroomChest.yCoord, par1TileEntityGreenMushroomChest.zCoord);
            }
            i = par1TileEntityGreenMushroomChest.getBlockMetadata();
        }

        par1TileEntityGreenMushroomChest.checkForAdjacentChests();
    }

    if (par1TileEntityGreenMushroomChest.adjacentChestZNeg == null && par1TileEntityGreenMushroomChest.adjacentChestXNeg == null)
    {
        ModelChest modelchest;

        if (par1TileEntityGreenMushroomChest.adjacentChestXPos == null && par1TileEntityGreenMushroomChest.adjacentChestZPosition == null)
        {
            modelchest = this.chestModel;
            this.bindTexture(SINGLE);
        }
        else
        {
            modelchest = this.largeChestModel;
            this.bindTexture(DOUBLE);
        }

        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float)par2, (float)par4 + 1.0F, (float)par6 + 1.0F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        short short1 = 0;

        if (i == 2)
        {
            short1 = 180;
        }

        if (i == 3)
        {
            short1 = 0;
        }

        if (i == 4)
        {
            short1 = 90;
        }

        if (i == 5)
        {
            short1 = -90;
        }

        if (i == 2 && par1TileEntityGreenMushroomChest.adjacentChestXPos != null)
        {
            GL11.glTranslatef(1.0F, 0.0F, 0.0F);
        }

        if (i == 5 && par1TileEntityGreenMushroomChest.adjacentChestZPosition != null)
        {
            GL11.glTranslatef(0.0F, 0.0F, -1.0F);
        }

        GL11.glRotatef((float)short1, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        float f1 = par1TileEntityGreenMushroomChest.prevLidAngle + (par1TileEntityGreenMushroomChest.lidAngle - par1TileEntityGreenMushroomChest.prevLidAngle) * par8;
        float f2;

        if (par1TileEntityGreenMushroomChest.adjacentChestZNeg != null)
        {
            f2 = par1TileEntityGreenMushroomChest.adjacentChestZNeg.prevLidAngle + (par1TileEntityGreenMushroomChest.adjacentChestZNeg.lidAngle - par1TileEntityGreenMushroomChest.adjacentChestZNeg.prevLidAngle) * par8;

            if (f2 > f1)
            {
                f1 = f2;
            }
        }

        if (par1TileEntityGreenMushroomChest.adjacentChestXNeg != null)
        {
            f2 = par1TileEntityGreenMushroomChest.adjacentChestXNeg.prevLidAngle + (par1TileEntityGreenMushroomChest.adjacentChestXNeg.lidAngle - par1TileEntityGreenMushroomChest.adjacentChestXNeg.prevLidAngle) * par8;

            if (f2 > f1)
            {
                f1 = f2;
            }
        }

        f1 = 1.0F - f1;
        f1 = 1.0F - f1 * f1 * f1;
        modelchest.chestLid.rotateAngleX = -(f1 * (float)Math.PI / 2.0F);
        modelchest.renderAll();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
	@Override
	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntityGreenMushroomChestAt((TileEntityGreenMushroomChest)par1TileEntity, par2, par4, par6, par8);
    }

}
