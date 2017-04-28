package com.risto.supermarket.model.supermarket;

import java.util.ArrayList;
import java.util.List;

/**
 * Shopping cart for a supermarket
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public class ShoppingCart {

	// Supermarket this shopping cart belongs to
	private Supermarket supermarket;
	
	// Items in cart
	private List<Item> items = new ArrayList<Item>();
	
	/**
	 * Create new supermarket
	 * @param supermarket
	 */
	protected ShoppingCart(Supermarket supermarket) {
		this.supermarket = supermarket;
	}

	/**
	 * Add item to cart
	 * @param item
	 */
	public void addItem(Item item) {
		items.add(item);
	}

	/**
	 * Add item to cart with weight
	 * @param itemByName
	 * @param weight
	 * @throws NonWeightableItemException 
	 */
	public void addItem(Item itemByName, Weight weight) throws NonWeightableItemException {
		items.add(itemByName.setWeight(weight));
	}

	/**
	 * Get number of items in cart
	 * @return
	 */
	public int getItemCount() {
		return items.size();
	}

	/**
	 * Get number of specific items in cart
	 * @param itemName
	 * @return
	 */
	public int getItemCountByName(String itemName) {
		return (int) items.stream()
				.filter(item -> item.getName().equals(itemName))
				.count();
	}
}
