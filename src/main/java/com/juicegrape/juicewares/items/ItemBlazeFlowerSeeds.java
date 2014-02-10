package com.juicegrape.juicewares.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemSeeds;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

import com.juicegrape.juicewares.juicewares;
import com.juicegrape.juicewares.blocks.ModBlocks;

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
	public void registerIcons(IIconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.BLAZEFLOWERSEEDS_ICON);
	}

}
