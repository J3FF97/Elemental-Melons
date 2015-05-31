package j3ff97.elementalmelons.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import j3ff97.elementalmelons.handler.CraftingHandler;
import j3ff97.elementalmelons.init.ModBlocks;
import j3ff97.elementalmelons.init.ModItems;
import j3ff97.elementalmelons.utility.LogHelper;
import j3ff97.elementalmelons.worldgen.MelonGen;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent e)
    {
        ModItems.init();

        ModBlocks.init();
        LogHelper.info("Elemental Melons: Initialized Blocks");

        ModBlocks.initStems();

        ModItems.initSeeds();
        LogHelper.info("Elemental Melons: Initialized Items");


    }

    public void init(FMLInitializationEvent e)
    {

        CraftingHandler.initRecipes();
        LogHelper.info("Elemental Melons: Initialized Crafting");

        GameRegistry.registerWorldGenerator(new MelonGen(), 1);
        LogHelper.info("Elemental Melons: Initialized OreGen");
    }

    public void postInit(FMLPostInitializationEvent e)
    {

    }

}
