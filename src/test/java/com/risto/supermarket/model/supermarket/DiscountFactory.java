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
	 */
	public void populate(Supermarket s) {
		s.addDiscount(new FixedDiscount(100));
	}

	public int getDiscountCount() {
		return 1;
	}

}
