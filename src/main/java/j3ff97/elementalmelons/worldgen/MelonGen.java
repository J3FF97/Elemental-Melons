package j3ff97.elementalmelons.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import j3ff97.elementalmelons.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class MelonGen implements IWorldGenerator
{
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch(world.provider.dimensionId)
        {
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
                break;
        }
    }

        private void generateEnd(World world, Random random, int x, int z)
        {
            addOreSpawn(ModBlocks.blockSkyMelon, world, random, Blocks.air, x, z, 15, 15, 3, 0.01, 148, 149 );
        }

        private void generateSurface(World world, Random random, int x, int z)
        {
            addOreSpawn(ModBlocks.blockWaterMelon, world, random, Blocks.water, x, z, 8, 8, 3, 2, 0, 256);
            addOreSpawn(ModBlocks.blockEarthMelon, world, random, Blocks.stone, x, z, 8, 8, 3, 10, 0, 256);

        }

        private void generateNether(World world, Random random, int x, int z)
        {
            addOreSpawn(ModBlocks.blockFireMelon, world, random, Blocks.netherrack, x, z, 8, 8, 3, 5, 0, 128);
        }

        /**
        * Adds an Ore Spawn to Minecraft. Simply register all Ores to spawn with this method in your Generation method in your IWorldGeneration extending Class
        *
        * @param block Block to spawn
        * @param world World to spawn in
        * @param random Random object for retrieving random positions within the world to spawn the Block
        * @param blockXPos int for passing the X-Coordinate for the Generation method
        * @param blockZPos int for passing the Z-Coordinate for the Generation method
        * @param maxX int for setting the maximum X-Coordinate values for spawning on the X-Axis on a Per-Chunk basis
        * @param maxZ int for setting the maximum Z-Coordinate values for spawning on the Z-Axis on a Per-Chunk basis
        * @param maxVeinSize int for setting the maximum size of a vein
        * @param chancesToSpawn int for the Number of chances available for the Block to spawn per-chunk
        * @param minY int for the minimum Y-Coordinate height at which this block may spawn
        * @param maxY int for the maximum Y-Coordinate height at which this block may spawn
        **/

        public void addOreSpawn(Block block, World world, Random random, Block target, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, double chancesToSpawn, int minY, int maxY)
        {
            assert maxY > minY : "The maximum Y must be greater than the Minimum Y";
            assert maxX > 0 && maxX <= 16 : "addOreSpawn: The Maximum X must be greater than 0 and less than 16";
            assert minY > 0 : "addOreSpawn: The Minimum Y must be greater than 0";
            assert maxY < 256 && maxY > 0 : "addOreSpawn: The Maximum Y must be less than 256 but greater than 0";
            assert maxZ > 0 && maxZ <= 16 : "addOreSpawn: The Maximum Z must be greater than 0 and less than 16";

            int diffBtwnMinMaxY = maxY - minY;
            for (int x = 0; x < chancesToSpawn; x++)
            {
                int posX = blockXPos + random.nextInt(maxX);
                int posY = minY + random.nextInt(diffBtwnMinMaxY);
                int posZ = blockZPos + random.nextInt(maxZ);
                (new WorldGenMinable(block, maxVeinSize, target)).generate(world, random, posX, posY, posZ);
            }
        }

    }




