package com.risto.supermarket.supermarket.api;

import java.util.Collection;

import com.risto.supermarket.discount.api.Discount;
import com.risto.supermarket.discount.api.DiscountNotAvailableException;
import com.risto.supermarket.stock.api.Item;
import com.risto.supermarket.stock.api.ItemNotStockedException;

/**
 * Supermarket API
 * 
 * Read view into Stock and Discount storages.
 * 
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public interface Supermarket {

	/**
	 * Get supermarket name
	 * @return
	 */
	String getName();

	/**
	 * Get stocked item by name
	 * @param itemName
	 * @return
	 * @throws ItemNotStockedException 
	 */
	Item getItemByName(String itemName) throws ItemNotStockedException;

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
	Collection<Discount> getDiscounts();

	/**
	 * Return supermarket currency
	 * @return
	 */
	String getCurrency();

	/**
	 * Return stocked items
	 * @return
	 */
	Collection<Item> getStockedItems();
}