package sevenno_addons.common.item;

import sevenno_addons.common.block.SABlockList;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;

public class SuperPickaxe extends ItemPickaxe
{
	public SuperPickaxe(ToolMaterial toolmaterial)
	{
		super(toolmaterial);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsTool);
	}

	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if(world.getBlock(x, y, z) == (Blocks.bedrock) && y != 0 && !world.isRemote)
		{
				world.setBlockToAir(x, y, z);
			EntityItem entityitem = new EntityItem(world, x, y, z, new ItemStack(SAItemList.BedrockPowder, 2, 0));
			entityitem.delayBeforeCanPickup = 10;
				world.spawnEntityInWorld(entityitem);
				stack.damageItem(8000, player);
				
			return true;
		}
		else
		{
			return false;
		}
	}

  	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("sevenno_addons:Superpickaxe");
 	}
}