package mrriegel.favour.particle;

import mrriegel.favour.Favour;
import mrriegel.limelib.helper.ColorHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.util.ResourceLocation;

public class ParticleGod extends Particle {
	public static final ResourceLocation sprite = new ResourceLocation(Favour.MODID + ":particle/godparticle");

	public ParticleGod(double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, int color) {
		super(Minecraft.getMinecraft().theWorld, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
		setParticleTexture(Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(sprite.toString()));
		this.motionX = xSpeedIn;
		this.motionY = ySpeedIn;
		this.motionZ = zSpeedIn;
		// color += this.rand.nextInt(45) - 22;
		this.particleMaxAge = this.rand.nextInt(25) + 5;
		this.particleRed = ColorHelper.getRed(color) / 255f;
		this.particleGreen = ColorHelper.getGreen(color) / 255f;
		this.particleBlue = ColorHelper.getBlue(color) / 255f;
	}

	public ParticleGod(double xCoordIn, double yCoordIn, double zCoordIn, int color) {
		this(xCoordIn, yCoordIn, zCoordIn, 0, 0, 0, color);
	}

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;

		this.moveEntity(this.motionX, this.motionY, this.motionZ);
		double fac = (double) particleAge / (double) particleMaxAge;
		this.motionX *= Math.max(1d - fac, .8);
		this.motionY *= Math.max(1d - fac, .8);
		this.motionZ *= Math.max(1d - fac, .8);
		// TODO
		if (false) {
			this.motionX += (this.rand.nextDouble() - .5) / 70d;
			this.motionY += (this.rand.nextDouble() - .5) / 70d;
			this.motionZ += (this.rand.nextDouble() - .5) / 70d;
		}

		if (this.isCollided) {
			this.motionX *= 0.699999988079071D;
			this.motionZ *= 0.699999988079071D;
		}
		if (this.particleAge++ >= this.particleMaxAge) {
			this.setExpired();
		}
	}

	@Override
	public int getFXLayer() {
		return 1;
	}

	@Override
	public boolean isTransparent() {
		return !super.isTransparent();
	}

	@Override
	public int getBrightnessForRender(float p_189214_1_) {
		return super.getBrightnessForRender(p_189214_1_);
	}

}
