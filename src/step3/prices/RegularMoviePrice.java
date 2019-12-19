package step3.prices;

import step3.MoviePrice;

public class RegularMoviePrice implements MoviePrice{

	@Override
	public double calcPrice(int daysRented) {
		double price = 2;		
		if (daysRented > 2)
			price += (daysRented - 2) * 1.5;
		return price;
	}
}
