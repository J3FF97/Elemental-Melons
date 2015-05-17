package com.j3ff97.elementalmelons.init;


import com.j3ff97.elementalmelons.items.ItemCrafting;
import com.j3ff97.elementalmelons.items.ItemSeedEM;
import com.j3ff97.elementalmelons.items.ItemSliceEM;
import com.j3ff97.elementalmelons.items.ItemWrench;
import com.j3ff97.elementalmelons.reference.Names;
import com.j3ff97.elementalmelons.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems
{
    public static ItemSeedEM  skyMelonSeeds;
    public static ItemSeedEM  earthMelonSeeds;
    public static ItemSeedEM  waterMelonSeeds;
    public static ItemSeedEM  fireMelonSeeds;
    public static ItemSliceEM skyMelonSlice;
    public static ItemSliceEM earthMelonSlice;
    public static ItemSliceEM waterMelonSlice;
    public static ItemSliceEM fireMelonSlice;

    public static ItemCrafting itemJuicer;
    public static ItemWrench   itemWrench;

    public static void initSlices()
    {
        skyMelonSlice = new ItemSliceEM(2, 0.3f, false, Names.skyMelonSlicename, 3, Names.Text.skySliceText);
        earthMelonSlice = new ItemSliceEM(2, 0.3f, false, Names.earthMelonSlicename, 5, Names.Text.earthSliceText);
        waterMelonSlice = new ItemSliceEM(2, 0.3f, false, Names.waterMelonSlicename, 13, Names.Text.waterSliceText);
        fireMelonSlice = new ItemSliceEM(2, 0.3f, false, Names.fireMelonSlicename, 12, Names.Text.fireSliceText);

        itemJuicer = new ItemCrafting(Names.itemSqueezername, 256);
        itemWrench = new ItemWrench(Names.itemWrenchname);

        registerItems();
    }

    public static void initSeeds()
    {
        skyMelonSeeds = new ItemSeedEM(ModBlocks.skyMelonStem, Blocks.farmland, Names.skyMelonSeedsname);
        earthMelonSeeds = new ItemSeedEM(ModBlocks.earthMelonStem, Blocks.farmland, Names.earthMelonSeedsname);
        waterMelonSeeds = new ItemSeedEM(ModBlocks.waterMelonStem, Blocks.farmland, Names.waterMelonSeedsname);
        fireMelonSeeds = new ItemSeedEM(ModBlocks.fireMelonStem, Blocks.farmland, Names.fireMelonSeedsname);

        GameRegistry.registerItem(skyMelonSeeds, Names.skyMelonSeedsname);
        GameRegistry.registerItem(earthMelonSeeds, Names.earthMelonSeedsname);
        GameRegistry.registerItem(waterMelonSeeds, Names.waterMelonSeedsname);
        GameRegistry.registerItem(fireMelonSeeds, Names.fireMelonSeedsname);
    }

    public static void registerItems()
    {
        GameRegistry.registerItem(skyMelonSlice, Names.skyMelonSlicename);
        GameRegistry.registerItem(earthMelonSlice, Names.earthMelonSlicename);
        GameRegistry.registerItem(waterMelonSlice, Names.waterMelonSlicename);
        GameRegistry.registerItem(fireMelonSlice, Names.fireMelonSlicename);

        GameRegistry.registerItem(itemJuicer, Names.itemSqueezername);
        GameRegistry.registerItem(itemWrench, Names.itemWrenchname);

    }

    public static void registerItemRenderer()
    {
        registerModel(skyMelonSlice, Names.skyMelonSlicename);
        registerModel(earthMelonSlice, Names.earthMelonSlicename);
        registerModel(waterMelonSlice, Names.waterMelonSlicename);
        registerModel(fireMelonSlice, Names.fireMelonSlicename);
        registerModel(skyMelonSeeds, Names.skyMelonSeedsname);
        registerModel(earthMelonSeeds, Names.earthMelonSeedsname);
        registerModel(waterMelonSeeds, Names.waterMelonSeedsname);
        registerModel(fireMelonSeeds, Names.fireMelonSeedsname);

        registerModel(itemJuicer, Names.itemSqueezername);
        registerModel(itemWrench, Names.itemWrenchname);
    }

    public static void registerModel(Item item, String itemName)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.ID + ":" + itemName, "inventory"));
    }
}
