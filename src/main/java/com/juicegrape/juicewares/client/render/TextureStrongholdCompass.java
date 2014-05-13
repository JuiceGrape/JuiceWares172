package com.juicegrape.juicewares.client.render;

import net.minecraft.client.renderer.texture.TextureCompass;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;

public class TextureStrongholdCompass extends TextureCompass {

	public TextureStrongholdCompass(String text) {
		super(text);
	}
	
	@Override
	public void updateCompass(World world, double x, double z, double rotation, boolean bool1, boolean bool2) {
		if (!this.framesTextureData.isEmpty()) {
			double tempAngle = 0.0D;
			
			if (world != null && !bool1) {
				ChunkPosition coors = world.findClosestStructure("Stronghold", (int)x, 0, (int)z);
				double coorX = (double)coors.chunkPosX - x;
				double coorZ = (double)coors.chunkPosZ - z;
				rotation %= 360.0D;
				tempAngle = -((rotation - 90.0D) * Math.PI / 180.0D - Math.atan2(coorZ, coorX));
				
				if (!world.provider.isSurfaceWorld()) {
					tempAngle = Math.random() * Math.PI * 2.0D;
				}
			}
			
			if (bool2) {
				this.currentAngle = tempAngle;
			} else {
				double d6;
				for (d6 = tempAngle - this.currentAngle; d6 < -Math.PI; d6 += (Math.PI * 2D)) {
					
				}
				
				while (d6 >= Math.PI) {
					d6 -= (Math.PI * 2D);
				}
				
				if (d6 < -1.0D) {
					d6 = -1.0D;
				}
				
				if (d6 > 1.0D) {
					d6 = 1.0D;
				}
				
				this.angleDelta += d6 * 0.1D;
				this.angleDelta *= 0.8D;
				this.currentAngle += this.angleDelta;
			}
			
			int i;
			
			for (i = (int)((this.currentAngle / (Math.PI * 2D) + 1.0D) * (double)this.framesTextureData.size()) % this.framesTextureData.size(); i < 0; i = (i + this.framesTextureData.size()) % this.framesTextureData.size()) {
				
			}
			
			if (i != this.frameCounter) {
				this.frameCounter = i;
				TextureUtil.uploadTextureMipmap((int[][])this.framesTextureData.get(this.frameCounter), this.width, this.height, this.originX, this.originY, false, false);
			}
		}
	}
}
