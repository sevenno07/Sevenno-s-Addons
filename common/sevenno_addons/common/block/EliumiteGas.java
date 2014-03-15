package sevenno_addons.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EliumiteGas extends BlockFluidClassic
{
    private IIcon stillIcon, flowingIcon;
	
	public EliumiteGas(Fluid fluid, Material material)
	{
		super(fluid, material);
		this.setTickRandomly(true);
	}
       
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if (entity instanceof EntityLivingBase)
		{
			((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.confusion.getId(),200, 10));
		}
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block blockid)
	{
		super.onNeighborBlockChange(world, x, y, z, blockid);
		this.checkdoexplode(world, x, y, z);
	}
	
	public void checkdoexplode(World world, int x, int y, int z)
	{
	    if(world.getBlock(x, y - 1, z) == Blocks.powered_comparator || world.getBlock(x, y + 1, z) == Blocks.powered_comparator || world.getBlock(x - 1, y, z) == Blocks.powered_comparator || world.getBlock(x + 1, y, z) == Blocks.powered_comparator || world.getBlock(x, y, z - 1) == Blocks.powered_comparator || world.getBlock(x, y, z + 1) == Blocks.powered_comparator ||
	      (world.getBlock(x, y - 1, z) == Blocks.powered_repeater || world.getBlock(x, y + 1, z) == Blocks.powered_repeater || world.getBlock(x - 1, y, z) == Blocks.powered_repeater || world.getBlock(x + 1, y, z) == Blocks.powered_repeater || world.getBlock(x, y, z - 1) == Blocks.powered_repeater || world.getBlock(x, y, z + 1) == Blocks.powered_repeater ||
	      (world.getBlock(x, y - 1, z) == Blocks.redstone_torch || world.getBlock(x, y + 1, z) == Blocks.redstone_torch || world.getBlock(x - 1, y, z) == Blocks.redstone_torch || world.getBlock(x + 1, y, z) == Blocks.redstone_torch || world.getBlock(x, y, z - 1) == Blocks.redstone_torch || world.getBlock(x, y, z + 1) == Blocks.redstone_torch ||
	      (world.getBlock(x, y - 1, z) == Blocks.torch || world.getBlock(x, y + 1, z) == Blocks.torch || world.getBlock(x - 1, y, z) == Blocks.torch || world.getBlock(x + 1, y, z) == Blocks.torch || world.getBlock(x, y, z - 1) == Blocks.torch || world.getBlock(x, y, z + 1) == Blocks.torch ||
	      (world.getBlock(x, y - 1, z) == Blocks.lava || world.getBlock(x, y + 1, z) == Blocks.lava || world.getBlock(x - 1, y, z) == Blocks.lava || world.getBlock(x + 1, y, z) == Blocks.lava || world.getBlock(x, y, z - 1) == Blocks.lava || world.getBlock(x, y, z + 1) == Blocks.lava || world.getBlock(x, y - 1, z) == Blocks.flowing_lava || world.getBlock(x, y + 1, z) == Blocks.flowing_lava || world.getBlock(x - 1, y, z) == Blocks.flowing_lava || world.getBlock(x + 1, y, z) == Blocks.flowing_lava || world.getBlock(x, y, z - 1) == Blocks.flowing_lava || world.getBlock(x, y, z + 1) == Blocks.flowing_lava ||
	      (world.getBlock(x, y - 1, z) == SABlockList.blockSoulplasm || world.getBlock(x, y + 1, z) == SABlockList.blockSoulplasm || world.getBlock(x - 1, y, z) == SABlockList.blockSoulplasm || world.getBlock(x + 1, y, z) == SABlockList.blockSoulplasm || world.getBlock(x, y, z - 1) == SABlockList.blockSoulplasm || world.getBlock(x, y, z + 1) == SABlockList.blockSoulplasm))))))
		{
			if(!world.isRemote)
			{
				world.setBlockToAir(x, y, z);
				float power = (float)world.rand.nextInt(15) - 5.5F;
				if(power < 7F)
				{
					power = 20F;
				}
				EntityTNTPrimed tnt = new EntityTNTPrimed(world);
				world.newExplosion(tnt, x, y, z, power, true, true);
				world.notifyBlockChange(x, y, z, this);
			}
		}
	}
	
	public IIcon getIcon(int side, int metadata)
	{
		return (side == 0 || side == 1) ? stillIcon : flowingIcon;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.stillIcon = iconRegister.registerIcon("sevenno_addons:eliumite_gas");
		this.flowingIcon = iconRegister.registerIcon("sevenno_addons:eliumite_gas");
	}
	
	public boolean canDisplace(IBlockAccess world, int x, int y, int z)
	{
		if(world.getBlock(x, y, z).getMaterial().isLiquid())
		{
			return false;
		}
		return super.canDisplace(world, x, y, z);
	}

	public boolean displaceIfPossible(World world, int x, int y, int z)
	{
		if(world.getBlock(x, y, z).getMaterial().isLiquid())
		{
			return false;
		}
		return super.displaceIfPossible(world, x, y, z);
	}
}