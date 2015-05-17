package com.j3ff97.elementalmelons.blocks;

import com.j3ff97.elementalmelons.init.ModBlocks;
import com.j3ff97.elementalmelons.reference.GuiIDs;
import com.j3ff97.elementalmelons.tile.TileSeedInfuser;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BlockSeedInfuser extends BlockContainerEM
{

    public BlockSeedInfuser(Material material,String name, SoundType stepSound, float hardness, float resistance)
    {
        super(material, name, stepSound,hardness,resistance, TileSeedInfuser.class);
        this.setStepSound(stepSound);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setUnlocalizedName(name);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, BlockPos pos, IBlockState state, Random rnd) {

        TileSeedInfuser te = (TileSeedInfuser) world.getTileEntity(pos);
        if (te.getIsActive()) {
            int l = te.getFacingDirection().ordinal();
            float f = (float)pos.getX() + 0.5F;
            float f1 = (float)pos.getY() + 0.0F + rnd.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)pos.getZ() + 0.5F;
            float f3 = 0.52F;
            float f4 = rnd.nextFloat() * 0.6F - 0.3F;

            if (l == 4) {
                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(EnumParticleTypes.FLAME, f - f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
            } else if (l == 5) {
                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(EnumParticleTypes.FLAME, f + f3, f1, f2 + f4, 0.0D, 0.0D, 0.0D);
            } else if (l == 2) {
                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(EnumParticleTypes.FLAME, f + f4, f1, f2 - f3, 0.0D, 0.0D, 0.0D);
            } else if (l == 3) {
                world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
                world.spawnParticle(EnumParticleTypes.FLAME, f + f4, f1, f2 + f3, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int fortune) {

        return Item.getItemFromBlock(ModBlocks.blockSeedInfuser);
    }

    @Override
    public int getLightValue(IBlockAccess world, BlockPos pos) {

        TileSeedInfuser te = (TileSeedInfuser) world.getTileEntity(pos);
        return te.getIsActive() ? 13 : 0;
    }

    @Override
    public GuiIDs getGuiID()
    {
        return GuiIDs.INFUSER;
    }

    @Override
    protected boolean canRotateVertical() {

        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType() {

        return 0;
    }
}
