package com.j3ff97.elementalmelons.lib.widget;

import net.minecraft.client.gui.FontRenderer;

import java.awt.*;
import java.util.List;

public interface IGuiAnimatedStat
{
    public Rectangle getButtonScaledRectangle(int origX, int origY, int width, int height);

    public void scaleTextSize(float scale);

    public boolean isLeftSided();

    public boolean isDoneExpanding();

    public void setLeftSided(boolean leftSided);

    public IGuiAnimatedStat setText(List<String> text);

    public IGuiAnimatedStat setText(String text);

    public void setTextWithoutCuttingString(List<String> text);

    public void setTitle(String title);

    public String getTitle();

    public void setMinDimensionsAndReset(int minWidth, int minHeight);

    public void setParentStat(IGuiAnimatedStat stat);

    public void setBaseX(int x);

    public void setBaseY(int y);

    public int getAffectedY();

    public int getBaseX();

    public int getBaseY();

    public int getHeight();

    public int getWidth();

    public void update();

    public void render(FontRenderer fontRenderer, float zLevel, float partialTicks);

    public void closeWindow();

    public void openWindow();

    public boolean isClicked();
}
