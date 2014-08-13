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
	enablePrimalEnchanting,
	enableDragonBootsRecipe
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
	CATEGORY_RECIPE = "recipes",
	CATEGORY_WORLDGEN = "worldgen",
	CATEGORY_ENTITIES = "entities",
	CATEGORY_LOOT = "loot",
	CATEGORY_INTEGRATION = "mod integration",
	CATEGORY_BLOCKS = "blocks",
	CATEGORY_ITEMS = "items",
	CATEGORY_MISC = "misc"
	;
	
	public static final String[] categories =  new String[] {
		CATEGORY_BLOCKS,
		CATEGORY_ENTITIES,
		CATEGORY_INTEGRATION,
		CATEGORY_ITEMS,
		CATEGORY_LOOT,
		CATEGORY_MISC,
		CATEGORY_RECIPE,
		CATEGORY_WORLDGEN
	};
	

}
