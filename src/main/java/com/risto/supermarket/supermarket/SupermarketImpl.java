package com.risto.supermarket.supermarket;

import java.util.Collection;
import java.util.UUID;

import com.google.inject.Inject;
import com.risto.supermarket.discount.api.Discount;
import com.risto.supermarket.discount.api.DiscountRepository;
import com.risto.supermarket.discount.api.DiscountNotAvailableException;
import com.risto.supermarket.stock.api.Item;
import com.risto.supermarket.stock.api.ItemNotStockedException;
import com.risto.supermarket.stock.api.StockRepository;
import com.risto.supermarket.supermarket.api.ShoppingCart;
import com.risto.supermarket.supermarket.api.Supermarket;

/**
 * Class to represent supermarket, its stock, and discounts.
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public class SupermarketImpl implements Supermarket {

	private final UUID id;
	
	// Supermarket name
	private final String name;
	
	// Supermarket currency
	private final String supermarketCurrency;
	
	// Stock
	@Inject
	private final StockRepository stock;

	// Discounts
	@Inject
	private final DiscountRepository discounts;

	/**
	 * Construct a new supermarket
	 * @param name
	 */
	public SupermarketImpl(String name, String currency) {		
		this.id = UUID.randomUUID();
		
		this.name = name;
		this.supermarketCurrency = currency;
		
		// inject Stock and Discounts
		stock = AppInjector.getInstance().getInstance(StockRepository.class);
		discounts = AppInjector.getInstance().getInstance(DiscountRepository.class);
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.supermarket.Supermarket#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.supermarket.Supermarket#getItemByName(java.lang.String)
	 */
	@Override
	public Item getItemByName(String itemName) throws ItemNotStockedException {
		return stock.getItemByName(itemName);
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.supermarket.Supermarket#getDiscountByName(java.lang.String)
	 */
	@Override
	public Discount getDiscountByName(String discountName) throws DiscountNotAvailableException {
		return discounts.getDiscountByName(discountName);
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.supermarket.Supermarket#getDiscounts()
	 */
	@Override
	public Collection<Discount> getDiscounts() {
		return discounts.getAllDiscounts();
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.supermarket.Supermarket#getCurrency()
	 */
	@Override
	public String getCurrency() {
		return supermarketCurrency;
	}
	
	@Override
	public ShoppingCart createShoppingCart() {
		return new ShoppingCartImpl(this);
	}

	@Override
	public Collection<Item> getStockedItems() {
		return stock.getAllStockedItems();
	}
}
