package com.mindtree.mobileShops;

public class Mobile {
	private int id;
	private String name;
	private float rating;
	private float price;

	public Mobile() {

	}

	public Mobile(int id, String name, float rating, float price) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", name=" + name + ", rating=" + rating + ", price=" + price + "]";
	}

}
