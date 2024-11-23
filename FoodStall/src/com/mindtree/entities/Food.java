package com.mindtree.entities;

public class Food {
	private String foodName;
	private int quant;
	private int totalCount;

	public Food() {

	}

	public Food(String foodName, int quant) {
		super();
		this.foodName = foodName;
		this.quant = quant;
		
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "Food [foodName=" + foodName + ", quant=" + quant + ", totalCount=" + totalCount + "]";
	}

}
