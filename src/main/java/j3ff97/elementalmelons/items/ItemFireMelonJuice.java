package j3ff97.elementalmelons.items;

import j3ff97.elementalmelons.handler.CreativeTab;
import j3ff97.elementalmelons.reference.Names;
import j3ff97.elementalmelons.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemFireMelonJuice extends ItemFood
{
    public ItemFireMelonJuice(int hunger, float saturation, boolean isWolfFood)
    {
        super(hunger, saturation, isWolfFood);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
        this.setUnlocalizedName(Names.itemFireMelonJuice_unlocalizedName);
        this.setAlwaysEdible();
        this.setPotionEffect(12, 60, 4, 1f);

    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        list.add("Purified Fire Melon.");
        list.add("Gives a longer and stronger effect");
    }

    public void registerIcons(IIconRegister icon)
    {
        itemIcon = icon.registerIcon(Reference.ID.toLowerCase()  + ":" + "itemFireMelonJuice");
    }
}
