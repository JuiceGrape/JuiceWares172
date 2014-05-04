package com.juicegrape.juicewares.misc;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class CustomEntityItem extends EntityItem{

	public CustomEntityItem(World par1World) {
		super(par1World);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		if(this.getEntityItem().getItem().equals(Items.gunpowder)) {
			explodeGunpowder(this);	
		}

	}
	
	public void explodeGunpowder(EntityItem item) {
		if (item.worldObj != null) {
			if(item.getEntityItem().getItem().equals(Items.gunpowder)) {
				if(item.isBurning()) {
					item.worldObj.createExplosion(item, item.posX, item.posY, item.posZ, (float)(this.getEntityItem().stackSize / 16f) + 1f, true);
					item.setDead();
				}
			}
		}
	}

	
	
}
