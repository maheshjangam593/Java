package com.mindtree.clotheshop.entity;

public class Brand {
	private int brandId;
	private String brandName;
	private int clothCount;
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Brand(int brandId, String brandName, int clothCount) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
		this.clothCount = clothCount;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public int getClothCount() {
		return clothCount;
	}

	public void setClothCount(int clothCount) {
		this.clothCount = clothCount;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandName=" + brandName + ", clothCount=" + clothCount + "]";
	}

}
