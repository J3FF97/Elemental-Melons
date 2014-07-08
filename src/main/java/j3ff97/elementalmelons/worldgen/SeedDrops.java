package j3ff97.elementalmelons.worldgen;

import j3ff97.elementalmelons.init.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class SeedDrops
{
    public static void init()
    {
        MinecraftForge.addGrassSeed(new ItemStack(ModItems.earthMelonSeeds), 3);
        MinecraftForge.addGrassSeed(new ItemStack(ModItems.fireMelonSeeds), 3);
        MinecraftForge.addGrassSeed(new ItemStack(ModItems.skyMelonSeeds), 3);
        MinecraftForge.addGrassSeed(new ItemStack(ModItems.waterMelonSeeds), 3);
    }
}
