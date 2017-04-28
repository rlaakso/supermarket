package com.risto.supermarket.model.discount;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.risto.supermarket.model.supermarket.InvalidCurrencyException;

/**
 * Collection of active discounts
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public class Discounts {

	private final String discountCurrency;
	
	private Map<String, AbstractDiscount> discounts;

	/**
	 * Create new discount
	 * @param currency
	 */
	public Discounts(String currency) {
		this.discountCurrency = currency;
		this.discounts = new HashMap<String, AbstractDiscount>();
	}

	/**
	 * Add discount
	 * @param discount
	 * @throws InvalidCurrencyException
	 */
	public void addDiscount(AbstractDiscount discount) throws InvalidCurrencyException {
		if (!discount.getDiscountValue().getCurrency().equals(discountCurrency)) {
			throw new InvalidCurrencyException("Discount currency is " + discountCurrency);
		}
		this.discounts.put(discount.getDiscountName(), discount);		
	}

	/**
	 * Get number of active discounts
	 * @return
	 */
	public int getNumberOfDiscounts() {
		return this.discounts.size();
	}

	/**
	 * Get discount by name
	 * @param discountName
	 * @return
	 * @throws DiscountNotAvailableException
	 */
	public AbstractDiscount getDiscountByName(String discountName) throws DiscountNotAvailableException {
		if (!discounts.containsKey(discountName)) {
			throw new DiscountNotAvailableException("Discount not available");
		}
		return discounts.get(discountName);
	}

	/**
	 * Get all active discounts
	 * @return
	 */
	public Collection<AbstractDiscount> getAllDiscounts() {
		return Collections.unmodifiableCollection(discounts.values());
	}

}
