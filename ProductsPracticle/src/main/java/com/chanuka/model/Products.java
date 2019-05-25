package com.chanuka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
 
	@Column(name="Item")
	private String Item;
 
	@Column(name="category")
	private String category;
	
	@Column(name="Price")
	private String Price;

	@Column(name="description")
	private String Description;
	
	@Column(name="country")
	private String Country;

    @Lob
    @Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
    private byte[] image;


	public long getId() {
		return id;
	}

	 public void setId(long id) {
		this.id = id;
	 }

	 public String getItem() {
		return Item;
	 }

	 public void setItem(String Item) {
		 this.Item = Item;
	 }

	 public String getCategory() {
		 return category;
	 }

	 public void setCategory(String category) {
		 this.category = category;
	 }
	 
	public String getPrice() {
		return Price;
	}

	public void setPrice(String Price) {
		this.Price = Price;
	}

	 public String getDescription() {
		 return Description;
	 }

	 public void setDescription(String description) {
		 this.Description = description;
	 }
	 
	public String getCountry() {
		return Country;
	}

	public void setCountry(String Country) {
		this.Country = Country;
	}
}