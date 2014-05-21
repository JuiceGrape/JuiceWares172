package com.juicegrape.juicewares.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;

import com.juicegrape.juicewares.juicewares;
import com.juicegrape.juicewares.blocks.ModBlocks;
import com.juicegrape.juicewares.config.ConfigInfo;

public class ItemBlazeFlowerSeeds extends ItemSeeds {

	public ItemBlazeFlowerSeeds() {
		super(ModBlocks.blazeflower, Blocks.soul_sand);
		setUnlocalizedName(ItemInfo.BLAZEFLOWERSEEDS_UNLOCALIZED_NAME);
		setCreativeTab(juicewares.juiceTab);
	}
	
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Nether;
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (ConfigInfo.enableBlazeFlowers) {
			return super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10);
		} else {
			return false;
		}
	}
	
	@Override
	public void registerIcons(IIconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.BLAZEFLOWERSEEDS_ICON);
	}

}
