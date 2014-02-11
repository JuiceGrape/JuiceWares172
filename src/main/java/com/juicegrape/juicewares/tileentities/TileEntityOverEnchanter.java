package com.juicegrape.juicewares.tileentities;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import com.juicegrape.juicewares.misc.SidedBlockHelper;

public class TileEntityOverEnchanter extends TileEntity {
	
	
	public ItemStack tool;
	private Random random;
	
	
	public TileEntityOverEnchanter() {
		tool = null;
		random = new Random();
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagCompound nbt1 = nbt.getCompoundTag("tool");
		if (nbt1 != null) {
			tool = ItemStack.loadItemStackFromNBT(nbt1);
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		if (tool != null) {
			NBTTagCompound nbt1 = new NBTTagCompound();
			tool.writeToNBT(nbt1);
			nbt.setTag("tool", nbt1);
		}
	}
	

    
    public boolean canEnchant() {
    	if (tool == null) {
    		return false;
    	}
    	ForgeDirection facing = SidedBlockHelper.getDirectionFromMeta(worldObj.getBlockMetadata(xCoord, yCoord, zCoord));
    	TileEntityAltar[] alt = {null, null};
    	ForgeDirection[] sds = new ForgeDirection[2];
    	if (facing.equals(ForgeDirection.NORTH) || facing.equals(ForgeDirection.SOUTH)) {
    		sds[0] = ForgeDirection.EAST;
    		sds[1] = ForgeDirection.WEST;
    	} else {
    		sds[0] = ForgeDirection.NORTH;
    		sds[1] = ForgeDirection.SOUTH;
    	}
    	
    	if (worldObj.getTileEntity(xCoord + sds[0].offsetX, yCoord + sds[0].offsetY, zCoord + sds[0].offsetZ) instanceof TileEntityAltar) {
			alt[0] = (TileEntityAltar)worldObj.getTileEntity(xCoord + sds[0].offsetX, yCoord + sds[0].offsetY, zCoord + sds[0].offsetZ);
		} 
		if (worldObj.getTileEntity(xCoord + sds[1].offsetX, yCoord + sds[1].offsetY, zCoord + sds[1].offsetZ) instanceof TileEntityAltar) {
			alt[1] = (TileEntityAltar)worldObj.getTileEntity(xCoord + sds[1].offsetX, yCoord + sds[1].offsetY, zCoord + sds[1].offsetZ);
		} 
		
		if (alt[0] == null || alt[1] == null) {
			return false;
		}
		
		if (!alt[0].isBookEnchanted() || !alt[1].isBookEnchanted()) {
			return false;
		}
		
		if (alt[0].getEnchant().equals(alt[1].getEnchant()) && alt[0].getEnchantLvl() == alt[1].getEnchantLvl()) {
			if (!tool.isItemEnchanted() && alt[0].getEnchant().canApply(tool)) {
				return true;
			}
		}
		
		return false;
		
    }
	
    public void enchantAndPop() {
    	
    	ForgeDirection facing = SidedBlockHelper.getDirectionFromMeta(worldObj.getBlockMetadata(xCoord, yCoord, zCoord));
    	TileEntityAltar[] alt = {null, null};
    	ForgeDirection[] sds = new ForgeDirection[2];
    	if (facing.equals(ForgeDirection.NORTH) || facing.equals(ForgeDirection.SOUTH)) {
    		sds[0] = ForgeDirection.EAST;
    		sds[1] = ForgeDirection.WEST;
    	} else {
    		sds[0] = ForgeDirection.NORTH;
    		sds[1] = ForgeDirection.SOUTH;
    	}
    	
    	if (worldObj.getTileEntity(xCoord + sds[0].offsetX, yCoord + sds[0].offsetY, zCoord + sds[0].offsetZ) instanceof TileEntityAltar) {
			alt[0] = (TileEntityAltar)worldObj.getTileEntity(xCoord + sds[0].offsetX, yCoord + sds[0].offsetY, zCoord + sds[0].offsetZ);
		} 
		if (worldObj.getTileEntity(xCoord + sds[1].offsetX, yCoord + sds[1].offsetY, zCoord + sds[1].offsetZ) instanceof TileEntityAltar) {
			alt[1] = (TileEntityAltar)worldObj.getTileEntity(xCoord + sds[1].offsetX, yCoord + sds[1].offsetY, zCoord + sds[1].offsetZ);
		} 
		
		ItemStack toolDone = tool.copy();
		toolDone.addEnchantment(alt[0].getEnchant(), alt[0].getEnchantLvl() + 1);
		EntityItem spawnTool = createItem(toolDone);
		worldObj.spawnEntityInWorld(spawnTool);
		tool = null;
		alt[0].deleteBook();
		alt[1].deleteBook();
    }
	
	
	
    
    
    private EntityItem createItem(ItemStack itemStack) {
		float xThang = random.nextFloat() * 0.8F + 0.1F;
		float yThang = random.nextFloat() * 0.8F + 0.1F;
		float zThang = random.nextFloat() * 0.8F + 0.1F;
		EntityItem entityItem = new EntityItem(worldObj, xCoord + xThang, yCoord + yThang, zCoord + zThang, itemStack);
        entityItem.motionX = (float) random.nextGaussian() * 0.05F;
        entityItem.motionY = (float) random.nextGaussian() * 0.05F + 0.2F;
        entityItem.motionZ = (float) random.nextGaussian() * 0.05F;
        return entityItem;
	}
    
    public void update() {
    	worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }
    
    public void setItem(ItemStack stack) {
    	if (tool == null) {
    		tool = stack;
    	}
    }
    
    public void popTool() {
    	if (tool != null) {
    		worldObj.spawnEntityInWorld(createItem(tool));
    		tool = null;
    	}
    }
    
    @Override
    public Packet getDescriptionPacket() {
    	NBTTagCompound nbtTag = new NBTTagCompound();
    	writeToNBT(nbtTag);
    	return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, nbtTag);
    	
    }
    
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
    	readFromNBT(pkt.func_148857_g());
    }
    
	
	
}
