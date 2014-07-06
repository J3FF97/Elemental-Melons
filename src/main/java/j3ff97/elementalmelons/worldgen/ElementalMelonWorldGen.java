package j3ff97.elementalmelons.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class ElementalMelonWorldGen implements IWorldGenerator
{
    @Override
    public void generate(Random random, int X, int Z, World world, IChunkProvider chunkGenerator, IChunkProvider ChunkProvider)
    {
        switch(world.provider.dimensionId)
        {
            case 0: generateSurface(random, X*16, Z*16, world); break;
            case 1: generateEnd(random, X*16, Z*16, world); break;
            case -1: generateNether(random, X*16, Z*16, world); break;
            default:;
        }
    }

    public void generateSurface(Random random, int X, int Z, World world)
    {

    }

    public void generateEnd(Random random, int X, int Z, World world)
    {

    }

    public void generateNether(Random random, int X, int Z, World world)
    {

    }

    public void addSkyMelon(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
    {
        for(int i = 0; i<chancesToSpawn; i++)
        {
            int posX = blockXPos + random.nextInt(16);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(16);
            new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), Blocks.air).generate(world, random, posX, posY, posZ);
        }
    }

    public void addWaterMelon(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
    {
        for(int i = 0; i<chancesToSpawn; i++)
        {
            int posX = blockXPos + random.nextInt(16);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(16);
            new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), Blocks.water).generate(world, random, posX, posY, posZ);
        }
    }

    public void addEarthMelon(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
    {
        for(int i = 0; i<chancesToSpawn; i++)
        {
            int posX = blockXPos + random.nextInt(16);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(16);
            new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), Blocks.dirt).generate(world, random, posX, posY, posZ);
        }
    }

    public void addFireMelon(Block block, World world, Random random, int blockXPos, int blockZPos, int minVeinSize, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
    {
        for(int i = 0; i<chancesToSpawn; i++)
        {
            int posX = blockXPos + random.nextInt(16);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(16);
            new WorldGenMinable(block, (minVeinSize + random.nextInt(maxVeinSize - minVeinSize)), Blocks.lava).generate(world, random, posX, posY, posZ);
        }
    }
}
