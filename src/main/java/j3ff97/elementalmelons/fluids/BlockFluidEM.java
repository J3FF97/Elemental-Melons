package j3ff97.elementalmelons.fluids;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import j3ff97.elementalmelons.reference.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidEM extends BlockFluidClassic
{
    @SideOnly(Side.CLIENT) protected IIcon stillIcon;
    @SideOnly(Side.CLIENT) protected IIcon flowingIcon;

    public BlockFluidEM(Fluid fluid, Material material)
    {
        super(fluid, material);
        this.setBlockName(fluid.getName());
        this.setBlockTextureName(Reference.ID.toLowerCase() + ":" + fluid.getName());
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register) {
        stillIcon = register.registerIcon(this.textureName + "_still");
        flowingIcon = register.registerIcon(this.textureName + "_flow");
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Reference.ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
        if(world.getBlock(x,y,z) == this) return true;
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
        if(world.getBlock(x,y,z) == this) return true;
        return super.displaceIfPossible(world, x, y, z);
    }
}
