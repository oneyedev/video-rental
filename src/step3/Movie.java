package step3;

import step3.prices.ChildrenMoviePrice;
import step3.prices.NewReleaseMoviePrice;
import step3.prices.RegularMoviePrice;
import step3.prices.UnknownMoviePrice;

public class Movie {
	public static final MoviePrice REGULAR = new RegularMoviePrice();
	public static final MoviePrice NEW_RELEASE = new NewReleaseMoviePrice();
	public static final MoviePrice CHILDRENS = new ChildrenMoviePrice();
	public static final MoviePrice UNKNOWN = new UnknownMoviePrice();
	private static final MoviePrice[] PRICES = {
			new RegularMoviePrice(), 
			new NewReleaseMoviePrice(), 
			new ChildrenMoviePrice()
	};
	
	private String title;
	
	private MoviePrice price;
		
	public Movie(String title, MoviePrice price) {
		this.title = title;
		this.price = price;
	}

	public Movie(String title, int priceCode) {
		this.title = title;
		this.price = getPrice(priceCode);
	}
	
	public static MoviePrice getPrice(int priceCode) {
		return priceCode >= 0 && priceCode < PRICES.length ? PRICES[priceCode] : UNKNOWN;
	}

	public String getTitle() {
		return title;
	}

	double calcPrice(int daysRented) {
		return price.calcPrice(daysRented);
	}

	int calcFrequentRenterPoints(int daysRented) {
		if (price == NEW_RELEASE && daysRented > 1) {
			return 2;
		} else {
			return 1;
		}
	}
}