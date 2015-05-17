package com.j3ff97.elementalmelons.gui;

import com.j3ff97.elementalmelons.container.ContainerInfuser;
import com.j3ff97.elementalmelons.reference.GuiIDs;
import com.j3ff97.elementalmelons.tile.TileSeedInfuser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{


    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {

        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);

        switch(GuiIDs.values()[ID])
        {
            case INFUSER:
                return new ContainerInfuser(player.inventory, (TileSeedInfuser) te);
            default:
                break;
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);

        switch(GuiIDs.values()[ID])
        {
            case INFUSER:
                return new GuiInfuser(player.inventory, (TileSeedInfuser) te);
            default:
                break;
        }
        return null;
    }
}
