package com.juicegrape.juicewares.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;

import com.juicegrape.juicewares.juicewares;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRocketBoots extends ItemArmor implements ISpecialArmor {
	ArmorProperties armour;

	public ItemRocketBoots(int renderIndex) {
		super(ItemArmor.ArmorMaterial.IRON, renderIndex, 3);
		setUnlocalizedName(ItemInfo.ROCKETBOOTS_UNLOCALIZED_NAME);
		setCreativeTab(juicewares.juiceTab);
		armour = new ArmorProperties(0, 0, 2);
		this.setMaxDamage(100);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.ROCKETBOOTS_ICON);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return ItemInfo.TEXTURE_LOCATION + ":textures/models/armour/" + ItemInfo.ROCKETBOOTS_TEXTURE;
	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
		return armour;
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return armour.AbsorbMax;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		return;
	}
	
	
	
	@Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemStack, int par2)
    {
		return 0x9945D9;
    }
	
	
	
	

}
