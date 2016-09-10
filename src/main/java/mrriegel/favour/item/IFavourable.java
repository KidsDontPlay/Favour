package mrriegel.favour.item;

import mrriegel.favour.FavourHelper.Favour;

public interface IFavourable<T> {

	int receiveFavour(T container, int maxReceive, boolean simulate, Favour f);

	int extractFavour(T container, int maxExtract, boolean simulate, Favour f);

	int getFavour(T container, Favour f);

	int getMaxFavour(T container, Favour f);
}
