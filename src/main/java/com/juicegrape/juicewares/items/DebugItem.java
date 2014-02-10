package com.juicegrape.juicewares.items;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.juicegrape.juicewares.juicewares;
import com.juicegrape.juicewares.entities.EntityEyeball;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class DebugItem extends Item {
	
	Random random;

	public DebugItem() {
		super();
		setUnlocalizedName(ItemInfo.DEBUG_UNLOCALIZED_NAME);
		setCreativeTab(juicewares.juiceTab);
		random = new Random();
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		itemIcon = register.registerIcon(ItemInfo.TEXTURE_LOCATION + ":" + ItemInfo.DEBUG_ICON);
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (world != null && !world.isRemote) {
			System.out.println(world.getWorldTime());
		}
		return itemStack;
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			if (player.isSneaking()) {
				Block block = world.getBlock(x, y, z);
				block.updateTick(world, x, y, z, random);
				System.out.println(world.getBlockMetadata(x, y, z));
			} else {
				System.out.println(world.getBlockMetadata(x, y, z));
			}
		}

		return true;

	}

	
	@SuppressWarnings("unused")
	private void spawnEyeball(World world, int x, int y, int z, int amount) {
		for (int i = 0; i < amount; i ++) {
			Entity entity = new EntityEyeball(world);
			
			EntityLiving entityliving = (EntityLiving)entity;
	        entity.setLocationAndAngles(x + 0.5, y + 1, z + 0.5, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
	        entityliving.rotationYawHead = entityliving.rotationYaw;
	        entityliving.renderYawOffset = entityliving.rotationYaw;
	        entityliving.onSpawnWithEgg((IEntityLivingData)null);
	        world.spawnEntityInWorld(entity);
	        entityliving.playLivingSound();
		}
	}

}
