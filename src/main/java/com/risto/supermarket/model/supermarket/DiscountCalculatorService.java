package com.risto.supermarket.model.supermarket;

import java.util.ArrayList;
import java.util.List;

/**
 * Discount calculator service to calculate discounts for items in shopping cart
 * @author Risto Laakso <risto.laakso@iki.fi>
 *
 */
public class DiscountCalculatorService {

	/**
	 * Calculate total discounts for shopping cart for a single discount rule
	 * @param sc
	 * @param discount
	 * @return
	 */
	public static List<Discount> calculateDiscountFor(ShoppingCart sc, Discount discount) {
		int matchingItemsInCart = sc.getItemCountByName(discount.getItemName());
		int discountMultiplier = matchingItemsInCart / discount.getItemCount();
		List<Discount> discounts = new ArrayList<>();
		for (int i = 0; i < discountMultiplier; i++) {
			discounts.add(discount);
		}
		return discounts;
	}

}
