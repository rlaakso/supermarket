package com.risto.supermarket.model.stock;

import com.risto.supermarket.model.supermarket.InvalidCurrencyException;
import com.risto.supermarket.model.supermarket.Supermarket;

public class StockTestHelper {
	
	/**
	 * Populate supermarket with test goods
	 * @param s
	 * @throws UnsupportedUnitException
	 * @throws InvalidCurrencyException 
	 */
	public static void populateSupermarketStock(Supermarket s, String currency) throws UnsupportedUnitException, InvalidCurrencyException {
		s.addItem(new SingleItem("Beans", new Money(50, currency)));
		s.addItem(new SingleItem("Coke", new Money(70, currency)));
		s.addItem(new WeightedItem("Oranges", new Weight(0.0, "kg"), new Money(199, currency)));
	}

}
