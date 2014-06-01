package com.juicegrape.juicewares.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import com.juicegrape.juicewares.items.ModItems;

public class BlockHemp extends BlockReed {

	public BlockHemp() {
		super();
		setBlockName(BlockInfo.STRINGREED_UNLOCALIZED);	
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register) {
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.STRINGREED);
	}
	
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
		if (canBlockStay(world, x, y, z)) {
			if (world.isAirBlock(x, y + 1, z)) {
				Block beneath = world.getBlock(x, y - 1, z);
				if (beneath != this) {
					int meta = world.getBlockMetadata(x, y, z);
					if (meta >= BlockInfo.STRINGREED_GROWTH) {
						world.setBlock(x, y + 1, z, this);
						world.setBlockMetadataWithNotify(x, y + 1, z, 0, 4);
						world.setBlockMetadataWithNotify(x, y, z, 5, 4);
					} else {
						world.setBlockMetadataWithNotify(x, y, z, meta + 1, 4);
					}
				}
			}
		} else {
			func_150170_e(world, x, y, z);
		}
	}

	@Override
//	public boolean canSustainPlant(World world, int x, int y, int z, ForgeDirection direction, IPlantable plant) {
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
		Block plant = plantable.getPlant(world, x, y + 1, z);
		if (plant == this && this == ModBlocks.stringreed) {
			return true;
		}
		return super.canSustainPlant(world, x, y, z, direction,plantable);
	}
	
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		return new ItemStack(ModItems.stringreed);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return ModItems.stringreed;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Plains;
	}
	
	 @Override
	 public Block getPlant(IBlockAccess world, int x, int y, int z) {
		 return this;
	 }

}
