package com.juicegrape.juicewares.client.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

import com.juicegrape.juicewares.ModInformation;
import com.juicegrape.juicewares.config.ConfigHandler;
import com.juicegrape.juicewares.config.ConfigInfo;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;

public class JuiceWaresConfigGUI extends GuiConfig {
	
	public JuiceWaresConfigGUI(GuiScreen parentScreen) {
		super(parentScreen, getConfigElements(), ModInformation.ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
	}
	
	@SuppressWarnings("rawtypes")
	private static List<IConfigElement> getConfigElements() {
		List<IConfigElement> list = new ArrayList<IConfigElement>();
		
		for (String name : ConfigInfo.categories) {
			list.add(new ConfigElement(ConfigHandler.config.getCategory(name)));
		}
		
		
		return list;
		
	}
	

}
