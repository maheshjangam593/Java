package com.mindtree.mobileShop.entity;

public class Mobile {
	private Company company;
	private int mobileId;
	private String model;
	private float rating;
	private double price;

	public Mobile() {

	}

	public Mobile(Company company, int mobileId, String model, float rating, double price) {
		super();
		this.company = company;
		this.mobileId = mobileId;
		this.model = model;
		this.rating = rating;
		this.price = price;
	}

	public Mobile(Company company, String model, float rating, double price) {
		super();
		this.company = company;
		this.model = model;
		this.rating = rating;
		this.price = price;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Mobile [company=" + company + ", mobileId=" + mobileId + ", model=" + model + ", rating=" + rating
				+ ", price=" + price + "]";
	}

}
