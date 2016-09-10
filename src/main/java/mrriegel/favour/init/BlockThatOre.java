package mrriegel.favour.init;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import mrriegel.limelib.block.CommonBlock;

public class BlockThatOre extends CommonBlock {

	public BlockThatOre() {
		super(Material.ROCK, "that");
		setHardness(3F);
		setHarvestLevel("pickaxe", 2);
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.SOLID;
	}

}
