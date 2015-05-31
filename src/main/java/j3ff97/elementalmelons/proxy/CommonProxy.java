package j3ff97.elementalmelons.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import j3ff97.elementalmelons.handler.BucketHandler;
import j3ff97.elementalmelons.handler.CraftingHandler;
import j3ff97.elementalmelons.init.ModBlocks;
import j3ff97.elementalmelons.init.ModFluids;
import j3ff97.elementalmelons.init.ModItems;
import j3ff97.elementalmelons.utility.LogHelper;
import j3ff97.elementalmelons.worldgen.MelonGen;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy
{
    public static void initMelons()
    {
        ModItems.initSlices();
        ModBlocks.initBlocks();
        ModBlocks.initStems();
        ModItems.initSeeds();
    }

    public void preInit(FMLPreInitializationEvent e)
    {
        initMelons();

        ModItems.init();
        LogHelper.info("Elemental Melons: Initialized Items");

        ModBlocks.init();
        LogHelper.info("Elemental Melons: Initialized Blocks");

        ModFluids.init();
        LogHelper.info("Elemental Melons: Initialized Fluids");

    }

    public void init(FMLInitializationEvent e)
    {

        CraftingHandler.initRecipes();
        LogHelper.info("Elemental Melons: Initialized Crafting");

        GameRegistry.registerWorldGenerator(new MelonGen(), 1);
        LogHelper.info("Elemental Melons: Initialized OreGen");

        ModFluids.registerBuckets();
        MinecraftForge.EVENT_BUS.register(BucketHandler.instance);
        LogHelper.info("Elemental Melons: Initialized BucketHandler");
    }

    public void postInit(FMLPostInitializationEvent e)
    {

    }

}
