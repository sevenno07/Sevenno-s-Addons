package sevenno_addons.common.block;

import java.util.Random;

import sevenno_addons.common.Sevenno_addons;
import sevenno_addons.common.block.container.InventoryGreenMushroomLargeChest;
import sevenno_addons.common.creativetabs.SevennoAddonsCreativeTabs;
import sevenno_addons.common.tileentity.TileEntityGreenMushroomChest;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GreenMushroomChest extends BlockContainer
{
	private final Random random = new Random();
	
	protected GreenMushroomChest()
	{
		super(Material.wood);
//		this.setCreativeTab(SevennoAddonsCreativeTabs.SACreativeTabsBlock);
		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return 22;
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        if (world.getBlock(x, y, z - 1) == this)
        {
            this.setBlockBounds(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
        }
        else if (world.getBlock(x, y, z + 1) == this)
        {
            this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
        }
        else if (world.getBlock(x - 1, y, z) == this)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
        }
        else if (world.getBlock(x + 1, y, z) == this)
        {
            this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
        }
        else
        {
            this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
        }
    }

    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.unifyAdjacentChests(world, x, y, z);
        Block l = world.getBlock(x, y, z - 1);
        Block i1 = world.getBlock(x, y, z + 1);
        Block j1 = world.getBlock(x - 1, y, z);
        Block k1 = world.getBlock(x + 1, y, z);

        if (l == this)
        {
            this.unifyAdjacentChests(world, x, y, z - 1);
        }

        if (i1 == this)
        {
            this.unifyAdjacentChests(world, x, y, z + 1);
        }

        if (j1 == this)
        {
            this.unifyAdjacentChests(world, x - 1, y, z);
        }

        if (k1 == this)
        {
            this.unifyAdjacentChests(world, x + 1, y, z);
        }
    }
    
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving living, ItemStack itemStack)
    {
        Block l = world.getBlock(x, y, z - 1);
        Block i1 = world.getBlock(x, y, z + 1);
        Block j1 = world.getBlock(x - 1, y, z);
        Block k1 = world.getBlock(x + 1, y, z);
        byte b0 = 0;
        int l1 = MathHelper.floor_double((double)(living.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l1 == 0)
        {
            b0 = 2;
        }

        if (l1 == 1)
        {
            b0 = 5;
        }

        if (l1 == 2)
        {
            b0 = 3;
        }

        if (l1 == 3)
        {
            b0 = 4;
        }

        if (l != this && i1 != this && j1 != this && k1 != this)
        {
            world.setBlockMetadataWithNotify(x, y, z, b0, 3);
        }
        else
        {
            if ((l == this || i1 == this) && (b0 == 4 || b0 == 5))
            {
                if (l == this)
                {
                    world.setBlockMetadataWithNotify(x, y, z - 1, b0, 3);
                }
                else
                {
                    world.setBlockMetadataWithNotify(x, y, z + 1, b0, 3);
                }

                world.setBlockMetadataWithNotify(x, y, z, b0, 3);
            }

            if ((j1 == this || k1 == this) && (b0 == 2 || b0 == 3))
            {
                if (j1 == this)
                {
                    world.setBlockMetadataWithNotify(x - 1, y, z, b0, 3);
                }
                else
                {
                    world.setBlockMetadataWithNotify(x + 1, y, z, b0, 3);
                }

                world.setBlockMetadataWithNotify(x, y, z, b0, 3);
            }
        }

        if (itemStack.hasDisplayName())
        {
            ((TileEntityGreenMushroomChest)world.getTileEntity(x, y, z)).func_94043_a(itemStack.getDisplayName());
        }
    }

    public void unifyAdjacentChests(World world, int x, int y, int z)
    {
        if (!world.isRemote)
        {
            Block l = world.getBlock(x, y, z - 1);
            Block i1 = world.getBlock(x, y, z + 1);
            Block j1 = world.getBlock(x - 1, y, z);
            Block k1 = world.getBlock(x + 1, y, z);
            boolean flag = true;
            Block l1;
            Block i2;
            boolean flag1;
            byte b0;
            int j2;

            if (l != this && i1 != this)
            {
                if (j1 != this && k1 != this)
                {
                    b0 = 3;

                    if (l.func_149730_j() && !i1.func_149730_j())
                    {
                        b0 = 3;
                    }

                    if (i1.func_149730_j() && !l.func_149730_j())
                    {
                        b0 = 2;
                    }

                    if (j1.func_149730_j() && !k1.func_149730_j())
                    {
                        b0 = 5;
                    }

                    if (k1.func_149730_j() && !j1.func_149730_j())
                    {
                        b0 = 4;
                    }
                }
                else
                {
                    l1 = world.getBlock(j1 == this ? x - 1 : x + 1, y, z - 1);
                    i2 = world.getBlock(j1 == this ? x - 1 : x + 1, y, z + 1);
                    b0 = 3;
                    flag1 = true;

                    if (j1 == this)
                    {
                        j2 = world.getBlockMetadata(x - 1, y, z);
                    }
                    else
                    {
                        j2 = world.getBlockMetadata(x + 1, y, z);
                    }

                    if (j2 == 2)
                    {
                        b0 = 2;
                    }

                    if ((l.func_149730_j() || l1.func_149730_j()) && !i1.func_149730_j() && !i2.func_149730_j())
                    {
                        b0 = 3;
                    }

                    if ((i1.func_149730_j() || i2.func_149730_j()) && !l.func_149730_j() && !l1.func_149730_j())
                    {
                        b0 = 2;
                    }
                }
            }
            else
            {
                l1 = world.getBlock(x - 1, y, l == this ? z - 1 : z + 1);
                i2 = world.getBlock(x + 1, y, l == this ? z - 1 : z + 1);
                b0 = 5;
                flag1 = true;

                if (l == this)
                {
                    j2 = world.getBlockMetadata(x, y, z - 1);
                }
                else
                {
                    j2 = world.getBlockMetadata(x, y, z + 1);
                }

                if (j2 == 4)
                {
                    b0 = 4;
                }

                if ((j1.func_149730_j() || l1.func_149730_j()) && !k1.func_149730_j() && !i2.func_149730_j())
                {
                    b0 = 5;
                }

                if ((k1.func_149730_j() || i2.func_149730_j()) && !j1.func_149730_j() && !l1.func_149730_j())
                {
                    b0 = 4;
                }
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 3);
        }
    }
    
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        int l = 0;

        if (world.getBlock(x - 1, y, z) == this)
        {
            ++l;
        }

        if (world.getBlock(x + 1, y, z) == this)
        {
            ++l;
        }

        if (world.getBlock(x, y, z - 1) == this)
        {
            ++l;
        }

        if (world.getBlock(x, y, z + 1) == this)
        {
            ++l;
        }

        return l > 1 ? false : (this.isThereANeighborChest(world, x - 1, y, z) ? false : (this.isThereANeighborChest(world, x + 1, y, z) ? false : (this.isThereANeighborChest(world, x, y, z - 1) ? false : !this.isThereANeighborChest(world, x, y, z + 1))));
    }

    private boolean isThereANeighborChest(World world, int x, int y, int z)
    {
        return world.getBlock(x, y, z) != this ? false : (world.getBlock(x - 1, y, z) == this ? true : (world.getBlock(x + 1, y, z) == this ? true : (world.getBlock(x, y, z - 1) == this ? true : world.getBlock(x, y, z + 1) == this)));
    }

    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        super.onNeighborBlockChange(world, x, y, z, block);
        TileEntityGreenMushroomChest tileentitygrimwoodchest = (TileEntityGreenMushroomChest)world.getTileEntity(x, y, z);

        if (tileentitygrimwoodchest != null)
        {
            tileentitygrimwoodchest.updateContainingBlockInfo();
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int par6)
    {
        TileEntityGreenMushroomChest tileentitygrimwoodchest = (TileEntityGreenMushroomChest)world.getTileEntity(x, y, z);

        if (tileentitygrimwoodchest != null)
        {
            for (int j1 = 0; j1 < tileentitygrimwoodchest.getSizeInventory(); ++j1)
            {
                ItemStack itemstack = tileentitygrimwoodchest.getStackInSlot(j1);

                if (itemstack != null)
                {
                    float f = this.random.nextFloat() * 0.8F + 0.1F;
                    float f1 = this.random.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityitem;

                    for (float f2 = this.random.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem))
                    {
                        int k1 = this.random.nextInt(21) + 10;

                        if (k1 > itemstack.stackSize)
                        {
                            k1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= k1;
                        entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));
                        float f3 = 0.05F;
                        entityitem.motionX = (double)((float)this.random.nextGaussian() * f3);
                        entityitem.motionY = (double)((float)this.random.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double)((float)this.random.nextGaussian() * f3);

                        if (itemstack.hasTagCompound())
                        {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                        }
                    }
                }
            }

            world.func_147453_f(x, y, z, block);
        }

        super.breakBlock(world, x, y, z, block, par6);
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f, float g, float t)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            IInventory iinventory = this.getInventory(world, x, y, z);

            if (iinventory != null)
            {
            	player.openGui(Sevenno_addons.instance, 3, world, x, y, z);
            }

            return true;
        }
    }
    
    public IInventory getInventory(World world, int x, int y, int z)
    {
        Object object = (TileEntityGreenMushroomChest)world.getTileEntity(x, y, z);

        if (object == null)
        {
            return null;
        }
        else if (world.isSideSolid(x, y + 1, z, ForgeDirection.DOWN))
        {
            return null;
        }
        else
        {
            if (world.getBlock(x - 1, y, z) == this)
            {
                object = new InventoryGreenMushroomLargeChest("container.gtreenMushroomDouble", (TileEntityGreenMushroomChest)world.getTileEntity(x - 1, y, z), (IInventory)object);
            }

            if (world.getBlock(x + 1, y, z) == this)
            {
                object = new InventoryGreenMushroomLargeChest("container.gtreenMushroomDouble", (IInventory)object, (TileEntityGreenMushroomChest)world.getTileEntity(x + 1, y, z));
            }

            if (world.getBlock(x, y, z - 1) == this)
            {
                object = new InventoryGreenMushroomLargeChest("container.gtreenMushroomDouble", (TileEntityGreenMushroomChest)world.getTileEntity(x, y, z - 1), (IInventory)object);
            }

            if (world.getBlock(x, y, z + 1) == this)
            {
                object = new InventoryGreenMushroomLargeChest("container.gtreenMushroomDouble", (IInventory)object, (TileEntityGreenMushroomChest)world.getTileEntity(x, y, z + 1));
            }

            return (IInventory)object;
        }
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int i)
	{
		return new TileEntityGreenMushroomChest();
	}
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("sevenno_addons:greenMushroomBlock_N");
    }
}