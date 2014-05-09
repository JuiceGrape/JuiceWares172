package com.juicegrape.juicewares.compat.NEI;

import net.minecraft.item.ItemStack;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

import com.juicegrape.juicewares.blocks.ModBlocks;

public class NEIJuicewaresConfig implements IConfigureNEI {

	@Override
	public void loadConfig() {
		API.hideItem(new ItemStack(ModBlocks.blazeflower));
		API.hideItem(new ItemStack(ModBlocks.stringreed));
	}

	@Override
	public String getName() {
		return "Primal Enchanting Config";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

}
