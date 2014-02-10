package com.juicegrape.juicewares.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderEyeball extends RenderLiving {

	
	public RenderEyeball(ModelBase par1ModelBase, float shadowSize) {
		
		super(par1ModelBase, shadowSize);
	}


	
	private static final ResourceLocation texture = new ResourceLocation("juicewares", "textures/models/eyeball.png");
	


	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}
