package com.j3ff97.elementalmelons.api;

import com.j3ff97.elementalmelons.api.recipe.IInfuserRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class EMApi
{
    private static IEMApi instance;

    public static IEMApi getInstance()
    {
        return instance;
    }

    public static interface IEMApi
    {
        public IInfuserRegistry getInfuserRegistry();

        public void loadSilkySettings(World world, BlockPos pos, ItemStack stack);
    }
}
