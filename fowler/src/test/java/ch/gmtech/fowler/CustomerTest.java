package ch.gmtech.fowler;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void statementReturnsNameTitleAmount() {
		Customer customer = new Customer("tizio");
		customer.addRental(new Rental(new Movie("title", new RegularPrice()), 2));
		customer.addRental(new Rental(new Movie("title2", new ChildrensPrice()), 1));
		
		String statement = customer.statement();
		
		assertTrue(statement.contains("tizio"));
		assertTrue(statement.contains("title"));
		assertTrue("wrong price: " + statement,statement.contains("2"));
		
		assertTrue(statement.contains("title2"));
		assertTrue(statement.contains("1"));
		
		assertTrue("wrong total: " + statement, statement.contains("3.5"));
	}

}