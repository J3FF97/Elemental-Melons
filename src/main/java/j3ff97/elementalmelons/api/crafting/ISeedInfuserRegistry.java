package j3ff97.elementalmelons.api.crafting;

import net.minecraft.item.ItemStack;

public interface ISeedInfuserRegistry
{
    void addRecipe(ISeedInfuserRecipe recipe);

    void addRecipe(ItemStack output, Object... input);
}
