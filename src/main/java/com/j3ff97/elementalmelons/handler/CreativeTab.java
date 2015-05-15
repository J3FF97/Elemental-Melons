package com.j3ff97.elementalmelons.handler;

import com.j3ff97.elementalmelons.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTab
{
    public static CreativeTabs tabElementalMelons = new CreativeTabs("tabElementalMelons")
    {
        public ItemStack getIconItemStack()
        {
            return new ItemStack(ModItems.skyMelonSlice);
        }

        @Override
        public Item getTabIconItem()
        {

            return ModItems.skyMelonSlice;
        }
    };
}
