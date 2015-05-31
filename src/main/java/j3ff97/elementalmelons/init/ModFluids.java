package j3ff97.elementalmelons.init;

import cpw.mods.fml.common.registry.GameRegistry;
import j3ff97.elementalmelons.fluids.BlockFluidEM;
import j3ff97.elementalmelons.fluids.FluidEM;
import j3ff97.elementalmelons.handler.BucketHandler;
import j3ff97.elementalmelons.items.FluidContainerEM;
import j3ff97.elementalmelons.reference.Names;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids
{
    public static FluidEM melonJuice;
    public static FluidEM pumpkinJuice;
    public static FluidEM appleJuice;
    public static FluidEM skyMelonJuice;
    public static FluidEM waterMelonJuice;
    public static FluidEM fireMelonJuice;
    public static FluidEM earthMelonJuice;

    public static BlockFluidEM blockMelonJuice;
    public static BlockFluidEM blockPumpkinJuice;
    public static BlockFluidEM blockAppleJuice;
    public static BlockFluidEM blockSkyMelonJuice;
    public static BlockFluidEM blockWaterMelonJuice;
    public static BlockFluidEM blockFireMelonJuice;
    public static BlockFluidEM blockEarthMelonJuice;


    public static FluidContainerEM melonJuiceBucket;
    public static FluidContainerEM pumpkinJuiceBucket;
    public static FluidContainerEM appleJuiceBucket;
    public static FluidContainerEM skyMelonJuiceBucket;
    public static FluidContainerEM waterMelonJuiceBucket;
    public static FluidContainerEM fireMelonJuiceBucket;
    public static FluidContainerEM earthMelonJuiceBucket;

    public static void init()
    {
        melonJuice = new FluidEM(Names.fluidMelonJuicename, 0, 900, false);
        pumpkinJuice = new FluidEM(Names.fluidPumpkinJuicename, 0, 900, false);
        appleJuice = new FluidEM(Names.fluidAppleJuiceName, 0, 900, false);
        skyMelonJuice = new FluidEM(Names.fluidSkyMelonJuicename, 0, 900, false);
        waterMelonJuice = new FluidEM(Names.fluidWaterMelonJuicename, 0, 900, false);
        fireMelonJuice = new FluidEM(Names.fluidFireMelonJuicename, 0, 900, false);
        earthMelonJuice = new FluidEM(Names.fluidEarthMelonJuicename, 0, 900, false);

        registerFluids();

        initFluidBlocks();

        initFluidContainers();
    }

    public static void initFluidBlocks()
    {
        blockMelonJuice = new BlockFluidEM(melonJuice, Material.water);
        blockPumpkinJuice = new BlockFluidEM(pumpkinJuice, Material.water);
        blockAppleJuice = new BlockFluidEM(appleJuice, Material.water);
        blockSkyMelonJuice = new BlockFluidEM(skyMelonJuice, Material.water);
        blockWaterMelonJuice = new BlockFluidEM(waterMelonJuice, Material.water);
        blockFireMelonJuice = new BlockFluidEM(fireMelonJuice, Material.water);
        blockEarthMelonJuice = new BlockFluidEM(earthMelonJuice, Material.water);

        registerFluidBlocks();
    }

    public static void initFluidContainers()
    {
        melonJuiceBucket = new FluidContainerEM(blockMelonJuice, Names.bucketMelonJuiceName);
        pumpkinJuiceBucket = new FluidContainerEM(blockPumpkinJuice, Names.bucketPumpkinJuiceName);
        appleJuiceBucket = new FluidContainerEM(blockAppleJuice, Names.bucketAppleJuiceName);
        skyMelonJuiceBucket = new FluidContainerEM(blockSkyMelonJuice, Names.bucketSkyMelonJuiceName);
        waterMelonJuiceBucket = new FluidContainerEM(blockWaterMelonJuice, Names.bucketWaterMelonJuiceName);
        fireMelonJuiceBucket = new FluidContainerEM(blockFireMelonJuice, Names.bucketFireMelonJuiceName);
        earthMelonJuiceBucket = new FluidContainerEM(blockEarthMelonJuice, Names.bucketEarthMelonJuiceName);

        registerFluidContainers();
    }

    public static void registerFluids()
    {
        FluidRegistry.registerFluid(melonJuice);
        FluidRegistry.registerFluid(pumpkinJuice);
        FluidRegistry.registerFluid(appleJuice);
        FluidRegistry.registerFluid(skyMelonJuice);
        FluidRegistry.registerFluid(waterMelonJuice);
        FluidRegistry.registerFluid(fireMelonJuice);
        FluidRegistry.registerFluid(earthMelonJuice);
    }

    public static void registerFluidBlocks()
    {
        GameRegistry.registerBlock(blockMelonJuice, Names.fluidMelonJuicename);
        GameRegistry.registerBlock(blockPumpkinJuice, Names.fluidPumpkinJuicename);
        GameRegistry.registerBlock(blockAppleJuice, Names.fluidAppleJuiceName);
        GameRegistry.registerBlock(blockSkyMelonJuice, Names.fluidSkyMelonJuicename);
        GameRegistry.registerBlock(blockWaterMelonJuice, Names.fluidWaterMelonJuicename);
        GameRegistry.registerBlock(blockFireMelonJuice, Names.fluidFireMelonJuicename);
        GameRegistry.registerBlock(blockEarthMelonJuice, Names.fluidEarthMelonJuicename);
    }

    public static void registerFluidContainers()
    {
        GameRegistry.registerItem(melonJuiceBucket, Names.bucketMelonJuiceName);
        GameRegistry.registerItem(pumpkinJuiceBucket, Names.bucketPumpkinJuiceName);
        GameRegistry.registerItem(appleJuiceBucket, Names.bucketAppleJuiceName);
        GameRegistry.registerItem(skyMelonJuiceBucket, Names.bucketSkyMelonJuiceName);
        GameRegistry.registerItem(waterMelonJuiceBucket, Names.bucketWaterMelonJuiceName);
        GameRegistry.registerItem(fireMelonJuiceBucket, Names.bucketFireMelonJuiceName);
        GameRegistry.registerItem(earthMelonJuiceBucket, Names.bucketEarthMelonJuiceName);

        FluidContainerRegistry.registerFluidContainer(melonJuice, new ItemStack(melonJuiceBucket), new ItemStack(Items.bucket));
        FluidContainerRegistry.registerFluidContainer(pumpkinJuice, new ItemStack(pumpkinJuiceBucket), new ItemStack(Items.bucket));
        FluidContainerRegistry.registerFluidContainer(appleJuice, new ItemStack(appleJuiceBucket), new ItemStack(Items.bucket));
        FluidContainerRegistry.registerFluidContainer(skyMelonJuice, new ItemStack(skyMelonJuiceBucket), new ItemStack(Items.bucket));
        FluidContainerRegistry.registerFluidContainer(waterMelonJuice, new ItemStack(waterMelonJuiceBucket), new ItemStack(Items.bucket));
        FluidContainerRegistry.registerFluidContainer(fireMelonJuice, new ItemStack(fireMelonJuiceBucket), new ItemStack(Items.bucket));
        FluidContainerRegistry.registerFluidContainer(earthMelonJuice, new ItemStack(earthMelonJuiceBucket), new ItemStack(Items.bucket));
    }

    public static void registerBuckets()
    {
        BucketHandler.instance.buckets.put(blockMelonJuice, melonJuiceBucket);
        BucketHandler.instance.buckets.put(blockPumpkinJuice, pumpkinJuiceBucket);
        BucketHandler.instance.buckets.put(blockAppleJuice, appleJuiceBucket);
        BucketHandler.instance.buckets.put(blockSkyMelonJuice, skyMelonJuiceBucket);
        BucketHandler.instance.buckets.put(blockWaterMelonJuice, waterMelonJuiceBucket);
        BucketHandler.instance.buckets.put(blockFireMelonJuice, fireMelonJuiceBucket);
        BucketHandler.instance.buckets.put(blockEarthMelonJuice, earthMelonJuiceBucket);
    }


}
