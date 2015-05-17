package com.j3ff97.elementalmelons.helper;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class IOHelper
{
    public static void spawnItemInWorld(World world, ItemStack itemStack, double x, double y, double z) {

        if (world.isRemote)
            return;
        float dX = world.rand.nextFloat() * 0.8F + 0.1F;
        float dY = world.rand.nextFloat() * 0.8F + 0.1F;
        float dZ = world.rand.nextFloat() * 0.8F + 0.1F;

        EntityItem entityItem = new EntityItem(world, x + dX, y + dY, z + dZ, new ItemStack(itemStack.getItem(), itemStack.stackSize,
                itemStack.getItemDamage()));

        if (itemStack.hasTagCompound()) {
            entityItem.getEntityItem().setTagCompound((NBTTagCompound) itemStack.getTagCompound().copy());
        }

        float factor = 0.05F;
        entityItem.motionX = world.rand.nextGaussian() * factor;
        entityItem.motionY = world.rand.nextGaussian() * factor + 0.2F;
        entityItem.motionZ = world.rand.nextGaussian() * factor;
        world.spawnEntityInWorld(entityItem);
        itemStack.stackSize = 0;
    }
}
