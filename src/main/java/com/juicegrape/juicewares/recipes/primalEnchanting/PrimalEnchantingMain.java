package com.juicegrape.juicewares.recipes.primalEnchanting;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;

import com.juicegrape.juicewares.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class PrimalEnchantingMain {

	public static PrimalEnchantMaterial[] mats;
	
	public static void init() {
		
		List<PrimalEnchantMaterial> tempMats = new ArrayList<PrimalEnchantMaterial>();
		
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(ModItems.enchantmentItem, 1, 0), Enchantment.sharpness, 1, false));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(ModItems.enchantmentItem, 1, 1), Enchantment.fortune, 1, true));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(ModItems.enchantmentItem, 1, 1), Enchantment.looting, 1, true));
		
		mats = new PrimalEnchantMaterial[tempMats.size()];
		
		Iterator<PrimalEnchantMaterial> itr = tempMats.iterator();
		int counter = 0;
		
		while (itr.hasNext()) {
			mats[counter] = itr.next();
			counter++;
		}
		
		GameRegistry.addRecipe(new NewPrimalEnchantRecipe(mats));
	}
	
	
	
}
