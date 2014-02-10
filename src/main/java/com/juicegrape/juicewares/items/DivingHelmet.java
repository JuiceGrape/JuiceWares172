package com.juicegrape.juicewares.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.juicegrape.juicewares.juicewares;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DivingHelmet extends ItemArmor {
	

	public DivingHelmet(ArmorMaterial material, int renderIndex, int slotType) {
		super(material, renderIndex, slotType);
		setUnlocalizedName(ItemInfo.DIVINGHELMET_UNLOCALIZED_NAME);
        this.setCreativeTab(juicewares.juiceTab);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.DIVINGHELMET_ICON);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return ItemInfo.TEXTURE_LOCATION + ":textures/models/armour/" + ItemInfo.DIVINGHELMET_TEXTURE;
	}
	
}
