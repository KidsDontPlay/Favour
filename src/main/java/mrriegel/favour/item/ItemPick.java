package mrriegel.favour.item;

import mrriegel.limelib.helper.NBTStackHelper;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemPick extends ItemPickaxe implements IFavourable<ItemStack>{

	protected ItemPick(ToolMaterial material) {
		super(material);
	}

	@Override
	public int receiveFavour(ItemStack container, int maxReceive, boolean simulate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int extractFavour(ItemStack container, int maxExtract, boolean simulate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFavour(ItemStack container) {
		return NBTStackHelper.getInt(container, "Favour");
	}

	@Override
	public int getMaxFavour(ItemStack container) {
		return 1000;
	}

}
