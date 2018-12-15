package com.bookstore;

public class Book {
	private String title;
	private String author;
	private float price;
	private Integer id;
	private static Integer counter=0;
	
	
	/**
	 * @param title
	 * @param author
	 * @param price
	 */
	public Book(String title, String author, float price) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.id = ++counter;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

}
