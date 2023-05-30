package model;

import java.util.Date;

public abstract class User {

	private String name;
	private String cedula;
	private Date bindingDate;

	public User(String name, String id, Date bindingDate) {
		this.name = name;
		this.cedula = id;
		this.bindingDate = bindingDate;
	}

	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	public String getCedula() {
		return this.cedula;
	}

	/**
	 * 
	 * @param cedula
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Date getBindingDate() {
		return this.bindingDate;
	}

	/**
	 * 
	 * @param bindingDate
	 */
	public void setBindingDate(Date bindingDate) {
		this.bindingDate = bindingDate;
	}

	public String buyBook(Producto libro) {
		return null;
	}

	public String suscripcion(Producto revista) {
		return null;
	}

	public boolean searchProduct(String id) {
		return false;
	}

	public String seeProducts() {
		return null;
	}
}