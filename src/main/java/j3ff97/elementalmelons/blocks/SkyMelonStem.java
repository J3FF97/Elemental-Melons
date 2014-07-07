package j3ff97.elementalmelons.blocks;

import j3ff97.elementalmelons.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;

public class SkyMelonStem extends BlockStem
{

    public SkyMelonStem(Block block)
    {
        super(block);
        this.setHardness(0.0F);
        this.setStepSound(Block.soundTypeWood);
        this.setBlockName(Names.skyMelonStem_unlocalizedName);
        this.setBlockTextureName("melon_stem");
    }

}
