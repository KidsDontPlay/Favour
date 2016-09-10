package mrriegel.favour.item;

public interface IFavourable<T> {
	
	int receiveFavour(T container, int maxReceive, boolean simulate);

	int extractFavour(T container, int maxExtract, boolean simulate);

	int getFavour(T container);

	int getMaxFavour(T container);
}
