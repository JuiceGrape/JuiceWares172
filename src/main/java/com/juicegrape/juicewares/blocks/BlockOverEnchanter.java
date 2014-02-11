package com.juicegrape.juicewares.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import com.juicegrape.juicewares.juicewares;
import com.juicegrape.juicewares.misc.SidedBlockHelper;
import com.juicegrape.juicewares.tileentities.TileEntityOverEnchanter;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOverEnchanter extends BlockContainer {

	IIcon[] icons;
	
	protected BlockOverEnchanter() {
		super(Material.anvil);
		setCreativeTab(juicewares.juiceTab);
		setBlockName(BlockInfo.OVERENCHANTER_UNLOCALIZED_NAME);
		
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityOverEnchanter();
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityliving, ItemStack itemStack) {
		int dir = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 0.5D) & 3;
	    world.setBlockMetadataWithNotify(x, y, z, dir, 3);
		System.out.println(SidedBlockHelper.getDirectionFromMeta(dir).name());
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		icons = new IIcon[BlockInfo.OVERENCHANTER_ARRAY.length];
		for (int i = 0; i < BlockInfo.OVERENCHANTER_ARRAY.length; i++) {
			icons[i] = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.OVERENCHANTER_ARRAY[i]);
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		ForgeDirection direc = SidedBlockHelper.getDirectionFromMeta(meta);
		ForgeDirection sideDirec = ForgeDirection.getOrientation(side);
		return getIconFromForgeDirc(direc, sideDirec);
	}
	
	private IIcon getIconFromForgeDirc(ForgeDirection direction, ForgeDirection side) {
		switch(direction) {
		case NORTH:
		case SOUTH:
			return icons[handleNorthSouth(direction, side)];
		case EAST:
		case WEST:
			return icons[handleEastWest(direction, side)];
		default:
			return icons[2];
		}
	}
	
	private int handleNorthSouth(ForgeDirection direction, ForgeDirection side) {
		if (side.equals(direction)) {
			return 0;
		} else if (side.equals(ForgeDirection.EAST) || side.equals(ForgeDirection.WEST)) {
			return 1;
		} else {
			return 2;
		}
	}
	
	private int handleEastWest(ForgeDirection direction, ForgeDirection side) {
		if (side.equals(direction)) {
			return 0;
		} else if (side.equals(ForgeDirection.NORTH) || side.equals(ForgeDirection.SOUTH)) {
			return 1;
		} else {
			return 2;
		}
	}
	
	@Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
    	if (!world.isRemote) {
    		if (world.getTileEntity(x, y, z) instanceof TileEntityOverEnchanter) {
    			TileEntityOverEnchanter over = (TileEntityOverEnchanter)world.getTileEntity(x, y, z);
    			if (player.isSneaking()) {
    				System.out.println(over.canEnchant());
    				if (over.canEnchant()) {
    					over.enchantAndPop();
    				}
					return true;
    			}
    			
    			if (over.tool == null) {
    				if (player.getCurrentEquippedItem() != null) {
    					ItemStack tool = player.getCurrentEquippedItem();
    					ItemStack tool1 = tool.copy();
    					tool1.stackSize = 1;
    					over.setItem(tool1);
    					tool.stackSize--;
    					if (tool.stackSize <= 0) {
    						player.setCurrentItemOrArmor(0, null);
    					} else {
        					player.setCurrentItemOrArmor(0, tool);
    					}
    				}
    			} else {
    				over.popTool();
    			}
    		}
    	}
    	return true;
	}
	

}
