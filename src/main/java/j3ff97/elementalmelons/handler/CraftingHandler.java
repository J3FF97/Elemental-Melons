package j3ff97.elementalmelons.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import j3ff97.elementalmelons.api.EMApi;
import j3ff97.elementalmelons.api.crafting.ISeedInfuserRegistry;
import j3ff97.elementalmelons.crafting.SeedInfuserRecipes;
import j3ff97.elementalmelons.init.ModBlocks;
import j3ff97.elementalmelons.init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CraftingHandler
{
    public static void initRecipes()
    {
        initCraftingRecipes();
        initShapelessRecipes();
        initInfusingRecipes();
        initSmeltingRecipes();
        initPotionRecipes();

    }


    public static void initCraftingRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSkyMelon,1), "XXX", "XXX", "XXX", 'X', ModItems.skyMelonSlice);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWaterMelon,1), "XXX", "XXX", "XXX", 'X', ModItems.waterMelonSlice);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockEarthMelon,1), "XXX", "XXX", "XXX", 'X', ModItems.earthMelonSlice);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockFireMelon,1), "XXX", "XXX", "XXX", 'X', ModItems.fireMelonSlice);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.infusedStone, 8), "XXX", "XYX", "XXX", 'X', Blocks.stone, 'Y', ModItems.commonCatalyst);
        GameRegistry.addRecipe(new ItemStack(ModItems.itemSqueezer,1), "XYX", " X ", 'X', Blocks.stone, 'Y', Blocks.stone_button);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.seedInfuser,1), "YZY", "YXY", "YYY", 'X', ModItems.commonCatalyst, 'Y', ModBlocks.infusedStone, 'Z', ModItems.itemSqueezer);
    }

    public static void initShapelessRecipes()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.commonCatalyst, 2), Items.nether_wart, Items.glowstone_dust, Items.speckled_melon);
    }

    public static void initInfusingRecipes()
    {

        //Seeds
        SeedInfuserRecipes.addInfusing(Items.melon_seeds, ModItems.earthCatalyst, new ItemStack(ModItems.earthMelonSeeds));
        SeedInfuserRecipes.addInfusing(ModItems.earthCatalyst ,Items.melon_seeds, new ItemStack(ModItems.earthMelonSeeds));

        SeedInfuserRecipes.addInfusing(Items.melon_seeds, ModItems.fireCatalyst, new ItemStack(ModItems.fireMelonSeeds));
        SeedInfuserRecipes.addInfusing(ModItems.fireCatalyst ,Items.melon_seeds, new ItemStack(ModItems.fireMelonSeeds));

        SeedInfuserRecipes.addInfusing(Items.melon_seeds, ModItems.skyCatalyst, new ItemStack(ModItems.skyMelonSeeds));
        SeedInfuserRecipes.addInfusing(ModItems.skyCatalyst, Items.melon_seeds, new ItemStack(ModItems.skyMelonSeeds));

        SeedInfuserRecipes.addInfusing(Items.melon_seeds, ModItems.waterCatalyst, new ItemStack(ModItems.waterMelonSeeds));
        SeedInfuserRecipes.addInfusing(ModItems.waterCatalyst, Items.melon_seeds, new ItemStack(ModItems.waterMelonSeeds));

        //Catalysts
        SeedInfuserRecipes.addInfusing(Items.nether_wart, Items.magma_cream, new ItemStack(ModItems.fireCatalyst));
        SeedInfuserRecipes.addInfusing(Items.magma_cream, Items.nether_wart, new ItemStack(ModItems.fireCatalyst));

        SeedInfuserRecipes.addInfusing(Items.nether_wart, Items.sugar, new ItemStack(ModItems.skyCatalyst));
        SeedInfuserRecipes.addInfusing(Items.sugar, Items.nether_wart, new ItemStack(ModItems.skyCatalyst));

        SeedInfuserRecipes.addInfusing(Items.nether_wart, new ItemStack(Items.fish, 1, 3).getItem(), new ItemStack(ModItems.waterCatalyst));
        SeedInfuserRecipes.addInfusing(new ItemStack(Items.fish, 1, 3).getItem(), Items.nether_wart, new ItemStack(ModItems.waterCatalyst));

        SeedInfuserRecipes.addInfusing(Items.nether_wart, Items.blaze_powder, new ItemStack(ModItems.earthCatalyst));
        SeedInfuserRecipes.addInfusing(Items.blaze_powder, Items.nether_wart, new ItemStack(ModItems.earthCatalyst));

        //Slices
        SeedInfuserRecipes.addInfusing(ModItems.skyMelonSlice, ModItems.commonCatalyst, new ItemStack(ModItems.skyMelonSeeds));
        SeedInfuserRecipes.addInfusing(ModItems.commonCatalyst, ModItems.skyMelonSlice, new ItemStack(ModItems.skyMelonSeeds));

        SeedInfuserRecipes.addInfusing(ModItems.earthMelonSlice, ModItems.commonCatalyst, new ItemStack(ModItems.earthMelonSeeds));
        SeedInfuserRecipes.addInfusing(ModItems.commonCatalyst, ModItems.earthMelonSlice, new ItemStack(ModItems.earthMelonSeeds));

        SeedInfuserRecipes.addInfusing(ModItems.fireMelonSlice, ModItems.commonCatalyst, new ItemStack(ModItems.fireMelonSeeds));
        SeedInfuserRecipes.addInfusing(ModItems.commonCatalyst, ModItems.fireMelonSlice, new ItemStack(ModItems.fireMelonSeeds));

        SeedInfuserRecipes.addInfusing(ModItems.waterMelonSlice, ModItems.commonCatalyst, new ItemStack(ModItems.waterMelonSeeds));
        SeedInfuserRecipes.addInfusing(ModItems.commonCatalyst, ModItems.waterMelonSlice, new ItemStack(ModItems.waterMelonSeeds));


        //This is just for the NEI Handler until I can get everything to behave and work T.T
        ISeedInfuserRegistry si = EMApi.getInstance().getInfuserRegistry();

        si.addRecipe(new ItemStack(ModItems.fireMelonSeeds), Items.melon_seeds, ModItems.fireCatalyst);
        si.addRecipe(new ItemStack(ModItems.fireMelonSeeds), ModItems.commonCatalyst, ModItems.fireMelonSlice);
        si.addRecipe(new ItemStack(ModItems.earthMelonSeeds), Items.melon_seeds, ModItems.earthCatalyst);
        si.addRecipe(new ItemStack(ModItems.earthMelonSeeds), ModItems.commonCatalyst, ModItems.earthMelonSlice);
        si.addRecipe(new ItemStack(ModItems.waterMelonSeeds), Items.melon_seeds, ModItems.waterCatalyst);
        si.addRecipe(new ItemStack(ModItems.waterMelonSeeds), ModItems.commonCatalyst, ModItems.waterMelonSlice);
        si.addRecipe(new ItemStack(ModItems.skyMelonSeeds), Items.melon_seeds, ModItems.skyCatalyst);
        si.addRecipe(new ItemStack(ModItems.skyMelonSeeds), ModItems.commonCatalyst, ModItems.skyMelonSlice);
        si.addRecipe(new ItemStack(ModItems.fireCatalyst), Items.nether_wart, Items.magma_cream);
        si.addRecipe(new ItemStack(ModItems.waterCatalyst), Items.nether_wart, new ItemStack(Items.fish, 1, 3).getItem());
        si.addRecipe(new ItemStack(ModItems.earthCatalyst), Items.nether_wart, Items.blaze_powder);
        si.addRecipe(new ItemStack(ModItems.skyCatalyst), Items.nether_wart, Items.sugar);

    }

    public static void initSmeltingRecipes()
    {

    }

    public static void initPotionRecipes()
    {

    }
}

