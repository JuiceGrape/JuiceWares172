package com.juicegrape.juicewares.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.juicegrape.juicewares.juicewares;
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
		switch (meta) {
		case 0:
			if (side == 2) {
				return icons[0];
			} else if (side == 4 || side == 5){
				return icons[1];
			} else {
				return icons[2];
			}
		case 1:
			if (side == 5) {
				return icons[0];
			} else if (side ==  2|| side == 3){
				return icons[1];
			} else {
				return icons[2];
			}
		case 2:
			if (side == 3) {
				return icons[0];
			} else if (side == 4 || side == 5){
				return icons[1];
			} else {
				return icons[2];
			}
		case 3:
			if (side == 4) {
				return icons[0];
			} else if (side == 2 || side == 3){
				return icons[1];
			} else {
				return icons[2];
			}
		default:
			if (side == 3) {
				return icons[0];
			} else if (side == 4 || side == 5){
				return icons[1];
			} else {
				return icons[2];
			}
		}
	}
	

}
