package j3ff97.elementalmelons.inventory;

import j3ff97.elementalmelons.inventory.slot.SlotMachineInput;
import j3ff97.elementalmelons.inventory.slot.SlotMachineOutput;
import j3ff97.elementalmelons.tileentity.TileEntitySeedInfuser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerSeedInfuser extends ContainerEM
{
    private TileEntitySeedInfuser infuser;

    private int cookTime;

    public ContainerSeedInfuser(InventoryPlayer player, TileEntitySeedInfuser tile)
    {
        cookTime = 0;

        this.infuser = tile;

        this.addSlotToContainer(new SlotMachineInput(tile,0, 54, 24));
        this.addSlotToContainer(new SlotMachineInput(tile,1, 54, 46));
        this.addSlotToContainer(new SlotMachineOutput(tile, 2, 116, 35));

        bindPlayerInventory(player);
    }

    public void addCraftingToCrafters(ICrafting crafting)
    {
        super.addCraftingToCrafters(crafting);
        crafting.sendProgressBarUpdate(this, 0, infuser.cookTime);
    }

    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for(int i = 0; i < this.crafters.size(); i++)
        {
            ICrafting crafting = (ICrafting) this.crafters.get(i);

            if(this.cookTime != infuser.cookTime)
            {
                crafting.sendProgressBarUpdate(this, 0 , infuser.cookTime);
            }
        }

        this.cookTime = infuser.cookTime;
    }

    public void updateProgressBar(int id, int data)
    {
        if(id == 0)
        {
            infuser.cookTime = data;
        }
    }

    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if(slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if(index == 2)
            {
                if(!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if(index != 1 && index != 0)
            {
                if(FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
                {
                    if(!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if(TileEntityFurnace.isItemFuel(itemstack1))
                {
                    if(!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if(index >= 3 && index < 30)
                {
                    if(!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if(index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if(!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if(itemstack1.stackSize == 0)
            {
                slot.putStack(null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if(itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemstack1);
        }

        return itemstack;
    }
}

