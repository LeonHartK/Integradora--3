package model;

import java.util.Date;

public abstract class User {

	private String name;
	private String cedula;
	private Date bindingDate;

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

}