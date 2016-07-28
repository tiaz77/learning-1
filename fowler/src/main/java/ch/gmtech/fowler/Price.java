package ch.gmtech.fowler;

public abstract class Price {
	
	public abstract int getPriceCode();
	
	public abstract double getCharge(int daysRented);
	
	/**
	 * @param daysRented  
	 */
	public int getFrequentRenterPoints(int daysRented){
        return 1;
    }
	
}