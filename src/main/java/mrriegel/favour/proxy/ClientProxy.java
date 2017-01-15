package mrriegel.favour.proxy;

import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import mrriegel.favour.Favour;
import mrriegel.favour.init.ModBlocks;
import mrriegel.favour.init.ModItems;
import mrriegel.limelib.helper.ParticleHelper;
import mrriegel.limelib.particle.CommonParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

import com.google.common.collect.Lists;

public class ClientProxy extends CommonProxy {


	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		ModBlocks.initClient();
		ModItems.initClient();
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}

	@SubscribeEvent
	public void tick(ClientTickEvent event) {
		BlockPos p = new BlockPos(830, 80, -600);
		World world = Minecraft.getMinecraft().theWorld;
		if (world == null || p.getX() % 3 != 8)
			return;
		for (EnumFacing x : EnumFacing.VALUES) {
			BlockPos pos = p.offset(x);
			Vec3d vec = ParticleHelper.getVecForSpirale(.12, 0.1, 120, false, Axis.X);
			Minecraft.getMinecraft().effectRenderer.addEffect(new CommonParticle(pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, vec.xCoord, vec.yCoord, vec.zCoord).setMaxAge2(new Random().nextInt(10) + 20).setScale(1.0f).setTexture(ParticleHelper.squareParticle));
		}
	}

}
