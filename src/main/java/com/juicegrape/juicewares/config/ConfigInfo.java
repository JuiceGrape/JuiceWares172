package com.juicegrape.juicewares.config;

public class ConfigInfo {
	
	//World gen
	public static boolean
	enableReedGen,
	enableMeatyGen,
	enableDungeonLoot
	;
	
	//Loot
	public static boolean
	enableRocketBootsDrop
	;

	//Item enabling
	public static boolean
	enableMatch,
	enableTimeSpring,
	enableDivingHelmet,
	enableNightVisionGoggles,
	enableRocketBoots,
	enableBlazeFlowers,
	enableMortarAndPestle,
	enableHemp
	;
	
	//Block enabling
	public static boolean
	enableDrawer,
	enableAltar
	;
	
	//Recipes
	public static boolean
	enableWoolToString,
	enableDiscRecipes,
	enableSaddleRecipe,
	enableNameTagRecipe,
	enableEasyNightVisionLensRecipe,
	enableModerateNightVisionLensRecipe,
	enableHardNightVisionLensRecipe,
	enableSuperHardNightVisionLensRecipe,
	enablePrimalEnchanting
	;
	
	//Mod integration
	public static boolean
	enableThaumCraft,
	enableNEI
	;
	
	//Misc
	public static boolean 
	enableExplodingGunpowder
	;
	
	//Categories
	public static final String
	CATEGORY_RECIPE = "Recipes",
	CATEGORY_WORLDGEN = "Worldgen",
	CATEGORY_ENTITIES = "Entities",
	CATEGORY_LOOT = "Loot",
	CATEGORY_INTEGRATION = "Mod integration",
	CATEGORY_BLOCKS = "Blocks",
	CATEGORY_ITEMS = "Items",
	CATEGORY_MISC = "Misc"
	;
	

}
