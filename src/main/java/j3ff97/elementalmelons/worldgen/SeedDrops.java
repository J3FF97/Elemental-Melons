package j3ff97.elementalmelons.worldgen;

import j3ff97.elementalmelons.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class SeedDrops
{
    public static void init()
    {
        MinecraftForge.addGrassSeed(new ItemStack(ModItems.earthMelonSeeds), 1);
        MinecraftForge.addGrassSeed(new ItemStack(ModItems.fireMelonSeeds), 1);
        MinecraftForge.addGrassSeed(new ItemStack(ModItems.skyMelonSeeds), 1);
        MinecraftForge.addGrassSeed(new ItemStack(ModItems.waterMelonSeeds), 1);
    }
}
