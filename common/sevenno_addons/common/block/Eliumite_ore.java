package sevenno_addons.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Eliumite_ore extends BlockBreakable
{
    public Eliumite_ore()
    {
        super("sevenno_addons:DEliumite_ore", Material.rock, false);
        this.setTickRandomly(true);
		this.setHarvestLevel("pickaxe", 3);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int par2, int par3, int par4, int par5)
    {
        return super.shouldSideBeRendered(blockAccess, par2, par3, par4, 1 - par5);
    }

    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if (world.getSavedLightValue(EnumSkyBlock.Block, x, y, z) > 11 - this.getLightOpacity())
        {
            if (world.provider.isHellWorld)
            {
            	world.setBlockToAir(x, y, z);
                return;
            }
            
            world.setBlock(x, y, z, SABlockList.blockEliumite_gas);
        }
    }
}