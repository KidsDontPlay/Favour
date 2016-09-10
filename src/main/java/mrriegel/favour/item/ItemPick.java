package mrriegel.favour.item;

import mrriegel.favour.FavourHelper.Favour;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemPick extends ItemPickaxe implements IFavourable<ItemStack> {

	protected ItemPick(ToolMaterial material) {
		super(material);
	}

	@Override
	public int receiveFavour(ItemStack container, int maxReceive, boolean simulate, Favour f) {
		return 0;
	}

	@Override
	public int extractFavour(ItemStack container, int maxExtract, boolean simulate, Favour f) {
		return 0;
	}

	@Override
	public int getFavour(ItemStack container, Favour f) {
		return 0;
	}

	@Override
	public int getMaxFavour(ItemStack container, Favour f) {
		return 0;
	}

}
