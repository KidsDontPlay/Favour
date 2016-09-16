package mrriegel.favour.init;

import mrriegel.favour.block.BlockPipe;
import mrriegel.favour.block.BlockThatOre;
import mrriegel.limelib.block.CommonBlock;

public class ModBlocks {

	public static final CommonBlock that = new BlockThatOre();
	public static final CommonBlock pipe = new BlockPipe();

	public static void init() {
		that.registerBlock();
		pipe.registerBlock();
	}

	public static void initClient() {
		that.initModel();
		pipe.initModel();
	}

}
