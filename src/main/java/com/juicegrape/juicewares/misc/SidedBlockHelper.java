package com.juicegrape.juicewares.misc;

import net.minecraftforge.common.util.ForgeDirection;

public class SidedBlockHelper {
	
	public static ForgeDirection getDirectionFromMeta(int meta) {
		switch(meta) {
		case 0:
		return ForgeDirection.NORTH;
		case 1:
		return ForgeDirection.EAST;
		case 2:
		return ForgeDirection.SOUTH;	
		case 3:
		return ForgeDirection.WEST;	
		default:
		return ForgeDirection.SOUTH;
		}
	}


	
	

}
