package com.j3ff97.elementalmelons.init;

import com.j3ff97.elementalmelons.blocks.BlockEM;
import com.j3ff97.elementalmelons.blocks.BlockMelonEM;
import com.j3ff97.elementalmelons.blocks.BlockSeedInfuser;
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
    public static BlockMelonEM blockSkyMelon;
    public static BlockMelonEM blockEarthMelon;
    public static BlockMelonEM blockWaterMelon;
    public static BlockMelonEM blockFireMelon;
    public static BlockStemEM  skyMelonStem;
    public static BlockStemEM  earthMelonStem;
    public static BlockStemEM  waterMelonStem;
    public static BlockStemEM  fireMelonStem;

    public static BlockSeedInfuser blockSeedInfuser;

    public static void init()
    {

        blockSkyMelon = new BlockMelonEM(Names.blockSkyMelonname, Material.gourd, 1F, 5F, BlockMelonEM.soundTypeWood, ModItems.skyMelonSlice, 0.5F);
        blockEarthMelon = new BlockMelonEM(Names.blockEarthMelonname, Material.gourd, 1F, 5F, BlockMelonEM.soundTypeWood, ModItems.earthMelonSlice, 0.5F);
        blockWaterMelon = new BlockMelonEM(Names.blockWaterMelonname, Material.gourd, 1F, 5F, BlockMelonEM.soundTypeWood, ModItems.waterMelonSlice, 0.5F);
        blockFireMelon = new BlockMelonEM(Names.blockFireMelonname, Material.gourd, 1F, 5F, BlockMelonEM.soundTypeWood, ModItems.fireMelonSlice, 0.5F );

        blockSeedInfuser = new BlockSeedInfuser(Material.rock,Names.blockSeedInfusername, BlockEM.soundTypeStone, 3F, 15F);

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

        GameRegistry.registerBlock(blockSeedInfuser, Names.blockSeedInfusername);

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

        registerModel(blockSeedInfuser, Names.blockSeedInfusername);
    }

    public static void registerModel(Block block, String blockName)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
                .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.ID + ":" + blockName, "inventory"));
    }
}
