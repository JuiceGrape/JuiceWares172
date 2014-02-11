package com.juicegrape.juicewares.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.juicegrape.juicewares.juicewares;
import com.juicegrape.juicewares.tileentities.TileEntityAltar;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockAltar extends BlockContainer {

	protected BlockAltar() {
		super(Material.iron);
		setHardness(3F);
		setCreativeTab(juicewares.juiceTab);
		this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.6875F, 0.9375F);
		this.setBlockName(BlockInfo.ALTAR_UNLOCALIZED_NAME);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) {
		blockIcon = Blocks.obsidian.getIcon(0, 0);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityAltar();
	}
	
	@Override
    public boolean isOpaqueCube()
    {
        return false;
    }
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
	{
	   return false;
	}
    
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
  
    
    
    
    @Override
    public void breakBlock(World world, int x, int y, int z, Block b, int i2) {
    	TileEntity te = world.getTileEntity(x, y, z);
		if (te instanceof TileEntityAltar) {
			((TileEntityAltar) te).clearItem();
		}
    	super.breakBlock(world, x, y, z, b, i2);
    }
    
    protected void spawnParticles(String particles, World world, int x, int y, int z, Random random) {
    	for (int i = 0; i < 4; i ++) {
    		float particleX = x + random.nextFloat();
    		float particleY = y + random.nextFloat();
    		float particleZ = z + random.nextFloat();
    		float particleMotionX = -0.5F + random.nextFloat();
    		float particleMotionY = -0.5F + random.nextFloat();
    		float particleMotionZ = -0.5F + random.nextFloat();
    		
    		world.spawnParticle(particles, particleX, particleY, particleZ, particleMotionX, particleMotionY, particleMotionZ);
    	}
    }
    
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
    	if (!world.isRemote) {
    		TileEntity te = world.getTileEntity(x, y, z);
    		if (te instanceof TileEntityAltar) {
    			if (((TileEntityAltar) te).book == null) {
    				if (player.getCurrentEquippedItem() != null) {
    					ItemStack tool = player.getCurrentEquippedItem();
    					ItemStack tool1 = tool.copy();
    					tool1.stackSize = 1;
    					((TileEntityAltar) te).setBook(tool1);
    					tool.stackSize--;
    					if (tool.stackSize <= 0) {
    						player.setCurrentItemOrArmor(0, null);
    					} else {
        					player.setCurrentItemOrArmor(0, tool);
    					}
    				}
    			} else {
    				((TileEntityAltar) te).clearItem();
    			}
    		} 

    	}
    	
    	return true;
    }


}
