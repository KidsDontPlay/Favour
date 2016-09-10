package mrriegel.favour.block;

import java.util.Random;

import mrriegel.favour.FavourHelper;
import mrriegel.favour.particle.ParticleSin;
import mrriegel.limelib.block.CommonBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
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
			double d3 = (rand.nextFloat() - 0.5D) * 0.5D*0;
			double d4 = (rand.nextFloat() - 0.5D) * 0.5D*2.5;
			double d5 = (rand.nextFloat() - 0.5D) * 0.5D*0;
			int j = rand.nextInt(2) * 2 - 1;

//			if (worldIn.getBlockState(pos.west()).getBlock() != this && worldIn.getBlockState(pos.east()).getBlock() != this) {
//				d0 = pos.getX() + 0.5D + 0.25D * j;
//				d3 = rand.nextFloat() * 2.0F * j;
//			} else {
//				d2 = pos.getZ() + 0.5D + 0.25D * j;
//				d5 = rand.nextFloat() * 2.0F * j;
//			}
			Minecraft.getMinecraft().effectRenderer.addEffect(new ParticleSin(worldIn, d0, d1, d2, d3, d4, d5));
}
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote){
			new Exception().printStackTrace();
		}return !super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
	}

}
