package com.juicegrape.juicewares.recipes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.juicegrape.juicewares.config.ConfigInfo;
import com.juicegrape.juicewares.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class MortarPestleRecipes {
	
	private static ItemStack getDustItem(String ingot) {
		List<ItemStack> results = OreDictionary.getOres(ingot);
		if (!results.isEmpty()) {
			return results.get(0);
		} else {
			return null;
		}
		
	}
	
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
			ItemStack dust = getDustItem("dust" + ing);
			String ingot = "ingot" + ing;
			if (hasBoth(ing) && dust != null) {
				GameRegistry.addRecipe(new ShapelessOreRecipe(dust, new Object[] {
						ingot,
						new ItemStack(ModItems.mortarPestle, 1, OreDictionary.WILDCARD_VALUE)
				}));
			}
		}
		
	}
	

}
