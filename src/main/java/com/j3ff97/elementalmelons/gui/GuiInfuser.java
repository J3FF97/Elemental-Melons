package com.j3ff97.elementalmelons.gui;

import com.j3ff97.elementalmelons.container.ContainerInfuser;
import com.j3ff97.elementalmelons.reference.Reference;
import com.j3ff97.elementalmelons.tile.TileSeedInfuser;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiInfuser extends GuiContainerEM
{
    private static final ResourceLocation resLoc = new ResourceLocation(Reference.ID, "textures/gui/infuser.png");
    private final TileSeedInfuser infuser;

    public GuiInfuser(InventoryPlayer player, TileSeedInfuser infuser)
    {
        super(infuser, new ContainerInfuser(player, infuser), resLoc);
        this.infuser = infuser;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        super.drawGuiContainerBackgroundLayer(f,i,j);

        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;

        mc.renderEngine.bindTexture(resLoc);

        int burningPercentage = (int) (infuser.getBurningPercentage() * 13);
        if (burningPercentage > 0)
            drawTexturedModalRect(x + 22, y + 54 + 13 - burningPercentage, 177, 13 - burningPercentage, 14, burningPercentage + 1);

        int processPercentage = (int) (infuser.getProcessPercentage() * 22);
        drawTexturedModalRect(x + 103, y + 35, 178, 14, processPercentage, 15);
    }
}
