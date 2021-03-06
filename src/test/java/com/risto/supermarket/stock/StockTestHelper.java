package com.risto.supermarket.stock;

import com.risto.supermarket.common.AppInjector;
import com.risto.supermarket.common.api.Money;
import com.risto.supermarket.stock.api.StockRepository;
import com.risto.supermarket.stock.api.UnsupportedUnitException;
import com.risto.supermarket.stock.api.Weight;
import com.risto.supermarket.supermarket.api.InvalidCurrencyException;

public class StockTestHelper {
	
	/**
	 * Populate supermarket with test goods
	 * @param s
	 * @throws UnsupportedUnitException
	 * @throws InvalidCurrencyException 
	 */
	public static void populateSupermarketStock(String currency) throws UnsupportedUnitException, InvalidCurrencyException {
		StockRepository s = AppInjector.getInstance().getInstance(StockRepository.class);
		s.addItemToStock(new SingleItem("Beans", new Money(50, currency)));
		s.addItemToStock(new SingleItem("Coke", new Money(70, currency)));
		s.addItemToStock(new WeightedItem("Oranges", new Weight(0.0, "kg"), new Money(199, currency)));
	}

}
