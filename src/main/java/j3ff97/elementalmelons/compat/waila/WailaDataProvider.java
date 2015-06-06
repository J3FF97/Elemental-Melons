package j3ff97.elementalmelons.compat.waila;

import j3ff97.elementalmelons.reference.Names;
import j3ff97.elementalmelons.tileentity.TileEntitySeedInfuser;
import mcp.mobius.waila.api.*;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.List;

public class WailaDataProvider implements IWailaDataProvider
{
    public static void callBackRegister(IWailaRegistrar registrar)
    {
        registrar.registerHeadProvider(new WailaDataProvider(), TileEntitySeedInfuser.class);
    }

    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return null;
    }

    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        if(accessor.getTileEntity() instanceof TileEntitySeedInfuser)
        {
            currenttip.set(0, String.format("%s%s", SpecialChars.WHITE, StatCollector.translateToLocal(Names.blockSeedInfusername)));
        }
        return currenttip;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return currenttip;
    }

    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config)
    {
        return currenttip;
    }

    @Override
    public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x, int y, int z)
    {
        return null;
    }
}
