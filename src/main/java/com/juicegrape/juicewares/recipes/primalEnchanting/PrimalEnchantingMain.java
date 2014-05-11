package com.juicegrape.juicewares.recipes.primalEnchanting;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;

import com.juicegrape.juicewares.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class PrimalEnchantingMain {

	public static PrimalEnchantMaterial[] mats;
	
	public static void init() {
		
		RecipeSorter.register("Primal Enchanting", NewPrimalEnchantRecipe.class, Category.SHAPELESS, "");
		
		
		List<PrimalEnchantMaterial> tempMats = new ArrayList<PrimalEnchantMaterial>();
		
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(ModItems.enchantmentItem, 1, 0), Enchantment.sharpness, 1, false));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(ModItems.enchantmentItem, 1, 1), Enchantment.fortune, 1, true));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(ModItems.enchantmentItem, 1, 1), Enchantment.looting, 1, true));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(Blocks.piston), Enchantment.knockback));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(Items.blaze_rod), Enchantment.fireAspect));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(Items.magma_cream), Enchantment.baneOfArthropods));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(ModItems.enchantmentItem, 1, 2), Enchantment.smite));
		
		
		
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(Items.blaze_powder), Enchantment.fireProtection));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(Blocks.cactus), Enchantment.thorns));
		
		
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
