package j3ff97.elementalmelons.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import j3ff97.elementalmelons.client.gui.inventory.GuiSeedInfuser;
import j3ff97.elementalmelons.inventory.ContainerSeedInfuser;
import j3ff97.elementalmelons.reference.GUI;
import j3ff97.elementalmelons.tileentity.TileEntitySeedInfuser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == GUI.SEEDINFUSER.ordinal() && world.getTileEntity(x,y,z) instanceof TileEntitySeedInfuser)
        {
            TileEntitySeedInfuser entitySeedInfuser = (TileEntitySeedInfuser) world.getTileEntity(x,y,z);
            return new ContainerSeedInfuser(player.inventory, entitySeedInfuser);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == GUI.SEEDINFUSER.ordinal() && world.getTileEntity(x,y,z) instanceof TileEntitySeedInfuser)
        {
            TileEntitySeedInfuser entitySeedInfuser = (TileEntitySeedInfuser) world.getTileEntity(x,y,z);
            return new GuiSeedInfuser(player.inventory, entitySeedInfuser);
        }
        return null;
    }
}
