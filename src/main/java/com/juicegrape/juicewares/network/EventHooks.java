package com.juicegrape.juicewares.network;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

import com.juicegrape.juicewares.config.Enabling;
import com.juicegrape.juicewares.items.ModItems;
import com.juicegrape.juicewares.misc.CustomEntityItem;
import com.juicegrape.juicewares.potionEffects.Potions;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHooks {
	
	public static final double DEFAULT_GRAVITY = -0.07;
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent event) {
		
		divingHelmetHandler(event.entityLiving);
		
		nightVisionGogglesHandler(event.entityLiving);
		
		customPotionEffectHandler(event.entityLiving);
		
		rocketPowerHandler(event.entityLiving);
		
		if (event.entityLiving instanceof EntityPlayer) {
			ItemStack boots = event.entityLiving.getEquipmentInSlot(1);
			if (boots != null && boots.getItem().equals(ModItems.rocketBoots)) {
				event.entityLiving.fallDistance = (float) calculateFallFromVelocity(event.entityLiving.motionY);
			}
		}
		
	}
	
	
	
	@SubscribeEvent
	public void onBlockBreak(BreakEvent event) {
		if (event.block == Blocks.mob_spawner) {
			if (event.world.getTileEntity(event.x, event.y, event.z) instanceof TileEntityMobSpawner) {
				TileEntityMobSpawner te = (TileEntityMobSpawner)event.world.getTileEntity(event.x, event.y, event.z);
				
				 if (te.func_145881_a().getEntityNameToSpawn().equals("Blaze")) {
					 event.world.spawnEntityInWorld(createItem(event.world, new ItemStack(ModItems.blazeflowerseeds), new Random(), event.x, event.y, event.z));
				 }
			}

		}
	}
	
	@SubscribeEvent
	public void onEntityCreation(EntityJoinWorldEvent event) {
		if (event.entity.worldObj == null || event.entity.worldObj.isRemote) {
			return;
		}
		if (event.entity instanceof EntityItem) {
			if (event.entity instanceof CustomEntityItem) {
				return;
			} else {
				onItemCreation((EntityItem)event.entity);
			}
		}
	}
	
	
	
	public void onItemCreation(EntityItem item) {
		if (Enabling.enableExplodingGunpowder){
			if (item.worldObj != null) {
				if (item.getEntityItem().getItem().equals(Items.gunpowder)) {
					NBTTagCompound old = item.getEntityData();
					item.writeToNBT(old);
					CustomEntityItem boon = new CustomEntityItem(item.worldObj);
					boon.readFromNBT(old);
					boon.delayBeforeCanPickup = item.delayBeforeCanPickup;
					boon.worldObj.spawnEntityInWorld(boon);
					item.setInvisible(true);
					item.setDead();
				}
			}
		}
	}
	
	
	
	public void divingHelmetHandler(EntityLivingBase entityLivingBase) {
		ItemStack helmet = entityLivingBase.getEquipmentInSlot(4);
		
		//Main loop for checking
		if (helmet != null) {
			if(helmet.getItem() == ModItems.divinghelmet) {
				if (entityLivingBase.worldObj.isAnyLiquid(entityLivingBase.boundingBox) && entityLivingBase.isOffsetPositionInLiquid(0, 1, 0)) {
					entityLivingBase.addPotionEffect(new PotionEffect(Potions.cWaterBreathing.getId(), 1200, 0, true));
				}
			} else {
				if (entityLivingBase.isPotionActive(Potions.cWaterBreathing)) {
					entityLivingBase.removePotionEffect(Potions.cWaterBreathing.getId());
					entityLivingBase.removePotionEffectClient(Potions.cWaterBreathing.getId());
				}
			}
		} else {
			if (entityLivingBase.isPotionActive(Potions.cWaterBreathing)) {
				entityLivingBase.removePotionEffect(Potions.cWaterBreathing.getId());
				entityLivingBase.removePotionEffectClient(Potions.cWaterBreathing.getId());
			}
		}
		
		//Removing the potioneffect if the entity is not in water. Makes it a bit cleaner
		if (entityLivingBase.isPotionActive(Potions.cWaterBreathing)) {
			if (!entityLivingBase.worldObj.isAnyLiquid(entityLivingBase.boundingBox)) {
				entityLivingBase.removePotionEffectClient(Potions.cWaterBreathing.getId());
				entityLivingBase.removePotionEffect(Potions.cWaterBreathing.getId());
			}
		}
		
		
		//debugging (removing glitches caused by certain circomestances
		if (entityLivingBase.isPotionActive(Potions.cWaterBreathing)) {
			if (entityLivingBase.getActivePotionEffect(Potions.cWaterBreathing).getDuration() == 0) {
				entityLivingBase.removePotionEffectClient(Potions.cWaterBreathing.getId());
				entityLivingBase.removePotionEffect(Potions.cWaterBreathing.getId());
			}
		}
	}
	
	public void nightVisionGogglesHandler(EntityLivingBase entityLivingBase) {
		ItemStack helmet = entityLivingBase.getEquipmentInSlot(4);
		if (helmet != null) {
			if (helmet.getItem() == ModItems.nightvisiongoggles) {
				entityLivingBase.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 300, 0, true));
			}
		}
	}
	
	public void customPotionEffectHandler(EntityLivingBase entityLivingBase) {
		if (entityLivingBase.isPotionActive(Potions.cWaterBreathing)) {
			entityLivingBase.setAir(300);
		}
	}
	
	private EntityItem createItem(World world, ItemStack itemStack, Random random, int x, int y, int z) {
		float xThang = random.nextFloat() * 0.8F + 0.1F;
		float yThang = random.nextFloat() * 0.8F + 0.1F;
		float zThang = random.nextFloat() * 0.8F + 0.1F;
		EntityItem entityItem = new EntityItem(world, x + xThang, y + yThang, z + zThang, itemStack);
        entityItem.motionX = (float) random.nextGaussian() * 0.05F;
        entityItem.motionY = (float) random.nextGaussian() * 0.05F + 0.2F;
        entityItem.motionZ = (float) random.nextGaussian() * 0.05F;
        return entityItem;
	}
	
	public void rocketPowerHandler(EntityLivingBase entityLivingBase) {
		EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
		EntityPlayer player2 = null;
		if (entityLivingBase instanceof EntityPlayer) {
			player2 = (EntityPlayer)entityLivingBase;
		}
		if (player != null && player2 != null) {
			if (player.getDisplayName().equals(player2.getDisplayName())) {
				ItemStack boots = player.getEquipmentInSlot(1);
				if (boots != null) {
					if (boots.getItem().equals(ModItems.rocketBoots)) {
						if (boots.getItemDamage() > 0 && player.onGround) {
							boots.setItemDamage(boots.getItemDamage() - 1);
						}
						if (boots.getItemDamage() < boots.getMaxDamage()) {
							if (player.movementInput.jump) {
								player.addVelocity(0, 0.05, 0);
								boots.setItemDamage(boots.getItemDamage() + 1);
							} 
						}
					}
				}
			}
		}
	}
	
	public double calculateFallFromVelocity(double velocity) {
		double time = velocity / DEFAULT_GRAVITY;
		double distance = -0.5 * DEFAULT_GRAVITY * time * time;
		return distance;
	}
	
	

	

}
