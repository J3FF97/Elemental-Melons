package j3ff97.elementalmelons.client.gui.inventory;

import j3ff97.elementalmelons.inventory.ContainerSeedInfuser;
import j3ff97.elementalmelons.reference.Textures;
import j3ff97.elementalmelons.tileentity.TileEntitySeedInfuser;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import org.lwjgl.opengl.GL11;

public class GuiSeedInfuser extends GuiContainer
{
    private TileEntitySeedInfuser infuser;

    public GuiSeedInfuser(InventoryPlayer player, TileEntitySeedInfuser entitySeedInfuser)
    {
        super(new ContainerSeedInfuser(player, entitySeedInfuser));
        infuser = entitySeedInfuser;

        this.xSize = 176;
        this.ySize = 166;
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String name = this.infuser.hasCustomInventoryName() ? this.infuser.getInventoryName() : I18n.format(this.infuser.getInventoryName());

        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 5, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

        this.mc.getTextureManager().bindTexture(Textures.GUI.SEEDINFUSER);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

        int j1 = infuser.getInfuseProgressScaled(15);
        drawTexturedModalRect(guiLeft + 84, guiTop + 29, 176, 0, j1 + 1, 26);

    }
}
