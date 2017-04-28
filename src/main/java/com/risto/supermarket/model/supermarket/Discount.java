package com.risto.supermarket.model.supermarket;

/**
 * Discount interface
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public interface Discount {
	/**
	 * Apply discount to items price
	 * @param item
	 * @return
	 */
	public Money applyTo(Item item);

	/**
	 * Get discount name
	 * @return
	 */
	public String getName();
}
