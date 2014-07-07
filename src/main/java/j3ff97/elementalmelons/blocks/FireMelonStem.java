package j3ff97.elementalmelons.blocks;

import j3ff97.elementalmelons.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;

public class FireMelonStem extends BlockStem
{
    public FireMelonStem(Block block)
    {
        super(block);
        this.setHardness(0.0F);
        this.setStepSound(Block.soundTypeWood);
        this.setBlockName(Names.fireMelonStem_unlocalizedName);
        this.setBlockTextureName("melon_stem");
    }
}
