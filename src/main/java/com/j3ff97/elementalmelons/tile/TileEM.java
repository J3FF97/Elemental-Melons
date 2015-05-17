package com.j3ff97.elementalmelons.tile;

import com.j3ff97.elementalmelons.utility.LogHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

import java.util.ArrayList;
import java.util.List;

public class TileEM extends TileEntity implements IRotatable, IUpdatePlayerListBox
{
    private boolean isRedstonePowered;
    private int     outputtingRedstone;
    private   int        ticker   = 0;
    private   EnumFacing rotation = EnumFacing.UP;
    BlockPos pos = new BlockPos(getPos());

    /****Basic TE Functions****/

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        isRedstonePowered = compound.getBoolean("isRedstonePowered");
        readFromPacketNBT(compound);
    }

    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setBoolean("isRedstonePowered", isRedstonePowered);

        writeToPacketNBT(compound);
    }

    protected void writeToPacketNBT(NBTTagCompound compound)
    {
        compound.setByte("rotation", (byte) rotation.ordinal());
        compound.setByte("outputtingRedstone", (byte) outputtingRedstone);
    }

    protected void readFromPacketNBT(NBTTagCompound compound)
    {
        rotation = EnumFacing.getHorizontal(compound.getByte("rotation"));
        if(rotation.ordinal() > 5)
        {
            LogHelper.warn("invalid rotation!");
            rotation = EnumFacing.UP;
        }
        outputtingRedstone = compound.getByte("outputtingRedstone");
        if(worldObj != null)
        {
            markForRenderUpdate();
        }
    }

    @Override
    public Packet getDescriptionPacket()
    {
        NBTTagCompound compound = new NBTTagCompound();
        writeToPacketNBT(compound);
        return new S35PacketUpdateTileEntity(pos, 0, compound);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
    {
        readFromPacketNBT(pkt.getNbtCompound());
    }

    protected void sendUpdatePacket()
    {
        if(!worldObj.isRemote)
            worldObj.markBlockForUpdate(pos);
    }

    protected void markForRenderUpdate()
    {
        if(worldObj != null) worldObj.markBlockRangeForRenderUpdate(pos, pos);
    }

    protected void notifyNeighborBlockUpdate()
    {
        worldObj.notifyBlockOfStateChange(pos, getBlockType());
    }



    @Override
    public void update()
    {
       if (ticker == 0) {
           onTileLoaded();
       }
       ticker++;
    }

    /** added functions **/

    public void onBlockNeighbourChanged() {

        checkRedstonePower();
    }

    public void checkRedstonePower() {

        boolean isIndirectlyPowered = getWorld().isBlockPowered(pos);
        if (isIndirectlyPowered && !getIsRedstonePowered()) {
            redstoneChanged(true);
        } else if (getIsRedstonePowered() && !isIndirectlyPowered) {
            redstoneChanged(false);
        }
    }

    public void setOutputtingRedstone(boolean newValue) {

        setOutputtingRedstone(newValue ? 15 : 0);
    }

    public void setOutputtingRedstone(int value) {

        value = Math.max(0, value);
        value = Math.min(15, value);
        if (outputtingRedstone != value) {
            outputtingRedstone = value;
            notifyNeighborBlockUpdate();
        }
    }

    public int getOutputtingRedstone() {

        return outputtingRedstone;
    }

    protected void redstoneChanged(boolean newValue) {

        isRedstonePowered = newValue;
    }

    public boolean getIsRedstonePowered() {

        return isRedstonePowered;
    }

    public int getTicker()
    {
        return ticker;
    }

    protected void onTileLoaded()
    {
        if(!worldObj.isRemote) onBlockNeighbourChanged();
    }

    public List<ItemStack> getDrops()
    {
        return new ArrayList<ItemStack>();
    }

    @Override
    public void setFacingDirection(EnumFacing face)
    {
        rotation = face;
        if(worldObj != null)
        {
            sendUpdatePacket();
            notifyNeighborBlockUpdate();
        }
    }

    @Override
    public EnumFacing getFacingDirection()
    {
        return rotation;
    }

    public boolean canConnectRedstone() {

        return false;
    }


}
