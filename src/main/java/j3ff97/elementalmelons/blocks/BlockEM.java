package j3ff97.elementalmelons.blocks;

import j3ff97.elementalmelons.handler.CreativeTab;
import j3ff97.elementalmelons.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockEM extends Block
{
    public BlockEM(Material material, String name, SoundType stepsound, float hardness, float resistance)
    {
        super(material);
        this.setBlockName(name);
        this.setStepSound(stepsound);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setBlockTextureName(Reference.ID.toLowerCase() + ":" + name);
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
