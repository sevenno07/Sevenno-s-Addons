package sevenno_addons.common.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.List;

import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ModLogs extends BlockLog
{
    public static final String[] types = new String[] {"cherry", "ebony"};

    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativetab, List list)
    {
    	list.add(new ItemStack(item, 1, 0));
    	list.add(new ItemStack(item, 1, 1));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister)
    {
        this.field_150167_a = new IIcon[types.length];
        this.field_150166_b = new IIcon[types.length];

        for (int i = 0; i < this.field_150167_a.length; ++i)
        {
            this.field_150167_a[i] = iconregister.registerIcon(this.getTextureName() + "_" + types[i]);
            this.field_150166_b[i] = iconregister.registerIcon(this.getTextureName() + "_" + types[i] + "_top");
        }
    }
}