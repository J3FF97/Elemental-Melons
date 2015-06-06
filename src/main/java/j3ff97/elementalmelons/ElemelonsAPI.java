package j3ff97.elementalmelons;

import j3ff97.elementalmelons.api.EMApi.IEMApi;
import j3ff97.elementalmelons.api.crafting.ISeedInfuserRegistry;
import j3ff97.elementalmelons.crafting.SeedInfuserRegistry;

public class ElemelonsAPI implements IEMApi
{

    @Override
    public ISeedInfuserRegistry getInfuserRegistry()
    {
        return SeedInfuserRegistry.getInstance();
    }
}
