package j3ff97.elementalmelons.blocks;

import j3ff97.elementalmelons.handler.CreativeTab;
import j3ff97.elementalmelons.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockEarthMelon extends Block
{
    public BlockEarthMelon(Material material)
    {
        super(material);
        this.setBlockName(Names.blockEarthMelon_unlocalizedName);
        this.setHardness(1F);
        this.setResistance(5F);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
        this.setStepSound(Block.soundTypeWood);
    }
}
