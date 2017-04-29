package com.risto.supermarket.discount;

import com.risto.supermarket.discount.api.Discount;
import com.risto.supermarket.stock.api.Money;

/**
 * Discount abstract class
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public abstract class DiscountImpl implements Discount {

	// discount name
	protected final String discountName;

	// item name this discount applies to
	protected final String itemName;
	
	// items needed for discount
	protected final int itemCount;

	// item value
	protected final Money itemValue;
	
	/**
	 * Construct a new discount, which applies to itemName if there are at least itemCount of them in shopping cart.
	 * @param discountName
	 * @param itemName
	 * @param itemCount
	 */
	public DiscountImpl(String discountName, String itemName, int itemCount, Money itemValue) {
		this.discountName = discountName;
		this.itemName = itemName;
		this.itemCount = itemCount;
		this.itemValue = itemValue;
	}
	
	/* (non-Javadoc)
	 * @see com.risto.supermarket.discount.Discount#getDiscountName()
	 */
	@Override
	public String getDiscountName() {
		return discountName;
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.discount.Discount#getItemName()
	 */
	@Override
	public String getItemName() {
		return itemName;
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.discount.Discount#getItemCount()
	 */
	@Override
	public int getItemCount() {
		return itemCount;
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.discount.Discount#getItemValue()
	 */
	@Override
	public Money getItemValue() {
		return itemValue;
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.discount.Discount#getDiscountValue()
	 */
	@Override
	public abstract Money getDiscountValue(); 
}
