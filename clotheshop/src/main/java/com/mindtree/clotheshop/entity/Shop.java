package com.mindtree.clotheshop.entity;

public class Shop {
	private int shopId;
	private String shopName;

	public Shop() {

		// TODO Auto-generated constructor stub
	}

	public Shop(int shopId, String shopName) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
	}

	public Shop(int shopId) {
		super();
		this.shopId = shopId;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopName=" + shopName + "]";
	}

}
