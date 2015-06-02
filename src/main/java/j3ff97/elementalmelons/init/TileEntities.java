package j3ff97.elementalmelons.init;

import cpw.mods.fml.common.registry.GameRegistry;
import j3ff97.elementalmelons.reference.Names;
import j3ff97.elementalmelons.tileentity.TileEntitySeedInfuser;

public class TileEntities
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TileEntitySeedInfuser.class, Names.blockSeedInfusername);
    }
}
