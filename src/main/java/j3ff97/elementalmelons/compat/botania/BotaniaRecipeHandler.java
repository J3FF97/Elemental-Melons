package j3ff97.elementalmelons.compat.botania;

import j3ff97.elementalmelons.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.recipe.RecipeRuneAltar;

import java.util.ArrayList;
import java.util.List;

public class BotaniaRecipeHandler
{
    public static List<RecipeRuneAltar> melonSeeds;

    public static void init()
    {
        initAltar();
    }

    public static void initAltar()
    {
        final int manaCost = 4000;

        melonSeeds = new ArrayList();

        melonSeeds.add(BotaniaAPI.registerRuneAltarRecipe(new ItemStack(ModItems.earthMelonSeeds), manaCost, Items.melon_seeds, Items.nether_wart, Items.blaze_powder));
    }
}
