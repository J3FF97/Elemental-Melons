package j3ff97.elementalmelons.items;

import j3ff97.elementalmelons.handler.CreativeTab;
import j3ff97.elementalmelons.reference.Names;
import j3ff97.elementalmelons.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;

public class ItemWaterMelonSlice extends ItemFood
{
    public ItemWaterMelonSlice(int hunger, float saturation, boolean isWolfFood)
    {
        super(hunger, saturation,isWolfFood);
        this.setUnlocalizedName(Names.waterMelonSlice_unlocalizedName);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
        this.setPotionEffect(13, 20, 1, 1f);
    }

    public void registerIcons(IIconRegister icon)
    {
        itemIcon = icon.registerIcon(Reference.ID.toLowerCase() + ":" + "WaterMelonSlice");
    }
}
