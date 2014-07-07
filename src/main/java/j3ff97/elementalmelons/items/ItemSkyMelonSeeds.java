package j3ff97.elementalmelons.items;

import j3ff97.elementalmelons.handler.CreativeTab;
import j3ff97.elementalmelons.reference.Names;
import j3ff97.elementalmelons.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSeeds;

public class ItemSkyMelonSeeds extends ItemSeeds
{
    public ItemSkyMelonSeeds(Block crop, Block soil)
    {
        super(crop, soil);
        this.setUnlocalizedName(Names.skyMelonSeeds_unlocalizedName);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
    }

    public void registerIcons(IIconRegister icon)
    {
        itemIcon = icon.registerIcon(Reference.ID.toLowerCase() + ":" + "SkyMelonSeeds");
    }
}
