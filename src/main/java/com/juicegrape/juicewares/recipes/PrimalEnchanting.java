package com.juicegrape.juicewares.recipes;

import java.util.Iterator;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;

import com.juicegrape.juicewares.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;



public class PrimalEnchanting {

	private static void addRecipe(ItemStack stack, ItemStack enchantItem, Enchantment enchant, int level) {
		if (enchant.canApply(stack)) {
			GameRegistry.addRecipe(new PrimalEnchantRecipe(stack.getItem(), enchantItem, enchant, level));
		}
	}
	
	public static void init() {
		
		RecipeSorter.register("Primal Enchanting", PrimalEnchantRecipe.class, Category.SHAPELESS, "");
		
		
		@SuppressWarnings("rawtypes")
		Iterator itr = Item.itemRegistry.iterator();
		while (itr.hasNext()) {
			Item toolItem = (Item)itr.next();
			if (toolItem != null) {
				ItemStack tool = new ItemStack(toolItem);
				
				addRecipe(tool, new ItemStack(ModItems.enchantmentItem, 1, 0), Enchantment.sharpness, 1);
				
				addRecipe(tool, new ItemStack(ModItems.enchantmentItem, 1, 1), Enchantment.fortune, 1);
				addRecipe(tool, new ItemStack(ModItems.enchantmentItem, 1, 1), Enchantment.looting, 1);
				
				addRecipe(tool, new ItemStack(Blocks.piston), Enchantment.knockback, 1);
				
				addRecipe(tool, new ItemStack(Items.blaze_rod), Enchantment.fireAspect, 1);
				
				addRecipe(tool, new ItemStack(Items.blaze_powder), Enchantment.fireProtection, 1);
				
				addRecipe(tool, new ItemStack(Items.magma_cream), Enchantment.baneOfArthropods, 1);
				
				addRecipe(tool, new ItemStack(Items.golden_carrot), Enchantment.smite, 1);
				
				addRecipe(tool, new ItemStack(Blocks.cactus), Enchantment.thorns, 1);
				
				
				
				
			}
		}
	}
}
