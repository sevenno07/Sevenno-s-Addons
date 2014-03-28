package sevenno_addons.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sevenno_addons.common.block.SABlockList;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import net.minecraft.block.BlockRailBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class mineroller extends ItemArmor
{
	public mineroller(ArmorMaterial armorMaterial, int type, int layer)
	{
		super(armorMaterial, type, layer);
		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsArmor);
	}
	
	 public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	 {
		 if(this.armorType == 3 && player.isSprinting())
		 {
			 player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20, 1));
			 
/*			 System.out.println("rail");
			 if(this.armorType == 3 && player.isCollided)
			 {
				 player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20, 3));
			 }*/
		 }
		 
/*		 System.out.println("rail");
		 if(player.worldObj.getBlock(MathHelper.floor_double(player.posX), MathHelper.floor_double(player.posY), MathHelper.floor_double(player.posZ)) instanceof BlockRailBase);
		 {
			 player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20, 2));
		 }*/
	 }
	 
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(stack.getItem().equals(SAItemList.mineroller2))
        {
        	return null;
		}
        else
        {
        	return "sevenno_addons:textures/armor/MRoller.png";
        }
	}
	
	public boolean getIsRepairable(ItemStack stack, ItemStack repairItem)
	{
		if(stack.getItem().equals(this) && repairItem.getItem() == Items.iron_ingot)
			return true;
		return false;
	}
}