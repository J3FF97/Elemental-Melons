package j3ff97.elementalmelons.blocks;

import j3ff97.elementalmelons.init.ModItems;
import j3ff97.elementalmelons.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;
import net.minecraft.item.Item;

import java.util.Random;

public class EarthMelonStem extends BlockStem
{
    public EarthMelonStem(Block block)
    {
        super(block);
        this.setHardness(0.0F);
        this.setStepSound(Block.soundTypeWood);
        this.setBlockName(Names.earthMelonStem_unlocalizedName);
        this.setBlockTextureName("melon_stem");
    }

    public Item getItemDropped(int par1, Random random, int par2)
    {
        return ModItems.earthMelonSeeds;
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }
}
