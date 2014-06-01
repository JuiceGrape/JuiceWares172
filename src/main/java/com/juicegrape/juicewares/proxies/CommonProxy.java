package com.juicegrape.juicewares.proxies;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.juicegrape.juicewares.blocks.BlockInfo;
import com.juicegrape.juicewares.tileentities.TileEntityAltar;
import com.juicegrape.juicewares.tileentities.TileEntityDrawer;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy implements IGuiHandler {

	public void initSounds() {

		
	}

	public void initRenderers() {

		
	}
	
	public void initKeyBind() {
		
	}
	
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityDrawer.class, BlockInfo.DRAWER_KEY);
		GameRegistry.registerTileEntity(TileEntityAltar.class, BlockInfo.ALTAR_KEY);
	}
	
	public boolean isClient() {
		return false;
	}
	

	public int addArmor(String armor) {
		return 0;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}
}
