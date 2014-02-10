package com.juicegrape.juicewares.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemReed;

import com.juicegrape.juicewares.juicewares;
import com.juicegrape.juicewares.blocks.ModBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHemp extends ItemReed {
	
	public ItemHemp() {
		super(ModBlocks.stringreed);
		setCreativeTab(juicewares.juiceTab);
		setUnlocalizedName(ItemInfo.STRINGREED_UNLOCALIZED_NAME);
		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.STRINGREED_ICON);
	}
	
}