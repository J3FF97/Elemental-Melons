package j3ff97.elementalmelons.blocks;

import j3ff97.elementalmelons.handler.CreativeTab;
import j3ff97.elementalmelons.init.ModItems;
import j3ff97.elementalmelons.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockSkyMelon extends Block
{
    public BlockSkyMelon(Material material)
    {
        super(material);
        this.setBlockName(Names.blockSkyMelon_unlocalizedName);
        this.setHardness(1F);
        this.setResistance(5F);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
        this.setStepSound(Block.soundTypeWood);
    }

    public Item getItemDropped(int par1, Random random, int par2)
    {
        return ModItems.skyMelonSlice;
    }

    public int quantityDropped(Random random)
    {
        return 3 + random.nextInt(5);
    }
}
