package step2;

import java.util.ArrayList;
import java.util.List;

class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	};

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	};

	public String statement() {
		String result = getHeader();
		result += getBody();
		result += getFooter();
		return result;
	}

	private String getHeader() {
		return "Rental Record for " + getName() + "\n";
	}

	private String getBody() {
		String result = "";
		for (Rental rental : rentals) {
			result += String.format("\t%s(%s)\n", rental.calcPrice(), rental.getMovie().getTitle());
		}
		return result;
	}

	private String getFooter() {
		String result = "";
		result += "Amount owed is " + caclTotalPrice() + "\n";
		result += "You earned " + calcTotalFrequentRenterPoints() + " frequent renter pointers";
		return result;
	}

	private double caclTotalPrice() {
		double totalPrice = 0;
		for (Rental rental : rentals) {
			totalPrice += rental.calcPrice();
		}
		return totalPrice;
	}

	private int calcTotalFrequentRenterPoints() {
		int totalFrequentRenterPoints = 0;
		for (Rental rental : rentals) {
			totalFrequentRenterPoints += rental.calcFrequentRenterPoints();
		}
		return totalFrequentRenterPoints;
	}

}