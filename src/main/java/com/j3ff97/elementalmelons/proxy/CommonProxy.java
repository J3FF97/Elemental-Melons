package com.j3ff97.elementalmelons.proxy;

import com.j3ff97.elementalmelons.ElementalMelons;
import com.j3ff97.elementalmelons.gui.GuiHandler;
import com.j3ff97.elementalmelons.handler.CraftingHandler;
import com.j3ff97.elementalmelons.init.ModBlocks;
import com.j3ff97.elementalmelons.init.ModItems;
import com.j3ff97.elementalmelons.init.TileEntity;
import com.j3ff97.elementalmelons.utility.LogHelper;
import com.j3ff97.elementalmelons.worldgen.MelonGen;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent e)
    {
        ModItems.initSlices();

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

        TileEntity.init();
        LogHelper.info("Elemental Melons: Initialized TileEntities");

        NetworkRegistry.INSTANCE.registerGuiHandler(ElementalMelons.instance, new GuiHandler());

    }

    public void postInit(FMLPostInitializationEvent e)
    {

    }

    public boolean isSneakingInGui() {

        return false;
    }
}
