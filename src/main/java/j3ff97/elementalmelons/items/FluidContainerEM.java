package j3ff97.elementalmelons.items;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class FluidContainerEM extends ItemBucket
{

    public FluidContainerEM(Block block, String name)
    {
        super(block);
        this.setUnlocalizedName(name);
        this.setContainerItem(Items.bucket);
    }
}
