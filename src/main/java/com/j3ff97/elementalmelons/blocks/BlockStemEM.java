package com.j3ff97.elementalmelons.blocks;

import com.j3ff97.elementalmelons.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockStemEM extends BlockStem
{
    public Item breakItem;

    public BlockStemEM(Block block, String name, Item breakItem)
    {
        super(block);
        this.setHardness(0.0F);
        this.setStepSound(BlockStemEM.soundTypeWood);
        this.setUnlocalizedName(name);
        this.setCreativeTab(null);
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
        return 1;
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
