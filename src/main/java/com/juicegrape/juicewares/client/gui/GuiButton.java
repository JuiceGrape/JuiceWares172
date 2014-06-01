package com.juicegrape.juicewares.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class GuiButton extends Gui {
	
	private static final ResourceLocation back = new ResourceLocation("juicewares:textures/gui/button2-2.png");
	private static final ResourceLocation backOn = new ResourceLocation("juicewares:textures/gui/button2.png");
	private static final ResourceLocation next = new ResourceLocation("juicewares:textures/gui/button1-2.png");
	private static final ResourceLocation nextOn = new ResourceLocation("juicewares:textures/gui/button1.png");
	
	private final int width = 20;
	private final int height = 10;
	
	private boolean isBackButton;
	private int x;
	private int y;
	
	public GuiButton(boolean isBack, int left, int frameWidth, int top, int frameHeight) {
		super();
		isBackButton = isBack;
		
		int modifier = 15;
		
		if (isBack) {
			x = left + modifier;
		} else {
			x = left + frameWidth - width - modifier;
		}
		y = top + frameHeight - height - modifier;

		
	}
	
	public boolean isBackButton() {
		return isBackButton;
	}
	
	public boolean isOnButton(int x, int y) {
		return x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height;
	}
	
	public void renderButton(Minecraft mc, int mouseX, int mouseY) {
		if (this.isBackButton()) {
			if (isOnButton(mouseX, mouseY)) {
				mc.renderEngine.bindTexture(backOn);
			} else {
				mc.renderEngine.bindTexture(back);
			}
		} else {
			if (isOnButton(mouseX, mouseY)) {
				mc.renderEngine.bindTexture(nextOn);
			} else {
				mc.renderEngine.bindTexture(next);
			}
		}
		Gui.func_146110_a(x, y, 0, 0, width, height, width, height);
	}
	
	

}
