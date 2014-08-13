package com.juicegrape.juicewares.compat.NEI;

import net.minecraft.item.ItemStack;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

import com.juicegrape.juicewares.blocks.ModBlocks;
import com.juicegrape.juicewares.config.ConfigInfo;

public class NEIJuicewaresConfig implements IConfigureNEI {

	@Override
	public void loadConfig() {
		
		if (!ConfigInfo.enableNEI) {
			return;
		}
		API.hideItem(new ItemStack(ModBlocks.blazeflower));
		API.hideItem(new ItemStack(ModBlocks.stringreed));
		API.registerRecipeHandler(new PrimalEnchantingHandler());
		API.registerUsageHandler(new PrimalEnchantingHandler());
	}

	@Override
	public String getName() {
		return "JuiceWares nei integration";
	}

	@Override
	public String getVersion() {
		return "2.0";
	}

}
