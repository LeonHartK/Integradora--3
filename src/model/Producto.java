package model;

import java.util.Date;

public abstract class Producto {

	private String id;
	private String name;
	private int totPages;
	private Date datePost;
	private String url;
	private int totPagesRead;

	public Producto(String id, String name, int totPages, Date datePost, String url) {
		this.id = id;
		this.name = name;
		this.totPages = totPages;
		this.datePost = datePost;
		this.url = url;
		this.totPagesRead = 0;
	}

	public String getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
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

	public int getTotPages() {
		return this.totPages;
	}

	/**
	 * 
	 * @param totPages
	 */
	public void setTotPages(int totPages) {
		this.totPages = totPages;
	}

	public Date getDatePost() {
		return this.datePost;
	}

	/**
	 * 
	 * @param datePost
	 */
	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

	public String getUrl() {
		return this.url;
	}

	/**
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public int getTotPagesRead() {
		return this.totPagesRead;
	}

	/**
	 * 
	 * @param totPagesRead
	 */
	public void setTotPagesRead(int totPagesRead) {
		this.totPagesRead = totPagesRead;
	}

}