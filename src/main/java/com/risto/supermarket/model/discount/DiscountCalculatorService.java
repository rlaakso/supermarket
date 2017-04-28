package com.risto.supermarket.model.discount;

import java.util.ArrayList;
import java.util.List;

import com.risto.supermarket.model.supermarket.ShoppingCart;

/**
 * Discount calculator service to calculate discounts for items in shopping cart
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public final class DiscountCalculatorService {

	private DiscountCalculatorService() { }
	
	/**
	 * Calculate total discounts for shopping cart for a single discount rule
	 * @param sc
	 * @param discount
	 * @return
	 */
	public static List<AbstractDiscount> calculateDiscountFor(ShoppingCart sc, AbstractDiscount discount) {
		int matchingItemsInCart = sc.getItemCountByName(discount.getItemName());
		int discountMultiplier = matchingItemsInCart / discount.getItemCount();
		List<AbstractDiscount> discounts = new ArrayList<>();
		for (int i = 0; i < discountMultiplier; i++) {
			discounts.add(discount);
		}
		return discounts;
	}

}
