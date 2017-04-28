package com.risto.supermarket.model.supermarket;

/**
 * Test class to populate supermarket with discounts.
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public class DiscountFactory {

	/**
	 * Populate supermarket with discounts
	 * @param s
	 * @throws InvalidDiscountException 
	 */
	public void populate(Supermarket s) throws InvalidDiscountException {
		s.addDiscount(new ThreeForTwoDiscount("Beans 3 for 2", "Beans", 3, 2));
		s.addDiscount(new TwoForOnePoundDiscount("Coke 2 for £1", "Coke", 2, new Money(100, "GBP")));
	}

	public int getDiscountCount() {
		return 2;
	}

}
