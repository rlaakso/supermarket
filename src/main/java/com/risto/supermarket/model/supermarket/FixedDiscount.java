package com.risto.supermarket.model.supermarket;

/**
 * Class for fixed discounts, e.g. £0.50
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public final class FixedDiscount implements Discount {

	// discount amount
	private final int discount;
	
	/**
	 * Construct new discount
	 * @param discount
	 */
	public FixedDiscount(int discount) {
		this.discount = discount;
	}
	
	/**
	 * Return discount
	 * @return
	 */
	public int getDiscount() {
		return discount;
	}

	public Money applyTo(Item item) {
		Money originalPrice = item.getPrice();
		return originalPrice.add(-discount);
	}

	public String getName() {
		return null;
	}

}
