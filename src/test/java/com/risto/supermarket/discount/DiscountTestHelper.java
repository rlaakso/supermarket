package com.risto.supermarket.discount;

import com.risto.supermarket.common.AppInjector;
import com.risto.supermarket.common.api.Money;
import com.risto.supermarket.discount.api.DiscountRepository;
import com.risto.supermarket.discount.api.InvalidDiscountException;
import com.risto.supermarket.stock.api.ItemNotStockedException;
import com.risto.supermarket.supermarket.api.InvalidCurrencyException;
import com.risto.supermarket.supermarket.api.Supermarket;

public class DiscountTestHelper {

	/**
	 * Populate supermarket with discounts
	 * @param s
	 * @throws InvalidDiscountException 
	 * @throws ItemNotStockedException 
	 * @throws InvalidCurrencyException 
	 */
	public static void populateSupermarketDiscounts(Supermarket s, String currency) throws InvalidDiscountException, ItemNotStockedException, InvalidCurrencyException {
		DiscountRepository d = AppInjector.getInstance().getInstance(DiscountRepository.class);
		d.addDiscount(new ThreeForTwoDiscount("Beans 3 for 2", "Beans", 3, 2, s.getItemByName("Beans").getPrice()));
		d.addDiscount(new TwoForOnePoundDiscount("Coke 2 for £1", "Coke", 2, new Money(100, currency), s.getItemByName("Coke").getPrice()));
	}

}
