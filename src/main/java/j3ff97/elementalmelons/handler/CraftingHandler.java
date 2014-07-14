package j3ff97.elementalmelons.handler;

import cpw.mods.fml.common.registry.GameRegistry;
import j3ff97.elementalmelons.init.ModBlocks;
import j3ff97.elementalmelons.init.ModItems;
import net.minecraft.init.Items;
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
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemMelonJuice), new ItemStack(ModItems.itemSqueezer), new ItemStack(Items.melon), new ItemStack(Items.glass_bottle));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemSkyMelonJuice), new ItemStack(ModItems.itemCrystalPurifier), new ItemStack(ModItems.skyMelonSlice), new ItemStack(Items.glass_bottle));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemWaterMelonJuice), new ItemStack(ModItems.itemCrystalPurifier), new ItemStack(ModItems.waterMelonSlice), new ItemStack(Items.glass_bottle));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemFireMelonJuice), new ItemStack(ModItems.itemCrystalPurifier), new ItemStack(ModItems.fireMelonSlice), new ItemStack(Items.glass_bottle));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.itemEarthMelonJuice), new ItemStack(ModItems.itemCrystalPurifier), new ItemStack(ModItems.earthMelonSlice), new ItemStack(Items.glass_bottle));

    }

    public static void initSmeltingRecipes()

    {

    }

    public static void initPotionRecipes()

    {

    }
}

