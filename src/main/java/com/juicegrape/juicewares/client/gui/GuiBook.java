package com.juicegrape.juicewares.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiBook extends GuiContainer {
	
	private static final ResourceLocation book = new ResourceLocation("juicewares:textures/gui/book.png");
	
	private GuiButton
		buttonNext,
		buttonBack;
	
	private GuiPage[] pages;
	
	private int currentPage;
	
	FontRenderer fontRender = Minecraft.getMinecraft().fontRenderer;
	private int colour = 0x404040;
	

	public GuiBook() {
		super(new Container() {
			@Override
			public boolean canInteractWith(EntityPlayer player) {
				return true;
			}
		});
		
		xSize = 256;
		ySize = 128;
		
		pages = GuiPage.createPages();
		
		currentPage = 0;
		
		
	}
	
	@Override
	public void initGui() {
		super.initGui();
		buttonNext = new GuiButton(false, guiLeft, xSize, guiTop, ySize);
		buttonBack = new GuiButton(true, guiLeft, xSize, guiTop, ySize);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int mouseX, int mouseY) {
		
		mc.renderEngine.bindTexture(book);

		Gui.func_146110_a(guiLeft, guiTop, 0,0, xSize, ySize, xSize, ySize);
		
		if ((currentPage == pages.length || currentPage == pages.length - 1)) {
			
		} else {
			buttonNext.renderButton(mc, mouseX, mouseY);
		}

		
		if (!(currentPage == 0 || currentPage == 1))
		buttonBack.renderButton(mc, mouseX, mouseY);	
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		boolean flag = mouseButton == this.mc.gameSettings.keyBindPickBlock.getKeyCode() + 100;
		
		if (flag) {
			return;
		}
		
		if (buttonNext.isOnButton(mouseX, mouseY)) {
			
			if (currentPage < pages.length) {
				currentPage++;
			}
			if (currentPage < pages.length) {
				currentPage++;
			} else {
				currentPage--;
			}
			
		} else if (buttonBack.isOnButton(mouseX, mouseY)){
			
			if (currentPage >= 0) {
				currentPage--;
			}
			if (currentPage >= 0) {
				currentPage--;
			} else {
				currentPage++;
			}
			
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		
		drawPage();
		currentPage++;
		System.out.println(currentPage);
		drawPage();
		currentPage--;
		System.out.println(currentPage);
		
		
		
		
		
	}
	
	protected void drawPage() {
		
		int xModifier = 15;
		int yModifier = 15;
		int maxLength = this.xSize / 2 - 20;
		
		if (currentPage >= pages.length) {
			return;
		} 
		
		if (currentPage % 2 == 1) {
			xModifier += this.xSize / 2 - 5;
		}
		
		
		if (!pages[currentPage].text.equals("Recipe")) {
			fontRender.drawSplitString(pages[currentPage].text, xModifier, yModifier, maxLength, colour);
		} else {
			pages[currentPage].renderRecipe(this);
		}
	}
	
	public void drawItemStack(ItemStack stack, int x, int y) {
		GuiScreen.itemRender.renderItemIntoGUI(fontRender, mc.getTextureManager(), stack, x, y);
	}

}
