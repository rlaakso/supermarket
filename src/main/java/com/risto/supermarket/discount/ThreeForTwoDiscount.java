package com.risto.supermarket.discount;

import com.risto.supermarket.discount.api.InvalidDiscountException;
import com.risto.supermarket.stock.api.Money;

/**
 * Create discount e.g. Beans 3 for 2
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
final class ThreeForTwoDiscount extends DiscountImpl {

	// freebie count
	private final int freebieCount;

	/**
	 * Construct a new 3 for 2 discount
	 * @param discountName name for this discount
	 * @param itemName item this applies to
	 * @param itemCount item count required for discount
	 * @param forCount number of items to be paid
	 * @throws InvalidDiscountException 
	 */
	public ThreeForTwoDiscount(String discountName, String itemName, int itemCount, int forCount, Money itemValue) throws InvalidDiscountException {
		super(discountName, itemName, itemCount, itemValue);
		this.freebieCount = itemCount - forCount;
		if (this.freebieCount <= 0) {
			throw new InvalidDiscountException("forCount needs to be less than itemCount");
		}
	}

	/**
	 * Get number of free items, e.g. 1 for "3 for 2" 
	 * @return
	 */
	public int getFreebieCount() {
		return freebieCount;
	}

	@Override
	public Money getDiscountValue() {
		return new Money(itemValue.getValue() * freebieCount, itemValue.getCurrency());
	}
	
}
