package com.risto.supermarket.discount;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Singleton;
import com.risto.supermarket.discount.api.Discount;
import com.risto.supermarket.discount.api.DiscountCalculatorService;
import com.risto.supermarket.supermarket.api.ShoppingCart;

/**
 * Discount calculator service to calculate discounts for items in shopping cart
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
@Singleton
public final class DiscountCalculatorServiceImpl implements DiscountCalculatorService {
	
	/* (non-Javadoc)
	 * @see com.risto.supermarket.discount.DiscountCalculatorService#calculateDiscountFor(com.risto.supermarket.model.supermarket.ShoppingCart, com.risto.supermarket.discount.DiscountImpl)
	 */
	@Override
	public List<Discount> calculateDiscountFor(ShoppingCart sc, Discount discount) {
		int matchingItemsInCart = sc.getItemCountByName(discount.getItemName());
		int discountMultiplier = matchingItemsInCart / discount.getItemCount();
		List<Discount> discounts = new ArrayList<>();
		for (int i = 0; i < discountMultiplier; i++) {
			discounts.add(discount);
		}
		return discounts;
	}

}
