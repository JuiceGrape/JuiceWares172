package com.juicegrape.juicewares.items;


import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.juicegrape.juicewares.juicewares;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLens extends Item{

	public ItemLens() {
		super();
		setCreativeTab(juicewares.juiceTab);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return ItemInfo.LENS_UNLOCALIZED_NAME + itemStack.getItemDamage();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.LENS_ICON);
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemStack, int par2)
    {
		if (itemStack.getItem() instanceof Item) {
			
		} else {
			return super.getColorFromItemStack(itemStack, par2);	
		}
		
		if (itemStack.getItemDamage() == 1) {
			return (60 << 16) | (180 << 8) | 60;
		} else {
			return super.getColorFromItemStack(itemStack, par2);
		}
    }
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 2; i++) {
			ItemStack stack = new ItemStack(item, 1, i);
			
			list.add(stack);
		}

		
	}
	


}
