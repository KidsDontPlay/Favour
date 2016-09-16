package mrriegel.favour.block;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import mrriegel.favour.proxy.ClientProxy;
import mrriegel.limelib.block.CommonBlock;
import mrriegel.limelib.helper.ParticleHelper;
import mrriegel.limelib.particle.CommonParticle;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class BlockThatOre extends CommonBlock {

	public BlockThatOre() {
		super(Material.ROCK, "that");
		setHardness(3F);
		setHarvestLevel("pickaxe", 2);
	}

	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		pos = pos.up();
		// for (Vec3d vec : ParticleHelper.getVecsForCircle(pos, .34, 14.4,
		// Axis.Y)) {
		// Minecraft.getMinecraft().effectRenderer.addEffect(new
		// ParticleGod(pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5,
		// vec.xCoord - (pos.getX() + .5), vec.yCoord - (pos.getY() + .5),
		// vec.zCoord - (pos.getZ() + .5)).setMaxAge2(new Random().nextInt(30) +
		// 10).setColor(ColorHelper.getRGB(EnumDyeColor.WHITE),
		// 0).setFlouncing(.004));
		// }

	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			EntityItem ei = new EntityItem(worldIn);
			ei.setEntityItemStack(new ItemStack(Blocks.EMERALD_BLOCK));
			// boolean s = WorldHelper.spawnInRange(new
			// EntityTNTPrimed(worldIn),
			// worldIn, pos, 6);
			pos = pos.up();
		} else {
			// for (Vec3d vec : ParticleHelper.getVecsForCircle(pos, 2.44, 4.4,
			// Axis.Y))
			// Minecraft.getMinecraft().effectRenderer.addEffect(new
			// ParticleGod(vec.xCoord, vec.yCoord, vec.zCoord).setMaxAge2(new
			// Random().nextInt(30) +
			// 10).setColor(ColorHelper.getRGB(EnumDyeColor.ORANGE),
			// 0).setFlouncing(.004));

			// for (Vec3d vec : ParticleHelper.getVecsForLine(pos,
			// pos.up(10).east().south(), 7.5))
			// Minecraft.getMinecraft().effectRenderer.addEffect(new
			// ParticleGod(vec.xCoord, vec.yCoord, vec.zCoord).setMaxAge2(new
			// Random().nextInt(20) +
			// 5).setColor(ColorHelper.getRGB(EnumDyeColor.PURPLE),
			// 0).setFlouncing(.04));
			pos = pos.up();
			for (Vec3d vec : ParticleHelper.getVecsForExplosion(pos, .54, 84.4, Axis.Y)) {
				Minecraft.getMinecraft().effectRenderer.addEffect(new CommonParticle(pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, vec.xCoord, vec.yCoord, vec.zCoord).setMaxAge2(40).setFlouncing(.009).setTexture(ClientProxy.roundParticle).setNoClip(true));
			}

			// for (Vec3d vec : ParticleHelper.getVecsForExplosion(pos, .34,
			// 14.4, Axis.X)) {
			// Minecraft.getMinecraft().effectRenderer.addEffect(new
			// CommonParticle(pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5,
			// vec.xCoord, vec.yCoord, vec.zCoord).setMaxAge2(new
			// Random().nextInt(30) +
			// 10).setFlouncing(.004).setTexture(ClientProxy.roundParticle));
			// }
			//
			// for (Vec3d vec : ParticleHelper.getVecsForExplosion(pos, .34,
			// 14.4, Axis.Z)) {
			// Minecraft.getMinecraft().effectRenderer.addEffect(new
			// CommonParticle(pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5,
			// vec.xCoord, vec.yCoord, vec.zCoord).setMaxAge2(new
			// Random().nextInt(30) +
			// 10).setFlouncing(.004).setTexture(ClientProxy.roundParticle));
			// }

		}
		return !super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
	}

}
