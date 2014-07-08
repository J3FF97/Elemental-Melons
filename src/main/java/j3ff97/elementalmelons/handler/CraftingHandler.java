package j3ff97.elementalmelons.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import j3ff97.elementalmelons.init.ModBlocks;
import j3ff97.elementalmelons.init.ModItems;
import net.minecraft.item.ItemStack;

public class CraftingHandler
{
    public static void initRecipes()
    {
        initCraftingRecipes();
        initShapelessRecipes();
        initSmeltingRecipes();
        initPotionRecipes();
    }


    public static void initCraftingRecipes()
    {
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockSkyMelon), "XXX", "XXX", "XXX", 'X', ModItems.skyMelonSlice);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockWaterMelon), "XXX", "XXX", "XXX", 'X', ModItems.waterMelonSlice);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockEarthMelon), "XXX", "XXX", "XXX", 'X', ModItems.earthMelonSlice);
        GameRegistry.addRecipe(new ItemStack(ModBlocks.blockFireMelon), "XXX", "XXX", "XXX", 'X', ModItems.fireMelonSlice);
    }

    public static void initShapelessRecipes()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.skyMelonSeeds), new ItemStack(ModItems.skyMelonSlice));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.fireMelonSeeds), new ItemStack(ModItems.fireMelonSlice));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.waterMelonSeeds), new ItemStack(ModItems.waterMelonSlice));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.earthMelonSeeds), new ItemStack(ModItems.earthMelonSlice));
    }

    public static void initSmeltingRecipes()

    {

    }

    public static void initPotionRecipes()

    {

    }
}

