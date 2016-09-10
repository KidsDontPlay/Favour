package mrriegel.favour.block;

import java.util.Random;

import mrriegel.favour.particle.ParticleGod;
import mrriegel.limelib.block.CommonBlock;
import mrriegel.limelib.helper.ColorHelper;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BlockThatOre extends CommonBlock {

	public BlockThatOre() {
		super(Material.ROCK, "that");
		setHardness(3F);
		setHarvestLevel("pickaxe", 2);
	}

	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		for (int i = 0; i < 4; ++i) {
			double d0 = pos.getX() + rand.nextFloat();
			double d1 = pos.getY() + rand.nextFloat();
			double d2 = pos.getZ() + rand.nextFloat();
			double d3 = (rand.nextFloat() - 0.5D) * 0.5D * 0;
			double d4 = (rand.nextFloat() - 0.5D) * 0.5D * 2.5;
			double d5 = (rand.nextFloat() - 0.5D) * 0.5D * 0;
			int j = rand.nextInt(2) * 2 - 1;

			// if (worldIn.getBlockState(pos.west()).getBlock() != this &&
			// worldIn.getBlockState(pos.east()).getBlock() != this) {
			// d0 = pos.getX() + 0.5D + 0.25D * j;
			// d3 = rand.nextFloat() * 2.0F * j;
			// } else {
			// d2 = pos.getZ() + 0.5D + 0.25D * j;
			// d5 = rand.nextFloat() * 2.0F * j;
			// }
			// Minecraft.getMinecraft().effectRenderer.addEffect(new
			// ParticleSin(worldIn, d0, d1, d2, d3, d4, d5));
		}
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {

		} else {
			BlockPos start = pos.up();
			BlockPos end = pos.up(1).west(6).north(0);
			final Vec3d ovec = new Vec3d(end.getX() - start.getX(), end.getY() - start.getY(), end.getZ() - start.getZ());
			int amount = (int) (ovec.lengthVector() * 1);
			// amount=0;
			Vec3d toAdd = new Vec3d(ovec.xCoord / amount, ovec.yCoord / amount, ovec.zCoord / amount);
			Vec3d foo = Vec3d.ZERO;
			Random rand = new Random();
			for (int i = 0; i < amount + 1; i++) {
				Minecraft.getMinecraft().effectRenderer.addEffect(new ParticleGod(start.getX() + foo.xCoord + .5, start.getY() + foo.yCoord + .5, start.getZ() + foo.zCoord + .5, ColorHelper.getRGB(EnumDyeColor.LIME)));
				foo = foo.add(toAdd);
			}
		}
		return !super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
	}

}
