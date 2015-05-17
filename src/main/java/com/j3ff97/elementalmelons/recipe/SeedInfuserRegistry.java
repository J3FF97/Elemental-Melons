package com.j3ff97.elementalmelons.recipe;

import com.j3ff97.elementalmelons.api.recipe.IInfuserRecipe;
import com.j3ff97.elementalmelons.api.recipe.IInfuserRegistry;
import com.j3ff97.elementalmelons.utility.ItemStackUtils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

public class SeedInfuserRegistry implements IInfuserRegistry
{
    private static SeedInfuserRegistry instance = new SeedInfuserRegistry();

    private final List<IInfuserRecipe>      infuserRecipes = new ArrayList<IInfuserRecipe>();

    private SeedInfuserRegistry()
    {

    }

    public static SeedInfuserRegistry getInstance()
    {
        return instance;
    }

    @Override
    public void addRecipe(IInfuserRecipe recipe)
    {
        infuserRecipes.add(recipe);
    }

    public List<IInfuserRecipe> getAllRecipes()
    {
        return infuserRecipes;
    }

    @Override
    public void addRecipe(ItemStack result, Object... requiredItems)
    {
        if(result == null || result.getItem() == null)
        {
            throw new NullPointerException("Can't register recipe with a null output Stack or Item!");
        }
        ItemStack[] requiredStacks = new ItemStack[requiredItems.length];
        for (int i = 0; i < requiredItems.length; i++)
        {
            if(requiredItems[i] instanceof ItemStack)
            {
                requiredStacks[i] = (ItemStack) requiredItems[i];
            }
            else if (requiredItems[i] instanceof Item)
            {
                requiredStacks[i] = new ItemStack((Item) requiredItems[i], 1, OreDictionary.WILDCARD_VALUE);
            }
            else if (requiredItems[i] instanceof Block)
            {
                requiredStacks[i] = new ItemStack(Item.getItemFromBlock((Block) requiredItems[i]), 1, OreDictionary.WILDCARD_VALUE);
            }
            else
            {
                throw new IllegalArgumentException("Can only be ItemStack, Item or Block!");
            }
        }
        addRecipe(new StandardInfuserRecipe(result, requiredStacks));
    }

    public IInfuserRecipe getMatchingRecipe(ItemStack[] input, ItemStack outputSlot)
    {
        for (IInfuserRecipe recipe : infuserRecipes)
        {
            if(recipe.matches(input))
            {
                if(outputSlot != null)
                {
                    ItemStack craftingResult = recipe.getCraftingResult(input);
                    if (!ItemStack.areItemStackTagsEqual(outputSlot, craftingResult) || !outputSlot.isItemEqual(craftingResult))
                    {
                        continue;
                    }
                    else if (craftingResult.stackSize + outputSlot.stackSize > outputSlot.getMaxStackSize())
                    {
                        continue;
                    }
                }
                return recipe;
            }
        }
        return null;
    }

    public class StandardInfuserRecipe implements  IInfuserRecipe
    {
        private final ItemStack craftingResult;
        private final ItemStack[] requiredItems;

        private StandardInfuserRecipe(ItemStack craftingResult, ItemStack... requiredItems)
        {
            if(craftingResult == null)
            {
                throw new IllegalArgumentException(" Crafting Result can't be null!");
            }
            if(requiredItems.length > 3)
            {
                throw new IllegalArgumentException(" Can't be more items for the Seed Infuser");
            }
            for(ItemStack requiredItem : requiredItems)
            {
                if (requiredItem == null)
                {
                    throw new NullPointerException("Crafting ingredient cannot be null");
                }
            }
            for(ItemStack stack : requiredItems)
            {
                for(ItemStack stack2 : requiredItems)
                {
                    if(stack != stack2 && ItemStackUtils.isItemFuzzyEqual(stack, stack2))
                    {
                        throw new IllegalArgumentException("No equivalent crafting ingredient can be given twice! This does take OreDict + wildcard in account");
                    }
                }
            }
            this.craftingResult = craftingResult;
            this.requiredItems = requiredItems;
        }

        @Override
        public boolean matches(ItemStack[] input)
        {
            for (ItemStack requiredItem : requiredItems)
            {
                int itemsNeeded = requiredItem.stackSize;
                for(ItemStack inputStack : input)
                {
                    if(inputStack != null && ItemStackUtils.isItemFuzzyEqual(inputStack, requiredItem))
                    {
                        itemsNeeded -= inputStack.stackSize;
                        if(itemsNeeded <=0 ) break;
                    }
                }
                if(itemsNeeded > 0) return false;
            }
            return true;
        }

        @Override
        public void useItems(ItemStack[] input)
        {
            for(ItemStack requiredItem : requiredItems)
            {
                int itemsNeeded = requiredItem.stackSize;
                for (int i = 0; i < input.length; i++)
                {
                    ItemStack inputStack = input[i];
                    if(inputStack != null && ItemStackUtils.isItemFuzzyEqual(inputStack, requiredItem))
                    {
                        int itemsSubtracted = Math.min(inputStack.stackSize, itemsNeeded);
                        inputStack.stackSize -= itemsSubtracted;
                        if(inputStack.stackSize <= 0) input[i] = null;
                        itemsNeeded -= itemsSubtracted;
                        if(itemsNeeded <= 0) break;
                    }
                }
                if(itemsNeeded > 0) throw new IllegalArgumentException("Recipe using items, after using still items required?? Bug!");
            }
        }

        @Override
        public ItemStack getCraftingResult(ItemStack[] input)
        {
            return craftingResult;
        }

        public ItemStack[] getRequiredItems()
        {
            return requiredItems;
        }
    }
}
