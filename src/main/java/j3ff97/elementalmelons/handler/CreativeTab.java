package j3ff97.elementalmelons.handler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTab
{
    public static CreativeTabs tabElementalMelons = new CreativeTabs("tabElementalMelons")
    {
        public ItemStack getIconItemStack()
        {
            return new ItemStack(Items.melon);
        }

        @Override
        public Item getTabIconItem()
        {

            return null;
        }
    };
}
