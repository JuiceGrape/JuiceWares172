package com.juicegrape.juicewares.recipes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.juicegrape.juicewares.config.ConfigInfo;
import com.juicegrape.juicewares.items.ModItems;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class MortarPestleRecipes {
	
	private static ItemStack getOredictItem(String ingot) {
		List<ItemStack> results = OreDictionary.getOres(ingot);
		if (!results.isEmpty()) {
			return results.get(0);
		} else {
			return null;
		}
		
	}
	
/*	private static ItemStack getOredictItemWithPref(String oreName, String modid) {
		List<ItemStack> results = OreDictionary.getOres(oreName);
		if (!results.isEmpty()) {
			Iterator<ItemStack> itr = results.iterator();
			while (itr.hasNext()) {
				ItemStack stack = itr.next();
				String name = stack.getUnlocalizedName();
				if (name.contains(modid)) {
					
				}
			}
		} 
		return null;
	} */
	
	private static boolean hasBoth(String ingot) {
		boolean hasIngot = false;
		boolean hasDust = false;
		for (String entry : OreDictionary.getOreNames()) {
			if (entry.contains(ingot)) {
				if (entry.startsWith("ingot")) {
					hasIngot = true;
				} else if (entry.startsWith("dust")) {
					hasDust = true;
				}
			}
		}
		return hasIngot && hasDust;
	}
	
	
	public static void init() {
		if (!ConfigInfo.enableMortarAndPestle) {
			return;
		}
		List<String> ingots = new ArrayList<String>();
		
		for (String entry : OreDictionary.getOreNames()) {
			if (entry.contains("ingot")) {
				String name = entry.substring(5);
				if (!ingots.contains(name) && hasBoth(name)) {
					ingots.add(name);
				}
			}
		}
		
		Iterator<String> itr = ingots.iterator();
		
		while (itr.hasNext()) {
			String ing = itr.next();
			ItemStack dust = getOredictItem("dust" + ing);
			String ingot = "ingot" + ing;
			if (hasBoth(ing) && dust != null) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(dust, new Object[] {
						ingot,
						new ItemStack(ModItems.mortarPestle, 1, OreDictionary.WILDCARD_VALUE)
				}));
			}
		}
		
		if (Loader.isModLoaded("appliedenergistics2")) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(getOredictItem("dustNetherQuartz"), new Object[] {
					"crystalNetherQuartz",
					new ItemStack(ModItems.mortarPestle, 1, OreDictionary.WILDCARD_VALUE)
			}));
			GameRegistry.addRecipe(new ShapelessOreRecipe(getOredictItem("dustCertusQuartz"), new Object[] {
				"crystalCertusQuartz",
				new ItemStack(ModItems.mortarPestle, 1, OreDictionary.WILDCARD_VALUE)
			}));
			GameRegistry.addRecipe(new ShapelessOreRecipe(getOredictItem("dustFluix"), new Object[] {
				"crystalFluix",
				new ItemStack(ModItems.mortarPestle, 1, OreDictionary.WILDCARD_VALUE)
			}));
			GameRegistry.addRecipe(new ShapelessOreRecipe(getOredictItem("dustEnder"), new Object[] {
				new ItemStack(Items.ender_pearl),
				new ItemStack(ModItems.mortarPestle, 1, OreDictionary.WILDCARD_VALUE)
			}));
			GameRegistry.addRecipe(new ShapelessOreRecipe(getOredictItem("dustWheat"), new Object[] {
				new ItemStack(Items.wheat),
				new ItemStack(ModItems.mortarPestle, 1, OreDictionary.WILDCARD_VALUE)
			}));
		}
		
	}
	

}
