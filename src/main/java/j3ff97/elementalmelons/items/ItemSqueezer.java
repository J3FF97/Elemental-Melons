package j3ff97.elementalmelons.items;

import j3ff97.elementalmelons.handler.CreativeTab;
import j3ff97.elementalmelons.reference.Names;
import j3ff97.elementalmelons.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemSqueezer extends Item
{
    public ItemSqueezer()
    {
        this.setCreativeTab(CreativeTab.tabElementalMelons);
        this.setUnlocalizedName(Names.itemSqueezer_unlocalizedName);
        this.setMaxStackSize(1);
        this.setContainerItem(this);
        this.setMaxDamage(128);


    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack)
    {
        return false;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        list.add("Makes delicious juice!");
        //list.add(ItemStack.getMaxDamage() - ItemStack.getItemDamage()  +"uses left");
    }

    public void registerIcons(IIconRegister icon)
    {
        itemIcon = icon.registerIcon(Reference.ID.toLowerCase() + ":" + "itemSqueezer");
    }
}
