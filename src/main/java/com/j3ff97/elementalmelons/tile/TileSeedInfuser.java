package com.j3ff97.elementalmelons.tile;

import com.j3ff97.elementalmelons.api.recipe.IInfuserRecipe;
import com.j3ff97.elementalmelons.init.ModBlocks;
import com.j3ff97.elementalmelons.recipe.SeedInfuserRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class TileSeedInfuser extends TileEM implements ISidedInventory, IUpdatePlayerListBox
{
    private boolean isActive;
    public int currentBurnTime;
    public int currentProcessTime;
    public int maxBurnTime;
    private ItemStack[] inventory;
    private ItemStack fuelInventory;
    private ItemStack outputInventory;
    private IInfuserRecipe currentRecipe;
    private boolean updatingRecipe = true;

    public TileSeedInfuser()
    {
        inventory = new ItemStack[4];
    }
    /**** basic TE Functioning ****/

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);

        for(int i = 0; i < 3; i++)
        {
            NBTTagCompound tc = compound.getCompoundTag("inventory" + i);
            inventory[i] = ItemStack.loadItemStackFromNBT(tc);
        }
        fuelInventory = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("fuelInventory"));
        outputInventory = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("outputInventory"));
    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);

        for(int i = 0; i < 4; i++)
        {
            if(inventory[i] != null)
            {
                NBTTagCompound tc = new NBTTagCompound();
                inventory[i].writeToNBT(tc);
                compound.setTag("inventory" + i, tc);
            }
        }
        if(fuelInventory != null)
        {
            NBTTagCompound fuelCompound = new NBTTagCompound();
            fuelInventory.writeToNBT(fuelCompound);
            compound.setTag("fuelInventory", fuelCompound);
        }
        if(outputInventory != null)
        {
            NBTTagCompound outputCompound = new NBTTagCompound();
            outputInventory.writeToNBT(outputCompound);
            compound.setTag("outputInventory", outputCompound);
        }
    }

    @Override
    public void readFromPacketNBT(NBTTagCompound tag)
    {
        super.readFromPacketNBT(tag);
        isActive = tag.getBoolean("isActive");

        currentBurnTime = tag.getInteger("currentBurnTime");
        currentProcessTime = tag.getInteger("currentProcessTime");
        maxBurnTime = tag.getInteger("maxBurnTime");
        markForRenderUpdate();
    }

    @Override
    public void writeToPacketNBT(NBTTagCompound tag) {

        super.writeToPacketNBT(tag);
        tag.setInteger("currentBurnTime", currentBurnTime);
        tag.setInteger("currentProcessTime", currentProcessTime);
        tag.setInteger("maxBurnTime", maxBurnTime);
        tag.setBoolean("isActive", isActive);
    }

    @Override
    public void update()
    {
        super.update();

        if(!worldObj.isRemote)
        {
            setIsActive(currentBurnTime > 0);
            if(isActive)
            {
                currentBurnTime--;
            }
            if(updatingRecipe)
            {
                currentRecipe = SeedInfuserRegistry.getInstance().getMatchingRecipe(inventory, outputInventory);
                updatingRecipe = false;
            }
            if(currentRecipe != null)
            {
                if(currentBurnTime <= 0)
                {
                    if (TileEntityFurnace.isItemFuel(fuelInventory))
                    {
                        currentBurnTime = maxBurnTime = TileEntityFurnace.getItemBurnTime(fuelInventory) + 1;
                        if(fuelInventory != null)
                        {
                            fuelInventory.stackSize--;
                            if (fuelInventory.stackSize <= 0)
                            {
                                fuelInventory = fuelInventory.getItem().getContainerItem(fuelInventory);
                            }
                        }
                    }
                    else
                    {
                        currentProcessTime = 0;
                    }
                }
            }
        }
    }

    @Override
    protected void redstoneChanged(boolean value)
    {

    }

    @SideOnly(Side.CLIENT)
    public void setBurnTicks(int _maxBurnTime, int _currentBurnTime)
    {
        maxBurnTime = _maxBurnTime;
        currentBurnTime = _currentBurnTime;
    }

    public float getBurningPercentage() {

        if (maxBurnTime > 0) {
            return (float) currentBurnTime / (float) maxBurnTime;
        } else {
            return 0;
        }
    }

    public float getProcessPercentage() {

        return (float) currentProcessTime / 200;
    }

    /** Added Functions **/

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean _isActive)
    {
        if(_isActive != isActive)
        {
            isActive = _isActive;
            sendUpdatePacket();
        }
    }

    /** IInventory **/

    @Override
    public int getSizeInventory()
    {
        return 3 + 1 + 1;
    }

    @Override
    public ItemStack getStackInSlot(int index)
    {
        updatingRecipe = true;
        if(index == 0)
        {
            return fuelInventory;
        }
        else if(index == 1)
        {
            return outputInventory;
        }
        else if (index < 7)
        {
            return inventory[index - 2];
        }
        return null;
    }

    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        ItemStack tInventory = getStackInSlot(index);

        if(tInventory == null)
        {
            return null;
        }

        ItemStack ret = null;
        if(tInventory.stackSize < count)
        {
            ret = tInventory;
            inventory = null;
        }
        else
        {
            ret = tInventory.splitStack(count);
            if(tInventory.stackSize <= 0)
            {
                if(index == 0)
                {
                    fuelInventory = null;
                }
                else if (index == 1)
                {
                    outputInventory = null;
                }
                else
                {
                    inventory[index-2] = null;
                }
            }
        }
        return ret;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index)
    {
        return getStackInSlot(index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        if (index == 0)
        {
            fuelInventory = stack;
        }
        else if (index == 1)
        {
            outputInventory = stack;
        }
        else
        {
            inventory[index - 2] = stack;
        }
        updatingRecipe = true;
    }

    @Override
    public String getName()
    {
        return ModBlocks.blockSeedInfuser.getUnlocalizedName();
    }

    @Override
    public boolean hasCustomName()
    {
        return false;
    }

    @Override
    public IChatComponent getDisplayName()
    {
        return null;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory(EntityPlayer player)
    {

    }

    @Override
    public void closeInventory(EntityPlayer player)
    {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack)
    {
        if(slot == 0)
        {
            return TileEntityFurnace.isItemFuel(stack);
        }
        else if (slot == 1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    @Override
    public int getField(int id)
    {
        switch(id)
        {
            case 0:
                return this.maxBurnTime;
            case 1:
                return this.currentProcessTime;
            case 2:
                return this.currentBurnTime;
            default:
                return 0;
        }
    }

    @Override
    public void setField(int id, int value)
    {
        switch (id)
        {
            case 0:
                this.maxBurnTime = value;
                break;
            case 1:
                this.currentProcessTime = value;
                break;
            case 2:
                this.currentBurnTime = value;
                break;
        }
    }

    @Override
    public int getFieldCount()
    {
        return 3;
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < this.inventory.length; ++i)
        {
            this.inventory[i] = null;
        }
    }

    @Override
    public List<ItemStack> getDrops()
    {
        List<ItemStack> drops = super.getDrops();
        if(fuelInventory != null) drops.add(fuelInventory);
        if(outputInventory != null) drops.add(outputInventory);
        for(ItemStack stack : inventory)
        {
            if(stack != null) drops.add(stack);
        }
        return drops;
    }

    @Override
    public int[] getSlotsForFace(EnumFacing side)
    {
        return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack item, EnumFacing side)
    {
        return isItemValidForSlot(slot, item);
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack item, EnumFacing side)
    {
        return slot == 1;
    }
}
