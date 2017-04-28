package com.risto.supermarket.model.supermarket;

/**
 * Test class to populate supermarket with items. 
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public class StockFactory {

	/**
	 * Populate supermarket with test goods
	 * @param s
	 * @throws UnsupportedUnitException
	 */
	public void populate(Supermarket s) throws UnsupportedUnitException {
		s.addItem(new SingleItem("Beans", new Money(50, "GBP")));
		s.addItem(new SingleItem("Coke", new Money(70, "GBP")));
		s.addItem(new WeightedItem("Oranges", new Weight(0.0, "kg"), new Money(199, "GBP")));
	}

	public int getItemCount() {
		return 3;
	}

}
