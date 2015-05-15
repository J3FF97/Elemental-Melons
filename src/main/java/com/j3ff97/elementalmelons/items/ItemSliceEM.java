package com.j3ff97.elementalmelons.items;

import com.j3ff97.elementalmelons.handler.CreativeTab;
import com.j3ff97.elementalmelons.reference.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemSliceEM extends ItemFood
{
    String message;

    public ItemSliceEM(int hunger, float saturation, boolean isWolfFood, String name, int potId, String message)
    {
        super(hunger, saturation, isWolfFood);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
        this.setPotionEffect(potId, 20, 0, 1f);
        this.setAlwaysEdible();
        this.message=message;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced)
    {
        list.add(message);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return String.format("item.%s%s", Reference.ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }


    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
