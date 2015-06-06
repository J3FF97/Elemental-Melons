package j3ff97.elementalmelons;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import j3ff97.elementalmelons.api.EMApi;
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
        LogHelper.info("Booting up EleMelons!");
        LogHelper.info("Made by: " + Reference.AUTHOR);

        EMApi.init(new ElemelonsAPI());

        proxy.preInit(event);

        LogHelper.info("EleMelons: PreInit Complete");
    }

    @Mod.EventHandler
    public static void Init(FMLInitializationEvent event)
    {
        LogHelper.info("EleMelons: Starting Init");

        proxy.init(event);

        LogHelper.info("EleMelons: Init Complete");
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("EleMelons: Starting PostInit");

        proxy.postInit(event);

        LogHelper.info("EleMelons: Successful PostInit");
        LogHelper.info("EleMelons: Initialization Completed, Ready to Nom!");
    }

    /**
    Todo:
     Tile Squeezer
     Block Squeezer
     Container Squeezer
     GUI Seed Infuser
     GUI Squeezer
     Recipe Squeezer
     Api
     Botania support
     TC support
     Texturing
     Recipes

     */
}
