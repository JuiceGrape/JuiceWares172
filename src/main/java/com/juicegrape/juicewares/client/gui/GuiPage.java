package com.juicegrape.juicewares.client.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.juicegrape.juicewares.blocks.ModBlocks;
import com.juicegrape.juicewares.items.ModItems;

public class GuiPage {
	
	public String category;
	public String text;
	
	private Object[] recipe;
	private ItemStack product;
	
	public GuiPage(String category,  ItemStack product, Object[] recipe) {
		this(category, "Recipe");
		this.recipe = recipe;
		this.product = product;
	}
	
	public GuiPage(String category, String text) {
		this.category = category;
		this.text = text;
	}
	
	
	
	public static GuiPage[] createPages() {
		
		List<GuiPage> pages = new ArrayList<GuiPage>();
		
		pages.add(new GuiPage("TestCategory", "swek"));
		pages.add(new GuiPage("TestCategory", 
				new ItemStack(ModItems.blazeflowerseeds), new Object[] {
						new ItemStack(ModBlocks.altar)
				}));
		pages.add(new GuiPage("TestCategory", "Test2"));
		pages.add(new GuiPage("TestCategory", "Test3"));
		pages.add(new GuiPage("TestCategory", "Test4"));
		pages.add(new GuiPage("TestCategory", "Test5"));
		pages.add(new GuiPage("TestCategory", "Test6"));
		
		return pages.toArray(new GuiPage[]{ null });
		
	}
	
	public void renderRecipe(GuiBook gui) {
		if (product == null || recipe == null) {
			return;
		}
			for(int i = 0; i < recipe.length; i++) {
				ItemStack renderStack;
				if (recipe[i] instanceof Item) {
					renderStack = new ItemStack((Item)recipe[i]);
				} else if (recipe[i] instanceof Block) {
					renderStack = new ItemStack((Block)recipe[i]);
				} else if (recipe[i] instanceof ItemStack) {
					renderStack = (ItemStack)recipe[i];
				} else {
					continue;
				}
				switch (i) {
				case 0:
					gui.drawItemStack(renderStack, 50, 50);
				}
					
			}
	}

}
