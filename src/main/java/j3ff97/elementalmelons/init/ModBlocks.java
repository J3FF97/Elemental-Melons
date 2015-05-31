package j3ff97.elementalmelons.init;

import cpw.mods.fml.common.registry.GameRegistry;
import j3ff97.elementalmelons.blocks.*;
import j3ff97.elementalmelons.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;
import net.minecraft.block.material.Material;

public class ModBlocks
{
    public static BlockMelonEM     blockSkyMelon;
    public static BlockMelonEM     blockEarthMelon;
    public static BlockMelonEM     blockWaterMelon;
    public static BlockMelonEM     blockFireMelon;
    public static BlockStemEM skyMelonStem;
    public static BlockStemEM earthMelonStem;
    public static BlockStemEM waterMelonStem;
    public static BlockStemEM fireMelonStem;

    public static void init()
    {

        blockSkyMelon = new BlockMelonEM(Names.blockSkyMelonname, Material.gourd, 1F, 5F, BlockMelonEM.soundTypeWood, ModItems.skyMelonSlice, 0.5F);
        blockEarthMelon = new BlockMelonEM(Names.blockEarthMelonname, Material.gourd, 1F, 5F, BlockMelonEM.soundTypeWood, ModItems.earthMelonSlice, 0.5F);
        blockWaterMelon = new BlockMelonEM(Names.blockWaterMelonname, Material.gourd, 1F, 5F, BlockMelonEM.soundTypeWood, ModItems.waterMelonSlice, 0.5F);
        blockFireMelon = new BlockMelonEM(Names.blockFireMelonname, Material.gourd, 1F, 5F, BlockMelonEM.soundTypeWood, ModItems.fireMelonSlice, 0.5F );

        GameRegistry.registerBlock(blockSkyMelon, Names.blockSkyMelonname);
        GameRegistry.registerBlock(blockEarthMelon, Names.blockEarthMelonname);
        GameRegistry.registerBlock(blockWaterMelon, Names.blockWaterMelonname);
        GameRegistry.registerBlock(blockFireMelon, Names.blockFireMelonname);

    }

    public static void initStems()
    {
        skyMelonStem = new BlockStemEM(blockSkyMelon, Names.skyMelonStemname);
        earthMelonStem = new BlockStemEM(blockEarthMelon, Names.earthMelonStemname);
        waterMelonStem = new BlockStemEM(blockWaterMelon, Names.waterMelonStemname);
        fireMelonStem = new BlockStemEM(blockFireMelon, Names.fireMelonStemname);

        GameRegistry.registerBlock(skyMelonStem, Names.skyMelonStemname);
        GameRegistry.registerBlock(earthMelonStem, Names.earthMelonStemname);
        GameRegistry.registerBlock(waterMelonStem, Names.waterMelonStemname);
        GameRegistry.registerBlock(fireMelonStem, Names.fireMelonStemname);


    }
}
