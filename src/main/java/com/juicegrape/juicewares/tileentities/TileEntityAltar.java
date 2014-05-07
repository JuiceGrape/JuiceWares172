package com.juicegrape.juicewares.tileentities;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAltar extends TileEntity implements IInventory {
	
	public ItemStack book;
	
	public TileEntityAltar() {
		book = null;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagCompound nbt1 = nbt.getCompoundTag("book");
		if (nbt1 != null) {
			book = ItemStack.loadItemStackFromNBT(nbt1);
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		if (book != null) {
			NBTTagCompound nbt1 = new NBTTagCompound();
			book.writeToNBT(nbt1);
			nbt.setTag("book", nbt1);
		}
	}
	
	public void update() {
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
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
    
    public boolean isBookEnchanted() {
    	return book != null && book.getItem() == Items.enchanted_book;
    }
    
    public Enchantment getEnchant() {
    	if (isBookEnchanted()) {
    		ItemEnchantedBook bookItem = (ItemEnchantedBook)book.getItem();
    		NBTTagList nbtlist = bookItem.func_92110_g(book);
    		
    		if (nbtlist.tagCount() != 1) {
    			System.out.println("More than 1 enchant on the book");
    			return null;
    		}
    		
    		if (nbtlist != null) {
    			for (int i = 0; i < nbtlist.tagCount(); i++) {
    				short id = nbtlist.getCompoundTagAt(i).getShort("id");
    				
    				if (Enchantment.enchantmentsList[id] != null) {
    					return Enchantment.enchantmentsList[id];
    				}
    			}
    		}
    	}
    	return null;
    }
    
    public short getEnchantLvl() {
    	if (isBookEnchanted()) {
    		ItemEnchantedBook bookItem = (ItemEnchantedBook)book.getItem();
    		NBTTagList nbtlist = bookItem.func_92110_g(book);
    		
    		if (nbtlist.tagCount() != 1) {
    			System.out.println("More than 1 enchant on the book");
    			return 0;
    		}
    		
    		if (nbtlist != null) {
    			for (int i = 0; i < nbtlist.tagCount(); i++) {
    				short id = nbtlist.getCompoundTagAt(i).getShort("id");
    				short lvl = nbtlist.getCompoundTagAt(i).getShort("lvl");
    				
    				if (Enchantment.enchantmentsList[id] != null) {
    					return lvl;
    				}
    			}
    		}
    	}
    	return 0;
    }
    
    public void deleteBook() {
    	book = null;
    	update();
    }

	@Override
	public int getSizeInventory() {
		return 1;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return book;
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if (book != null) {
			ItemStack itemStack = book;
			book = null;
			update();
			return itemStack;
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		book = stack;
		if (stack != null && stack.stackSize > this.getInventoryStackLimit()) {
			stack.stackSize = this.getInventoryStackLimit();
		}
		update();
	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return true;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return book == null;
	}
	
}
