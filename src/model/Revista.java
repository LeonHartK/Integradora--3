package model;

import java.util.Date;

public class Revista extends Producto {

	private typeCategory typeCategoria;
	private double subcriptionValue;
	private String issuancePeriodicity;
	private int numberOfSubcriptionActive;

	public Revista(String id, String name, int totPages, Date datePost, String url, typeCategory typeCategoria, double subcriptionValue, String issuancePeriodicity){
		super(id, name, totPages, datePost, url);
		this.typeCategoria = typeCategoria;
		this.subcriptionValue = subcriptionValue;
		this.issuancePeriodicity = issuancePeriodicity;
		this.numberOfSubcriptionActive = 0;
	}

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