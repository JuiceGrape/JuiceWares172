package com.juicegrape.juicewares.misc;

import net.minecraft.util.DamageSource;

public class CustomDamageSource extends DamageSource {
	
	public static DamageSource timeWound;

	protected CustomDamageSource(String damageType) {
		super(damageType);
	}
	
/*	@Override
	public ChatMessageComponent getDeathMessage(EntityLivingBase entityLivingBase) {
		String message = null;
		if (this.damageType.equals("juicewares.timewoundDamage")) {
			message = entityLivingBase.getEntityName() + " skipped too far ahead.";
		}
		return message != null ? ChatMessageComponent.createFromText(message) : super.getDeathMessage(entityLivingBase);
	} */
	//TODO: Possibly edit this
	
	

	public static void init() {
		timeWound = (new CustomDamageSource("juicewares.timewoundDamage")).setDamageBypassesArmor();
	}
	
}
