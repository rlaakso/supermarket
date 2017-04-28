package com.risto.supermarket.model.supermarket;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to represent supermarket, its stock, and discounts.
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public class Supermarket {

	// Supermarket name
	private final String name;
	
	// Stock
	private Map<String, Item> stock = new HashMap<String, Item>();

	// Discounts
	private Map<String, Discount> discounts = new HashMap<String, Discount>();
	
	/**
	 * Construct a new supermarket
	 * @param name
	 */
	public Supermarket(String name) {
		this.name = name;
	}

	/**
	 * Get supermarket name
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Add item to stock
	 * @param singleItem
	 */
	public void addItem(Item item) {
		this.stock.put(item.getName(), item);
	}

	/**
	 * Get number of stocked items
	 * @return
	 */
	public int getItemCount() {
		return this.stock.size();
	}

	/**
	 * Add discount 
	 * @param discount
	 */
	public void addDiscount(Discount discount) {
		this.discounts.put(discount.getDiscountName(), discount);
	}
	
	/**
	 * Get number of active discounts
	 * @return
	 */
	public int getDiscountCount() {
		return this.discounts.size();
	}

	/**
	 * Create new shopping cart
	 * @return
	 */
	public ShoppingCart createShoppingCart() {
		ShoppingCart sc = new ShoppingCart(this);
		return sc;
	}

	/**
	 * Get stocked item by name
	 * @param itemName
	 * @return
	 * @throws ItemNotStockedException 
	 */
	public Item getItemByName(String itemName) throws ItemNotStockedException {
		if (!stock.containsKey(itemName)) {
			throw new ItemNotStockedException("Item not in stock");
		}
		return stock.get(itemName);
	}
}
