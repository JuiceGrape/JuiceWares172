package com.juicegrape.juicewares.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.juicegrape.juicewares.juicewares;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMortarPestle extends Item{
	
	public ItemMortarPestle() {
		super();
		setUnlocalizedName(ItemInfo.MORTAR_PESTLE_UNLOCALIZED_NAME);
		setCreativeTab(juicewares.juiceTab);
		setMaxStackSize(1);
		setMaxDamage(256);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.MORTAR_PESTLE_ICON);
	}
	
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack stack) {
		return false;
	}
	
	@Override
	public ItemStack getContainerItem(ItemStack stack) {
		stack.setItemDamage(stack.getItemDamage() + 1);
		return stack;
	}
	
	@Override
	public boolean hasContainerItem(ItemStack stack) {
		return stack.getItemDamage() < 255;
	}

}
