package mrriegel.favour.block;

import java.util.List;

import javax.annotation.Nullable;

import mrriegel.limelib.block.CommonBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPipe extends CommonBlock {

	public static final IProperty<Connect> NORTH = PropertyEnum.<Connect> create("north", Connect.class);
	public static final IProperty<Connect> SOUTH = PropertyEnum.<Connect> create("south", Connect.class);
	public static final IProperty<Connect> WEST = PropertyEnum.<Connect> create("west", Connect.class);
	public static final IProperty<Connect> EAST = PropertyEnum.<Connect> create("east", Connect.class);
	public static final IProperty<Connect> UP = PropertyEnum.<Connect> create("up", Connect.class);
	public static final IProperty<Connect> DOWN = PropertyEnum.<Connect> create("down", Connect.class);

	public BlockPipe() {
		super(Material.IRON, "pipe");
		setCreativeTab(CreativeTabs.TRANSPORTATION);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		// if (getConnect(worldIn, pos, side) != Connect.NULL)
		// return false;
		System.out.println("default: "+shouldSideBeRendered(blockState, worldIn, pos, side));
		return true;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState blockState) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean canRenderInLayer(BlockRenderLayer layer) {
		return layer == BlockRenderLayer.CUTOUT || layer == BlockRenderLayer.TRANSLUCENT;
	}

	@Override
	public boolean isTranslucent(IBlockState state) {
		return true;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, NORTH, SOUTH, WEST, EAST, UP, DOWN);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return state.withProperty(NORTH, getConnect(worldIn, pos, EnumFacing.NORTH)).withProperty(SOUTH, getConnect(worldIn, pos, EnumFacing.SOUTH)).withProperty(WEST, getConnect(worldIn, pos, EnumFacing.WEST)).withProperty(EAST, getConnect(worldIn, pos, EnumFacing.EAST)).withProperty(UP, getConnect(worldIn, pos, EnumFacing.UP)).withProperty(DOWN, getConnect(worldIn, pos, EnumFacing.DOWN));
	}

	protected Connect getConnect(IBlockAccess worldIn, BlockPos pos, EnumFacing facing) {
		if (worldIn.getBlockState(pos.offset(facing)).getBlock() instanceof BlockPipe)
			return Connect.PIPE;
		// else if (InvHelper.hasItemHandler(worldIn, pos.offset(facing),
		// facing.getOpposite()))
		else if ( worldIn.getTileEntity(pos.offset(facing)) != null)
			return Connect.TILE;
		return Connect.NULL;
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn) {
		state = state.getActualState(worldIn, pos);
		addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.3125, 0.3125, 0.3125, 0.6875, 0.6875, 0.6875));
		if (state.getValue(DOWN) != Connect.NULL)
			addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.3125, 0.0, 0.3125, 0.6875, 0.3125, 0.6875));
		if (state.getValue(UP) != Connect.NULL)
			addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.3125, 0.6875, 0.3125, 0.6875, 1, 0.6875));
		if (state.getValue(WEST) != Connect.NULL)
			addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.0, 0.3125, 0.3125, 0.3125, 0.6875, 0.6875));
		if (state.getValue(EAST) != Connect.NULL)
			addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.6875, 0.3125, 0.3125, 1, 0.6875, 0.6875));
		if (state.getValue(NORTH) != Connect.NULL)
			addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.3125, 0.3125, 0, 0.6875, 0.6875, 0.3125));
		if (state.getValue(SOUTH) != Connect.NULL)
			addCollisionBoxToList(pos, entityBox, collidingBoxes, new AxisAlignedBB(0.3125, 0.3125, 0.6875, 0.6875, 0.6875, 1));
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		state = state.getActualState(source, pos);
		double f = 0.3125;
		double f1 = 0.6875;
		double f2 = 0.3125;
		double f3 = 0.6875;
		double f4 = 0.3125;
		double f5 = 0.6875;
		if (state.getValue(NORTH) != Connect.NULL)
			f2 = 0;
		if (state.getValue(SOUTH) != Connect.NULL)
			f3 = 1;
		if (state.getValue(WEST) != Connect.NULL)
			f = 0;
		if (state.getValue(EAST) != Connect.NULL)
			f1 = 1;
		if (state.getValue(DOWN) != Connect.NULL)
			f4 = 0;
		if (state.getValue(UP) != Connect.NULL)
			f5 = 1;
		return new AxisAlignedBB(f, f4, f2, f1, f5, f3);
	}

	public static enum Connect implements IStringSerializable {
		NULL("null"), PIPE("pipe"), TILE("tile");
		String name;

		private Connect(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}
	}

}
