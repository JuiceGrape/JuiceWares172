package com.juicegrape.juicewares.potionEffects;

import net.minecraft.potion.Potion;

public class Potions {
	
	public static Potion cWaterBreathing;
	public static int cWaterBreathingId;
	
	public static void init() {
		cWaterBreathing = (new CustomPotions(cWaterBreathingId, false, 0, 0, 0));
		cWaterBreathing.setPotionName("potion.cWaterBreathing");
	}

	
	

}