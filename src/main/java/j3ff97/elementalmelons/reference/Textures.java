package j3ff97.elementalmelons.reference;

import j3ff97.elementalmelons.utility.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;

public class Textures
{
    public static final String RESOURCE_PREFIX = Reference.ID.toLowerCase();

    public static final class GUI
    {
        public static final String           GUI_TEXTURE_LOCATION = "textures/gui/";
        public static final ResourceLocation SEEDINFUSER          = ResourceLocationHelper.getResourceLocation(GUI_TEXTURE_LOCATION + "guiSeedInfuser.png");
    }
}
