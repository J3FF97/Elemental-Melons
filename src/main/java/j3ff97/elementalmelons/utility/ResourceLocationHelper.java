package j3ff97.elementalmelons.utility;

import j3ff97.elementalmelons.reference.Textures;
import net.minecraft.util.ResourceLocation;

public class ResourceLocationHelper
{
    public static ResourceLocation getResourceLocation(String modId, String path)
    {
        return new ResourceLocation(modId, path);
    }

    public static ResourceLocation getResourceLocation(String path)
    {
        return getResourceLocation(Textures.RESOURCE_PREFIX, path);
    }
}
