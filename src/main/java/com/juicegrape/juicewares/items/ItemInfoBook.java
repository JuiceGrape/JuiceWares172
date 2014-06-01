package com.juicegrape.juicewares.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.juicegrape.juicewares.juicewares;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemInfoBook extends Item {
	
	public ItemInfoBook() {
		super();
		setUnlocalizedName(ItemInfo.INFO_BOOK_UNLOCALIZED_NAME);
		setMaxStackSize(1);
		setCreativeTab(juicewares.juiceTab);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.INFO_BOOK_ICON);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (world.isRemote) {
			player.openGui(juicewares.instance, 0, world, 0, 0, 0);
		}
		return itemStack;
	}

}
