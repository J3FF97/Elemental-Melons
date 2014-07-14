package j3ff97.elementalmelons.init;

import cpw.mods.fml.common.registry.GameRegistry;
import j3ff97.elementalmelons.items.*;
import j3ff97.elementalmelons.reference.Names;
import net.minecraft.init.Blocks;

public class ModItems
{
    public static ItemSkyMelonSlice   skyMelonSlice;
    public static ItemEarthMelonSlice earthMelonSlice;
    public static ItemWaterMelonSlice waterMelonSlice;
    public static ItemFireMelonSlice  fireMelonSlice;
    public static ItemSkyMelonSeeds   skyMelonSeeds;
    public static ItemEarthMelonSeeds earthMelonSeeds;
    public static ItemWaterMelonSeeds waterMelonSeeds;
    public static ItemFireMelonSeeds  fireMelonSeeds;
    public static ItemSkyMelonJuice   itemSkyMelonJuice;
    public static ItemEarthMelonJuice itemEarthMelonJuice;
    public static ItemWaterMelonJuice itemWaterMelonJuice;
    public static ItemFireMelonJuice  itemFireMelonJuice;
    public static ItemMelonJuice      itemMelonJuice;
    public static ItemSqueezer        itemSqueezer;
    public static ItemCrystalPurifier itemCrystalPurifier;

    public static void init()
    {
        skyMelonSlice = new ItemSkyMelonSlice(2, 0.3f, false);
        earthMelonSlice = new ItemEarthMelonSlice(2, 0.3f, false);
        waterMelonSlice = new ItemWaterMelonSlice(2, 0.3f, false);
        fireMelonSlice = new ItemFireMelonSlice(2, 0.3f, false);
        skyMelonSeeds = new ItemSkyMelonSeeds(ModBlocks.skyMelonStem, Blocks.farmland);
        earthMelonSeeds = new ItemEarthMelonSeeds(ModBlocks.earthMelonStem, Blocks.farmland);
        waterMelonSeeds = new ItemWaterMelonSeeds(ModBlocks.waterMelonStem, Blocks.farmland);
        fireMelonSeeds = new ItemFireMelonSeeds(ModBlocks.fireMelonStem, Blocks.farmland);
        itemSkyMelonJuice = new ItemSkyMelonJuice(3, 0.5f, false);
        itemEarthMelonJuice = new ItemEarthMelonJuice(3, 0.5f, false);
        itemWaterMelonJuice = new ItemWaterMelonJuice(3, 0.5f, false);
        itemFireMelonJuice = new ItemFireMelonJuice(3, 0.5f, false);
        itemMelonJuice = new ItemMelonJuice(3, 0.5f, false);
        itemSqueezer = new ItemSqueezer();
        itemCrystalPurifier = new ItemCrystalPurifier();

        GameRegistry.registerItem(skyMelonSlice, Names.skyMelonSlice_unlocalizedName);
        GameRegistry.registerItem(earthMelonSlice, Names.earthMelonSlice_unlocalizedName);
        GameRegistry.registerItem(waterMelonSlice, Names.waterMelonSlice_unlocalizedName);
        GameRegistry.registerItem(fireMelonSlice, Names.fireMelonSlice_unlocalizedName);
        GameRegistry.registerItem(skyMelonSeeds, Names.skyMelonSeeds_unlocalizedName);
        GameRegistry.registerItem(earthMelonSeeds, Names.earthMelonSeeds_unlocalizedName);
        GameRegistry.registerItem(waterMelonSeeds, Names.waterMelonSeeds_unlocalizedName);
        GameRegistry.registerItem(fireMelonSeeds, Names.fireMelonSeeds_unlocalizedName);
        GameRegistry.registerItem(itemMelonJuice, Names.itemMelonJuice_unlocalizedName);
        GameRegistry.registerItem(itemSkyMelonJuice, Names.itemSkyMelonJuice_unlocalizedName);
        GameRegistry.registerItem(itemEarthMelonJuice, Names.itemEarthMelonJuice_unlocalizedName);
        GameRegistry.registerItem(itemWaterMelonJuice, Names.itemWaterMelonJuice_unlocalizedName);
        GameRegistry.registerItem(itemFireMelonJuice, Names.itemFireMelonJuice_unlocalizedName);
        GameRegistry.registerItem(itemSqueezer, Names.itemSqueezer_unlocalizedName);
        GameRegistry.registerItem(itemCrystalPurifier, Names.itemCrystalPurifier_unlocalizedName);
    }
}
