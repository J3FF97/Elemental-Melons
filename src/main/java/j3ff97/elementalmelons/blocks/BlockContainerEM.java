package j3ff97.elementalmelons.blocks;

import j3ff97.elementalmelons.handler.CreativeTab;
import j3ff97.elementalmelons.reference.Reference;
import j3ff97.elementalmelons.tileentity.TileEntitySeedInfuser;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockContainerEM extends Block implements ITileEntityProvider
{
    private IIcon[] icons = new IIcon[2];

    protected BlockContainerEM(String name, Material material, float hardness, float resistance, SoundType stepSound, String toolClass, int harvestLevel)
    {
        super(material);
        this.setBlockName(name);
        this.setBlockTextureName(Reference.ID + ":" + name);
        this.setHarvestLevel(toolClass, harvestLevel);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setStepSound(stepSound);
        this.setCreativeTab(CreativeTab.tabElementalMelons);
        this.isBlockContainer = true;
    }

    public BlockContainerEM(String name)
    {
        super(Material.rock);
        this.setBlockName(name);
        this.setBlockTextureName(Reference.ID + ":" + name);
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
        super.breakBlock(world,x,y,z,block,meta);
        world.removeTileEntity(x,y,z);
    }

    public boolean onBlockEventReceived(World world,int x, int y, int z, int id, int param)
    {
        super.onBlockEventReceived(world,x,y,z,id,param);
        TileEntity entity = world.getTileEntity(x,y,z);
        return entity != null && entity.receiveClientEvent(id,param);
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
    public void registerBlockIcons(IIconRegister register)
    {
        this.icons[0] = register.registerIcon(this.textureName + "_top");
        this.icons[1] = register.registerIcon(this.textureName + "_side");
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        if(side == 1)
        {
            return icons[0];
        }
        else
        {
            return icons[1];
        }
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new TileEntitySeedInfuser();
    }
}
