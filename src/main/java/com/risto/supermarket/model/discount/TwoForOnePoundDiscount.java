package com.risto.supermarket.model.discount;

import com.risto.supermarket.model.stock.Money;
import com.risto.supermarket.model.supermarket.InvalidCurrencyException;

/**
 * Create discount, e.g. 2 for £1
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public final class TwoForOnePoundDiscount extends AbstractDiscount {

	// total price
	private final Money totalPrice;

	/**
	 * Construct a new 2 for £1 discount
	 * @param discountName name of this discount
	 * @param itemName item this applies to
	 * @param itemCount item count required
	 * @param totalPrice total price for items after discount
	 * @throws InvalidDiscountException 
	 * @throws InvalidCurrencyException 
	 */
	public TwoForOnePoundDiscount(String discountName, String itemName, int itemCount, Money totalPrice, Money itemValue) throws InvalidDiscountException, InvalidCurrencyException {
		super(discountName, itemName, itemCount, itemValue);
		this.totalPrice = totalPrice;
		if (this.totalPrice == null || this.totalPrice.getValue() < 0) {
			throw new InvalidDiscountException("totalPrice needs to be larger than zero");
		}
		if (!totalPrice.getCurrency().equals(itemValue.getCurrency())) {
			throw new InvalidCurrencyException("Discount currency " + totalPrice.getCurrency() + " does not match item price currency " + itemValue.getCurrency());
		}
	}

	public Money getTotalPrice() {
		return totalPrice;
	}

	@Override
	public Money getDiscountValue() {
		return new Money(itemValue.getValue() * itemCount - totalPrice.getValue(), itemValue.getCurrency());
	}
}
