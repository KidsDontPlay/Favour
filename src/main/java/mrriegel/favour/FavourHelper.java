package mrriegel.favour;

import mrriegel.limelib.helper.NBTHelper;
import net.minecraft.entity.player.EntityPlayer;

public class FavourHelper {

	public static int getFavour(EntityPlayer player) {
		return NBTHelper.getInt(player.getEntityData(), "Favour");
	}

	public static void addFavour(EntityPlayer player, int favour) {
		NBTHelper.setInt(player.getEntityData(), "Favour", NBTHelper.getInt(player.getEntityData(), "Favour") + favour);
	}

	public static boolean removeFavour(EntityPlayer player, int favour) {
		if (getFavour(player) < favour)
			return false;
		NBTHelper.setInt(player.getEntityData(), "Favour", NBTHelper.getInt(player.getEntityData(), "Favour") - favour);
		return true;
	}

}
