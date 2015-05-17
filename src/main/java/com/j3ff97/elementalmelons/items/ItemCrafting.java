package com.j3ff97.elementalmelons.items;

import net.minecraft.item.ItemStack;

import java.util.Random;

public class ItemCrafting extends ItemEM
{
    public ItemCrafting(String name, int uses)
    {
        super(name);
        this.setUnlocalizedName(name);
        this.setMaxDamage(uses - 1);
        this.setContainerItem(this);
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack)
    {
        ItemStack container = stack.copy();
        container.attemptDamageItem(1, new Random());
        return container;
    }
}
