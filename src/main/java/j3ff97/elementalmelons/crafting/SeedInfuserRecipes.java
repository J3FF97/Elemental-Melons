package j3ff97.elementalmelons.crafting;

import j3ff97.elementalmelons.api.crafting.ISeedInfuserRecipe;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

public class SeedInfuserRecipes
{
    private static SeedInfuserRecipes       infuserRecipes     = new SeedInfuserRecipes();
    private static ItemStack[][][] infuserList = new ItemStack[64][64][64];
    private final  List<ISeedInfuserRecipe> seedInfuserRecipes = new ArrayList<ISeedInfuserRecipe>();

    private SeedInfuserRecipes()
    {

    }

    public static SeedInfuserRecipes getInstance()
    {
        return infuserRecipes;
    }

    public static SeedInfuserRecipes instance()
    {
        return infuserRecipes;
    }

    public static void addInfusing(Item i1, Item i2, ItemStack output)
    {
        ItemStack input1 = new ItemStack(i1);
        ItemStack input2 = new ItemStack(i2);

        for(int i = 0; i < infuserList.length; i++)
        {
            if(infuserList[i][0][0] == null || infuserList[i][0][0] == output)
            {
                infuserList[i][0][0] = output;
                for(int j = 0; j < infuserList.length; j++)
                {
                    if(infuserList[i][j][0] == null)
                    {
                        infuserList[i][j][0] = input1;
                        for(int k = 0; k < infuserList.length; k++)
                        {
                            if(infuserList[i][j][k] == null)
                            {
                                infuserList[i][j][k] = input2;
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
    }

    public List<ISeedInfuserRecipe> getAllRecipes()
    {
        return seedInfuserRecipes;
    }

    public void addInfusing(String input, Item i1, int meta, ItemStack output)
    {
        List<ItemStack> inputs = OreDictionary.getOres(input);
        ItemStack input2 = new ItemStack(i1, 1, meta);

        for(int i = 0; i < infuserList.length; i++)
        {
            if(infuserList[i][0][0] == null || infuserList[i][0][0] == output)
            {
                infuserList[i][0][0] = output;
                for(int j = 0; j < inputs.size(); j++)
                {
                    if(infuserList[i][j + 1][0] == null)
                    {
                        infuserList[i][j + 1][0] = inputs.get(j);
                        for(int k = 0; k < infuserList.length; k++)
                        {
                            if(infuserList[i][j + 1][k + 1] == null)
                            {
                                infuserList[i][j + 1][k + 1] = input2;
                                break;
                            }
                        }
                    }
                }
                break;
            }
        }
    }

    public void addInfusing(String input, String input2, ItemStack output)
    {

        List<ItemStack> inputs = OreDictionary.getOres(input);
        List<ItemStack> inputs2 = OreDictionary.getOres(input2);

        for(int i = 0; i < infuserList.length; i++)
        {
            if(infuserList[i][0][0] == null || infuserList[i][0][0] == output)
            {
                infuserList[i][0][0] = output;
                for(int j = 0; j < inputs.size(); j++)
                {
                    if(infuserList[i][j + 1][0] == null)
                    {
                        infuserList[i][j + 1][0] = inputs.get(j);
                        for(int k = 0; k < inputs2.size(); k++)
                        {
                            if(infuserList[i][j + 1][k + 1] == null)
                            {
                                infuserList[i][j + 1][k + 1] = inputs2.get(k);
                            }
                        }
                    }
                }
                break;
            }
        }
    }

    public ItemStack getInfusingResult(Item i1, Item i2)
    {

        for(int i = 0; i < infuserList.length; i++)
        {
            for(int j = 1; j < infuserList.length; j++)
            {
                if(infuserList[i][j][0] != null)
                {
                    if(infuserList[i][j][0].getItem() == i1 )
                    {
                        for(int k = 1; k < infuserList.length; k++)
                        {
                            if(infuserList[i][j][k] != null)
                            {
                                if(infuserList[i][j][k].getItem() == i2)
                                {
                                    return infuserList[i][0][0];
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public boolean hasInfusingResult(Item item, int meta)
    {
        for(int i = 0; i < infuserList.length; i++)
        {
            for(int j = 0; j < infuserList.length - 1; j++)
            {
                if(infuserList[i][j + 1][0] != null)
                {

                    if(infuserList[i][j + 1][0].getItem() == item && (infuserList[i][j + 1][0].getItemDamage() == meta))
                    {
                        return true;
                    }

                    for(int k = 0; k < infuserList.length - 1; k++)
                    {
                        if(infuserList[i][j + 1][k + 1] != null)
                        {
                            if(infuserList[i][j + 1][k + 1].getItem() == item && (infuserList[i][j + 1][k + 1].getItemDamage() == meta))
                            {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}

