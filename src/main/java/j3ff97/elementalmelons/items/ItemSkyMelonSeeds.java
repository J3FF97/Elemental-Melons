package j3ff97.elementalmelons.items;

import j3ff97.elementalmelons.handler.CreativeTab;
import j3ff97.elementalmelons.reference.Names;
import j3ff97.elementalmelons.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ItemSkyMelonSeeds extends Item
{
    public ItemSkyMelonSeeds()
    {
        this.setUnlocalizedName(Names.skyMelonSeeds_unlocalizedName);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
    }

    public void registerIcons(IIconRegister icon)
    {
        itemIcon = icon.registerIcon(Reference.ID.toLowerCase() + ":" + "SkyMelonSeeds");
    }
}
