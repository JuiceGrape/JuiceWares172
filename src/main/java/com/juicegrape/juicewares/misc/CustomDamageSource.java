package com.juicegrape.juicewares.misc;

import net.minecraft.util.DamageSource;

public class CustomDamageSource extends DamageSource {
	
	public static DamageSource timeWound;

	protected CustomDamageSource(String damageType) {
		super(damageType);
	}
	
	

	public static void init() {
		timeWound = (new CustomDamageSource("juicewares.timewoundDamage")).setDamageBypassesArmor();
	}
	
}
