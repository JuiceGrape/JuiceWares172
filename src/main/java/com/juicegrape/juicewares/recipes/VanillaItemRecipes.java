package com.juicegrape.juicewares.recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.juicegrape.juicewares.config.Enabling;

import cpw.mods.fml.common.registry.GameRegistry;

public class VanillaItemRecipes {


	
	public static void regCustomVanillaRecipes() {
		
		if (Enabling.enableWoolToString) {
			GameRegistry.addShapelessRecipe(new ItemStack(Items.string, RecipeInfo.WOOL_TO_STRING), new Object[] { new ItemStack(Blocks.wool, 1, OreDictionary.WILDCARD_VALUE) });
		}

		if (Enabling.enableDiscRecipes) {

			GameRegistry.addRecipe(
					new ItemStack(Items.record_13),
					new Object[] { "OOO", "O#O", "OOO",

					Character.valueOf('O'), Blocks.obsidian,
							Character.valueOf('#'), Items.gold_ingot });
	

			GameRegistry.addRecipe(
					new ItemStack(Items.record_blocks),
					new Object[] { "OOO", "O#O", "OOO",

					Character.valueOf('O'), Blocks.obsidian,
							Character.valueOf('#'), Blocks.nether_brick });

			GameRegistry.addRecipe(
					new ItemStack(Items.record_chirp),
					new Object[] { "OOO", "O#O", "OOO",

					Character.valueOf('O'), Blocks.obsidian,
							Character.valueOf('#'), Items.redstone });
			
			if (CustomRecipes.checkRegOre("gemEmerald")) {
				GameRegistry.addRecipe(new ShapedOreRecipe(Items.record_cat,
						new Object[] {	"OOO",
										"O#O",
										"OOO",
	
						Character.valueOf('O'), Blocks.obsidian,
						Character.valueOf('#'), "gemEmerald"
					}));
			}

			GameRegistry.addRecipe(
					new ItemStack(Items.record_far),
					new Object[] { "OOO", "O#O", "OOO",

					Character.valueOf('O'), Blocks.obsidian,
							Character.valueOf('#'), Items.slime_ball });

			GameRegistry.addRecipe(
					new ItemStack(Items.record_mellohi),
					new Object[] { "OOO", "O#O", "OOO",

					Character.valueOf('O'), Blocks.obsidian,
							Character.valueOf('#'), Items.cake });

			GameRegistry.addRecipe(new ItemStack(Items.record_stal),
					new Object[] { "OOO", "OOO", "OOO",

					Character.valueOf('O'), Blocks.obsidian

					});

			GameRegistry.addRecipe(
					new ItemStack(Items.record_strad),
					new Object[] { "OOO", "O#O", "OOO",

					Character.valueOf('O'), Blocks.obsidian,
							Character.valueOf('#'), Blocks.gold_block });

			GameRegistry.addRecipe(
					new ItemStack(Items.record_ward),
					new Object[] { "OOO", "O#O", "OOO",

					Character.valueOf('O'), Blocks.obsidian,
							Character.valueOf('#'), Blocks.emerald_block });

			GameRegistry.addRecipe(
					new ItemStack(Items.record_wait),
					new Object[] { "OOO", "O#O", "OOO",

					Character.valueOf('O'), Blocks.obsidian,
							Character.valueOf('#'), Items.diamond });
			
			
			if (CustomRecipes.checkRegOre("dyeBlue")) {
				GameRegistry.addRecipe(new ShapedOreRecipe(Items.record_mall,
						new Object[] { "OOO", "O#O", "OOO",
	
						Character.valueOf('O'), Blocks.obsidian,
						Character.valueOf('#'), "dyeBlue"
						}));
			}

			GameRegistry.addSmelting(Items.record_stal, new ItemStack(
					Items.record_11), 0);


		}

		if (Enabling.enableSaddleRecipe) {

			GameRegistry.addRecipe(new ItemStack(Items.saddle),
					new Object[] {	"S L",
									"LLL",
									"LIL",
									Character.valueOf('S'), Items.string,
									Character.valueOf('L'), Items.leather,
									Character.valueOf('I'), Items.iron_ingot
					});

		}

		if (Enabling.enableNameTagRecipe) {

			GameRegistry.addRecipe(new ItemStack(Items.name_tag),
					new Object[] {	" S",
									"P ",
									Character.valueOf('S'), Items.string,
									Character.valueOf('P'), Items.paper
					});

		}

	}
}
