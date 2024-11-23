package com.mindtree.factory.entity;

public class Factory {
	private int factoryId;
	private String name;
	private String location;
	private String itemManufactured;

	public Factory(int factoryId, String name, String location, String itemManufactured) {
		super();
		this.factoryId = factoryId;
		this.name = name;
		this.location = location;
		this.itemManufactured = itemManufactured;
	}

	

	public Factory(int factoryId) {
		super();
		this.factoryId = factoryId;
	}



	public Factory(int factoryId, String name) {
		super();
		this.factoryId = factoryId;
		this.name = name;
	}



	public int getFactoryId() {
		return factoryId;
	}

	public void setFactoryId(int factoryId) {
		this.factoryId = factoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getItemManufactured() {
		return itemManufactured;
	}

	public void setItemManufactured(String itemManufactured) {
		this.itemManufactured = itemManufactured;
	}

	@Override
	public String toString() {
		return "Factory [factoryId=" + factoryId + ", name=" + name + ", location=" + location + ", itemManufactured="
				+ itemManufactured + "]";
	}

}
