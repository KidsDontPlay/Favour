package mrriegel.favour.init;

import mrriegel.favour.block.BlockThatOre;
import mrriegel.limelib.block.CommonBlock;

public class ModBlocks {

	public static final CommonBlock that = new BlockThatOre();

	public static void init() {
		that.registerBlock();
	}

	public static void initClient() {
		that.initModel();
	}

}
