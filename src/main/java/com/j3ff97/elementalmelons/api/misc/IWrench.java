package com.j3ff97.elementalmelons.api.misc;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IWrench
{
    public boolean damage(ItemStack stack, int damage, EntityPlayer player, boolean simulated);
}
