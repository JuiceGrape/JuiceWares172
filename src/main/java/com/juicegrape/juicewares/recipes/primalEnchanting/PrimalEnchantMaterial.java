package com.juicegrape.juicewares.recipes.primalEnchanting;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PrimalEnchantMaterial {
	
	private ItemStack item;
	private Enchantment enchant;
	private int enchantlvl;
	private boolean mult;
	
	public PrimalEnchantMaterial(ItemStack enchanter, Enchantment enchant, int lvl, boolean hasMultiple) {
		item = enchanter;
		this.enchant = enchant;
		enchantlvl = lvl;
		mult = hasMultiple;
	}
	
	public Enchantment getEnchant() {
		return enchant;
	}
	
	public int getEnchantLvl() {
		return enchantlvl;
	}
	
	public Item getItem() {
		return item.getItem();
	}
	
	public int getItemMetadata() {
		return item.getItemDamage();
	}
	
	public boolean hasMultiple() {
		return mult;
	}
	
	@Override
	public String toString() {
		String tempString = "Enchant:" + enchant.toString() + " Lvl:" + enchantlvl + " Item + metadata:" + getItem() + " " + getItemMetadata();
		return tempString;
	}
	
	
	
	

}
