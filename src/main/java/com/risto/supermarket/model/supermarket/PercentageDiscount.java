package com.risto.supermarket.model.supermarket;

/**
 * Percentage discount for items
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public final class PercentageDiscount implements Discount {

	// discount e.g. 0.05 for 5%
	private final double discount;
	
	/**
	 * Construct new percentage discount
	 * @param discount e.g. 0.05 for 5%
	 */
	public PercentageDiscount(double discount) {
		this.discount = discount;
	}
	
	/**
	 * Get discount amount
	 * @return
	 */
	public double getDiscount() {
		return discount;
	}

	/**
	 * Apply discount to item price
	 */
	public Money applyTo(Item item) {
		Money originalPrice = item.getPrice();
		return originalPrice.multiply(1.00 - discount);
	}

	public String getName() {
		return null;
	}

}
