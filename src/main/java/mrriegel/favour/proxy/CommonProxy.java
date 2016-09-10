package mrriegel.favour.proxy;

import mrriegel.favour.Favour;
import mrriegel.favour.handler.GuiHandler;
import mrriegel.favour.handler.WorldHandler;
import mrriegel.favour.init.ModBlocks;
import mrriegel.favour.init.ModItems;
import mrriegel.limelib.helper.IProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy implements IProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		ModItems.init();
		ModBlocks.init();
		GameRegistry.registerWorldGenerator(new WorldHandler(), 16);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		NetworkRegistry.INSTANCE.registerGuiHandler(Favour.instance, new GuiHandler());
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {

}

}
