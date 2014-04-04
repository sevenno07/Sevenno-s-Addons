package sevenno_addons.common.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Modplanks extends Block
{
    public static final String[] woodes_types = new String[] {"cherry", "ebony"};
    @SideOnly(Side.CLIENT)
    private IIcon[] icon;

    public Modplanks()
    {
        super(Material.wood);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int par1, int par2)
    {
        if (par2 < 0 || par2 >= this.icon.length)
        {
        	par2 = 0;
        }

        return this.icon[par2];
    }

    public int damageDropped(int par1)
    {
        return par1;
    }

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativetab, List list)
    {
    	list.add(new ItemStack(item, 1, 0));
    	list.add(new ItemStack(item, 1, 1));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister)
    {
        this.icon = new IIcon[woodes_types.length];

        for (int i = 0; i < this.icon.length; ++i)
        {
            this.icon[i] = iconregister.registerIcon(this.getTextureName() + "_" + woodes_types[i]);
        }
    }
}