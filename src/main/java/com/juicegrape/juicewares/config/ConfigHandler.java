package com.juicegrape.juicewares.config;

import java.io.File;

import com.juicegrape.juicewares.blocks.BlockInfo;
import com.juicegrape.juicewares.entities.EntityInfo;
import com.juicegrape.juicewares.potionEffects.Potions;
import com.juicegrape.juicewares.recipes.RecipeInfo;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		//Blocks
		
		//Drawer
		ConfigInfo.enableDrawer = config.get(ConfigInfo.CATEGORY_BLOCKS, "Enable drawer", true).getBoolean(true);
		
		//Altar
		ConfigInfo.enableAltar = config.get(ConfigInfo.CATEGORY_BLOCKS, "Enable altar", true).getBoolean(true);
		
		
		//Items
		
		//Tools
		ConfigInfo.enableMatch = config.get(ConfigInfo.CATEGORY_ITEMS, "Enable match", true).getBoolean(true);
		ConfigInfo.enableTimeSpring = config.get(ConfigInfo.CATEGORY_ITEMS, "Enable timewound clock", true).getBoolean(true);
		ConfigInfo.enableMortarAndPestle = config.get(ConfigInfo.CATEGORY_ITEMS, "Enable mortar and pestle", true).getBoolean(true);
		
		//Armour
		ConfigInfo.enableDivingHelmet= config.get(ConfigInfo.CATEGORY_ITEMS, "Enable diving helmet", true).getBoolean(true);
		ConfigInfo.enableNightVisionGoggles = config.get(ConfigInfo.CATEGORY_ITEMS, "Enable night vision goggles", true).getBoolean(true);
		ConfigInfo.enableRocketBoots = config.get(ConfigInfo.CATEGORY_ITEMS, "Enable dragon boots", true).getBoolean(true);
		
		//Rest
		ConfigInfo.enableBlazeFlowers = config.get(ConfigInfo.CATEGORY_ITEMS, "Enable blaze flowers", true).getBoolean(true);
		ConfigInfo.enableHemp = config.get(ConfigInfo.CATEGORY_ITEMS, "Enable hemp", true).getBoolean(true);
		

		//Recipes
		
		//Wool
		ConfigInfo.enableWoolToString = config.get(ConfigInfo.CATEGORY_RECIPE, "Enable conversion of wool to string", true).getBoolean(true);
		RecipeInfo.WOOL_TO_STRING = config.get(ConfigInfo.CATEGORY_RECIPE, RecipeInfo.WOOL_KEY, RecipeInfo.WOOL_STRING_DEF).getInt();
		
		//Night vision lenses
		ConfigInfo.enableEasyNightVisionLensRecipe = config.get(ConfigInfo.CATEGORY_RECIPE, "Enable easy night vision lens recipe", false).getBoolean(false);
		ConfigInfo.enableModerateNightVisionLensRecipe = config.get(ConfigInfo.CATEGORY_RECIPE, "Enable moderate night vision lens recipe", false).getBoolean(false);
		ConfigInfo.enableHardNightVisionLensRecipe = config.get(ConfigInfo.CATEGORY_RECIPE, "Enable hard night vision lens recipe", false).getBoolean(false);
		ConfigInfo.enableSuperHardNightVisionLensRecipe = config.get(ConfigInfo.CATEGORY_RECIPE, "Enable super hard night vision lens recipe", false).getBoolean(false);
		
		//Vanilla stuff
		ConfigInfo.enableDiscRecipes = config.get(ConfigInfo.CATEGORY_RECIPE, "Enable all music disc Recipes", true).getBoolean(true);
		ConfigInfo.enableNameTagRecipe = config.get(ConfigInfo.CATEGORY_RECIPE, "Enable name tag recipe", true).getBoolean(true);
		ConfigInfo.enableSaddleRecipe = config.get(ConfigInfo.CATEGORY_RECIPE, "Enable saddle recipe", true).getBoolean(true);
		
		//Primal Enchanting
		ConfigInfo.enablePrimalEnchanting = config.get(ConfigInfo.CATEGORY_RECIPE, "Enable primal enchanting", true).getBoolean(false);
		
		
		
		//Worldgen
		
		//Hemp
		BlockInfo.STRINGREED_SPAWN = config.get(ConfigInfo.CATEGORY_WORLDGEN, BlockInfo.STRINGREED_SPAWN_KEY, BlockInfo.STRINGREED_SPAWN_DEF).getInt();
		ConfigInfo.enableReedGen = config.get(ConfigInfo.CATEGORY_WORLDGEN, "Enable hemp generation", true).getBoolean(true);
		
		//Meaty ore
		ConfigInfo.enableMeatyGen = config.get(ConfigInfo.CATEGORY_WORLDGEN, "Enable meatyore generation", true).getBoolean(true);
		
		//Dungeon loot
		ConfigInfo.enableDungeonLoot = config.get(ConfigInfo.CATEGORY_WORLDGEN, "Enable dungeon loot", true).getBoolean(true);
		
		
		//Entity
		
		//Eyeball
		EntityInfo.EYEBALL_SPAWN = config.get(ConfigInfo.CATEGORY_ENTITIES, EntityInfo.EYEBALL_SPAWN_CONF, EntityInfo.EYEBALL_SPAWN_DEF).getBoolean(EntityInfo.EYEBALL_SPAWN_DEF);
		EntityInfo.EYEBALL_SPAWNRATE = config.get(ConfigInfo.CATEGORY_ENTITIES, EntityInfo.EYEBALL_SPAWNRATE_CONF, EntityInfo.EYEBALL_SPAWNRATE_DEF).getInt();
		
		
		//Loot
		
		//Dragon boots
		ConfigInfo.enableRocketBootsDrop = config.get(ConfigInfo.CATEGORY_LOOT, "Enable dragon boots drop from ender dragon", true).getBoolean(true);
		
		
		//Mod integration
		
		//NEI
		ConfigInfo.enableNEI = config.get(ConfigInfo.CATEGORY_INTEGRATION, "Enable nei integration", true).getBoolean(true);
		
		//Thaumcraft
		ConfigInfo.enableThaumCraft = config.get(ConfigInfo.CATEGORY_INTEGRATION, "Enable thaumcraft integration", true).getBoolean(true);
		
		
		//Misc
		
		//Water breathing potion effect id
		Potions.cWaterBreathingId = config.get("Misc", "Custom water breathing potion effect ID", 32).getInt(32);
		
		//Exploding gunpowder
		ConfigInfo.enableExplodingGunpowder = config.get("Misc", "Enable gunpowder exploding when on fire", true).getBoolean(true);
	
		config.save();
	}

}
