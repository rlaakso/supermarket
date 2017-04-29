package com.risto.supermarket.discount.api;

import java.util.Collection;

import com.risto.supermarket.supermarket.api.InvalidCurrencyException;

public interface DiscountList {

	/**
	 * Add discount
	 * @param discount
	 * @throws InvalidCurrencyException
	 */
	void addDiscount(Discount discount) throws InvalidCurrencyException;

	/**
	 * Get discount by name
	 * @param discountName
	 * @return
	 * @throws DiscountNotAvailableException
	 */
	Discount getDiscountByName(String discountName) throws DiscountNotAvailableException;

	/**
	 * Get all active discounts
	 * @return
	 */
	Collection<Discount> getAllDiscounts();

	/**
	 * Change discount storage currency. Can only be done for empty storages.
	 */
	void changeCurrency(String newCurrency) throws NotEmptyException;
	
	/**
	 * Clear discounts.
	 */
	void clear();

}