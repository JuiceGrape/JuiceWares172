package com.juicegrape.juicewares.tileentities;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityOverEnchanter extends TileEntity {
	
	
	public ItemStack tool;
	
	
	public TileEntityOverEnchanter() {
		tool = null;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		tool = ItemStack.loadItemStackFromNBT(nbt);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		tool.writeToNBT(nbt);
	}
	
	
	
	
}
