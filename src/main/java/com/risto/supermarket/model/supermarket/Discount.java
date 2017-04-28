package com.risto.supermarket.model.supermarket;

/**
 * Discount abstract class
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public abstract class Discount {

	// discount name
	private final String discountName;

	// item name this discount applies to
	private final String itemName;
	
	// items needed for discount
	private final int itemCount;
	
	/**
	 * Construct a new discount, which applies to itemName if there are at least itemCount of them in shopping cart.
	 * @param discountName
	 * @param itemName
	 * @param itemCount
	 */
	public Discount(String discountName, String itemName, int itemCount) {
		this.discountName = discountName;
		this.itemName = itemName;
		this.itemCount = itemCount;
	}
	
	/**
	 * Return discount name
	 * @return
	 */
	public String getDiscountName() {
		return discountName;
	}

	/**
	 * Return item name
	 * @return
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Return item count needed for discount
	 * @return
	 */
	public int getItemCount() {
		return itemCount;
	}

}
