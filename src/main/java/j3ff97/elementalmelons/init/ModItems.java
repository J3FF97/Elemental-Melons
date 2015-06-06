package j3ff97.elementalmelons.init;

import cpw.mods.fml.common.registry.GameRegistry;
import j3ff97.elementalmelons.items.ItemCraftingEM;
import j3ff97.elementalmelons.items.ItemEM;
import j3ff97.elementalmelons.items.ItemFoodEM;
import j3ff97.elementalmelons.items.ItemSeedEM;
import j3ff97.elementalmelons.reference.Names;
import net.minecraft.init.Blocks;

public class ModItems
{
    public static ItemSeedEM  skyMelonSeeds;
    public static ItemSeedEM  earthMelonSeeds;
    public static ItemSeedEM  waterMelonSeeds;
    public static ItemSeedEM  fireMelonSeeds;

    public static ItemFoodEM skyMelonSlice;
    public static ItemFoodEM earthMelonSlice;
    public static ItemFoodEM waterMelonSlice;
    public static ItemFoodEM fireMelonSlice;

    public static ItemCraftingEM itemSqueezer;

    public static ItemEM itemFlask;
    public static ItemEM commonCatalyst;
    public static ItemEM skyCatalyst;
    public static ItemEM earthCatalyst;
    public static ItemEM waterCatalyst;
    public static ItemEM fireCatalyst;

    public static void init()
    {
        itemSqueezer = new ItemCraftingEM(Names.itemSqueezername, 64);

        itemFlask = new ItemEM(Names.itemFlaskname);

        commonCatalyst = new ItemEM(Names.commonCatalystName);
        skyCatalyst = new ItemEM(Names.skyCatalystName);
        earthCatalyst = new ItemEM(Names.earthCatalystName);
        waterCatalyst = new ItemEM(Names.waterCatalystName);
        fireCatalyst = new ItemEM(Names.fireCatalystName);

        registerItems();
    }

    public static void registerItems()
    {
        GameRegistry.registerItem(itemSqueezer, Names.itemSqueezername);
        GameRegistry.registerItem(itemFlask, Names.itemFlaskname);
        GameRegistry.registerItem(commonCatalyst, Names.commonCatalystName);
        GameRegistry.registerItem(skyCatalyst, Names.skyCatalystName);
        GameRegistry.registerItem(earthCatalyst, Names.earthCatalystName);
        GameRegistry.registerItem(waterCatalyst, Names.waterCatalystName);
        GameRegistry.registerItem(fireCatalyst, Names.fireCatalystName);


    }

    public static void initSlices()
    {
        skyMelonSlice = new ItemFoodEM(2, 0.3f, false, Names.skyMelonSlicename, 3, Names.Text.skySliceText);
        earthMelonSlice = new ItemFoodEM(2, 0.3f, false, Names.earthMelonSlicename, 5, Names.Text.earthSliceText);
        waterMelonSlice = new ItemFoodEM(2, 0.3f, false, Names.waterMelonSlicename, 13, Names.Text.waterSliceText);
        fireMelonSlice = new ItemFoodEM(2, 0.3f, false, Names.fireMelonSlicename, 12, Names.Text.fireSliceText);


        GameRegistry.registerItem(skyMelonSlice, Names.skyMelonSlicename);
        GameRegistry.registerItem(earthMelonSlice, Names.earthMelonSlicename);
        GameRegistry.registerItem(waterMelonSlice, Names.waterMelonSlicename);
        GameRegistry.registerItem(fireMelonSlice, Names.fireMelonSlicename);
    }
    public static void initSeeds()
    {
        skyMelonSeeds = new ItemSeedEM(ModBlocks.skyMelonStem, Blocks.farmland, Names.skyMelonSeedsname);
        earthMelonSeeds = new ItemSeedEM(ModBlocks.earthMelonStem, Blocks.farmland,  Names.earthMelonSeedsname);
        waterMelonSeeds = new ItemSeedEM(ModBlocks.waterMelonStem, Blocks.farmland, Names.waterMelonSeedsname);
        fireMelonSeeds = new ItemSeedEM(ModBlocks.fireMelonStem, Blocks.farmland, Names.fireMelonSeedsname);

        GameRegistry.registerItem(skyMelonSeeds, Names.skyMelonSeedsname);
        GameRegistry.registerItem(earthMelonSeeds, Names.earthMelonSeedsname);
        GameRegistry.registerItem(waterMelonSeeds, Names.waterMelonSeedsname);
        GameRegistry.registerItem(fireMelonSeeds, Names.fireMelonSeedsname);
    }
}
