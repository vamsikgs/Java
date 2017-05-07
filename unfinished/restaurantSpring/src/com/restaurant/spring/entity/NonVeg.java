package com.restaurant.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nonveg")
public class NonVeg {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="price")
	private String price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public NonVeg() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "NonVeg [id=" + id + ", itemName=" + itemName + ", price=" + price + "]";
	}
}
