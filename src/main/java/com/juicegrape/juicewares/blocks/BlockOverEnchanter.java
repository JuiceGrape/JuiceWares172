package com.juicegrape.juicewares.blocks;

import com.juicegrape.juicewares.juicewares;
import com.juicegrape.juicewares.tileentities.TileEntityOverEnchanter;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockOverEnchanter extends BlockContainer {

	protected BlockOverEnchanter() {
		super(Material.anvil);
		setCreativeTab(juicewares.juiceTab);
		setBlockName(BlockInfo.OVERENCHANTER_UNLOCALIZED_NAME);
		
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityOverEnchanter();
	}

}
