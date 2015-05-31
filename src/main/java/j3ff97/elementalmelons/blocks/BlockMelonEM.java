package j3ff97.elementalmelons.blocks;

import j3ff97.elementalmelons.handler.CreativeTab;
import j3ff97.elementalmelons.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

public class BlockMelonEM extends Block
{
    public        Item  breakItem;
    public        String name;
    public static IIcon topIcon;
    public static IIcon sideIcon;


    public BlockMelonEM(String name, Material material, float hardness, float resistance, SoundType stepSound, Item breakItem, float lightLevel)
    {
        super(material);
        this.setBlockName(name);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
        this.setLightLevel(lightLevel);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setStepSound(stepSound);
        this.setLightLevel(0.5F);
        this.breakItem = breakItem;
        this.name = name;
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune)
    {
        return breakItem;
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 3 + random.nextInt(6);
    }

    public void registerBlockIcons(IIconRegister icon)
    {
        sideIcon = icon.registerIcon(Reference.ID.toLowerCase() + ":" + name + "_side");
        topIcon = icon.registerIcon(Reference.ID.toLowerCase() + ":" + name + "_top");
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

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
