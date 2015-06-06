package j3ff97.elementalmelons.api.crafting;

import net.minecraft.item.ItemStack;

public interface ISeedInfuserRecipe
{
    boolean matches(ItemStack[] input);

    void useItems(ItemStack[] input);

    ItemStack getCraftingResult(ItemStack[] input);
}
