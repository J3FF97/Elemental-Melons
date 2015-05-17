package com.j3ff97.elementalmelons.tile;

import net.minecraft.util.EnumFacing;

public interface IRotatable
{
     void setFacingDirection(EnumFacing face);

     EnumFacing getFacingDirection();
}
