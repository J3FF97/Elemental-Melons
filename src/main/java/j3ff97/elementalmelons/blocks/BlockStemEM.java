package j3ff97.elementalmelons.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import j3ff97.elementalmelons.handler.CreativeTab;
import j3ff97.elementalmelons.init.ModBlocks;
import j3ff97.elementalmelons.init.ModItems;
import j3ff97.elementalmelons.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class BlockStemEM extends BlockStem
{
    private final Block crop;

    public BlockStemEM(Block crop, String name)
    {
        super(crop);
        this.setHardness(0.0F);
        this.setStepSound(BlockStemEM.soundTypeWood);
        this.setBlockName(name);
        this.setBlockTextureName("melon_stem");
        this.setCreativeTab((CreativeTabs) null);
        this.crop = crop;
    }

    public Item getSeedItem()
    {
        if(this.crop == ModBlocks.blockEarthMelon)
        {
            return ModItems.earthMelonSeeds;
        }
        else if(this.crop == ModBlocks.blockFireMelon)
        {
            return ModItems.fireMelonSeeds;
        }
        else if(this.crop == ModBlocks.blockSkyMelon)
        {
            return ModItems.skyMelonSeeds;
        }
        else if(this.crop == ModBlocks.blockWaterMelon)
        {
            return ModItems.waterMelonSeeds;
        }
        else
        {
            return null;
        }
    }

    @Override
    public Item getItemDropped(int meta, Random rand, int fortune)
    {
        return this.getSeedItem();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
        Item item = this.getSeedItem();

        if(item != null)
        {
            return item;
        }
        else
        {
            return null;
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
