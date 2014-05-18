package com.juicegrape.juicewares.recipes.primalEnchanting;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PrimalEnchantMaterial {
	
	private ItemStack item;
	private Enchantment enchant;
	private int enchantlvl;
	private boolean mult;
	private int timer;
	private int iteration;
	
	public PrimalEnchantMaterial(ItemStack enchanter, Enchantment enchant, int lvl, boolean hasMultiple) {
		item = enchanter;
		this.enchant = enchant;
		enchantlvl = lvl;
		mult = hasMultiple;
		timer = 0;
		iteration = 0;
	}
	
	
	public PrimalEnchantMaterial(ItemStack enchanter, Enchantment enchant) {
		this(enchanter, enchant, 1, false);
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
	
	public ItemStack getItemStack() {
		return item;
	}
	
	public ItemStack getItemStackCopy() {
		return item.copy();
	}
	
	public String getPrintString() {
		return enchant.getTranslatedName(enchantlvl);
	}
	
	public String getTypeName() {
		return enchant.type.name();
	}
	
	public int updateTimer(int max) {
		timer++;
		if (timer >= 20) {
			iteration++;
			timer = 0;
		}
		if (iteration >= max) {
			iteration = 0;
		}
		return iteration;
	}
	
	
	
	

}
