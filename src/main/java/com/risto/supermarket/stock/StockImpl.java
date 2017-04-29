package com.risto.supermarket.stock;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.google.inject.Singleton;
import com.risto.supermarket.discount.api.NotEmptyException;
import com.risto.supermarket.stock.api.Item;
import com.risto.supermarket.stock.api.ItemNotStockedException;
import com.risto.supermarket.stock.api.Money;
import com.risto.supermarket.stock.api.Stock;
import com.risto.supermarket.supermarket.api.InvalidCurrencyException;

/**
 * Collection of stock for supermarket
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
@Singleton
public class StockImpl implements Stock {

	private String stockCurrency;
	
	private Map<String, Item> stock;

	/**
	 * Construct a new Stock
	 * @param currency
	 */
	public StockImpl() {
		this.stockCurrency = Money.DEFAULT_CURRENCY;
		this.stock = new HashMap<String, Item>();
	}
	
	/* (non-Javadoc)
	 * @see com.risto.supermarket.model.stock.ISTock#addItemToStock(com.risto.supermarket.model.stock.Item)
	 */
	@Override
	public void addItemToStock(Item item) throws InvalidCurrencyException {
		if (!item.getPrice().getCurrency().equals(stockCurrency)) {
			throw new InvalidCurrencyException("Stock currency is " + stockCurrency);
		}
		stock.put(item.getName(), item);	
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.model.stock.ISTock#getItemByName(java.lang.String)
	 */
	@Override
	public Item getItemByName(String itemName) throws ItemNotStockedException {
		if (!stock.containsKey(itemName)) {
			throw new ItemNotStockedException("Item not in stock");
		}
		return stock.get(itemName);
	}
	
	@Override
	public void changeCurrency(String newCurrency) throws NotEmptyException {
		if (!stock.isEmpty()) {
			throw new NotEmptyException("Cannot change currency for non-empty stock storages.");
		}
		this.stockCurrency = newCurrency;
	}
	
	@Override
	public void clear() {
		this.stock.clear();
	}

	@Override
	public Collection<Item> getAllStockedItems() {
		return Collections.unmodifiableCollection(stock.values());
	}
}
