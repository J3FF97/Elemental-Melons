package com.j3ff97.elementalmelons.blocks;

import com.j3ff97.elementalmelons.handler.CreativeTab;
import com.j3ff97.elementalmelons.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockEM extends Block
{
    public BlockEM(Material material, String name, SoundType stepsound, float hardness, float resistance)
    {
        super(material);
        this.setUnlocalizedName(name);
        this.setStepSound(stepsound);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
        this.setHardness(hardness);
        this.setResistance(resistance);
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
