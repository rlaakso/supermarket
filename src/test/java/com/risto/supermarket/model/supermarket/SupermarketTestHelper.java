package com.risto.supermarket.model.supermarket;

import com.risto.supermarket.model.discount.DiscountTestHelper;
import com.risto.supermarket.model.discount.InvalidDiscountException;
import com.risto.supermarket.model.stock.ItemNotStockedException;
import com.risto.supermarket.model.stock.NonWeightableItemException;
import com.risto.supermarket.model.stock.StockTestHelper;
import com.risto.supermarket.model.stock.UnsupportedUnitException;
import com.risto.supermarket.model.stock.Weight;

public class SupermarketTestHelper {
	
	/**
	 * Create new supermarket with some stock and discounts
	 * @return
	 * @throws UnsupportedUnitException
	 * @throws InvalidDiscountException
	 * @throws ItemNotStockedException 
	 * @throws InvalidCurrencyException 
	 */
	public static Supermarket createSupermarket() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, InvalidCurrencyException {
		Supermarket s = new Supermarket("ICA Maxi", "SEK");
		StockTestHelper.populateSupermarketStock(s, s.getCurrency());
		DiscountTestHelper.populateSupermarketDiscounts(s, s.getCurrency());
		return s;
	}

	/**
	 * Populate shopping cart with some items
	 * @param sc
	 * @param s
	 * @throws ItemNotStockedException
	 * @throws NonWeightableItemException
	 * @throws UnsupportedUnitException
	 */
	public static void populateCart(ShoppingCart sc, Supermarket s) throws ItemNotStockedException, NonWeightableItemException, UnsupportedUnitException {
		sc.addItem(s.getItemByName("Beans"));
		sc.addItem(s.getItemByName("Beans"));
		sc.addItem(s.getItemByName("Beans"));
		sc.addItem(s.getItemByName("Coke"));
		sc.addItem(s.getItemByName("Coke"));
		sc.addItem(s.getItemByName("Oranges"), new Weight(0.200, "kg"));
	}

	
}
