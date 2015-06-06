package j3ff97.elementalmelons.init;

import cpw.mods.fml.common.registry.GameRegistry;
import j3ff97.elementalmelons.blocks.*;
import j3ff97.elementalmelons.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

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

    public static BlockContainerEM seedInfuser;
    public static BlockContainerEM seedInfuser_on;

    public static BlockEM infusedStone;


    public static void init()
    {
        seedInfuser = new BlockSeedInfuser(false,Names.blockSeedInfusername, Material.rock, 3F, 30F, Block.soundTypeStone, "pickaxe", 1);
        seedInfuser_on = new BlockSeedInfuser(true, Names.blockSeedInfusername, Material.rock, 3F, 30F, Block.soundTypeStone, "pickaxe", 1);
        infusedStone = new BlockEM(Material.rock, Names.infusedStonename, Block.soundTypeStone, 1.5F, 30F, "pickaxe", 1);

        registerBlocks();
    }

    public static void registerBlocks()
    {
        GameRegistry.registerBlock(seedInfuser, Names.blockSeedInfusername);
        GameRegistry.registerBlock(seedInfuser_on, Names.blockSeedInfusername + "_on");
        GameRegistry.registerBlock(infusedStone, Names.infusedStonename);
    }

    public static void initBlocks()
    {
        blockSkyMelon = new BlockMelonEM(Names.blockSkyMelonname, ModItems.skyMelonSlice);
        GameRegistry.registerBlock(blockSkyMelon, Names.blockSkyMelonname);

        blockEarthMelon = new BlockMelonEM(Names.blockEarthMelonname,ModItems.earthMelonSlice);
        GameRegistry.registerBlock(blockEarthMelon, Names.blockEarthMelonname);

        blockWaterMelon = new BlockMelonEM(Names.blockWaterMelonname, ModItems.waterMelonSlice);
        GameRegistry.registerBlock(blockWaterMelon, Names.blockWaterMelonname);

        blockFireMelon = new BlockMelonEM(Names.blockFireMelonname, ModItems.fireMelonSlice);
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
