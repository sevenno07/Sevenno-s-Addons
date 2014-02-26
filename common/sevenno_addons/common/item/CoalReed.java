package sevenno_addons.common.item;

import sevenno_addons.common.block.SABlockList;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CoalReed extends Item implements IPlantable
{
	private Block Blocktype;
	
	public CoalReed(Block block, Block block1)
	{
		super();
		this.Blocktype = block;
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsItem);
	}
	
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
        if (par7 != 1)
        {
            return false;
        }
        else if (player.canPlayerEdit(x, y, z, par7, itemStack) && player.canPlayerEdit(x, y + 1, z, par7, itemStack))
        {
        	System.out.println(world.getBlock(x, y, z) == null);
        	if (world.getBlock(x, y, z) == SABlockList.SPReedBooster)
            {
                world.setBlock(x, y + 1, z, this.Blocktype);
                --itemStack.stackSize;
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("sevenno_addons:CoalReed");
 	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
	{
		return null;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z)
	{
		return Blocktype;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
	{
		return 0;
	}
}