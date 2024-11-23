package com.mindtree.factory.utility;

import java.util.Comparator;

import com.mindtree.factory.entity.Item;

public class CountComparator implements Comparator<Item> {

	@Override
	public int compare(Item o1, Item o2) {
		// TODO Auto-generated method stub

		return o1.getItemProducedCount() > o2.getItemProducedCount() ? 1
				: o1.getItemProducedCount() < o2.getItemProducedCount() ? -1 : 0;
	}

}
