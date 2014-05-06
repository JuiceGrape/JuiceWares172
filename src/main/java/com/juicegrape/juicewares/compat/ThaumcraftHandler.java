package com.juicegrape.juicewares.compat;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import com.juicegrape.juicewares.ModInformation;
import com.juicegrape.juicewares.blocks.ModBlocks;
import com.juicegrape.juicewares.entities.EntityInfo;
import com.juicegrape.juicewares.items.ModItems;

import cpw.mods.fml.common.event.FMLInterModComms;

public class ThaumcraftHandler {
	
	public static void init() {
		//Harvestables
		FMLInterModComms.sendMessage("Thaumcraft", "harvestStackedCrop", new ItemStack(ModBlocks.stringreed, 1, OreDictionary.WILDCARD_VALUE));
		System.out.println("Sending stringreed");
		FMLInterModComms.sendMessage("Thaumcraft", "harvestStandardCrop", new ItemStack(ModBlocks.blazeflower, 1, 15));
		System.out.println("Sending blazeflower");
	}
	
	public static void Postinit() {
		//complex blocks
		ThaumcraftApi.registerComplexObjectTag(new ItemStack(ModBlocks.drawer, 0, OreDictionary.WILDCARD_VALUE), (new AspectList().add(Aspect.VOID, 4)) );
		
		ThaumcraftApi.registerComplexObjectTag(new ItemStack(ModBlocks.altar, 0, OreDictionary.WILDCARD_VALUE), (new AspectList().add(Aspect.CRAFT, 4)) );
		
		//complex items
		ThaumcraftApi.registerComplexObjectTag(new ItemStack(ModItems.divinghelmet, 0, OreDictionary.WILDCARD_VALUE), (new AspectList().add(Aspect.AIR, 4)));
		
		ThaumcraftApi.registerComplexObjectTag(new ItemStack(ModItems.enchantmentItem, 1, 0), (new AspectList().add(Aspect.WEAPON, 4)));
		ThaumcraftApi.registerComplexObjectTag(new ItemStack(ModItems.enchantmentItem, 1, 1), (new AspectList().add(Aspect.GREED, 4)));
		
		ThaumcraftApi.registerComplexObjectTag(new ItemStack(ModItems.itemTimeSpring, 1, OreDictionary.WILDCARD_VALUE), (new AspectList().add(Aspect.ELDRITCH, 4).add(Aspect.MAGIC, 6)));
		
		
		
		//normal blocks
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.meatyore, 1, OreDictionary.WILDCARD_VALUE), (new AspectList().add(Aspect.FLESH, 8).add(Aspect.EARTH, 2)));
		
		//normal items
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.lens, 1, 0), (new AspectList().add(Aspect.CRYSTAL, 4).add(Aspect.SENSES, 2)));
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.lens, 1, 1), (new AspectList().add(Aspect.CRYSTAL, 4).add(Aspect.SENSES, 4).add(Aspect.MAGIC, 2)));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.stringreed, 1, OreDictionary.WILDCARD_VALUE), (new AspectList().add(Aspect.PLANT, 1).add(Aspect.EARTH, 1).add(Aspect.AIR, 1)));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.blazeflowerseeds, 1, OreDictionary.WILDCARD_VALUE), (new AspectList().add(Aspect.FIRE, 4).add(Aspect.MAGIC, 2).add(Aspect.PLANT, 1)));
		
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.match, 1, OreDictionary.WILDCARD_VALUE), (new AspectList().add(Aspect.FIRE, 1).add(Aspect.TREE, 1)));
		
		//Entities
		ThaumcraftApi.registerEntityTag(ModInformation.ID + "." + EntityInfo.EYEBALL_SYSTEM_NAME, (new AspectList().add(Aspect.MOTION, 4).add(Aspect.SENSES, 4)));
		
		

	}

}
