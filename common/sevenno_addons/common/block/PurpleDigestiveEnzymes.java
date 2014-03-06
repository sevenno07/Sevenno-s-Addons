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
import nether_plus.common.block.NPBlockList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PurpleDigestiveEnzymes extends BlockFluidClassic
{
    private IIcon stillIcon, flowingIcon;
	
	public PurpleDigestiveEnzymes(Fluid fluid, Material material)
	{
		super(fluid, material);
		this.setTickRandomly(true);
	}
       
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if (entity instanceof EntityLivingBase)
		{
			((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.digSlowdown.getId(),200, 500));
			((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.confusion.getId(),200, 10));
			((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.poison.getId(),100, 500));
		}
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block blockid)
	{
		super.onNeighborBlockChange(world, x, y, z, blockid);
		this.checkdoexplode(world, x, y, z);
	}
	
	public void checkdoexplode(World world, int x, int y, int z)
	{
		if(world.getBlock(x, y - 1, z) == Blocks.water || world.getBlock(x, y + 1, z) == Blocks.water || world.getBlock(x - 1, y, z) == Blocks.water || world.getBlock(x + 1, y, z) == Blocks.water || world.getBlock(x, y, z - 1) == Blocks.water || world.getBlock(x, y, z + 1) == Blocks.water || world.getBlock(x, y - 1, z) == Blocks.flowing_water || world.getBlock(x, y + 1, z) == Blocks.flowing_water || world.getBlock(x - 1, y, z) == Blocks.flowing_water || world.getBlock(x + 1, y, z) == Blocks.flowing_water || world.getBlock(x, y, z - 1) == Blocks.flowing_water || world.getBlock(x, y, z + 1) == Blocks.flowing_water ||
		  (world.getBlock(x, y - 1, z) == Blocks.lava || world.getBlock(x, y + 1, z) == Blocks.lava || world.getBlock(x - 1, y, z) == Blocks.lava || world.getBlock(x + 1, y, z) == Blocks.lava || world.getBlock(x, y, z - 1) == Blocks.lava || world.getBlock(x, y, z + 1) == Blocks.lava || world.getBlock(x, y - 1, z) == Blocks.flowing_lava || world.getBlock(x, y + 1, z) == Blocks.flowing_lava || world.getBlock(x - 1, y, z) == Blocks.flowing_lava || world.getBlock(x + 1, y, z) == Blocks.flowing_lava || world.getBlock(x, y, z - 1) == Blocks.flowing_lava || world.getBlock(x, y, z + 1) == Blocks.flowing_lava) ||
		  (world.getBlock(x, y - 1, z) == NPBlockList.blockQuicksilver || world.getBlock(x, y + 1, z) == NPBlockList.blockQuicksilver || world.getBlock(x - 1, y, z) == NPBlockList.blockQuicksilver || world.getBlock(x + 1, y, z) == NPBlockList.blockQuicksilver || world.getBlock(x, y, z - 1) == NPBlockList.blockQuicksilver || world.getBlock(x, y, z + 1) == NPBlockList.blockQuicksilver ||
		  (world.getBlock(x, y - 1, z) == NPBlockList.blockSoulplasm || world.getBlock(x, y + 1, z) == NPBlockList.blockSoulplasm || world.getBlock(x - 1, y, z) == NPBlockList.blockSoulplasm || world.getBlock(x + 1, y, z) == NPBlockList.blockSoulplasm || world.getBlock(x, y, z - 1) == NPBlockList.blockSoulplasm || world.getBlock(x, y, z + 1) == NPBlockList.blockSoulplasm )))
		{
			if(!world.isRemote)
			{
				world.setBlockToAir(x, y, z);
				float power = (float)world.rand.nextInt(15) - 5.5F;
				if(power < 2.5F)
				{
					power = 5F;
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
		this.stillIcon = iconRegister.registerIcon("sevenno_addons:PurpleDigestiveEnzymes");
		this.flowingIcon = iconRegister.registerIcon("sevenno_addons:PurpleDigestiveEnzymes_flow");
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