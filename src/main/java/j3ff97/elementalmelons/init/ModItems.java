package j3ff97.elementalmelons.init;

import cpw.mods.fml.common.registry.GameRegistry;
import j3ff97.elementalmelons.items.*;
import j3ff97.elementalmelons.reference.Names;

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

    public static void init()
    {
        skyMelonSlice = new ItemSkyMelonSlice();
        earthMelonSlice = new ItemEarthMelonSlice();
        waterMelonSlice = new ItemWaterMelonSlice();
        fireMelonSlice = new ItemFireMelonSlice();
        skyMelonSeeds = new ItemSkyMelonSeeds();
        earthMelonSeeds = new ItemEarthMelonSeeds();
        waterMelonSeeds = new ItemWaterMelonSeeds();
        fireMelonSeeds = new ItemFireMelonSeeds();

        GameRegistry.registerItem(skyMelonSlice   , Names.skyMelonSlice_unlocalizedName);
        GameRegistry.registerItem(earthMelonSlice , Names.earthMelonSlice_unlocalizedName);
        GameRegistry.registerItem(waterMelonSlice , Names.waterMelonSlice_unlocalizedName);
        GameRegistry.registerItem(fireMelonSlice  , Names.fireMelonSlice_unlocalizedName);
        GameRegistry.registerItem(skyMelonSeeds   , Names.skyMelonSeeds_unlocalizedName);
        GameRegistry.registerItem(earthMelonSeeds , Names.earthMelonSeeds_unlocalizedName);
        GameRegistry.registerItem(waterMelonSeeds , Names.waterMelonSeeds_unlocalizedName);
        GameRegistry.registerItem(fireMelonSeeds  , Names.fireMelonSeeds_unlocalizedName);
    }
}
