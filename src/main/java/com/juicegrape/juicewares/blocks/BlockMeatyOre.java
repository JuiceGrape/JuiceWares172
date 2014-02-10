package com.juicegrape.juicewares.blocks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.juicegrape.juicewares.juicewares;

public class BlockMeatyOre extends Block {
	Random random;

	public BlockMeatyOre() {
		
		super(Material.rock);
		setStepSound(Block.soundTypeStone);
		setBlockName(BlockInfo.MEATYORE_UNLOCALIZED_NAME);
		setCreativeTab(juicewares.juiceTab);
		setHardness(1.5F);
		random = new Random();
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register) {
		blockIcon = register.registerIcon(BlockInfo.TEXTURE_LOCATION + ":" + BlockInfo.MEATYORE);
	}
	

	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y,
			int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		int amount = 1 + random.nextInt(fortune + 1);
		for (int i = 0; i < amount; i++) {
			ret.add(BlockInfo.MEATYORE_DROP[random.nextInt(BlockInfo.MEATYORE_DROP.length)].copy());
		}
		Iterator<ItemStack> itr = ret.iterator();
		while (itr.hasNext()) {
			ItemStack test = itr.next();
			System.out.println(test.getDisplayName());
		}
		return ret; 
	}
	
}
