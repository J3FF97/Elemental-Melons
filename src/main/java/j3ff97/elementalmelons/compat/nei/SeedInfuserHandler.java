package j3ff97.elementalmelons.compat.nei;

import codechicken.nei.NEIClientUtils;
import codechicken.nei.PositionedStack;
import codechicken.nei.recipe.FurnaceRecipeHandler;
import j3ff97.elementalmelons.api.crafting.ISeedInfuserRecipe;
import j3ff97.elementalmelons.client.gui.inventory.GuiSeedInfuser;
import j3ff97.elementalmelons.crafting.SeedInfuserRegistry;
import j3ff97.elementalmelons.crafting.SeedInfuserRegistry.StandardInfuserRecipe;
import j3ff97.elementalmelons.reference.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;

import java.awt.*;
import java.util.Arrays;
import java.util.List;


public class SeedInfuserHandler extends FurnaceRecipeHandler
{
    @Override
    public String getRecipeName()
    {
        return "Seed Infuser";
    }

    @Override
    public String getGuiTexture()
    {
        return Reference.ID.toLowerCase() + ":textures/gui/guiSeedInfuser.png";

    }

    @Override
    public Class<? extends GuiContainer> getGuiClass()
    {
        return GuiSeedInfuser.class;
    }

    @Override
    public void loadTransferRects()
    {
        transferRects.add(new RecipeTransferRect(new Rectangle(80, 24, 22, 14), getRecipesID()));
    }

    @Override
    public void drawExtras(int recipe)
    {
        drawProgressBar(80, 18, 177, 0, 15, 50, 48, 0);
    }



    @Override
    public void loadCraftingRecipes(String outputId, Object... results)
    {
        if(outputId.equals(getRecipesID()))
        {
            for(ISeedInfuserRecipe recipe : SeedInfuserRegistry.getInstance().getAllRecipes())
            {
                if(recipe instanceof SeedInfuserRegistry.StandardInfuserRecipe)
                {
                    arecipes.add(new InfuserRecipe((SeedInfuserRegistry.StandardInfuserRecipe) recipe));
                }
                else
                {
                    super.loadCraftingRecipes(outputId,results);
                }
            }
        }
    }

    private String getRecipesID()
    {
        return "seedInfuser";
    }

    @Override
    public void loadCraftingRecipes(ItemStack result)
    {
        for (ISeedInfuserRecipe recipe : SeedInfuserRegistry.getInstance().getAllRecipes())
            if (recipe instanceof SeedInfuserRegistry.StandardInfuserRecipe) {
                if (NEIClientUtils.areStacksSameTypeCrafting(recipe.getCraftingResult(null), result)) {
                    arecipes.add(new InfuserRecipe((SeedInfuserRegistry.StandardInfuserRecipe) recipe));
                }
            }
    }

    @Override
    public void loadUsageRecipes(ItemStack ingredient)
    {
        for (ISeedInfuserRecipe recipe : SeedInfuserRegistry.getInstance().getAllRecipes())
        {
            if (recipe instanceof SeedInfuserRegistry.StandardInfuserRecipe)
            {
                SeedInfuserRegistry.StandardInfuserRecipe standardAlloyRecipe = (SeedInfuserRegistry.StandardInfuserRecipe) recipe;

                for (ItemStack input : standardAlloyRecipe.getRequiredItems())
                {
                    if (NEIClientUtils.areStacksSameTypeCrafting(input, ingredient))
                    {
                        arecipes.add(new InfuserRecipe(standardAlloyRecipe));
                        break;
                    }
                }
            }
        }
    }



    public class InfuserRecipe extends CachedRecipe
    {
        private final List<PositionedStack> inputs;
        private final PositionedStack       output;


        public InfuserRecipe(StandardInfuserRecipe infuserRecipe)
        {
            ItemStack[] stackInputs = infuserRecipe.getRequiredItems();
            inputs = Arrays.asList(new PositionedStack(new ItemStack(stackInputs[0].getItem(), stackInputs[0].stackSize, stackInputs[0].getItemDamage()), 49, 13), new PositionedStack(new ItemStack(stackInputs[1].getItem(), stackInputs[1].stackSize, stackInputs[1].getItemDamage()), 49, 35));

            output = new PositionedStack(infuserRecipe.getCraftingResult(new ItemStack[]{new ItemStack(stackInputs[0].getItem()), new ItemStack(stackInputs[1].getItem())}), 111, 24);

        }

        @Override
        public PositionedStack getResult() {

            return output;
        }

        @Override
        public List<PositionedStack> getIngredients() {

            return inputs;
        }

    }

}
