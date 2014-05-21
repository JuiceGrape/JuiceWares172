package com.juicegrape.juicewares.blocks;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.juicegrape.juicewares.items.ItemInfo;

public class BlockInfo {
	
	public static final String TEXTURE_LOCATION = ItemInfo.TEXTURE_LOCATION;
	
	
	//Stringreed
	public static final String STRINGREED_KEY = "stringreed_block";
	
	public static final String STRINGREED_UNLOCALIZED = "blockstringreed";
	
	public static final String STRINGREED = "stringreed_block";
	
	public static final int STRINGREED_SPAWN_DEF = 1;
	public static final String STRINGREED_SPAWN_KEY = "Spawn rate hemp";
	public static int STRINGREED_SPAWN;
	public static final int STRINGREED_GROWTH = 10;
	
	
	//Cabinet
	public static final String DRAWER_KEY = "drawer_block";
	
	public static final String DRAWER_UNLOCALIZED_NAME = "blockdrawer";
	
	public static final String DRAWER_INV_UNLOCALIZED_NAME = "container.drawer.name";

	
	//Meatyore
	public static final String MEATYORE_KEY = "meatyore_block";
	
	public static final String MEATYORE_UNLOCALIZED_NAME = "blockmeatyore";
	public static final String MEATYORE = "meatyore_block";
	
	public static final ItemStack[] MEATYORE_DROP = {new ItemStack(Items.beef), new ItemStack(Items.chicken), new ItemStack(Items.fish, 1, 0), new ItemStack(Items.fish, 1, 1), new ItemStack(Items.fish, 1, 2), new ItemStack(Items.porkchop), new ItemStack(Items.rotten_flesh)};
	
	
	//Altar
	public static final String ALTAR_KEY = "altar_block";
	
	public static final String ALTAR_UNLOCALIZED_NAME = "blockjuicealtar";
	
	//Blaze Flower
	public static final String BLAZEFLOWER_KEY = "blazeflower_block";
	
	public static final String BLAZEFLOWER_UNLOCALIZED_NAME = "blockblazeflower";
	
	public static final String BLAZEFLOWER = "blazeflower_block";
	
	
	
	
	
}
