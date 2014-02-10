package com.juicegrape.juicewares.client.render;

import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;


public class ItemTileEntityRenderer implements IItemRenderer {
	
	private final double pos = -0.5D;
	
	

	private TileEntity tileModel;
	
	public ItemTileEntityRenderer(TileEntity te) {
		tileModel = te;
	}
	

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;

	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		switch(helper) {
		case BLOCK_3D:
			return false;
		default:
			return true;
		}
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		switch (type) {
		case EQUIPPED:
			TileEntityRendererDispatcher.instance.renderTileEntityAt(tileModel, 0.0D, 0.0D, 0.0D, 0.0F);
			break;
		case ENTITY:
			TileEntityRendererDispatcher.instance.renderTileEntityAt(tileModel, pos, pos, pos, 0.0F);
			break;
		case EQUIPPED_FIRST_PERSON:
			TileEntityRendererDispatcher.instance.renderTileEntityAt(tileModel, 0.0D, 0.0D, 0.0D, 0.0F);
			break;
		case FIRST_PERSON_MAP:
			break;
		case INVENTORY:
			TileEntityRendererDispatcher.instance.renderTileEntityAt(tileModel, 0.0D, 0.0D, 0.0D, 0.0F);
			break;
		default:
			break;
			
		}
		
	}

}
