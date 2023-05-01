package model;

public class Revista extends Producto {

	private typeCategory typeCategoria;
	private double subcriptionValue;
	private String issuancePeriodicity;
	private int numberOfSubcriptionActive;

	public typeCategory getCategoria() {
		// TODO - implement Revista.getCategoria
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Categoria
	 */
	public void setCategoria(typeCategory Categoria) {
		// TODO - implement Revista.setCategoria
		throw new UnsupportedOperationException();
	}

	public double getSubcriptionValue() {
		return this.subcriptionValue;
	}

	/**
	 * 
	 * @param subcriptionValue
	 */
	public void setSubcriptionValue(double subcriptionValue) {
		this.subcriptionValue = subcriptionValue;
	}

	public String getIssuancePeriodicity() {
		return this.issuancePeriodicity;
	}

	/**
	 * 
	 * @param issuancePeriodicity
	 */
	public void setIssuancePeriodicity(String issuancePeriodicity) {
		this.issuancePeriodicity = issuancePeriodicity;
	}

	public int getNumberOfSubcriptionActive() {
		return this.numberOfSubcriptionActive;
	}

	/**
	 * 
	 * @param numberOfSubcriptionActive
	 */
	public void setNumberOfSubcriptionActive(int numberOfSubcriptionActive) {
		this.numberOfSubcriptionActive = numberOfSubcriptionActive;
	}

}