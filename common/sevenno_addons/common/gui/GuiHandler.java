package sevenno_addons.common.gui;

import sevenno_addons.common.block.container.ContainerWoodenBoxGUI;
import sevenno_addons.common.tileentity.TileEntityWoodenBoxGUI;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	TileEntity tile_entity = world.getTileEntity(x, y, z);

	if(tile_entity instanceof TileEntityWoodenBoxGUI)
	{
		return new ContainerWoodenBoxGUI(player.inventory, (TileEntityWoodenBoxGUI) tile_entity);
	}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	TileEntity tile_entity = world.getTileEntity(x, y, z);

	if(tile_entity instanceof TileEntityWoodenBoxGUI)
	{
		return new GuiWoodenBoxGUI(player.inventory, (TileEntityWoodenBoxGUI) tile_entity);
	}
		return null;
	}
}