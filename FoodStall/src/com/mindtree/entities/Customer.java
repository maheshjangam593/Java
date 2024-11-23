package com.mindtree.entities;

public class Customer {
	private int cId;
	private String name;
	private String email;
	private String userName;
	private String password;
	private int buyQunat;
	private int foodName;

	public Customer() {

	}

	public Customer(int cId, String name, String email, String userName, String password, int buyQunat, int foodName) {
		super();
		this.cId = cId;
		this.name = name;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.buyQunat = buyQunat;
		this.foodName = foodName;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBuyQunat() {
		return buyQunat;
	}

	public void setBuyQunat(int buyQunat) {
		this.buyQunat = buyQunat;
	}

	public int getFoodName() {
		return foodName;
	}

	public void setFoodName(int foodName) {
		this.foodName = foodName;
	}

	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", name=" + name + ", email=" + email + ", userName=" + userName + ", password="
				+ password + ", buyQunat=" + buyQunat + ", foodName=" + foodName + "]";
	}

}
