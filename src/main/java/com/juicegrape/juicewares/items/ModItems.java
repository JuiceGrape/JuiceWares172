package com.juicegrape.juicewares.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.oredict.OreDictionary;

import com.juicegrape.juicewares.juicewares;
import com.juicegrape.juicewares.config.Enabling;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

	public static Item stringreed;
	public static Item divinghelmet;
	public static Item nightvisiongoggles;
	public static Item debugitem;
	public static Item lens;
	public static Item enchantmentItem;
	public static Item itemTimeSpring;
	public static Item blazeflowerseeds;
	public static Item match;
	
	public static void init() {
		stringreed = new ItemHemp();
		GameRegistry.registerItem(stringreed, ItemInfo.STRINGREED_KEY);
		
		divinghelmet = new DivingHelmet(ItemArmor.ArmorMaterial.GOLD, juicewares.proxy.addArmor("Diving"), 0);
		GameRegistry.registerItem(divinghelmet, ItemInfo.DIVINGHELMET_KEY);
		
		nightvisiongoggles = new NightVisionGoggles(ItemArmor.ArmorMaterial.IRON, juicewares.proxy.addArmor("Goggles"), 0);
		GameRegistry.registerItem(nightvisiongoggles, ItemInfo.GOGGLES_KEY);
		
		debugitem = new DebugItem();
		GameRegistry.registerItem(debugitem, ItemInfo.DEBUG_KEY);
		
		lens = new ItemLens();
		GameRegistry.registerItem(lens, ItemInfo.LENS_KEY);
		
		enchantmentItem = new EnchantmentItem();
		GameRegistry.registerItem(enchantmentItem, ItemInfo.ENCHANTMENT_KEY);
		
		itemTimeSpring = new ItemTimeSpring();
		GameRegistry.registerItem(itemTimeSpring, ItemInfo.TIMESPRING_KEY);
		
		blazeflowerseeds = new ItemBlazeFlowerSeeds();
		GameRegistry.registerItem(blazeflowerseeds, ItemInfo.BLAZEFLOWERSEEDS_KEY);
		
		match = new ItemMatch();
		GameRegistry.registerItem(match, ItemInfo.MATCH_KEY);

	}
	
	
	public static void addOreDictionary() {
		OreDictionary.registerOre("gemEmerald", new ItemStack(Items.emerald));
		
		OreDictionary.registerOre("itemLens", lens);
		OreDictionary.registerOre("itemNightVisionLens", new ItemStack(lens, 1, 1));
		OreDictionary.registerOre("itemHemp", stringreed);
	}
	
	public static void miscInit() {
		(Blocks.command_block).setCreativeTab(CreativeTabs.tabRedstone);
	}
	
	public static void dungeonLoot() {
		if (Enabling.enableDungeonLoot){
			ItemStack divingChest = new ItemStack(ModItems.divinghelmet);
			divingChest.addEnchantment(Enchantment.aquaAffinity, 1);
			
			ChestGenHooks.addItem(ChestGenHooks.BONUS_CHEST, new WeightedRandomChestContent(new ItemStack(ModItems.nightvisiongoggles), 1, 1, 5));
			ChestGenHooks.addItem(ChestGenHooks.VILLAGE_BLACKSMITH, new WeightedRandomChestContent(new ItemStack(ModItems.nightvisiongoggles), 1, 1, 3));
			ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(divingChest, 1, 1, 2));
			ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(ModItems.lens, 1, 1),1, 5, 8));
			ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(new ItemStack(ModItems.lens, 1, 0),1, 5, 8));
		}
	}
		

	

	

				
			 

}
