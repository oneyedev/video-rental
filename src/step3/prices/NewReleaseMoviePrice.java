package step3.prices;

import step3.MoviePrice;

public class NewReleaseMoviePrice implements MoviePrice{

	@Override
	public double calcPrice(int daysRented) {
		return daysRented * 3;
	}

}
