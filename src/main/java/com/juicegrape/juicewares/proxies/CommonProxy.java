package com.juicegrape.juicewares.proxies;

import com.juicegrape.juicewares.blocks.BlockInfo;
import com.juicegrape.juicewares.tileentities.TileEntityAltar;
import com.juicegrape.juicewares.tileentities.TileEntityDrawer;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void initSounds() {

		
	}

	public void initRenderers() {

		
	}
	
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityDrawer.class, BlockInfo.DRAWER_KEY);
		GameRegistry.registerTileEntity(TileEntityAltar.class, BlockInfo.ALTAR_KEY);
	}
	

	public int addArmor(String armor) {
		return 0;
	}
}
