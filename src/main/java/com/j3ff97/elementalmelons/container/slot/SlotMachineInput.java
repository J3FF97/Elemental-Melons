package com.j3ff97.elementalmelons.container.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotMachineInput extends Slot
{
    IInventory inventory;

    public SlotMachineInput(IInventory _inventory, int slotNum, int x, int y)
    {
        super(_inventory, slotNum, x, y);
        inventory = _inventory;
    }

    @Override
    public boolean isItemValid(ItemStack stack)
    {
        return inventory.isItemValidForSlot(this.getSlotIndex(), stack);
    }
}
