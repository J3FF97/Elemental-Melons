package com.j3ff97.elementalmelons.items;

import com.j3ff97.elementalmelons.api.misc.IWrench;
import com.j3ff97.elementalmelons.blocks.BlockContainerEM;
import com.j3ff97.elementalmelons.reference.GuiIDs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class ItemWrench extends ItemEM implements IWrench
{
    public ItemWrench(String name)
    {
        super(name);
        this.setMaxDamage(250);
        this.setMaxStackSize(1);
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitx, float hity, float hitz)
    {
        Block block = world.getBlockState(pos).getBlock();

        if (block instanceof BlockContainerEM) {
            if (((BlockContainerEM) block).getGuiID() != GuiIDs.INVALID) {
                if (player.isSneaking()) {
                    block.rotateBlock(world, pos, side);
                    damage(stack, 1, player, false);
                }
            } else {
                if (block.rotateBlock(world, pos, side))
                    damage(stack, 1, player, false);
            }
        } else {
            if (block.rotateBlock(world, pos, side))
                damage(stack, 1, player, false);
        }
        return false;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean isFull3D()
    {
        return true;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BLOCK;
    }

    @Override
    public boolean damage(ItemStack stack, int damage, EntityPlayer player, boolean simulated)
    {
        if (player != null && player.capabilities.isCreativeMode)
            return true;
        if ((stack.getItemDamage() % stack.getMaxDamage()) + damage > stack.getMaxDamage())
            return false;

        if (!simulated) {
            if (stack.attemptDamageItem(damage, new Random())) {
                if (player != null)
                    player.renderBrokenItemStack(stack);
                --stack.stackSize;

                if (player != null && player instanceof EntityPlayer)
                    player.addStat(StatList.objectBreakStats[Item.getIdFromItem(stack.getItem())], 1);

                if (stack.stackSize < 0)
                    stack.stackSize = 0;

                stack.setItemDamage(0);
            }
        }

        return true;
    }
}

