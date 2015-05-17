package com.j3ff97.elementalmelons.api.recipe;

import net.minecraft.item.ItemStack;

public interface IInfuserRecipe
{
    boolean matches(ItemStack[] input);

    void useItems(ItemStack[] input);

    ItemStack getCraftingResult(ItemStack[] input);
}
