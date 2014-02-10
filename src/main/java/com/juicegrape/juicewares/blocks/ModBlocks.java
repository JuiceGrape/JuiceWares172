package com.juicegrape.juicewares.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static Block stringreed;
	public static Block drawer;
	public static Block meatyore;
	public static Block altar;
	public static Block blazeflower;
	
	public static void init() {
		
		stringreed = new BlockHemp();
		GameRegistry.registerBlock(stringreed, BlockInfo.STRINGREED_KEY);
		
		drawer = new BlockDrawer();
		GameRegistry.registerBlock(drawer, BlockInfo.DRAWER_KEY);
		
		meatyore = new BlockMeatyOre();
		GameRegistry.registerBlock(meatyore, BlockInfo.MEATYORE_KEY);
		
		altar = new BlockAltar();
		GameRegistry.registerBlock(altar, BlockInfo.ALTAR_KEY);
		
		blazeflower = new BlockBlazeFlower();
		GameRegistry.registerBlock(blazeflower, BlockInfo.BLAZEFLOWER_KEY);
		
		

	}
	

	
	public static void addOreDict() {
		
		OreDictionary.registerOre("oreMeat", meatyore);
		
	}
}
