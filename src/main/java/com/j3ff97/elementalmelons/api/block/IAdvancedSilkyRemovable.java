package com.j3ff97.elementalmelons.api.block;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public interface IAdvancedSilkyRemovable extends ISilkyRemovable
{
    public boolean preSilkyRemoval(World world, BlockPos pos);

    public void postSilkyRemoval(World world, BlockPos pos);

    public boolean writeSilkyData(World world, BlockPos pos, NBTTagCompound tag);

    public void readSilkyData(World world, BlockPos pos, NBTTagCompound tag);
}
