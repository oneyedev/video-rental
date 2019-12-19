package step1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {

	Customer customer = new Customer("홍길동");
	String title = "영화";
	
	@Test
	public void 대여한게_없을_경우_대여료는_0달러_적립포인트도_0점이다() {
		// when
		String statement = customer.statement();
		
		// then
		assertEquals("Rental Record for 홍길동\n" + 
				"Amount owed is 0.0\n" + 
				"You earned 0 frequent renter pointers", statement);
	}
	
	@Test
	public void 일반_비디오_1개를_3일_대여했을_경우_대여료는_3점5달러_적립포인트는_1점이다() {
		// given
		customer.addRental(new Rental(new Movie(title, Movie.REGULAR), 3));
		
		// when
		String statement = customer.statement();
		
		// then
		assertEquals("Rental Record for 홍길동\n" + 
				"	3.5(영화)\n" + 
				"Amount owed is 3.5\n" + 
				"You earned 1 frequent renter pointers", statement);
	}
	
	@Test
	public void 일반_비디오_1개를_2일_대여했을_경우_대여료는_2달러_적립포인트는_1점이다() {
		// given
		customer.addRental(new Rental(new Movie(title, Movie.REGULAR), 2));
		
		// when
		String statement = customer.statement();
		
		// then
		assertEquals("Rental Record for 홍길동\n" + 
				"	2.0(영화)\n" + 
				"Amount owed is 2.0\n" + 
				"You earned 1 frequent renter pointers", statement);
	}
	
	@Test
	public void 신작_비디오_1개를_2일_대여했을_경우_대여료는_6달러_적립포인트는_2점이다() {
		// given
		customer.addRental(new Rental(new Movie(title, Movie.NEW_RELEASE), 2));
		
		// when
		String statement = customer.statement();
		
		// then
		assertEquals("Rental Record for 홍길동\n" + 
				"	6.0(영화)\n" + 
				"Amount owed is 6.0\n" + 
				"You earned 2 frequent renter pointers", statement);
	}
	
	@Test
	public void 신작_비디오_1개를_1일_대여했을_경우_대여료는_3달러_적립포인트는_1점이다() {
		// given
		customer.addRental(new Rental(new Movie(title, Movie.NEW_RELEASE), 1));
		
		// when
		String statement = customer.statement();
		
		// then
		assertEquals("Rental Record for 홍길동\n" + 
				"	3.0(영화)\n" + 
				"Amount owed is 3.0\n" + 
				"You earned 1 frequent renter pointers", statement);
	}
	
	@Test
	public void 유아_비디오_1개를_4일_대여했을_경우_대여료는_3달러_적립포인트는_1점이다() {
		// given
		customer.addRental(new Rental(new Movie(title, Movie.CHILDRENS), 4));
		
		// when
		String statement = customer.statement();
		
		// then
		assertEquals("Rental Record for 홍길동\n" + 
				"	3.0(영화)\n" + 
				"Amount owed is 3.0\n" + 
				"You earned 1 frequent renter pointers", statement);
	}
	
	@Test
	public void 유아_비디오_1개를_3일_대여했을_경우_대여료는_1점5달러_적립포인트는_1점이다() {
		// given
		customer.addRental(new Rental(new Movie(title, Movie.CHILDRENS), 3));
		
		// when
		String statement = customer.statement();
		
		// then
		assertEquals("Rental Record for 홍길동\n" + 
				"	1.5(영화)\n" + 
				"Amount owed is 1.5\n" + 
				"You earned 1 frequent renter pointers", statement);
	}
	
	@Test
	public void 알_수_없는_비디오_1개를_3일_대여했을_경우_대여료는_0달러_적립포인트는_1점이다() {
		// given
		customer.addRental(new Rental(new Movie(title, 4), 4));
		
		// when
		String statement = customer.statement();
		
		// then
		assertEquals("Rental Record for 홍길동\n" + 
				"	0.0(영화)\n" + 
				"Amount owed is 0.0\n" + 
				"You earned 1 frequent renter pointers", statement);
	}
	
	@Test
	public void 일반_신작_유아_비디오를_각각_1개_총_3개를_3일씩_대여했을_경우_대여료는_14달러_적립포인트는_4점이다() {
		// given
		customer.addRental(new Rental(new Movie(title, Movie.REGULAR), 3));
		customer.addRental(new Rental(new Movie(title, Movie.NEW_RELEASE), 3));
		customer.addRental(new Rental(new Movie(title, Movie.CHILDRENS), 3));
		
		// when
		String statement = customer.statement();
		
		// then
		assertEquals("Rental Record for 홍길동\n" + 
				"	3.5(영화)\n" + 
				"	9.0(영화)\n" + 
				"	1.5(영화)\n" + 
				"Amount owed is 14.0\n" + 
				"You earned 4 frequent renter pointers", statement);
	}
}
