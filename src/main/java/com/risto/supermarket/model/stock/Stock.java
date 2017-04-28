package com.risto.supermarket.model.stock;

import java.util.HashMap;
import java.util.Map;

import com.risto.supermarket.model.supermarket.InvalidCurrencyException;

/**
 * Collection of stock for supermarket
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public class Stock {

	private final String stockCurrency;
	
	private Map<String, Item> stock;

	/**
	 * Construct a new Stock
	 * @param currency
	 */
	public Stock(String currency) {
		this.stockCurrency = currency;
		this.stock = new HashMap<String, Item>();
	}
	
	/**
	 * Add item to stock
	 * @param item
	 * @throws InvalidCurrencyException
	 */
	public void addItemToStock(Item item) throws InvalidCurrencyException {
		if (!item.getPrice().getCurrency().equals(stockCurrency)) {
			throw new InvalidCurrencyException("Stock currency is " + stockCurrency);
		}
		stock.put(item.getName(), item);	
	}

	/**
	 * Return number of items in stock
	 * @return
	 */
	public int getNumberOfItemsInStock() {
		return stock.size();
	}

	/**
	 * Return stocked item by name
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
