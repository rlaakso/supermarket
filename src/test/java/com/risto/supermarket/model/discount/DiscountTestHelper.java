package com.risto.supermarket.model.discount;

import com.risto.supermarket.model.stock.ItemNotStockedException;
import com.risto.supermarket.model.stock.Money;
import com.risto.supermarket.model.supermarket.InvalidCurrencyException;
import com.risto.supermarket.model.supermarket.Supermarket;

public class DiscountTestHelper {

	/**
	 * Populate supermarket with discounts
	 * @param s
	 * @throws InvalidDiscountException 
	 * @throws ItemNotStockedException 
	 * @throws InvalidCurrencyException 
	 */
	public static void populateSupermarketDiscounts(Supermarket s, String currency) throws InvalidDiscountException, ItemNotStockedException, InvalidCurrencyException {
		s.addDiscount(new ThreeForTwoDiscount("Beans 3 for 2", "Beans", 3, 2, s.getItemByName("Beans").getPrice()));
		s.addDiscount(new TwoForOnePoundDiscount("Coke 2 for £1", "Coke", 2, new Money(100, currency), s.getItemByName("Coke").getPrice()));
	}

}
