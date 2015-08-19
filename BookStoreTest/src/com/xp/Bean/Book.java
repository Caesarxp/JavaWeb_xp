package com.xp.Bean;

import java.io.Serializable;

public class Book implements Serializable{//可序列化的接口
	private String id;
	private String ISBN;
	private String name;
	private String author;
	private float price;
	private String description;
	
	public Book(){//??classForname
		
	}
	public Book(String id, String iSBN, String name, String author,
			float price, String description) {
		super();
		this.id = id;
		ISBN = iSBN;
		this.name = name;
		this.author = author;
		this.price = price;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
