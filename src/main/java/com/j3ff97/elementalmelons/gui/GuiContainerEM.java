package com.j3ff97.elementalmelons.gui;

import codechicken.nei.VisibilityData;
import codechicken.nei.api.INEIGuiHandler;
import codechicken.nei.api.TaggedInventoryArea;
import com.j3ff97.elementalmelons.lib.GuiContainerBase;
import com.j3ff97.elementalmelons.lib.widget.GuiAnimatedStat;
import com.j3ff97.elementalmelons.lib.widget.IGuiWidget;
import com.j3ff97.elementalmelons.reference.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Optional;

import java.awt.*;
import java.util.List;


@Optional.Interface(iface = "codechicken.nei.api.INEIGuiHandler", modid = Reference.NEI)
public class GuiContainerEM extends GuiContainerBase implements INEIGuiHandler
{
    public GuiContainerEM(Container mainContainer, ResourceLocation _resLoc)
    {

        super(mainContainer, _resLoc);
    }

    public GuiContainerEM(IInventory inventory, Container mainContainer, ResourceLocation _resLoc) {

        super(inventory, mainContainer, _resLoc);
    }



    // -----------NEI support

    @Override
    @Optional.Method(modid = Reference.NEI)
    public VisibilityData.VisiblityData modifyVisiblity(GuiContainer gui, VisibilityData.VisiblityData currentVisibility) {

        for (IGuiWidget widget : widgets) {
            if (widget instanceof GuiAnimatedStat) {
                GuiAnimatedStat stat = (GuiAnimatedStat) widget;
                if (stat.isLeftSided()) {
                    if (stat.getWidth() > 20) {
                        currentVisibility.showUtilityButtons = false;
                        currentVisibility.showStateButtons = false;
                    }
                } else {
                    if (stat.getAffectedY() < 10) {
                        currentVisibility.showWidgets = false;
                    }
                }
            }
        }
        return currentVisibility;
    }

    /**
     * NEI will give the specified item to the InventoryRange returned if the player's inventory is full. return null for no range
     */
    @Override
    public Iterable<Integer> getItemSpawnSlots(GuiContainer gui, ItemStack item) {

        return null;
    }

    /**
     * @return A list of TaggedInventoryAreas that will be used with the savestates.
     */
    @Override
    @Optional.Method(modid = Reference.NEI)
    public List<TaggedInventoryArea> getInventoryAreas(GuiContainer gui) {

        return null;
    }

    /**
     * Handles clicks while an itemstack has been dragged from the item panel. Use this to set configurable slots and the like. Changes made to the
     * stackSize of the dragged stack will be kept
     *
     * @param gui
     *            The current gui instance
     * @param mousex
     *            The x position of the mouse
     * @param mousey
     *            The y position of the mouse
     * @param draggedStack
     *            The stack being dragged from the item panel
     * @param button
     *            The button presed
     * @return True if the drag n drop was handled. False to resume processing through other routes. The held stack will be deleted if
     *         draggedStack.stackSize == 0
     */
    @Override
    public boolean handleDragNDrop(GuiContainer gui, int mousex, int mousey, ItemStack draggedStack, int button) {

        return false;
    }

    /**
     * Used to prevent the item panel from drawing on top of other gui elements.
     *
     * @param x
     *            The x coordinate of the rectangle bounding the slot
     * @param y
     *            The y coordinate of the rectangle bounding the slot
     * @param w
     *            The w coordinate of the rectangle bounding the slot
     * @param h
     *            The h coordinate of the rectangle bounding the slot
     * @return true if the item panel slot within the specified rectangle should not be rendered.
     */
    @Override
    public boolean hideItemPanelSlot(GuiContainer gui, int x, int y, int w, int h) {

        for (IGuiWidget stat : widgets) {
            if (stat.getBounds().intersects(new Rectangle(x, y, w, h)))
                return true;
        }
        return false;
    }
}
