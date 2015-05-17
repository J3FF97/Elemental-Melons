package com.j3ff97.elementalmelons.items;

import com.j3ff97.elementalmelons.handler.CreativeTab;
import com.j3ff97.elementalmelons.reference.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemEM extends Item
{
    public ItemEM(String name)
    {
        super();
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return String.format("item.%s%s", Reference.ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }


    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}