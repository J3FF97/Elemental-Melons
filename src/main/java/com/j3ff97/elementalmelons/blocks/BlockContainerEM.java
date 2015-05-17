package com.j3ff97.elementalmelons.blocks;

import com.j3ff97.elementalmelons.ElementalMelons;
import com.j3ff97.elementalmelons.api.EMApi;
import com.j3ff97.elementalmelons.api.block.IAdvancedSilkyRemovable;
import com.j3ff97.elementalmelons.helper.IOHelper;
import com.j3ff97.elementalmelons.init.ModItems;
import com.j3ff97.elementalmelons.reference.GuiIDs;
import com.j3ff97.elementalmelons.tile.IRotatable;
import com.j3ff97.elementalmelons.tile.TileEM;
import com.j3ff97.elementalmelons.utility.EnumFacingUtils;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

public class BlockContainerEM extends BlockEM implements ITileEntityProvider, IAdvancedSilkyRemovable
{
    private GuiIDs guiID = GuiIDs.INVALID;
    private Class<? extends TileEM> TEClass;
    private boolean isRedstoneEmitter;
    private boolean isSilkyRemoving;
    protected BlockPos pos;

    public BlockContainerEM(Material material,String name, SoundType stepSound, float hardness, float resistance, Class<? extends TileEM> TEClass)
    {
        super(material, name, stepSound, hardness, resistance);
        this.isBlockContainer = true;
        this.setTileEntityClass(TEClass);
    }

    public BlockPos getPos()
    {
        return this.pos;
    }

    public BlockContainerEM setGuiID(GuiIDs id)
    {
        this.guiID = id;
        return this;
    }

    public BlockContainerEM setTileEntityClass(Class<?extends TileEM> TEClass)
    {
        this.TEClass = TEClass;
        return this;
    }

    public BlockContainerEM emitsRedstone()
    {
        isRedstoneEmitter = true;
        return this;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        try
        {
            return getTileEntity().newInstance();
        }
        catch(Exception e)
        {
            return null;
        }
    }

    protected Class<? extends TileEntity> getTileEntity()
    {
        return TEClass;
    }

    protected TileEM get(IBlockAccess w, BlockPos pos)
    {
        TileEntity te = w.getTileEntity(pos);
        if(te == null || !(te instanceof TileEM)) return null;

        return (TileEM) te;
    }

    @Override
    public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state,Block block) {

        super.onNeighborBlockChange(world, pos,state, block);
        // Only do this on the server side.
        if (!world.isRemote) {
            TileEM tileEntity = get(world, pos);
            if (tileEntity != null) {
                tileEntity.onBlockNeighbourChanged();
            }
        }
    }

    @Override
    public boolean canProvidePower()
    {
        return isRedstoneEmitter;
    }

    @Override
    public int isProvidingWeakPower(IBlockAccess world, BlockPos pos, IBlockState state, EnumFacing side)
    {
        TileEntity te = get(world, pos);
        if (te instanceof TileEM) {
            TileEM tileBase = (TileEM) te;
            return tileBase.getOutputtingRedstone();
        }
        return 0;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitx, float hity, float hitz) {

        if (player.isSneaking()) {
            if (player.getHeldItem() != null) {
                if (player.getHeldItem().getItem() == ModItems.itemWrench) {
                    return false;
                }
            }
        }

        if (player.isSneaking()) {
            return false;
        }

        TileEntity entity = get(world, pos);
        if (entity == null || !(entity instanceof TileEM)) {
            return false;
        }

        if (getGuiID() != GuiIDs.INVALID) {
            if (!world.isRemote)
                FMLNetworkHandler.openGui(player, ElementalMelons.instance, getGuiID().ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }
        return false;
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        if(!isSilkyRemoving)
        {
            TileEM tile = get(world, pos);
            if(tile != null)
            {
                for(ItemStack stack : tile.getDrops())
                {
                    IOHelper.spawnItemInWorld(world, stack, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
                }
            }
        }
        super.breakBlock(world, pos, state);
        world.removeTileEntity(pos);
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack)
    {
        EMApi.getInstance().loadSilkySettings(world, pos, stack);
        TileEntity te = get(world, pos);
        if (te instanceof IRotatable)
        {
            ((IRotatable) te).setFacingDirection(EnumFacingUtils.getDirectionFacing(player, canRotateVertical()).getOpposite());
        }
    }

    protected boolean canRotateVertical()
    {
        return true;
    }

    @Override
    public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis)
    {
        TileEntity te = get(world, pos);
        if (te instanceof IRotatable)
        {
            IRotatable rotatable = (IRotatable) te;
            EnumFacing dir = rotatable.getFacingDirection();
            dir = dir.rotateY();
            if (dir != EnumFacing.UP && dir != EnumFacing.DOWN || canRotateVertical())
            {
                rotatable.setFacingDirection(dir);
                return true;
            }
        }
        return false;
    }

    public GuiIDs getGuiID()
    {
        return guiID;
    }

    @Override
    public boolean preSilkyRemoval(World world, BlockPos pos)
    {
        isSilkyRemoving = true;
        return true;
    }

    @Override
    public void postSilkyRemoval(World world, BlockPos pos)
    {
        isSilkyRemoving = false;
    }

    @Override
    public boolean writeSilkyData(World world, BlockPos pos, NBTTagCompound tag)
    {
        world.getTileEntity(pos).writeToNBT(tag);
        return false;
    }

    @Override
    public void readSilkyData(World world, BlockPos pos, NBTTagCompound tag) {

        world.getTileEntity(pos).readFromNBT(tag);
    }

    @Override
    public boolean canConnectRedstone(IBlockAccess world, BlockPos pos, EnumFacing side)
    {
        return((TileEM) world.getTileEntity(pos)).canConnectRedstone();
    }


}
