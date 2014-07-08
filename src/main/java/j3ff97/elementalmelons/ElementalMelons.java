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
import j3ff97.elementalmelons.proxy.IProxy;
import j3ff97.elementalmelons.reference.Reference;
import j3ff97.elementalmelons.utility.LogHelper;
import j3ff97.elementalmelons.worldgen.ElementalMelonWorldGen;
import j3ff97.elementalmelons.worldgen.SeedDrops;

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VERSION)

public class ElementalMelons
{
    @Mod.Instance
    public static ElementalMelons instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
    public static IProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event)
    {
        ModBlocks.init();
        ModItems.init();
        SeedDrops.init();


        LogHelper.info("Elemental Melons: Successful PreInit");
    }

    @Mod.EventHandler
    public static void Init(FMLInitializationEvent event)
    {

        CraftingHandler.initRecipes();
        LogHelper.info("Elemental Melons: Successful Init");
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {

        LogHelper.info("Elemental Melons: Successful PostInit");
        LogHelper.info("Elemental Melons: Initialization Completed, Ready to Nom!");
    }

}
