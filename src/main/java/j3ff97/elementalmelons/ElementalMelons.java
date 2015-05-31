package j3ff97.elementalmelons;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import j3ff97.elementalmelons.proxy.CommonProxy;
import j3ff97.elementalmelons.reference.Reference;
import j3ff97.elementalmelons.utility.LogHelper;

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
    }

    @Mod.EventHandler
    public static void Init(FMLInitializationEvent event)
    {
        LogHelper.info("Elemental Melons: Starting Init");

        proxy.init(event);

        LogHelper.info("Elemental Melons: Init Complete");
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Elemental Melons: Starting PostInit");

        proxy.postInit(event);

        LogHelper.info("Elemental Melons: Successful PostInit");
        LogHelper.info("Elemental Melons: Initialization Completed, Ready to Nom!");
    }

    /**
    Todo:
     Tile Seed Infuser
     Tile Squeezer
     Block Seed Infuser
     Block Squeezer
     Container Seed Infuser
     Container Squeezer
     GUI Seed Infuser
     GUI Squeezer
     GUI Handler
     Tile entity init class
     Recipe Seed Infuser
     Recipe Squeezer
     Api
     Botania support
     TC support
     Catalysts
     Texturing
     Recipes

     */
}
