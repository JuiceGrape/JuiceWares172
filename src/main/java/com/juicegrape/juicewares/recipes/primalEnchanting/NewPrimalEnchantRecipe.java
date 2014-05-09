package com.juicegrape.juicewares.recipes.primalEnchanting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class NewPrimalEnchantRecipe implements IRecipe {
	
	private ItemStack outPut;
	
	private PrimalEnchantMaterial[] materials;
	
	public NewPrimalEnchantRecipe(PrimalEnchantMaterial[] mats) {
		materials = mats;
		outPut = null;
	}

	@Override
	public boolean matches(InventoryCrafting grid, World world) {
		boolean hasTool = false;
		boolean hasItem = false;
		List<PrimalEnchantMaterial> usedMats = new ArrayList<PrimalEnchantMaterial>();
		for (int i = 0; i < grid.getSizeInventory(); i++) {
			ItemStack stack = grid.getStackInSlot(i);
			for (int j = 0; j < materials.length; j++) {
				if (stack != null && stack.getItem().equals(materials[j].getItem()) && stack.getItemDamage() == materials[j].getItemMetadata()) {
					if (hasItem && !usedMats.get(0).getItem().equals(materials[j].getItem()) && usedMats.get(0).getItemMetadata() != materials[j].getItemMetadata()) {
						return false;
					} else if (!hasItem){
						hasItem = true;
						usedMats.add(materials[j]);
						if (materials[j].hasMultiple()) {
							for (int k = 0; k < materials.length; k++) {
								if (k != j && materials[j].getItem().equals(materials[k].getItem()) && materials[j].getItemMetadata() == materials[k].getItemMetadata()) {
									usedMats.add(materials[k]);
								}
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < grid.getSizeInventory(); i++) {
			ItemStack stack = grid.getStackInSlot(i);
			if (hasItem && stack != null && !stack.getItem().equals(usedMats.get(0).getItem())) {
				if (hasTool) {
					return false;
				} else {
					Iterator<PrimalEnchantMaterial> itr = usedMats.iterator();
					
					while (itr.hasNext()) {
						PrimalEnchantMaterial tempMat = itr.next();
						if (tempMat.getEnchant().canApply(stack)) {
							if (hasTool) {
								System.out.println("ERROR, Double enchant material registered for this tool. Cannot primal enchant!");
							} else {
								hasTool = true;
								outPut = stack.copy();
								setOutput(tempMat.getEnchant(), tempMat.getEnchantLvl());
							}
						}
					}
				}
			}
		}
		
		return hasTool && hasItem && outPut != null;
	}
	
	private void setOutput(Enchantment enchant, int enchantLvl) {
		int damage = outPut.getItemDamage() + ((outPut.getMaxDamage() - outPut.getItemDamage()) / 10);
		if (outPut.getItem().isDamageable()) {
			outPut.setItemDamage(damage);
		}
		outPut.addEnchantment(enchant, enchantLvl);
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
