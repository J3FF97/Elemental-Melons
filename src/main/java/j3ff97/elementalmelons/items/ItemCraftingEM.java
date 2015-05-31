package j3ff97.elementalmelons.items;

import net.minecraft.item.ItemStack;

import java.util.Random;

public class ItemCraftingEM extends ItemEM
{

    public ItemCraftingEM(String name, int uses)
    {
        super(name);
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
