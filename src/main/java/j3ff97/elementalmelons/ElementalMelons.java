package j3ff97.elementalmelons;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import j3ff97.elementalmelons.handler.CraftingHandler;
import j3ff97.elementalmelons.init.ModBlocks;
import j3ff97.elementalmelons.init.ModItems;
import j3ff97.elementalmelons.proxy.CommonProxy;
import j3ff97.elementalmelons.reference.Reference;
import j3ff97.elementalmelons.utility.LogHelper;
import j3ff97.elementalmelons.worldgen.MelonGen;

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VERSION)

public class ElementalMelons
{
    @Mod.Instance(Reference.ID)
    public static ElementalMelons instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        LogHelper.info("Booting up Elemental Melons!");
        LogHelper.info("Made by: " + Reference.AUTHOR);

        proxy.preInit(event);

        LogHelper.info("Elemental Melons: PreInit Complete");




        ModBlocks.init();
        ModItems.init();
    }

    @Mod.EventHandler
    public static void Init(FMLInitializationEvent event)
    {
        LogHelper.info("Elemental Melons: Starting Init");

        proxy.init(event);

        LogHelper.info("Elemental Melons: Init Complete");


        CraftingHandler.initRecipes();
        GameRegistry.registerWorldGenerator(new MelonGen(), 1);
        LogHelper.info("Elemental Melons: Successful Init");
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Elemental Melons: Starting PostInit");

        proxy.postInit(event);

        LogHelper.info("Elemental Melons: Successful PostInit");
        LogHelper.info("Elemental Melons: Initialization Completed, Ready to Nom!");

        LogHelper.info("Elemental Melons: Successful PostInit");
        LogHelper.info("Elemental Melons: Initialization Completed, Ready to Nom!");
    }

}
