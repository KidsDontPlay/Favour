package mrriegel.favour.handler;

import mrriegel.favour.FavourHelper;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FavourEventHandler {

	@SubscribeEvent
	public void damage(LivingAttackEvent event) {
		if (event.getSource().getEntity() instanceof EntityPlayer && event.getEntityLiving() instanceof IMob) {
			EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
			if (FavourHelper.canInteract(player)) {
				FavourHelper.addGodFavour(player, (int) event.getAmount());
				System.out.println("p: " + player.motionX + " " + player.motionZ);
			}
		}
	}

	@SubscribeEvent
	public void damage(LivingDeathEvent event) {
		if (event.getSource().getEntity() instanceof EntityPlayer && event.getEntityLiving() instanceof IMob) {
			EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
			if (FavourHelper.canInteract(player)) {
				FavourHelper.addGodFavour(player, (int) (event.getEntityLiving().getMaxHealth() / (event.getEntityLiving().isNonBoss() ? 3F : 1.5F)));
			}
		}
	}
	
	@SubscribeEvent
	public void damage(BreakEvent event) {
		
	}
}
