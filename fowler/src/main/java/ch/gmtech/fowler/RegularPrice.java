package ch.gmtech.fowler;

public class RegularPrice extends Price {

	@Override
	public int getPriceCode() {
		return Movie.REGULAR;
	}
	
	public double getCharge(int daysRented) {
		int result = 2;
		if (daysRented > 2) result += (daysRented- 2) * 1.5;
		return result;
	}
}
