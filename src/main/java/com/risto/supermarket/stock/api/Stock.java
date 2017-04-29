package com.risto.supermarket.stock.api;

import com.risto.supermarket.discount.api.NotEmptyException;
import com.risto.supermarket.supermarket.api.InvalidCurrencyException;

public interface Stock {

	/**
	 * Add item to stock
	 * @param item
	 * @throws InvalidCurrencyException
	 */
	void addItemToStock(Item item) throws InvalidCurrencyException;

	/**
	 * Return number of items in stock
	 * @return
	 */
	int getNumberOfItemsInStock();

	/**
	 * Return stocked item by name
	 * @param itemName
	 * @return
	 * @throws ItemNotStockedException
	 */
	Item getItemByName(String itemName) throws ItemNotStockedException;

	/**
	 * Change stock storage currency. Can only be done for empty storages.
	 */
	void changeCurrency(String newCurrency) throws NotEmptyException;

	/**
	 * Clear stock.
	 */
	void clear();
}