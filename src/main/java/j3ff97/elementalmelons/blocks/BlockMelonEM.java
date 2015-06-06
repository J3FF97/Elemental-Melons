package j3ff97.elementalmelons.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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
    public  Item   breakItem;
    private IIcon[] icons = new IIcon[2];
    //private String name;


    public BlockMelonEM(String name, Item breakItem)
    {
        super(Material.gourd);
        this.setBlockName(name);
        this.setBlockTextureName(Reference.ID.toLowerCase() + ":" + name);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
        this.setHardness(1F);
        this.setResistance(5F);
        this.setStepSound(soundTypeWood);
        this.setLightLevel(0.5F);
        this.breakItem = breakItem;
    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune)
    {
        return breakItem;
    }

    @Override
    public int quantityDropped(Random random)
    {
        return 3 + random.nextInt(5);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister icon)
    {

        for(int i = 0; i < icons.length; i++)
        {
            this.icons[i] = icon.registerIcon(this.textureName + "_" + i);
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int metadata)
    {
        if(side == 1 || side == 0)
        {
            return icons[1];
        }
        else
        {
            return icons[0];
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
