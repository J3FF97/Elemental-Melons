package j3ff97.elementalmelons.api;

import cpw.mods.fml.common.Loader;
import j3ff97.elementalmelons.api.crafting.ISeedInfuserRegistry;

public class EMApi
{
    private static IEMApi instance;

    public static IEMApi getInstance()
    {
        return instance;
    }

    public static void init(IEMApi inst) {

        if (instance == null && Loader.instance().activeModContainer().getModId().equals("ElementalMelons")) {
            instance = inst;
        } else {
            throw new IllegalStateException("This method should be called from Elemental Melons only!");
        }
    }

    public static interface IEMApi
    {
        ISeedInfuserRegistry getInfuserRegistry();
    }
}
