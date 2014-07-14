package j3ff97.elementalmelons.items;

import j3ff97.elementalmelons.handler.CreativeTab;
import j3ff97.elementalmelons.init.ModItems;
import j3ff97.elementalmelons.reference.Names;
import j3ff97.elementalmelons.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemCrystalPurifier extends Item
{
    public ItemCrystalPurifier()
    {
        this.setUnlocalizedName(Names.itemCrystalPurifier_unlocalizedName);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
        this.setMaxDamage(512);
        this.setMaxStackSize(1);
        this.setContainerItem(this);
        this.canRepair = false;
    }

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack)
    {
        return false;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        list.add("Usable to extract the magic from melons.");
    }

    public void registerIcons(IIconRegister icon)
    {
        itemIcon = icon.registerIcon(Reference.ID.toLowerCase() + ":" + "itemCrystalPurifer");
    }
}
