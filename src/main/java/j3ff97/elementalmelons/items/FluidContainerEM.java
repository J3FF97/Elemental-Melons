package j3ff97.elementalmelons.items;

import j3ff97.elementalmelons.handler.CreativeTab;
import j3ff97.elementalmelons.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;

public class FluidContainerEM extends ItemBucket
{

    public FluidContainerEM(Block block, String name)
    {
        super(block);
        this.setUnlocalizedName(name);
        this.setTextureName(Reference.ID.toLowerCase() + ":" + name);
        this.setContainerItem(Items.bucket);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Reference.ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return String.format("item.%s%s", Reference.ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }


    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
