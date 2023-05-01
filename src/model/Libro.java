package model;

public class Libro extends Producto {

	private String reseña;
	private typeGenre typeGenre;
	private double saleValue;
	private int numberOfCopiesSold;

	public String getReseña() {
		return this.reseña;
	}

	/**
	 * 
	 * @param reseña
	 */
	public void setReseña(String reseña) {
		this.reseña = reseña;
	}

	public typeGenre getGénero() {
		return this.typeGenre;
	}

	/**
	 * 
	 * @param género
	 */
	public void setGénero(typeGenre género) {
		this.typeGenre = género;
	}

	public double getSaleValue() {
		return this.saleValue;
	}

	/**
	 * 
	 * @param saleValue
	 */
	public void setSaleValue(double saleValue) {
		this.saleValue = saleValue;
	}

	public int getNumberOfCopiesSold() {
		return this.numberOfCopiesSold;
	}

	/**
	 * 
	 * @param numberOfCopiesSold
	 */
	public void setNumberOfCopiesSold(int numberOfCopiesSold) {
		this.numberOfCopiesSold = numberOfCopiesSold;
	}

}