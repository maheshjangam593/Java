package com.mindtree.factory.entity;

public class Item {
	private Factory factory;
	private int itemId;
	private String Name;
	private int itemProducedCount;

	public Item(Factory factory, int itemId, String name, int itemProducedCount) {
		super();
		this.factory = factory;
		this.itemId = itemId;
		Name = name;
		this.itemProducedCount = itemProducedCount;
	}

	public Factory getFactory() {
		return factory;
	}

	public void setFactory(Factory factory) {
		this.factory = factory;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getItemProducedCount() {
		return itemProducedCount;
	}

	public void setItemProducedCount(int itemProducedCount) {
		this.itemProducedCount = itemProducedCount;
	}

	@Override
	public String toString() {
		return "Item [factory=" + factory + ", itemId=" + itemId + ", Name=" + Name + ", itemProducedCount="
				+ itemProducedCount + "]";
	}

}
