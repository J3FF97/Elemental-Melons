package j3ff97.elementalmelons.items;

import j3ff97.elementalmelons.handler.CreativeTab;
import j3ff97.elementalmelons.reference.Names;
import j3ff97.elementalmelons.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemEarthMelonSlice extends ItemFood
{
    public ItemEarthMelonSlice(int hunger, float saturation, boolean isWolfFood)
    {
        super(hunger, saturation,isWolfFood);
        this.setUnlocalizedName(Names.earthMelonSlice_unlocalizedName);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
        this.setPotionEffect(5, 20, 0, 1f);
        this.setAlwaysEdible();
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        list.add("Gives Strength for 20 seconds");
    }



    public void registerIcons(IIconRegister icon)
    {
        itemIcon = icon.registerIcon(Reference.ID.toLowerCase() + ":" + "slice_earth_melon");
    }
}
