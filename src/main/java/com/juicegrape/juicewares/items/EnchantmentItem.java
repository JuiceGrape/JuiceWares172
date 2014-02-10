package com.juicegrape.juicewares.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.juicegrape.juicewares.juicewares;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EnchantmentItem extends Item {

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	public EnchantmentItem() {
		super();
		setCreativeTab(juicewares.juiceTab);
		setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack) {
		return ItemInfo.ENCHANTMENT_UNLOCALIZED_NAME + itemStack.getItemDamage();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int dmg) {
		return icons[dmg];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		icons = new IIcon[ItemInfo.ENCHANTMENT_ICONS.length];
		for (int i = 0; i < ItemInfo.ENCHANTMENT_ICONS.length; i++) {
			switch(i) {
			case 1:
			case 2:
			case 3:
				icons [i] = register.registerIcon(ItemInfo.ENCHANTMENT_ICONS[i]);
				break;
			default:
				icons[i] = register.registerIcon((ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.ENCHANTMENT_ICONS[i]));
				break;
			}
			
		}
	}
	
	//(60 << 16) | (180 << 8) | 60;
	//(55 << 16) | (82 << 8) | 204;
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack itemStack, int par2) {
		switch(itemStack.getItemDamage()) {
		case 1:
		case 2:
		case 3:
			return (55 << 16) | (82 << 8) | 204;
		default:
			return super.getColorFromItemStack(itemStack, par2);
		}
	}
	
	@Override
	public EnumRarity getRarity(ItemStack itemStack) {
		switch(itemStack.getItemDamage()) {
		case 2:
			return EnumRarity.rare;
		case 3:
			return EnumRarity.epic;
		default:
			return EnumRarity.uncommon;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack itemStack, int pass) {
		return itemStack.getItemDamage() == 2 || itemStack.getItemDamage() == 3 ? true : super.hasEffect(itemStack, pass);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean useExtraInfo) {
		switch(itemStack.getItemDamage()) {
		case 1:
			info.add("Useless without a blessing");
			break;
		case 3:
			info.add("It's super blessed!");
		default:
			break;
		}
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < ItemInfo.ENCHANTMENT_ICONS.length; i++) {
			ItemStack stack = new ItemStack(item, 1, i);
			list.add(stack);
		}
	}
	

}
