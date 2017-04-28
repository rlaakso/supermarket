package com.risto.supermarket.model.supermarket;

/**
 * Create discount, e.g. 2 for £1
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public final class TwoForOnePoundDiscount extends Discount {

	// total price
	private final Money totalPrice;

	/**
	 * Construct a new 2 for £1 discount
	 * @param discountName name of this discount
	 * @param itemName item this applies to
	 * @param itemCount item count required
	 * @param totalPrice total price for items after discount
	 * @throws InvalidDiscountException 
	 */
	public TwoForOnePoundDiscount(String discountName, String itemName, int itemCount, Money totalPrice) throws InvalidDiscountException {
		super(discountName, itemName, itemCount);
		this.totalPrice = totalPrice;
		if (this.totalPrice == null || this.totalPrice.getValue() < 0) {
			throw new InvalidDiscountException("totalPrice needs to be larger than zero");
		}
	}

	public Money getTotalPrice() {
		return totalPrice;
	}
}
