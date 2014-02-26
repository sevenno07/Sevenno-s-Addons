package sevenno_addons.common.gui;

import sevenno_addons.common.block.container.ContainerWoodenBoxGUI;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiWoodenBoxGUI extends GuiContainer
{
    private static final ResourceLocation textures = new ResourceLocation("sevenno_addons", "textures/gui/container/WoodenBoxGUI.png");
	
	private IInventory tileEntity;
    private IInventory inventory;

    private int inventoryRows = 0;

    public GuiWoodenBoxGUI(IInventory par1IInventory, IInventory par2IInventory)
    {
        super(new ContainerWoodenBoxGUI(par1IInventory, par2IInventory));
        this.tileEntity = par1IInventory;
        this.inventory = par2IInventory;
        this.allowUserInput = false;
        short short1 = 222;
        int i = short1 - 108;
        this.inventoryRows = par2IInventory.getSizeInventory() / 9;
        this.ySize = i + this.inventoryRows * 18;
    }

    protected void drawGuiContainerForegroundLayer(int par1, int par2)
    {
        this.fontRendererObj.drawString(this.inventory.hasCustomInventoryName() ? this.inventory.getInventoryName() : StatCollector.translateToLocal(this.inventory.getInventoryName()), 5, 6, 2299);
        this.fontRendererObj.drawString(this.tileEntity.hasCustomInventoryName() ? this.tileEntity.getInventoryName() : StatCollector.translateToLocal(this.tileEntity.getInventoryName()), 8, this.ySize - 96 + 2, 2299);
    }

    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(textures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l + this.inventoryRows * 0 + 0, 0, 55, this.xSize, 167);
    }
}