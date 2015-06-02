package j3ff97.elementalmelons.init;

import cpw.mods.fml.common.registry.GameRegistry;
import j3ff97.elementalmelons.blocks.BlockContainerEM;
import j3ff97.elementalmelons.blocks.BlockMelonEM;
import j3ff97.elementalmelons.blocks.BlockSeedInfuser;
import j3ff97.elementalmelons.blocks.BlockStemEM;
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


    public static void init()
    {
        seedInfuser = new BlockSeedInfuser(false,Names.blockSeedInfusername, Material.rock, 3F, 15F, Block.soundTypeStone, "pickaxe", 1);
        seedInfuser_on = new BlockSeedInfuser(true, Names.blockSeedInfusername, Material.rock, 3F, 15F, Block.soundTypeStone, "pickaxe", 1);

        registerBlocks();
    }

    public static void registerBlocks()
    {
        GameRegistry.registerBlock(seedInfuser, Names.blockSeedInfusername);
        GameRegistry.registerBlock(seedInfuser_on, Names.blockSeedInfusername + "_on");
    }

    public static void initBlocks()
    {
        blockSkyMelon = new BlockMelonEM(Names.blockSkyMelonname, ModItems.skyMelonSlice);
        blockEarthMelon = new BlockMelonEM(Names.blockEarthMelonname,ModItems.earthMelonSlice);
        blockWaterMelon = new BlockMelonEM(Names.blockWaterMelonname, ModItems.waterMelonSlice);
        blockFireMelon = new BlockMelonEM(Names.blockFireMelonname, ModItems.fireMelonSlice);

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
