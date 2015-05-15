package com.j3ff97.elementalmelons.blocks;

import com.j3ff97.elementalmelons.handler.CreativeTab;
import com.j3ff97.elementalmelons.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockEM extends Block
{
    public Item breakItem;

    public BlockEM(String name, Material material, float hardness, float resistance, SoundType stepSound, Item breakItem, float lightLevel)
    {
        super(material);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
        this.setLightLevel(lightLevel);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setStepSound(stepSound);
        this.breakItem = breakItem;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune)
    {
        return breakItem;
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 3 + random.nextInt(5);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
