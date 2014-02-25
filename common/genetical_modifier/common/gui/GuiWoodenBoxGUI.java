package genetical_modifier.common.gui;

import genetical_modifier.common.block.container.ContainerWoodenBoxGUI;
import genetical_modifier.common.tileentity.TileEntityWoodenBoxGUI;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiWoodenBoxGUI extends GuiContainer
{
	public static ResourceLocation texture = new ResourceLocation("genetical_modifier", "textures/gui/container/WoodenBoxGUI.png");
	private TileEntityWoodenBoxGUI WoodenBox;
	private IInventory playerInventory;
	public GuiWoodenBoxGUI(InventoryPlayer inventory, TileEntityWoodenBoxGUI tileEntity)
	{
		super(new ContainerWoodenBoxGUI(inventory, tileEntity));
		this.WoodenBox = tileEntity;
		this.playerInventory = inventory;
		this.ySize = 230;
	}

	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		this.fontRendererObj.drawString(this.playerInventory.hasCustomInventoryName() ? this.playerInventory.getInventoryName() : StatCollector.translateToLocal(this.playerInventory.getInventoryName()), 8, 129, 0);
		this.fontRendererObj.drawString(this.WoodenBox.hasCustomInventoryName() ? this.WoodenBox.getInventoryName() : StatCollector.translateToLocal(this.WoodenBox.getInventoryName()), 8, 7, 0);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
	}
}
