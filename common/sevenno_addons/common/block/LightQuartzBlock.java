package sevenno_addons.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class LightQuartzBlock extends Block
{
    public static final String[] type_a = new String[] {"default", "chiseled", "lines"};
    private static String[] type_b = new String[] {"lightquartzblock", "lightquartzblockchiseled", "lightquartzblocklines", null, null};
    @SideOnly(Side.CLIENT)
    private IIcon[] part_M;
    @SideOnly(Side.CLIENT)
    private IIcon part_N;
    @SideOnly(Side.CLIENT)
    private IIcon part_O;
    @SideOnly(Side.CLIENT)
    private IIcon part_P;
    @SideOnly(Side.CLIENT)
    private IIcon part_Q;

    public LightQuartzBlock()
    {
        super(Material.rock);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        if (par2 != 2 && par2 != 3 && par2 != 4)
        {
            if (par1 != 1 && (par1 != 0 || par2 != 1))
            {
                if (par1 == 0)
                {
                    return this.part_Q;
                }
                else
                {
                    if (par2 < 0 || par2 >= this.part_M.length)
                    {
                    	par2 = 0;
                    }

                    return this.part_M[par2];
                }
            }
            else
            {
                return par2 == 1 ? this.part_N : this.part_P;
            }
        }
        else
        {
            return par2 == 2 && (par1 == 1 || par1 == 0) ? this.part_O : (par2 == 3 && (par1 == 5 || par1 == 4) ? this.part_O : (par2 == 4 && (par1 == 2 || par1 == 3) ? this.part_O : this.part_M[par2]));
        }
    }

    public int onBlockPlaced(World par1, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        if (par9 == 2)
        {
            switch (par5)
            {
                case 0:
                case 1:
                	par9 = 2;
                    break;
                case 2:
                case 3:
                	par9 = 4;
                    break;
                case 4:
                case 5:
                	par9 = 3;
            }
        }

        return par9;
    }

    public int damageDropped(int par1)
    {
        return par1 != 3 && par1 != 4 ? par1 : 2;
    }

    protected ItemStack createStackedBlock(int par1)
    {
        return par1 != 3 && par1 != 4 ? super.createStackedBlock(par1) : new ItemStack(Item.getItemFromBlock(this), 1, 2);
    }

    public int getRenderType()
    {
        return 39;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativetab, List list)
    {
    	list.add(new ItemStack(item, 1, 0));
    	list.add(new ItemStack(item, 1, 1));
    	list.add(new ItemStack(item, 1, 2));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        this.part_M = new IIcon[type_b.length];

        for (int i = 0; i < this.part_M.length; ++i)
        {
            if (type_b[i] == null)
            {
                this.part_M[i] = this.part_M[i - 1];
            }
            else
            {
                this.part_M[i] = icon.registerIcon("sevenno_addons:" + type_b[i]);
            }
        }

        this.part_P = icon.registerIcon(this.getTextureName() + "_top");
        this.part_N = icon.registerIcon(this.getTextureName() + "_chiseled_top");
        this.part_O = icon.registerIcon(this.getTextureName() + "_lines_top");
        this.part_Q = icon.registerIcon(this.getTextureName() + "_bottom");
    }

    public MapColor getMapColor(int p_149728_1_)
    {
        return MapColor.quartzColor;
    }
}