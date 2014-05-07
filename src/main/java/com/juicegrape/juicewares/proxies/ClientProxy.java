package com.juicegrape.juicewares.proxies;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.juicegrape.juicewares.blocks.ModBlocks;
import com.juicegrape.juicewares.client.models.ModelEyeball;
import com.juicegrape.juicewares.client.render.AltarRender;
import com.juicegrape.juicewares.client.render.CabinetRender;
import com.juicegrape.juicewares.client.render.ItemTileEntityRenderer;
import com.juicegrape.juicewares.client.render.RenderEyeball;
import com.juicegrape.juicewares.entities.EntityEyeball;
import com.juicegrape.juicewares.tileentities.TileEntityAltar;
import com.juicegrape.juicewares.tileentities.TileEntityDrawer;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void initSounds() {
	}

	@Override
	public void initRenderers() {
		//init the rendering stuff
		RenderingRegistry.registerEntityRenderingHandler(EntityEyeball.class, new RenderEyeball(new ModelEyeball(), 0.5F));
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDrawer.class, new CabinetRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAltar.class, new AltarRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.drawer), new ItemTileEntityRenderer(new TileEntityDrawer()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.altar), new ItemTileEntityRenderer(new TileEntityAltar()));
	}
	
	@Override
	public void initKeyBind() {
		
	}
	
	@Override
	public void registerTileEntities() {
		super.registerTileEntities();

	}
	
	@Override
	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}


}
