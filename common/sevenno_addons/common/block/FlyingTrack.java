package sevenno_addons.common.block;
     
import java.util.List;

import sevenno_addons.common.item.SAItemList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRail;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
     
public class FlyingTrack extends BlockRail
{
	@SideOnly(Side.CLIENT)
	private IIcon field_150056_b;
     
	protected FlyingTrack()
	{
		super();
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.1F, 1.0F);
	}
     
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2)
	{
		return par2 >= 6 ? this.field_150056_b : this.blockIcon;
	}
     
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		super.registerBlockIcons(iconRegister);
		this.field_150056_b = iconRegister.registerIcon(this.getTextureName() + "_Turn");
	}
     
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return true;
	}
     
	public void onBlockAdded(World world, int x, int y, int z)
	{
		if(!world.isRemote)
		{
			this.func_150052_a(world, x, y, z, true);
     
			if(this.field_150053_a)
			{
				this.onNeighborBlockChange(world, x, y, z, this);
			}
		}
	}
     
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		if(!world.isRemote)
		{
			int l = world.getBlockMetadata(x, y, z);
			int i1 = l;
     
			if(this.field_150053_a)
			{
				i1 = l & 7;
			}
     
			else
			{
				this.func_150048_a(world, x, y, z, l, i1, block);
			}
		}
	}
     
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axis, List list, Entity entity)
	{
		if(entity instanceof EntityLivingBase)
		{
			EntityLivingBase player = (EntityLivingBase)entity;
			ItemStack boots = player.getEquipmentInSlot(1);
			if(boots != null && boots.getItem() == SAItemList.mineroller)
			{
				AxisAlignedBB axisalignedbb1 = AxisAlignedBB.getAABBPool().getAABB((double)x - 0.05F, (double)y - 0.1F, (double)z - 0.05F, (double)x + 1.05F, (double)y + 0.0F, (double)z + 1.05F);
     
				if(axisalignedbb1 != null && axis.intersectsWith(axisalignedbb1))
				{
					list.add(axisalignedbb1);
				}
			}
		}
	}
}