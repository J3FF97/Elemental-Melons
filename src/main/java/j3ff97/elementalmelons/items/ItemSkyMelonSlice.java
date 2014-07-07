package j3ff97.elementalmelons.items;

import j3ff97.elementalmelons.handler.CreativeTab;
import j3ff97.elementalmelons.reference.Names;
import j3ff97.elementalmelons.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemSkyMelonSlice extends ItemFood
{
    public ItemSkyMelonSlice(int hunger, float saturation, boolean isWolfFood)
    {
        super(hunger, saturation,isWolfFood);
        this.setUnlocalizedName(Names.skyMelonSlice_unlocalizedName);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
        this.setPotionEffect(8, 20, 1, 1f);
    }

    public void registerIcons(IIconRegister icon)
    {
        itemIcon = icon.registerIcon(Reference.ID.toLowerCase() + ":" + "SkyMelonSlice");
    }


}
