package j3ff97.elementalmelons.compat.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import j3ff97.elementalmelons.init.ModBlocks;
import j3ff97.elementalmelons.reference.Reference;
import net.minecraft.item.ItemStack;

public class NEIConfig implements IConfigureNEI
{
    @Override
    public void loadConfig()
    {
        API.hideItem(new ItemStack(ModBlocks.earthMelonStem));
        API.hideItem(new ItemStack(ModBlocks.skyMelonStem));
        API.hideItem(new ItemStack(ModBlocks.fireMelonStem));
        API.hideItem(new ItemStack(ModBlocks.waterMelonStem));
        API.hideItem(new ItemStack(ModBlocks.seedInfuser_on));

        API.registerRecipeHandler(new SeedInfuserHandler());
        API.registerUsageHandler(new SeedInfuserHandler());

    }

    @Override
    public String getName()
    {
        return Reference.NAME;
    }

    @Override
    public String getVersion()
    {
        return Reference.VERSION;
    }
}
