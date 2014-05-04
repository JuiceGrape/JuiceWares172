package com.juicegrape.juicewares.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import com.juicegrape.juicewares.blocks.BlockInfo;
import com.juicegrape.juicewares.entities.EntityInfo;
import com.juicegrape.juicewares.potionEffects.Potions;
import com.juicegrape.juicewares.recipes.RecipeInfo;

public class ConfigHandler {
	
	
	public static void init(File file) {
		Configuration config = new Configuration(file);
		
		config.load();
		
		//Recipes
		RecipeInfo.WOOL_TO_STRING = config.get("Recipes", RecipeInfo.WOOL_KEY, RecipeInfo.WOOL_STRING_DEF).getInt();
		Enabling.enableEasyNightVisionLensRecipe = config.get("Recipes", "Easy night vision lens recipe", false).getBoolean(false);
		Enabling.enableModerateNightVisionLensRecipe = config.get("Recipes", "Moderate night vision lens recipe", false).getBoolean(false);
		Enabling.enableHardNightVisionLensRecipe = config.get("Recipes", "Hard night vision lens recipe", false).getBoolean(false);
		Enabling.enableSuperHardNightVisionLensRecipe = config.get("Recipes", "Super hard night vision lens recipe", false).getBoolean(false);
		Enabling.enableDiscRecipes = config.get("Recipes", "Disc Recipes", true).getBoolean(true);
		Enabling.enableNameTagRecipe = config.get("Recipes", "Name tag recipe", true).getBoolean(true);
		Enabling.enableSaddleRecipe = config.get("Recipes", "Saddle recipe", true).getBoolean(true);
		Enabling.enableWoolToString = config.get("Recipes", "Wool to string recipes", true).getBoolean(true);
		Enabling.enableMatchRecipe = config.get("Recipes", "Match recipe", true).getBoolean(true);
		
		//worldgen
		BlockInfo.STRINGREED_SPAWN = config.get("Worldgen", BlockInfo.STRINGREED_SPAWN_KEY, BlockInfo.STRINGREED_SPAWN_DEF).getInt();
		Enabling.enableReedGen = config.get("Worldgen", "Reed Generation", true).getBoolean(true);
		Enabling.enableMeatyGen = config.get("Worldgen", "Meaty Ore Generation", true).getBoolean(true);
		
		//misc
		BlockInfo.STRINGREED_GROWTH = config.get("Misc", BlockInfo.STRINGREED_GROWTH_KEY, BlockInfo.STRINGREED_GROWTH_DEF).getInt();
		Enabling.enableTimeSpring = config.get("Misc", "Enable Timewound Clock", true).getBoolean(false);
		Enabling.enablePrimalEnchanting = config.get("Misc", "Enable primal enchanting", true).getBoolean(false);
		Potions.cWaterBreathingId = config.get("Misc", "Custom water breathing potion effect ID", 32).getInt(32);
		Enabling.enableExplodingGunpowder = config.get("Misc", "Enable gunpowder exploding when on fire", true).getBoolean(true);
		Enabling.enableDungeonLoot = config.get("Misc", "Enable dungeon loot", true).getBoolean(true);
		
		
		//Spawns
		EntityInfo.EYEBALL_SPAWN = config.get("Spawns", EntityInfo.EYEBALL_SPAWN_CONF, EntityInfo.EYEBALL_SPAWN_DEF).getBoolean(EntityInfo.EYEBALL_SPAWN_DEF);
		EntityInfo.EYEBALL_SPAWNRATE = config.get("Spawns", EntityInfo.EYEBALL_SPAWNRATE_CONF, EntityInfo.EYEBALL_SPAWNRATE_DEF).getInt();
		
		
		
		config.save();
	}
}
