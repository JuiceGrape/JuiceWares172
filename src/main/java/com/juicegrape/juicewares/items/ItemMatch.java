package com.juicegrape.juicewares.items;

import com.juicegrape.juicewares.juicewares;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemMatch extends Item {

	public ItemMatch() {
		super();
		setUnlocalizedName(ItemInfo.MATCH_UNLOCALIZED_NAME);
		setCreativeTab(juicewares.juiceTab);
		setMaxStackSize(16);
	
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.MATCH_ICON);
	}
	
	
	
}
