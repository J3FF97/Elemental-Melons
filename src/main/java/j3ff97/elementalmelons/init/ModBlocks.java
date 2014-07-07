package j3ff97.elementalmelons.init;

import cpw.mods.fml.common.registry.GameRegistry;
import j3ff97.elementalmelons.blocks.*;
import j3ff97.elementalmelons.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;
import net.minecraft.block.material.Material;

public class ModBlocks
{
    public static Block     blockSkyMelon;
    public static Block     blockEarthMelon;
    public static Block     blockWaterMelon;
    public static Block     blockFireMelon;
    public static BlockStem skyMelonStem;
    public static BlockStem earthMelonStem;
    public static BlockStem waterMelonStem;
    public static BlockStem fireMelonStem;

    public static void init()
    {

        blockSkyMelon = new BlockSkyMelon(Material.gourd);
        blockEarthMelon = new BlockEarthMelon(Material.gourd);
        blockWaterMelon = new BlockWaterMelon(Material.gourd);
        blockFireMelon = new BlockFireMelon(Material.gourd);
        skyMelonStem = new SkyMelonStem(blockSkyMelon);
        earthMelonStem = new EarthMelonStem(blockEarthMelon);
        waterMelonStem = new WaterMelonStem(blockWaterMelon);
        fireMelonStem = new FireMelonStem(blockFireMelon);




        GameRegistry.registerBlock(blockSkyMelon, Names.blockSkyMelon_unlocalizedName);
        GameRegistry.registerBlock(blockEarthMelon, Names.blockEarthMelon_unlocalizedName);
        GameRegistry.registerBlock(blockWaterMelon, Names.blockWaterMelon_unlocalizedName);
        GameRegistry.registerBlock(blockFireMelon, Names.blockFireMelon_unlocalizedName);
        GameRegistry.registerBlock(skyMelonStem, Names.skyMelonStem_unlocalizedName);
        GameRegistry.registerBlock(earthMelonStem, Names.earthMelonStem_unlocalizedName);
        GameRegistry.registerBlock(waterMelonStem, Names.waterMelonStem_unlocalizedName);
        GameRegistry.registerBlock(fireMelonStem, Names.fireMelonStem_unlocalizedName);
    }
}
