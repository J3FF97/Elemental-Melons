package j3ff97.elementalmelons.crafting;

import j3ff97.elementalmelons.api.crafting.ISeedInfuserRecipe;
import j3ff97.elementalmelons.api.crafting.ISeedInfuserRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

public class SeedInfuserRegistry implements ISeedInfuserRegistry
{
    private static SeedInfuserRegistry INSTANCE = new SeedInfuserRegistry();

    private final List<ISeedInfuserRecipe> seedInfuserRecipes = new ArrayList<ISeedInfuserRecipe>();

    private SeedInfuserRegistry()
    {

    }

    public static SeedInfuserRegistry getInstance()
    {
        return INSTANCE;
    }

    @Override
    public void addRecipe(ISeedInfuserRecipe recipe)
    {
        seedInfuserRecipes.add(recipe);
    }

    public List<ISeedInfuserRecipe> getAllRecipes()
    {
        return seedInfuserRecipes;
    }

    @Override
    public void addRecipe(ItemStack craftingResult, Object... requiredItems)
    {
        ItemStack[] requiredStacks = new ItemStack[requiredItems.length];
        for(int i = 0; i <requiredStacks.length; i++)
        {
            if(requiredItems[i] instanceof ItemStack)
            {
                requiredStacks[i] = (ItemStack) requiredItems[i];
            }
            else if(requiredItems[i] instanceof Item)
            {
                requiredStacks[i] = new ItemStack((Item) requiredItems[i], 1, OreDictionary.WILDCARD_VALUE);
            }
            else if(requiredItems[i] instanceof Block)
            {
                requiredStacks[i] = new ItemStack(Item.getItemFromBlock((Block) requiredItems[i]), 1, OreDictionary.WILDCARD_VALUE);
            }
            else
            {
                throw new IllegalArgumentException("Can only register Items, ItemStacks or Blocks!");
            }
        }
        addRecipe(new StandardInfuserRecipe(craftingResult,requiredStacks));

    }

    public ISeedInfuserRecipe getMatchingRecipe(ItemStack[] input, ItemStack outputSlot)
    {
        for(ISeedInfuserRecipe recipe : seedInfuserRecipes)
        {
            if(recipe.matches(input))
            {
                if(outputSlot != null)
                {
                    ItemStack craftingResult = recipe.getCraftingResult(input);
                    if(!ItemStack.areItemStackTagsEqual(outputSlot, craftingResult) || !outputSlot.isItemEqual(craftingResult))
                    {
                        continue;
                    }
                    else if(craftingResult.stackSize + outputSlot.stackSize > outputSlot.getMaxStackSize())
                    {
                        continue;
                    }
                }
                return recipe;
            }
        }
        return null;
    }

    public class StandardInfuserRecipe implements ISeedInfuserRecipe
    {
        private final ItemStack craftingResult;
        private final ItemStack[] requiredItems;

        private StandardInfuserRecipe(ItemStack craftingResult, ItemStack... requiredItems)
        {
            this.craftingResult = craftingResult.copy();
            this.requiredItems = requiredItems;
        }

        @Override
        public boolean matches(ItemStack[] input)
        {
            for(ItemStack requiredItem : requiredItems)
            {
                int itemsNeeded = requiredItem.stackSize;

                for(ItemStack inputStack : input)
                {
                    if(inputStack != null)
                    {
                        itemsNeeded -= inputStack.stackSize;
                        if(itemsNeeded <= 0)
                        {
                            break;
                        }
                    }
                }
                if(itemsNeeded > 0)
                {
                    return false;
                }
            }
            return true;
        }

        @Override
        public void useItems(ItemStack[] input)
        {
            for (ItemStack requiredItem : requiredItems)
            {
                int itemsNeeded = requiredItem.stackSize;

                for (int i = 0; i < input.length; i++)
                {
                    ItemStack inputStack = input[i];

                    if (inputStack != null)
                    {
                        int itemsSubstracted = Math.min(inputStack.stackSize, itemsNeeded);

                        inputStack.stackSize -= itemsSubstracted;

                        if (inputStack.stackSize <= 0)
                        {
                            input[i] = null;
                        }

                        itemsNeeded -= itemsSubstracted;

                        if (itemsNeeded <= 0)
                        {
                            break;
                        }
                    }
                }
                if (itemsNeeded > 0)
                {
                    throw new IllegalArgumentException("Seed Infuser recipe using items, after using still items required?? This is a bug!");
                }
            }
        }

        @Override
        public ItemStack getCraftingResult(ItemStack[] input)
        {
            return this.craftingResult;
        }



        public ItemStack[] getRequiredItems()
        {
            return requiredItems;
        }
    }



}
