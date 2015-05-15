package com.j3ff97.elementalmelons;

import com.j3ff97.elementalmelons.handler.CraftingHandler;
import com.j3ff97.elementalmelons.init.ModBlocks;
import com.j3ff97.elementalmelons.init.ModItems;
import com.j3ff97.elementalmelons.proxy.CommonProxy;
import com.j3ff97.elementalmelons.reference.Reference;
import com.j3ff97.elementalmelons.utility.LogHelper;
import com.j3ff97.elementalmelons.worldgen.MelonGen;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

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

}
