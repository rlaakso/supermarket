package com.risto.supermarket.model.supermarket;

import java.util.Collection;

import com.risto.supermarket.model.discount.AbstractDiscount;
import com.risto.supermarket.model.discount.DiscountNotAvailableException;
import com.risto.supermarket.model.discount.Discounts;
import com.risto.supermarket.model.stock.Item;
import com.risto.supermarket.model.stock.ItemNotStockedException;
import com.risto.supermarket.model.stock.Stock;

/**
 * Class to represent supermarket, its stock, and discounts.
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public class Supermarket {

	// Supermarket name
	private final String name;
	
	// Supermarket currency
	private final String supermarketCurrency;
	
	// Stock
	private final Stock stock;

	// Discounts
	private final Discounts discounts;

	/**
	 * Construct a new supermarket
	 * @param name
	 */
	public Supermarket(String name, String currency) {
		this.name = name;
		this.supermarketCurrency = currency;
		this.stock = new Stock(currency);
		this.discounts = new Discounts(currency);
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
	 * @throws InvalidCurrencyException 
	 */
	public void addItem(Item item) throws InvalidCurrencyException {
		stock.addItemToStock(item);
	}

	/**
	 * Get number of stocked items
	 * @return
	 */
	public int getItemCount() {
		return stock.getNumberOfItemsInStock();
	}

	/**
	 * Get stocked item by name
	 * @param itemName
	 * @return
	 * @throws ItemNotStockedException 
	 */
	public Item getItemByName(String itemName) throws ItemNotStockedException {
		return stock.getItemByName(itemName);
	}

	/**
	 * Add discount 
	 * @param discount
	 * @throws InvalidCurrencyException 
	 */
	public void addDiscount(AbstractDiscount discount) throws InvalidCurrencyException {
		discounts.addDiscount(discount);
	}
	
	/**
	 * Get number of active discounts
	 * @return
	 */
	public int getDiscountCount() {
		return discounts.getNumberOfDiscounts();
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
	 * Get discount by name
	 * @param discountName
	 * @return
	 * @throws DiscountNotAvailableException 
	 */
	public AbstractDiscount getDiscountByName(String discountName) throws DiscountNotAvailableException {
		return discounts.getDiscountByName(discountName);
	}

	/**
	 * Get all active discounts
	 * @return
	 */
	public Collection<AbstractDiscount> getDiscounts() {
		return discounts.getAllDiscounts();
	}

	/**
	 * Return supermarket currency
	 * @return
	 */
	public String getCurrency() {
		return supermarketCurrency;
	}
}
