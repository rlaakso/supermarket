package com.risto.supermarket.model.supermarket;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiscountCalculatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanApplyTwoForOneDiscount() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException, DiscountNotAvailableException, InvalidCurrencyException {
		Supermarket s = SupermarketTestHelper.createSupermarket();
		ShoppingCart sc = s.createShoppingCart();
		SupermarketTestHelper.populateCart(sc, s);

		List<Discount> discounts = DiscountCalculatorService.calculateDiscountFor(sc, s.getDiscountByName("Beans 3 for 2"));
		int totalValue = discounts.stream().mapToInt(discount -> discount.getDiscountValue().getValue()).sum();
		assertEquals(50, totalValue);
	}
	
	@Test
	public void testCanApplyTwoForOnePoundDiscount() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException, DiscountNotAvailableException, InvalidCurrencyException {
		Supermarket s = SupermarketTestHelper.createSupermarket();
		ShoppingCart sc = s.createShoppingCart();
		SupermarketTestHelper.populateCart(sc, s);

		List<Discount> discounts = DiscountCalculatorService.calculateDiscountFor(sc, s.getDiscountByName("Coke 2 for £1"));
		int totalValue = discounts.stream().mapToInt(discount -> discount.getDiscountValue().getValue()).sum();
		assertEquals(40, totalValue);
	}

}
