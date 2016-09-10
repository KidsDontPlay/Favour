package mrriegel.favour.handler;

import java.util.Random;

import mrriegel.favour.init.ModBlocks;
import mrriegel.limelib.helper.WorldHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldHandler implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		int dimension = world.provider.getDimension();
		if (dimension != -1 && dimension != 1) {
			if (world.getWorldType() != WorldType.FLAT) {
//				System.out.println("gen");
				new WorldHelper().addOreSpawn(ModBlocks.that.getDefaultState(), world, 10, 4 + world.rand.nextInt(3), chunkX, chunkZ, 0, 258);
			}
		}

	}

}
