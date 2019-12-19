package step3.prices;

import step3.MoviePrice;

public class ChildrenMoviePrice implements MoviePrice{

	@Override
	public double calcPrice(int daysRented) {
		double price = 0;
		price += 1.5;
		if (daysRented > 3)
			price += (daysRented - 3) * 1.5;
		return price;
	}
}
