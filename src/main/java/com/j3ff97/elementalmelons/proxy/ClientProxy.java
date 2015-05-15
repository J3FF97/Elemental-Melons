package com.j3ff97.elementalmelons.proxy;

import com.j3ff97.elementalmelons.init.ModBlocks;
import com.j3ff97.elementalmelons.init.ModItems;
import com.j3ff97.elementalmelons.utility.LogHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent e)
    {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e)
    {
        super.init(e);

        ModItems.registerItemRenderer();
        ModBlocks.registerBlockRenderer();
        LogHelper.info("Elemental Melons: Initialized Rendering");
    }

    @Override
    public void postInit(FMLPostInitializationEvent e)
    {
        super.postInit(e);
    }
}
