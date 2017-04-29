package com.risto.supermarket.discount.api;

import java.util.List;

import com.risto.supermarket.supermarket.api.ShoppingCart;

public interface DiscountCalculatorService {

	/**
	 * Calculate total discounts for shopping cart for a single discount rule
	 * @param sc
	 * @param discount
	 * @return
	 */
	List<Discount> calculateDiscountFor(ShoppingCart sc, Discount discount);

}