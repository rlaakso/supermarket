package com.risto.supermarket.model.discount;

import com.risto.supermarket.model.stock.Money;

/**
 * Discount abstract class
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public abstract class AbstractDiscount {

	// discount name
	protected final String discountName;

	// item name this discount applies to
	protected final String itemName;
	
	// items needed for discount
	protected final int itemCount;

	// item value
	protected final Money itemValue;
	
	/**
	 * Construct a new discount, which applies to itemName if there are at least itemCount of them in shopping cart.
	 * @param discountName
	 * @param itemName
	 * @param itemCount
	 */
	public AbstractDiscount(String discountName, String itemName, int itemCount, Money itemValue) {
		this.discountName = discountName;
		this.itemName = itemName;
		this.itemCount = itemCount;
		this.itemValue = itemValue;
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

	/**
	 * Return discount item retail value
	 * @return
	 */
	public Money getItemValue() {
		return itemValue;
	}

	/**
	 * Get monetary value for this discount
	 * @return
	 */
	public abstract Money getDiscountValue(); 
}
