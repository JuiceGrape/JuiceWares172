package com.juicegrape.juicewares.recipes.primalEnchanting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class NewPrimalEnchantRecipe implements IRecipe {
	
	private boolean hasTool;
	private boolean hasItem;
	
	private int usedMat;
	
	private ItemStack outPut;
	
	private PrimalEnchantMaterial[] materials;
	
	public NewPrimalEnchantRecipe(PrimalEnchantMaterial[] mats) {
		materials = mats;
		hasTool = false;
		hasItem = false;
		outPut = null;
	}

	@Override
	public boolean matches(InventoryCrafting grid, World world) {
		for (int i = 0; i < grid.getSizeInventory(); i++) {
			ItemStack stack = grid.getStackInSlot(i);
			for (int j = 0; j < materials.length; j++) {
				if (stack != null && stack.getItem().equals(materials[j].getItem()) && stack.getItemDamage() == materials[j].getItemMetadata()) {
					if (hasItem) {
						return false;
					} else {
						hasItem = true;
						usedMat = j;
					}
				}
			}
		}
		
		if (hasItem) {
			for (int i = 0; i < grid.getSizeInventory(); i++) {
				ItemStack stack = grid.getStackInSlot(i);
				if (stack != null && stack.isItemEnchantable() && materials[usedMat].getEnchant().canApply(stack)) {
					if (hasTool) {
						return false;
					} else {
						hasTool = true;
						outPut = stack.copy();
						setOutput();
					}
				}
			}
		} else {
			hasItem = false;
			hasTool = false;
			return false;
		}
		
		if (!hasTool) {
			hasItem = false;
			hasTool = false;
		}
		
		return hasTool && hasItem && outPut != null;
	}
	
	private void setOutput() {
		int damage = outPut.getItemDamage() + ((outPut.getMaxDamage() - outPut.getItemDamage()) / 10);
		outPut.setItemDamage(damage);
		outPut.addEnchantment(materials[usedMat].getEnchant(), materials[usedMat].getEnchantLvl());
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting var1) {
		return outPut.copy();
	}

	@Override
	public int getRecipeSize() {
		return 2;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return outPut;
	}

}
