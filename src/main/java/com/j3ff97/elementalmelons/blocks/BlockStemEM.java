package com.j3ff97.elementalmelons.blocks;

import com.j3ff97.elementalmelons.init.ModBlocks;
import com.j3ff97.elementalmelons.init.ModItems;
import com.j3ff97.elementalmelons.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStem;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockStemEM extends BlockStem
{
   private final Block crop;

    public BlockStemEM(Block crop, String name)
    {
        super(crop);
        this.setHardness(0.0F);
        this.setStepSound(BlockStemEM.soundTypeWood);
        this.setUnlocalizedName(name);
        this.crop = crop;
    }

    @Override
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
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return this.getSeedItem();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, BlockPos pos)
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
