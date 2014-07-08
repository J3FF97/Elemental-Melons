package j3ff97.elementalmelons.items;

import j3ff97.elementalmelons.handler.CreativeTab;
import j3ff97.elementalmelons.init.ModBlocks;
import j3ff97.elementalmelons.reference.Names;
import j3ff97.elementalmelons.reference.Reference;
import j3ff97.elementalmelons.utility.SeedHelper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;


public class ItemSkyMelonSeeds extends SeedHelper
{

    public ItemSkyMelonSeeds()
    {
        super(ModBlocks.skyMelonStem, Blocks.farmland);
        this.setUnlocalizedName(Names.skyMelonSeeds_unlocalizedName);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
    }



    public void registerIcons(IIconRegister icon)
    {
        itemIcon = icon.registerIcon(Reference.ID.toLowerCase() + ":" + "seeds_sky_melon");
    }


}
