package com.juicegrape.juicewares.recipes.primalEnchanting;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;

import com.juicegrape.juicewares.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class PrimalEnchantingMain {

	public static PrimalEnchantMaterial[] mats;
	
	public static void init() {
		
		RecipeSorter.register("Primal Enchanting", NewPrimalEnchantRecipe.class, Category.SHAPELESS, "");
		
		
		List<PrimalEnchantMaterial> tempMats = new ArrayList<PrimalEnchantMaterial>();
		
		//Tools and weapons
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(ModItems.enchantmentItem, 1, 0), Enchantment.sharpness));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(ModItems.enchantmentItem, 1, 1), Enchantment.fortune, 1, true));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(ModItems.enchantmentItem, 1, 3), Enchantment.fortune, 2, true));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(ModItems.enchantmentItem, 1, 1), Enchantment.looting, 1, true));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(ModItems.enchantmentItem, 1, 3), Enchantment.looting, 2, true));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(ModItems.enchantmentItem, 1, 1), Enchantment.field_151370_z, 1, true));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(ModItems.enchantmentItem, 1, 3), Enchantment.field_151370_z, 2, true));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(Blocks.piston), Enchantment.knockback));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(Items.blaze_rod), Enchantment.fireAspect));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(Items.magma_cream), Enchantment.baneOfArthropods));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(ModItems.enchantmentItem, 1, 2), Enchantment.smite));
		
		
		//Armour
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(Items.blaze_powder), Enchantment.fireProtection));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(Blocks.cactus), Enchantment.thorns));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(Items.feather), Enchantment.featherFalling));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(Items.slime_ball), Enchantment.projectileProtection));
		tempMats.add(new PrimalEnchantMaterial(new ItemStack(Blocks.wool, 1, OreDictionary.WILDCARD_VALUE), Enchantment.blastProtection));
		
		
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
