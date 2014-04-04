package sevenno_addons.common.item;

import sevenno_addons.common.block.SABlockList;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class test extends Item
{
    public test()
    {
    	super();
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsTool);
    }
    
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
//		if(stack.getItemDamage() == 16)
		{
			if(!world.isRemote && world.getBlock(x, y, z) == SABlockList.DGoldenSandstone)
			{
				if(world.getBlock(x, y, z) == SABlockList.DGoldenSandstone && world.getBlock(x - 1, y, z) == SABlockList.DGoldenSandstone && world.getBlock(x - 2, y + 1, z) == SABlockList.DGoldenSandstone && world.getBlock(x - 2, y + 2, z) == SABlockList.DGoldenSandstone && world.getBlock(x - 2, y + 3, z) == SABlockList.DGoldenSandstone && world.getBlock(x + 1, y + 1, z) == SABlockList.DGoldenSandstone && world.getBlock(x + 1, y + 2, z) == SABlockList.DGoldenSandstone && world.getBlock(x + 1, y + 3, z) == SABlockList.DGoldenSandstone && world.getBlock(x - 1, y + 4, z) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 4, z) == SABlockList.DGoldenSandstone)
				{
					for(int i = 0; i < 3; i++)
					{
						world.setBlock(x, y + 1 + i, z, SABlockList.DragonPortal);
						world.setBlock(x - 1, y + 1 + i, z, SABlockList.DragonPortal);
					}
					if(!player.capabilities.isCreativeMode)
					{
						stack.stackSize--;
					}
					return true;
				}

				if(world.getBlock(x, y, z) == SABlockList.DGoldenSandstone && world.getBlock(x + 1, y, z) == SABlockList.DGoldenSandstone && world.getBlock(x + 2, y + 1, z) == SABlockList.DGoldenSandstone && world.getBlock(x + 2, y + 2, z) == SABlockList.DGoldenSandstone && world.getBlock(x + 2, y + 3, z) == SABlockList.DGoldenSandstone && world.getBlock(x - 1, y + 1, z) == SABlockList.DGoldenSandstone && world.getBlock(x - 1, y + 2, z) == SABlockList.DGoldenSandstone && world.getBlock(x - 1, y + 3, z) == SABlockList.DGoldenSandstone && world.getBlock(x + 1, y + 4, z) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 4, z) == SABlockList.DGoldenSandstone)
				{
					for(int i = 0; i < 3; i++)
					{
						world.setBlock(x, y + 1 + i, z, SABlockList.DragonPortal);
						world.setBlock(x + 1, y + 1 + i, z, SABlockList.DragonPortal);
					}
					if(!player.capabilities.isCreativeMode)
					{
						stack.stackSize--;
					}
					return true;
				}

				if(world.getBlock(x, y, z) == SABlockList.DGoldenSandstone && world.getBlock(x, y, z - 1) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 1, z - 2) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 2, z - 2) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 3, z - 2) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 1, z + 1) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 2, z + 1) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 3, z + 1) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 4, z - 1) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 4, z) == SABlockList.DGoldenSandstone)
				{
					for(int i = 0; i < 3; i++)
					{
						world.setBlock(x, y + 1 + i, z, SABlockList.DragonPortal);
						world.setBlock(x, y + 1 + i, z - 1, SABlockList.DragonPortal);
					}
					if(!player.capabilities.isCreativeMode)
					{
						stack.stackSize--;
					}
					return true;
				}

				if(world.getBlock(x, y, z) == SABlockList.DGoldenSandstone && world.getBlock(x, y, z + 1) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 1, z + 2) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 2, z + 2) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 3, z + 2) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 1, z - 1) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 2, z - 1) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 3, z - 1) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 4, z + 1) == SABlockList.DGoldenSandstone && world.getBlock(x, y + 4, z) == SABlockList.DGoldenSandstone)
				{
					for(int i = 0; i < 3; i++)
					{
						world.setBlock(x, y + 1 + i, z, SABlockList.DragonPortal);
						world.setBlock(x, y + 1 + i, z + 1, SABlockList.DragonPortal);
					}
					if(!player.capabilities.isCreativeMode)
					{
						stack.stackSize--;
					}
					return true;
				}
			}
		}
		return false;
	}
}