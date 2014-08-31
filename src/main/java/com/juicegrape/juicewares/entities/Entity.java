package com.juicegrape.juicewares.entities;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import com.juicegrape.juicewares.juicewares;

import cpw.mods.fml.common.registry.EntityRegistry;

public class Entity {
	
	static int modEntityId = 0;
	
	
	public static void init() {
		EntityRegistry.registerModEntity(EntityEyeball.class, EntityInfo.EYEBALL_SYSTEM_NAME, ++modEntityId, juicewares.instance, 80, 3, true);
	}
	
	
	public static void initEggs() {
		registerEntityEgg(EntityEyeball.class, 0xFFFFFF , 0xFF1C1C,  EntityInfo.EYEBALL_SYSTEM_NAME);
	}
	
	public static void initSpawns() {
		if (EntityInfo.EYEBALL_SPAWN) {
			for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++) {
	                if (BiomeGenBase.getBiomeGenArray()[i] != null) {
	                	boolean endneth = false;
	                	for (Type type : BiomeDictionary.getTypesForBiome(BiomeGenBase.getBiomeGenArray()[i])) {
	                		if (type.equals(Type.END) || type.equals(Type.NETHER)) {
	                			endneth = true;
	                		}
	                	}
	                	if (!endneth)
	                		EntityRegistry.addSpawn(EntityEyeball.class, EntityInfo.EYEBALL_SPAWNRATE, 1, 2, EnumCreatureType.monster, BiomeGenBase.getBiomeGenArray()[i]);
	                	
	                }
	                
			}
		}
		
		
	}
	
	public static void registerEntityEgg(Class<? extends EntityLiving> entity, int primaryColor, int secondaryColor, String name) {
            int id = EntityRegistry.findGlobalUniqueEntityId();
            EntityRegistry.registerGlobalEntityID(entity, name, id, primaryColor, secondaryColor);
    }
}
