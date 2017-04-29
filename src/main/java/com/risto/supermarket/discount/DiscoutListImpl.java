package com.risto.supermarket.discount;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.google.inject.Singleton;
import com.risto.supermarket.discount.api.Discount;
import com.risto.supermarket.discount.api.DiscountList;
import com.risto.supermarket.discount.api.DiscountNotAvailableException;
import com.risto.supermarket.discount.api.NotEmptyException;
import com.risto.supermarket.stock.api.Money;
import com.risto.supermarket.supermarket.api.InvalidCurrencyException;

/**
 * Collection of active discounts
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
@Singleton
public class DiscoutListImpl implements DiscountList {

	private String discountCurrency;
	
	private Map<String, Discount> discounts;

	/**
	 * Create new discount
	 * @param currency
	 */
	public DiscoutListImpl() {
		this.discountCurrency = Money.DEFAULT_CURRENCY;
		this.discounts = new HashMap<String, Discount>();
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.model.discount.IDiscounts#addDiscount(com.risto.supermarket.model.discount.AbstractDiscount)
	 */
	@Override
	public void addDiscount(Discount discount) throws InvalidCurrencyException {
		if (!discount.getDiscountValue().getCurrency().equals(discountCurrency)) {
			throw new InvalidCurrencyException("Discount currency is " + discountCurrency);
		}
		this.discounts.put(discount.getDiscountName(), discount);		
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.model.discount.IDiscounts#getNumberOfDiscounts()
	 */
	@Override
	public int getNumberOfDiscounts() {
		return this.discounts.size();
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.model.discount.IDiscounts#getDiscountByName(java.lang.String)
	 */
	@Override
	public Discount getDiscountByName(String discountName) throws DiscountNotAvailableException {
		if (!discounts.containsKey(discountName)) {
			throw new DiscountNotAvailableException("Discount not available");
		}
		return discounts.get(discountName);
	}

	/* (non-Javadoc)
	 * @see com.risto.supermarket.model.discount.IDiscounts#getAllDiscounts()
	 */
	@Override
	public Collection<Discount> getAllDiscounts() {
		return Collections.unmodifiableCollection(discounts.values());
	}

	@Override
	public void changeCurrency(String newCurrency) throws NotEmptyException {
		if (!discounts.isEmpty()) {
			throw new NotEmptyException("Cannot change currency for non-empty discount storages.");
		}
		this.discountCurrency = newCurrency;
	}

	@Override
	public void clear() {
		this.discounts.clear();
	}
}
