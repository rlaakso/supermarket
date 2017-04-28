package com.risto.supermarket.model.supermarket;

public class SupermarketFactory {
	
	/**
	 * Create new supermarket with some stock and discounts
	 * @return
	 * @throws UnsupportedUnitException
	 * @throws InvalidDiscountException
	 */
	public static Supermarket createSupermarket() throws UnsupportedUnitException, InvalidDiscountException {
		Supermarket s = new Supermarket("ICA Maxi");
		StockFactory stockFactory = new StockFactory();
		stockFactory.populate(s);
		DiscountFactory discountFactory = new DiscountFactory();
		discountFactory.populate(s);
		return s;
	}

}
