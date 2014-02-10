package com.juicegrape.juicewares.recipes;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.juicegrape.juicewares.blocks.ModBlocks;
import com.juicegrape.juicewares.items.ModItems;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class FuelHandler implements IFuelHandler {
	
	public FuelHandler() {
		GameRegistry.registerFuelHandler(this);
	}

	@Override
	public int getBurnTime(ItemStack fuel) {
		Item item = fuel.getItem();
		
		if (item == ModItems.stringreed) {
			return 150;
		} else if (item == Item.getItemFromBlock(ModBlocks.drawer)){
			return 300;
		} else {
			return 0;
		} 
	}

}
