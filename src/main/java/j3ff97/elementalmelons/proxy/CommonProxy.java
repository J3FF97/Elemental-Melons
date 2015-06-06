package j3ff97.elementalmelons.proxy;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import j3ff97.elementalmelons.ElementalMelons;
import j3ff97.elementalmelons.handler.BucketHandler;
import j3ff97.elementalmelons.handler.CraftingHandler;
import j3ff97.elementalmelons.handler.GuiHandler;
import j3ff97.elementalmelons.init.ModBlocks;
import j3ff97.elementalmelons.init.ModFluids;
import j3ff97.elementalmelons.init.ModItems;
import j3ff97.elementalmelons.init.TileEntities;
import j3ff97.elementalmelons.utility.LogHelper;
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
        LogHelper.info("EleMelons: Initialized Items");

        ModBlocks.init();
        LogHelper.info("EleMelons: Initialized Blocks");

        ModFluids.init();
        LogHelper.info("EleMelons: Initialized Fluids");

    }

    public void init(FMLInitializationEvent e)
    {
        CraftingHandler.initRecipes();
        LogHelper.info("EleMelons: Initialized Crafting");

        NetworkRegistry.INSTANCE.registerGuiHandler(ElementalMelons.instance, new GuiHandler());
        LogHelper.info("EleMelons: Initialized GuiHandler");

        TileEntities.init();
        LogHelper.info("EleMelons: Initialized TileEntities");

        ModFluids.registerBuckets();
        MinecraftForge.EVENT_BUS.register(BucketHandler.instance);
        LogHelper.info("EleMelons: Initialized BucketHandler");

        FMLInterModComms.sendMessage("Waila", "register", "com.j3ff97.elementalmelons.compat.waila.WailaDataProvider.callBackRegister");
    }

    public void postInit(FMLPostInitializationEvent e)
    {
            if(Loader.isModLoaded("Botania"))
            {
          //      BotaniaRecipeHandler.init();
            }
    }

}
