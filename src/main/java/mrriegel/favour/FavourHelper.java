package mrriegel.favour;

import java.util.Map;

import mrriegel.limelib.helper.NBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.google.common.collect.Maps;

public class FavourHelper {

	public enum Favour {
		GODFAVOUR("GodFavour"), DEMONFAVOUR("DemonFavour"), GAIAFAVOUR("GaiaFavour");

		String ID;

		private Favour(String id) {
			this.ID = id;
		}

		public String getID() {
			return ID;
		}

	}

	public static Map<Item, Integer> oreValues;

	public static void init() {
		fillOres();
	}

	private static void fillOres() {
		oreValues = Maps.newHashMap();
		oreValues.put(Items.IRON_INGOT, 100);
		oreValues.put(Items.GOLD_INGOT, 400);
		oreValues.put(Items.DIAMOND, 2000);
		oreValues.put(Items.EMERALD, 2500);
		for (ItemStack stack : OreDictionary.getOres("ingotCopper"))
			oreValues.put(stack.getItem(), 60);
		for (ItemStack stack : OreDictionary.getOres("ingotTin"))
			oreValues.put(stack.getItem(), 80);
		for (ItemStack stack : OreDictionary.getOres("ingotSteel"))
			oreValues.put(stack.getItem(), 350);
		for (ItemStack stack : OreDictionary.getOres("ingotSilver"))
			oreValues.put(stack.getItem(), 300);
		for (ItemStack stack : OreDictionary.getOres("ingotElectrum"))
			oreValues.put(stack.getItem(), 350);
	}

	public static int getFavour(EntityPlayer player, Favour f) {
		return NBTHelper.getInt(player.getEntityData(), f.ID);
	}

	public static void addFavour(EntityPlayer player, int favour, Favour f) {
		NBTHelper.setInt(player.getEntityData(), f.ID, NBTHelper.getInt(player.getEntityData(), "Favour") + favour);
	}

	public static boolean removeFavour(EntityPlayer player, int favour, Favour f) {
		if (getFavour(player, f) < favour)
			return false;
		NBTHelper.setInt(player.getEntityData(), f.ID, NBTHelper.getInt(player.getEntityData(), "Favour") - favour);
		return true;
	}

	public static boolean canInteract(EntityPlayer player) {
		return player != null && !player.worldObj.isRemote && !player.capabilities.isCreativeMode;
	}

}
