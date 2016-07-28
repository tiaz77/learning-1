package ch.gmtech.fowler;

import java.util.Vector;

class Customer {

	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		String result = "Rental Record for " + getName() + "\n";

		for (Rental rental : _rentals) {
			result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
		}

		result += "Amount owed is " + String.valueOf(totalCharge()) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints()) + " frequent renter points";

		return result;
	}
	
	public String htmlStatement() {
		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
		
		for (Rental rental : _rentals) {
			result += "\t" + rental.getMovie().getTitle() + ": " + String.valueOf(rental.getCharge()) + "<BR>\n";
		}
		
		result += "<P>You owe <EM>" + String.valueOf(totalCharge()) + "</EM><P>\n";
		result += "On this rental you earned <EM>" + String.valueOf(frequentRenterPoints())
				+ "</EM> frequent renter points<P>";
		
		return result;
	}
	
	private double totalCharge() {
		double totalAmount = 0;
		
		for (Rental rental : _rentals) {
			totalAmount += rental.getCharge();
		}
		
		return totalAmount;
	}


	private int frequentRenterPoints() {
		int result = 0;

		for (Rental rental : _rentals) {
			result += rental.getFrequentRenterPoints();
		}

		return result;
	}
}