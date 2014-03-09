package sevenno_addons.common.item;

import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PurpleEnzymesBucket extends ItemBucket
{
    public PurpleEnzymesBucket(Block blockPurpleDigestiveEnzymes)
    {
    	super(blockPurpleDigestiveEnzymes);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsItem);
    }
    
  	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
	{
        this.itemIcon = iconregister.registerIcon("sevenno_addons:purpleEnzymes_bucket");
 	}
}