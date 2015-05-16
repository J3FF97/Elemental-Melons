package com.j3ff97.elementalmelons.init;

import com.j3ff97.elementalmelons.blocks.BlockEM;
import com.j3ff97.elementalmelons.blocks.BlockStemEM;
import com.j3ff97.elementalmelons.reference.Names;
import com.j3ff97.elementalmelons.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks
{
    public static BlockEM     blockSkyMelon;
    public static BlockEM     blockEarthMelon;
    public static BlockEM     blockWaterMelon;
    public static BlockEM     blockFireMelon;
    public static BlockStemEM skyMelonStem;
    public static BlockStemEM earthMelonStem;
    public static BlockStemEM waterMelonStem;
    public static BlockStemEM fireMelonStem;

    public static void init()
    {

        blockSkyMelon = new BlockEM(Names.blockSkyMelonname, Material.gourd, 1F, 5F, BlockEM.soundTypeWood, ModItems.skyMelonSlice, 0.5F );
        blockEarthMelon = new BlockEM(Names.blockEarthMelonname, Material.gourd, 1F, 5F, BlockEM.soundTypeWood, ModItems.earthMelonSlice, 0.5F );
        blockWaterMelon = new BlockEM(Names.blockWaterMelonname, Material.gourd, 1F, 5F, BlockEM.soundTypeWood, ModItems.waterMelonSlice, 0.5F );
        blockFireMelon = new BlockEM(Names.blockFireMelonname, Material.gourd, 1F, 5F, BlockEM.soundTypeWood, ModItems.fireMelonSlice, 0.5F );



        registerBlocks();
    }

    public static void initStems()
    {
        skyMelonStem = new BlockStemEM(blockSkyMelon, Names.skyMelonStemname);
        earthMelonStem = new BlockStemEM(blockEarthMelon, Names.earthMelonStemname);
        waterMelonStem = new BlockStemEM(blockWaterMelon,Names.waterMelonStemname);
        fireMelonStem = new BlockStemEM(blockFireMelon, Names.fireMelonStemname);

        GameRegistry.registerBlock(skyMelonStem, Names.skyMelonStemname);
        GameRegistry.registerBlock(earthMelonStem, Names.earthMelonStemname);
        GameRegistry.registerBlock(waterMelonStem, Names.waterMelonStemname);
        GameRegistry.registerBlock(fireMelonStem, Names.fireMelonStemname);
    }
    public static void registerBlocks()
    {
        GameRegistry.registerBlock(blockSkyMelon, Names.blockSkyMelonname);
        GameRegistry.registerBlock(blockEarthMelon, Names.blockEarthMelonname);
        GameRegistry.registerBlock(blockWaterMelon, Names.blockWaterMelonname);
        GameRegistry.registerBlock(blockFireMelon, Names.blockFireMelonname);

    }

    public static void registerBlockRenderer()
    {
        registerModel(blockSkyMelon, Names.blockSkyMelonname);
        registerModel(blockEarthMelon, Names.blockEarthMelonname);
        registerModel(blockWaterMelon, Names.blockWaterMelonname);
        registerModel(blockFireMelon, Names.blockFireMelonname);

        registerModel(skyMelonStem, Names.skyMelonStemname);
        registerModel(earthMelonStem, Names.earthMelonStemname);
        registerModel(waterMelonStem, Names.waterMelonStemname);
        registerModel(fireMelonStem, Names.fireMelonStemname);
    }

    public static void registerModel(Block block, String blockName)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.ID + ":" + blockName, "inventory"));
    }
}
