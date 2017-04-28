package com.risto.supermarket.model.supermarket;

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
		populateSupermarketStock(s, s.getCurrency());
		populateSupermarketDiscounts(s, s.getCurrency());
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
