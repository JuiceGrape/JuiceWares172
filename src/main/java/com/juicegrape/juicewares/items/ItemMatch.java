package com.juicegrape.juicewares.items;

import com.juicegrape.juicewares.juicewares;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

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
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			if (ForgeDirection.getOrientation(side) == ForgeDirection.UP) {
				if (world.isAirBlock(x, y + 1, z)) {
					world.setBlock(x, y + 1, z, Blocks.fire);
					stack.stackSize--;
					if (stack.stackSize <= 0) {
						stack = null;
					}
				}
			}
		}
		
		return true;
	}
	
	
	
}
