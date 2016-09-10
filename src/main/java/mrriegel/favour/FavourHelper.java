package mrriegel.favour;

import java.util.Map;

import com.google.common.collect.Maps;

import mrriegel.limelib.helper.NBTHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class FavourHelper {

	public static final String GODFAVOUR = "GodFavour";
	public static final String DEMONFAVOUR = "DemonFavour";
	public static final String GAIAFAVOUR = "GaiaFavour";

	public static Map<Item, Integer> oreValues;

	public static void init() {
		fillOres();
	}

	private static void fillOres() {
		oreValues=Maps.newHashMap();
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

	public static int getGodFavour(EntityPlayer player) {
		return NBTHelper.getInt(player.getEntityData(), GODFAVOUR);
	}

	public static void addGodFavour(EntityPlayer player, int favour) {
		NBTHelper.setInt(player.getEntityData(), GODFAVOUR, NBTHelper.getInt(player.getEntityData(), "Favour") + favour);
	}

	public static boolean removeGodFavour(EntityPlayer player, int favour) {
		if (getGodFavour(player) < favour)
			return false;
		NBTHelper.setInt(player.getEntityData(), GODFAVOUR, NBTHelper.getInt(player.getEntityData(), "Favour") - favour);
		return true;
	}

	public static int getDemonFavour(EntityPlayer player) {
		return NBTHelper.getInt(player.getEntityData(), DEMONFAVOUR);
	}

	public static void addDemonFavour(EntityPlayer player, int favour) {
		NBTHelper.setInt(player.getEntityData(), DEMONFAVOUR, NBTHelper.getInt(player.getEntityData(), "Favour") + favour);
	}

	public static boolean removeDemonFavour(EntityPlayer player, int favour) {
		if (getGodFavour(player) < favour)
			return false;
		NBTHelper.setInt(player.getEntityData(), DEMONFAVOUR, NBTHelper.getInt(player.getEntityData(), "Favour") - favour);
		return true;
	}

	public static boolean canInteract(EntityPlayer player) {
		return player != null && !player.worldObj.isRemote && !player.capabilities.isCreativeMode;
	}

}
