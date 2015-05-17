package com.j3ff97.elementalmelons.init;

import com.j3ff97.elementalmelons.reference.Names;
import com.j3ff97.elementalmelons.tile.TileSeedInfuser;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntity
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TileSeedInfuser.class, Names.blockSeedInfusername);
    }
}
