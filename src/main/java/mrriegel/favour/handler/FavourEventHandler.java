package mrriegel.favour.handler;

import mrriegel.favour.FavourHelper;
import mrriegel.favour.FavourHelper.Favour;
import mrriegel.limelib.helper.InvHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FavourEventHandler {

	@SubscribeEvent
	public void damage(LivingAttackEvent event) {
		if (event.getSource().getEntity() instanceof EntityPlayer && event.getEntityLiving() instanceof IMob) {
			EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
			if (FavourHelper.canInteract(player)) {
				FavourHelper.addFavour(player, (int) event.getAmount(), Favour.GODFAVOUR);
			}
		}
	}

	@SubscribeEvent
	public void damage(LivingDeathEvent event) {
		if (event.getSource().getEntity() instanceof EntityPlayer && event.getEntityLiving() instanceof IMob) {
			EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
			if (FavourHelper.canInteract(player)) {
				FavourHelper.addFavour(player, (int) (event.getEntityLiving().getMaxHealth() / (event.getEntityLiving().isNonBoss() ? 3F : 1.5F)), Favour.GODFAVOUR);
			}
		}
	}

	@SubscribeEvent
	public void damage(BreakEvent event) {

	}

	@SubscribeEvent
	public void click(RightClickBlock event) {
//		if (InvHelper.hasItemHandler(event.getWorld(), event.getPos(), event.getFace()))
//			System.out.println(InvHelper.getItemHandler(event.getWorld(), event.getPos(), event.getFace()).getStackInSlot(0));
	}
	
	@SubscribeEvent
	public void update(LivingUpdateEvent event){
		EntityLivingBase entity=event.getEntityLiving();
		if(!entity.worldObj.isRemote){
			entity.posX=entity.lastTickPosX;
			entity.posY=entity.lastTickPosY;
			entity.posZ=entity.lastTickPosZ;
//			entity.lastTickPosX;
		}
	}
	
	@SubscribeEvent
	public void hurt(LivingHurtEvent event){
		if(!event.getEntityLiving().worldObj.isRemote&&event.getEntityLiving() instanceof EntityPlayer){
			event.setAmount(0);
		}
	}
}
