package step2;

class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	double calcPrice() {
		return movie.calcPrice(getDaysRented());
	}

	int calcFrequentRenterPoints() {
		return movie.calcFrequentRenterPoints(getDaysRented());
	}
}