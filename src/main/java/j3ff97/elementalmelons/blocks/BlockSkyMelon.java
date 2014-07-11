package j3ff97.elementalmelons.blocks;

import j3ff97.elementalmelons.handler.CreativeTab;
import j3ff97.elementalmelons.init.ModItems;
import j3ff97.elementalmelons.reference.Names;
import j3ff97.elementalmelons.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

public class BlockSkyMelon extends Block
{
    public static IIcon topIcon;
    public static IIcon sideIcon;

    public BlockSkyMelon(Material material)
    {
        super(material);
        this.setBlockName(Names.blockSkyMelon_unlocalizedName);
        this.setHardness(1F);
        this.setResistance(5F);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
        this.setStepSound(Block.soundTypeWood);
        this.setLightLevel(0.5F);
    }

    public Item getItemDropped(int par1, Random random, int par2)
    {
        return ModItems.skyMelonSlice;
    }

    public int quantityDropped(Random random)
    {
        return 3 + random.nextInt(5);
    }

    public void registerBlockIcons(IIconRegister icon)
    {
        sideIcon = icon.registerIcon(Reference.ID.toLowerCase() + ":sky_melon_side");
        topIcon = icon.registerIcon(Reference.ID.toLowerCase() + ":sky_melon_top");
    }

    @Override
    public IIcon getIcon(int side, int metadata)
    {
        if(side == 1)
        {
            return topIcon;
        }
        else
        {
            return sideIcon;
        }
    }
}
