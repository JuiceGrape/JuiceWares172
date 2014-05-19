package com.juicegrape.juicewares.compat.NEI;

import java.util.ArrayList;
import java.util.List;

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
import com.juicegrape.juicewares.recipes.primalEnchanting.PrimalEnchantMaterial;
/* 
 * Note: This NEI integration code was partially copied from RWTema's mod: Extra Utilities. 
 * I tried to understand the NEI API myself, but I failed miserably. 
 * What I did understand I mostly changed to actually fit my purpose. I hope you understand.
 */
import com.juicegrape.juicewares.recipes.primalEnchanting.PrimalEnchantingMain;

public class PrimalEnchantingHandler implements IUsageHandler, ICraftingHandler {
	
	private int thisRecipe;
	private ItemStack displayItem = null;
	public static int width = 166;
	private int colour = 0x000000;
	public static int id = 13364;
	
	private PrimalEnchantMaterial[] enchants;
	
	FontRenderer fontRender = Minecraft.getMinecraft().fontRenderer;
	
	public PrimalEnchantingHandler() {
		thisRecipe = -2;
	}
	
	public PrimalEnchantingHandler(boolean all) {
		if (all) {
			thisRecipe = -1;
		} else {
			thisRecipe = -2;
		}
	}
	
	public PrimalEnchantingHandler(ItemStack tool) {
		List<PrimalEnchantMaterial> mats2 = new ArrayList<PrimalEnchantMaterial>();
		for (PrimalEnchantMaterial mat : PrimalEnchantingMain.mats) {
			if (mat.getEnchant().canApply(tool)) {
				mats2.add(mat);
			}
		}
		if (!mats2.isEmpty()) {
			enchants = mats2.toArray(new PrimalEnchantMaterial[0]);
		}
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
		if (enchants != null) {
			return enchants.length;
		}
		return thisRecipe < -1 ? 0 : thisRecipe >= 0 ? 1 : PrimalEnchantingMain.mats.length;
	}

	@Override
	public void drawBackground(int recipe) {
	}

	@Override
	public void drawForeground(int recipe) {
		int recipes;
		if (enchants != null) {
			recipes = recipe;
		} else if (thisRecipe >= 0) {
			recipes = thisRecipe;
		} else {
			recipes = recipe;
		}
		String text;
		if (enchants != null) {
			text = enchants[recipes] != null ? enchants[recipes].getPrintString() : "Error";
		} else {
			text = PrimalEnchantingMain.mats[recipes] != null ? PrimalEnchantingMain.mats[recipes].getPrintString() : "Error";
		}
		
		fontRender.drawString(text, (width / 2) - ( fontRender.getStringWidth(text) / 2), 36, colour, false);
		
		
	}
	
	@Override
	public List<PositionedStack> getIngredientStacks(int recipe) {
		return new ArrayList<PositionedStack>();
	}

	@Override
	public List<PositionedStack> getOtherStacks(int recipetype) {
		List<PositionedStack> stacks = new ArrayList<PositionedStack>();
		stacks.add(new PositionedStack(((new ItemStack(ModItems.debugitem, 1, 1))), width / 2 - 9, 18, false));
		return stacks;
	}

	@Override
	public PositionedStack getResultStack(int recipe) {
		PositionedStack stack;
		if (enchants != null) {
			if (enchants[recipe].getItemStack() != null) {
				if (enchants[recipe].getItemMetadata() == OreDictionary.WILDCARD_VALUE) {
					stack = new PositionedStack(enchants[recipe].getItemStack(), width / 2 - 9, 0, true);
					stack.setPermutationToRender(enchants[recipe].updateTimer(stack.items.length));
				} else {
					stack = new PositionedStack(enchants[recipe].getItemStack(), width / 2 - 9, 0, false);
				}
			} else {
				stack = new PositionedStack(this.displayItem, width / 2 - 9, 0, false);
			}
		} else if (displayItem != null && numRecipes() == 1) {
			stack = new PositionedStack(this.displayItem, width / 2 - 9, 0, false);
		} else if (PrimalEnchantingMain.mats[recipe].getItemStack() != null) {
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
			return GuiUsageRecipe.openRecipeGui("primalAll", new Object[0]);

		}
		return false;
	}

	@Override
	public ICraftingHandler getRecipeHandler(String outputId, Object... results) {
		if (outputId.equals("primalAll")) {
			return new PrimalEnchantingHandler(true);
		}
		if (outputId != "item") {
			return new PrimalEnchantingHandler(false);
		}
		for (int i = 0; i < results.length; i++) {
			if (results[i] instanceof ItemStack) {
				for (int j = 0; j < PrimalEnchantingMain.mats.length; j++) {
					if (PrimalEnchantingMain.mats[j].getItemMetadata() == OreDictionary.WILDCARD_VALUE) {
						if (PrimalEnchantingMain.mats[j].getItem().equals(((ItemStack)results[i]).getItem())) {
							ItemStack tempStack = ((ItemStack)results[i]).copy();
							tempStack.stackSize = 1;
							return new PrimalEnchantingHandler(j, tempStack);
						}
					} else {
						if (PrimalEnchantingMain.mats[j].getItem() == ((ItemStack)results[i]).getItem() && PrimalEnchantingMain.mats[j].getItemMetadata() == ((ItemStack)results[i]).getItemDamage() ) {
							ItemStack tempStack = ((ItemStack)results[i]).copy();
							tempStack.stackSize = 1;
							return new PrimalEnchantingHandler(j, tempStack);
						}
					}
				}
			}			
		}
		return new PrimalEnchantingHandler(false);
	}

	@Override
	public IUsageHandler getUsageHandler(String inputId, Object... ingredients) {
		if (inputId.equals("primalAll")) {
			return new PrimalEnchantingHandler(true);
		}
		if (inputId != "item") {
			return new PrimalEnchantingHandler(false);
		}
		for (int i = 0; i < ingredients.length; i++) {
			if (ingredients[i] instanceof ItemStack) {
				for (int j = 0; j < PrimalEnchantingMain.mats.length; j++) {
					if (PrimalEnchantingMain.mats[j].getEnchant().canApply((ItemStack)ingredients[i])) {
						return new PrimalEnchantingHandler((ItemStack)ingredients[i]);
					}
					if (PrimalEnchantingMain.mats[j].getItemMetadata() == OreDictionary.WILDCARD_VALUE) {
						if (PrimalEnchantingMain.mats[j].getItem().equals(((ItemStack)ingredients[i]).getItem())) {
							ItemStack tempStack = ((ItemStack)ingredients[i]).copy();
							tempStack.stackSize = 1;
							return new PrimalEnchantingHandler(j, tempStack);
						}
					} else {
						if (PrimalEnchantingMain.mats[j].getItem() == ((ItemStack)ingredients[i]).getItem() && PrimalEnchantingMain.mats[j].getItemMetadata() == ((ItemStack)ingredients[i]).getItemDamage() ) {
							ItemStack tempStack = ((ItemStack)ingredients[i]).copy();
							tempStack.stackSize = 1;
							return new PrimalEnchantingHandler(j, tempStack);
						}
					}
				}
			}			
		}
		return new PrimalEnchantingHandler(false);
	}

}
