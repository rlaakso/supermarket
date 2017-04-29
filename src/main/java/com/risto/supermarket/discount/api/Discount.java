package com.risto.supermarket.discount.api;

import com.risto.supermarket.stock.api.Money;

public interface Discount {

	/**
	 * Return discount name
	 * @return
	 */
	String getDiscountName();

	/**
	 * Return item name
	 * @return
	 */
	String getItemName();

	/**
	 * Return item count needed for discount
	 * @return
	 */
	int getItemCount();

	/**
	 * Return discount item retail value
	 * @return
	 */
	Money getItemValue();

	/**
	 * Get monetary value for this discount
	 * @return
	 */
	Money getDiscountValue();

}