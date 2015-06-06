package j3ff97.elementalmelons.tileentity;

import j3ff97.elementalmelons.blocks.BlockSeedInfuser;
import j3ff97.elementalmelons.crafting.SeedInfuserRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntitySeedInfuser extends TileEntity implements ISidedInventory
{
    public static final int cookSpeed = 300;
    public static final int INPUT_1 = 0;
    public static final int INPUT_2 = 1;
    private static final int[] slots_top    = new int[]{0};
    private static final int[] slots_bottom = new int[]{2};
    private static final int[] slots_side   = new int[]{1};
    public int cookTime;
    public boolean isActive = cookTime > 0;
    private ItemStack[] slots;
    private ItemStack outputInventory;
    private String customName;

    public TileEntitySeedInfuser()
    {
        slots = new ItemStack[3];
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        NBTTagList list = compound.getTagList("Items", 10);
        slots = new ItemStack[getSizeInventory()];

        for(int i = 0; i < list.tagCount(); i++)
        {
            NBTTagCompound compound1 = list.getCompoundTagAt(i);
            byte b0 = compound1.getByte("Slot");

            if(b0 >= 0 && b0 < slots.length)
            {
                slots[b0] = ItemStack.loadItemStackFromNBT(compound1);
            }
        }

        outputInventory = ItemStack.loadItemStackFromNBT(compound.getCompoundTag("outputInventory"));
        cookTime = compound.getShort("CookTime");
    }

    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setShort("CookTime", (short) cookTime);

        NBTTagList list = new NBTTagList();

        for(int i = 0; i < slots.length; i++)
        {
            if(slots[i] != null)
            {
                NBTTagCompound compound1 = new NBTTagCompound();
                compound1.setByte("Slot", (byte) i);
                slots[i].writeToNBT(compound);
                list.appendTag(compound1);
            }
        }

        if(outputInventory != null)
        {
            NBTTagCompound outputCompound = new NBTTagCompound();
            outputInventory.writeToNBT(outputCompound);
            compound.setTag("outputInventory", outputCompound);
        }

        compound.setTag("Items", list);
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side)
    {
        if(side == ForgeDirection.DOWN.ordinal())
        {
            return slots_bottom;
        }
        else if(side == ForgeDirection.UP.ordinal())
        {
            return slots_top;
        }
        else
        {
            return slots_side;
        }

    }

    @Override
    public boolean canInsertItem(int index, ItemStack stack, int side)
    {
        return isItemValidForSlot(index, stack);
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, int side)
    {
        return side == 3;
    }

    @Override
    public int getSizeInventory()
    {
        return slots.length;
    }

    @Override
    public ItemStack getStackInSlot(int index)
    {
        return slots[index];
    }

    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        if(slots[index] != null)
        {
            if(slots[index].stackSize <= count)
            {
                ItemStack stack = slots[index];
                slots[index] = null;
                return stack;
            }

            ItemStack stack1 = slots[index].splitStack(count);

            if(slots[index].stackSize == 0)
            {
                slots[index] = null;
            }
            return stack1;
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index)
    {
        return getStackInSlot(index);
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        slots[index] = stack;
        if(stack != null && stack.stackSize > getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }
    }

    @Override
    public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.customName : "container.seedInfuser";
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return this.customName != null && this.customName.length() > 0;
    }

    public void setCustomInventoryName(String name)
    {
        this.customName = name;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64;
    }

    @Override
    public void openInventory()
    {
//empty
    }

    @Override
    public void closeInventory()
    {
//empty
    }

    @Override
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        return index != 2;
    }

    public int getInfuseProgressScaled(int i)
    {
        return (this.cookTime * i) / cookSpeed;
    }

    public boolean isInfusing()
    {
        return this.cookTime > 0;
    }

    private boolean canInfuse()
    {
        if(slots[0] == null || slots[1] == null)
        {
            return false;
        }
        else
        {
            ItemStack stack = SeedInfuserRecipes.instance().getInfusingResult(slots[0].getItem(), slots[1].getItem());
            if(stack == null) return false;
            if(slots[2] == null) return true;
            if(!slots[2].isItemEqual(stack)) return false;
            int result = slots[2].stackSize + stack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.slots[2].getMaxStackSize();
        }
    }

    private void infuseItem()
    {
        if(canInfuse())
        {
            ItemStack stack = SeedInfuserRecipes.instance().getInfusingResult(slots[0].getItem(), slots[1].getItem());

            if(slots[2] == null)
            {
                slots[2] = stack.copy();
            }
            else if(slots[2].isItemEqual(stack))
            {
                slots[2].stackSize += stack.stackSize;
            }

            for(int i = 0; i < 2; i++)
            {
                --slots[i].stackSize;

                if(slots[i].stackSize <= 0)
                {
                    slots[i] = null;
                }
            }

        }
    }

    public void updateEntity()
    {
        boolean flag = false;
        if(!worldObj.isRemote)
        {
            if(canInfuse())
            {
                ++this.cookTime;
                if(this.cookTime == cookSpeed)
                {
                    this.cookTime = 0;
                    this.infuseItem();
                    flag = true;
                }
            }
            else
            {
                this.cookTime = 0;
            }

            if(isInfusing())
            {
                BlockSeedInfuser.updateBlockState(true, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
            else
            {
                BlockSeedInfuser.updateBlockState(false, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if(flag)
        {
            this.markDirty();
        }
    }

}

