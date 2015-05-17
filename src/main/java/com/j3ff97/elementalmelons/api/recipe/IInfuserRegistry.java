package com.j3ff97.elementalmelons.api.recipe;

import net.minecraft.item.ItemStack;

public interface IInfuserRegistry
{
    void addRecipe(IInfuserRecipe recipe);

    void addRecipe(ItemStack output, Object... input);


}
