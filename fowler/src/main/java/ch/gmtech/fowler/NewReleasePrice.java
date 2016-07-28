package ch.gmtech.fowler;

public class NewReleasePrice extends Price {

	@Override
	public int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

	public double getCharge(int daysRented) {
		int result = 0;
		result += daysRented * 3;
		return result;
	}
	
	public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2: 1;
  }
}
