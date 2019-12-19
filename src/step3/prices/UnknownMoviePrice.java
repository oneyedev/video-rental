package step3.prices;

import step3.MoviePrice;

public class UnknownMoviePrice implements MoviePrice{

	@Override
	public double calcPrice(int daysRented) {
		return 0;
	}

}
