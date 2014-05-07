package com.juicegrape.juicewares.recipes.primalEnchanting;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;

import com.juicegrape.juicewares.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class TestPrimalEnchant {

	
	public static void init() {
		
		PrimalEnchantMaterial[] mats = new PrimalEnchantMaterial[1];
		mats[0] = new PrimalEnchantMaterial(new ItemStack(ModItems.enchantmentItem, 1, 0), Enchantment.sharpness, 1);
		
		GameRegistry.addRecipe(new NewPrimalEnchantRecipe(mats));
	}
	
	
	
}
