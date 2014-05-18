package com.juicegrape.juicewares.compat.NEI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import codechicken.nei.PositionedStack;
import codechicken.nei.api.IOverlayHandler;
import codechicken.nei.api.IRecipeOverlayRenderer;
import codechicken.nei.recipe.GuiRecipe;
import codechicken.nei.recipe.GuiUsageRecipe;
import codechicken.nei.recipe.ICraftingHandler;
import codechicken.nei.recipe.IUsageHandler;

import com.juicegrape.juicewares.items.ModItems;
/* 
 * Note: This NEI integration code was partially copied from RWTema's mod: Extra Utilities. 
 * I tried to understand the NEI API myself, but I failed miserably. 
 * What I did understand I mostly changed to actually fit my purpose. I hope you understand.
 */
import com.juicegrape.juicewares.recipes.primalEnchanting.PrimalEnchantingMain;

public class PrimalEnchantingHandler implements IUsageHandler, ICraftingHandler {
	
	int thisRecipe;
	ItemStack displayItem = null;
	public static int width = 166;
	int colour = 0x000000;
	Random random = new Random();
	public static int id = 13364;
	
	FontRenderer fontRender = Minecraft.getMinecraft().fontRenderer;
	
	public PrimalEnchantingHandler() {
		thisRecipe = -1;
	}
	
	public PrimalEnchantingHandler(int recipe, ItemStack item) {
		if (recipe < PrimalEnchantingMain.mats.length) {
			thisRecipe = recipe;
		}
		displayItem = item;
	}

	@Override
	public String getRecipeName() {
		return "Primal Enchanting";
	}

	@Override
	public int numRecipes() {
		return thisRecipe >= 0 ? 1 : PrimalEnchantingMain.mats.length;
	}

	@Override
	public void drawBackground(int recipe) {
	}

	@Override
	public void drawForeground(int recipe) {
		int recipes;
		if (thisRecipe >= 0) {
			recipes = thisRecipe;
		} else {
			recipes = recipe;
		}
		String text = PrimalEnchantingMain.mats[recipes] != null ? PrimalEnchantingMain.mats[recipes].getPrintString() : "Error";
		fontRender.drawString(text, (width / 2) - ( fontRender.getStringWidth(text) / 2), 36, colour, false);
		
		
	}
	
	@Override
	public List<PositionedStack> getIngredientStacks(int recipe) {
		return new ArrayList<PositionedStack>();
	}

	@Override
	public List<PositionedStack> getOtherStacks(int recipetype) {
		List<PositionedStack> stacks = new ArrayList<PositionedStack>();
		stacks.add(new PositionedStack(((new ItemStack(ModItems.debugitem))), width / 2 - 9, 18, false));
		return stacks;
	}

	@Override
	public PositionedStack getResultStack(int recipe) {
		PositionedStack stack;
		
		if (displayItem != null && numRecipes() == 1) {
			stack = new PositionedStack(this.displayItem, width / 2 - 9, 0, false);
		} else 
		if (PrimalEnchantingMain.mats[recipe].getItemStack() != null) {
			if (PrimalEnchantingMain.mats[recipe].getItemMetadata() == OreDictionary.WILDCARD_VALUE) {
				
				stack = new PositionedStack(PrimalEnchantingMain.mats[recipe].getItemStack(), width / 2 - 9, 0, true);
				stack.setPermutationToRender(PrimalEnchantingMain.mats[recipe].updateTimer(stack.items.length));
				
			} else {
				stack = new PositionedStack(PrimalEnchantingMain.mats[recipe].getItemStack(), width / 2 - 9, 0, false);
			}
			
		} else {
			stack = new PositionedStack(this.displayItem, width / 2 - 9, 0, false);
		}
		return stack;
	}

	@Override
	public void onUpdate() {
	}

	@Override
	public boolean hasOverlay(GuiContainer gui, Container container, int recipe) {
		return false;
	}

	@Override
	public IRecipeOverlayRenderer getOverlayRenderer(GuiContainer gui,
			int recipe) {
		return null;
	}

	@Override
	public IOverlayHandler getOverlayHandler(GuiContainer gui, int recipe) {
		return null;
	}

	@Override
	public int recipiesPerPage() {
		return 2;
	}

	@Override
	public List<String> handleTooltip(GuiRecipe gui, List<String> currenttip,
			int recipe) {
		return currenttip;
	}

	@Override
	public List<String> handleItemTooltip(GuiRecipe gui, ItemStack stack,
			List<String> currenttip, int recipe) {
		
		PositionedStack stack2 = getOtherStacks(recipe).get(0);
		
		if (gui.isMouseOver(stack2, recipe)) {
			List<String> tip = new ArrayList<String>();
			tip.add("All primal enchanting materials");
			return tip;
		}
		return currenttip;
	}

	@Override
	public boolean keyTyped(GuiRecipe gui, char keyChar, int keyCode, int recipe) {
		return false;
	}

	@Override
	public boolean mouseClicked(GuiRecipe gui, int button, int recipe) {
		
		PositionedStack stack = getOtherStacks(recipe).get(0);
		
		if (gui.isMouseOver(stack, recipe)) {
			System.out.println("YUP");
			return GuiUsageRecipe.openRecipeGui("primalAll", new Object[0]);

		}
		return false;
	}

	@Override
	public ICraftingHandler getRecipeHandler(String outputId, Object... results) {
		if (outputId.equals("primalAll")) {
			return this;
		}
		for (int i = 0; i < results.length; i++) {
			if (results[i] instanceof ItemStack) {
				for (int j = 0; j < PrimalEnchantingMain.mats.length; j++) {
					if (PrimalEnchantingMain.mats[j].getItemMetadata() == OreDictionary.WILDCARD_VALUE) {
						if (PrimalEnchantingMain.mats[j].getItem().equals(((ItemStack)results[i]).getItem())) {
							return new PrimalEnchantingHandler(j, (ItemStack)results[i]);
						}
					} else {
						if (ItemStack.areItemStacksEqual(PrimalEnchantingMain.mats[j].getItemStack(), (ItemStack)results[i])) {
							return new PrimalEnchantingHandler(j, (ItemStack)results[i]);
						}
					}
				}
			}			
		}
		return this;
	}

	@Override
	public IUsageHandler getUsageHandler(String inputId, Object... ingredients) {
		if (inputId.equals("primalAll")) {
			return this;
		}
		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i] instanceof ItemStack) {
				for (int j = 0; j < PrimalEnchantingMain.mats.length; j++) {
					if (PrimalEnchantingMain.mats[j].getItemMetadata() == OreDictionary.WILDCARD_VALUE) {
						if (PrimalEnchantingMain.mats[j].getItem().equals(((ItemStack)ingredients[i]).getItem())) {
							return new PrimalEnchantingHandler(j, (ItemStack)ingredients[i]);
						}
					} else {
						if (ItemStack.areItemStacksEqual(PrimalEnchantingMain.mats[j].getItemStack(), (ItemStack)ingredients[i])) {
							return new PrimalEnchantingHandler(j, (ItemStack)ingredients[i]);
						}
					}
				}
			}			
		}
		return this;
	}

}
