package com.juicegrape.juicewares.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.juicegrape.juicewares.blocks.ModBlocks;
import com.juicegrape.juicewares.config.ConfigInfo;
import com.juicegrape.juicewares.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class CustomRecipes {
	
	public static boolean checkRegOre(String name) {
		for (String entry : OreDictionary.getOreNames()) {
			if (entry.equals(name)) {
				return true;
			}
		}
		return false;
	}

	public static void regCustomModRecipes() {
		
		if (ConfigInfo.enableHemp) {
			GameRegistry.addShapelessRecipe(new ItemStack(Items.string),
					new Object[] { new ItemStack(ModItems.stringreed) }); 
		}
		
		
		if (ConfigInfo.enableDrawer) {
			GameRegistry.addRecipe(new ShapedOreRecipe(ModBlocks.drawer, new Object[] { 	
							"WWW",
							" W ",
							"WWW",
	
			Character.valueOf('W'), "plankWood"}));
		}

		
		if (ConfigInfo.enableDivingHelmet) {
			GameRegistry.addRecipe( new ItemStack(ModItems.divinghelmet), new Object[] {
					" H ",
					"IGI",
					" B ",
					Character.valueOf('H'), Items.golden_helmet,
					Character.valueOf('B'), Blocks.iron_bars,
					Character.valueOf('I'), Items.iron_ingot,
					Character.valueOf('G'), ModItems.lens
			});
		}
		
		//Easy night vision lens recipe
		if (ConfigInfo.enableEasyNightVisionLensRecipe) {
			if (checkRegOre("gemEmerald")) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.lens, 1, 1),
						new Object[] {	"E",
										"L",
					Character.valueOf('L'), new ItemStack(ModItems.lens, 1, 0),
					Character.valueOf('E'), "gemEmerald"
					}));
			}
		}
		if (ConfigInfo.enableModerateNightVisionLensRecipe) {
			if (checkRegOre("gemEmerald")) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.lens, 1, 1),
						new Object[] {	" E ",
										"ELE",
										" E ",
					Character.valueOf('L'), new ItemStack(ModItems.lens, 1, 0),
					Character.valueOf('E'), "gemEmerald"
					}));
			}
		}
		if (ConfigInfo.enableHardNightVisionLensRecipe) {
			if (checkRegOre("gemEmerald")) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.lens, 1, 1),
						new Object[] {	"PEP",
										"ELE",
										"PEP",
					Character.valueOf('L'), new ItemStack(ModItems.lens, 1, 0),
					Character.valueOf('E'), "gemEmerald",
					Character.valueOf('P'), new ItemStack(Items.potionitem,1, 8230),
					}));
			}
		}
		if (ConfigInfo.enableSuperHardNightVisionLensRecipe) {
			if (checkRegOre("gemEmerald")) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.lens, 1, 1),
						new Object[] {	"PEP",
										"ELE",
										"PEP",
					Character.valueOf('L'), new ItemStack(ModItems.lens, 1, 0),
					Character.valueOf('E'), "gemEmerald",
					Character.valueOf('P'), new ItemStack(Items.potionitem,1, 8262),
					}));
			}
		}
		
		if (ConfigInfo.enableNightVisionGoggles) {
			GameRegistry.addRecipe(new ItemStack(ModItems.nightvisiongoggles), new Object[] {
				"S S",
				"OLO",
				"LIL",
				Character.valueOf('S'), Items.string,
				Character.valueOf('L'), new ItemStack(ModItems.lens, 1, 1),
				Character.valueOf('I'), Items.iron_ingot,
				Character.valueOf('O'), Blocks.obsidian
			});
		}
		
		
		if (ConfigInfo.enablePrimalEnchanting) {
		
			GameRegistry.addRecipe(new ItemStack(ModItems.enchantmentItem, 1, 0), new Object[] {
				" C ",
				"CIC",
				" C ",
				Character.valueOf('C'), Blocks.clay,
				Character.valueOf('I'), Items.iron_ingot
			});
			
			GameRegistry.addRecipe(new ItemStack(ModItems.enchantmentItem, 1, 1), new Object[] {
				" L ",
				"LGL",
				" L ",
				Character.valueOf('L'), new ItemStack(Items.dye, 1, 4),
				Character.valueOf('G'), Items.gold_ingot
			});
			
			GameRegistry.addRecipe(new ItemStack(ModItems.enchantmentItem, 1, 3), new Object[] {
				" L ",
				"LGL",
				" L ",
				Character.valueOf('L'), Blocks.lapis_block,
				Character.valueOf('G'), Items.diamond
			});
			
			
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.enchantmentItem, 1, 2), new Object[] {
				" N ",
				"NIN",
				" N ",
				Character.valueOf('N'), "nuggetGold",
				Character.valueOf('I'), Items.iron_ingot
			}));
			
			
		}
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.altar), new Object[] {
			"I I",
			"I I",
			"OOO",
			Character.valueOf('I'), Items.iron_ingot,
			Character.valueOf('O'), Blocks.obsidian
		}); 
		
		if (ConfigInfo.enableTimeSpring) {	
			if (checkRegOre("gemEmerald")) {
				GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemTimeSpring), new Object[] {
				"E ",
				"CI",
				"O ",
				Character.valueOf('E'), "gemEmerald",
				Character.valueOf('C'), Items.clock,
				Character.valueOf('I'), Items.iron_ingot,
				Character.valueOf('O'), Items.ender_eye
				}));
			}
		}

		if (ConfigInfo.enableMatch) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.match), new Object[] {
				" R",
				"/ ",
				Character.valueOf('R'), "dyeRed",
				Character.valueOf('/'), "stickWood"
			}));
			
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.match, 4), new Object[] {
				" S",
				"/ ",
				Character.valueOf('S'), Items.gunpowder,
				Character.valueOf('/'), "stickWood"
			}));
		}
		
		if (ConfigInfo.enableMortarAndPestle) { 
			GameRegistry.addRecipe(new ItemStack(ModItems.mortarPestle), new Object[] {
				"  B",
				"SBS",
				" S ",
				Character.valueOf('B'), Items.bone,
				Character.valueOf('S'), Blocks.stone
			});
		}
		
		
		
		

		
	}
}
