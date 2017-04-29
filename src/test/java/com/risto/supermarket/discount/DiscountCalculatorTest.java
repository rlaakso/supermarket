package com.risto.supermarket.discount;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.risto.supermarket.discount.api.Discount;
import com.risto.supermarket.discount.api.DiscountCalculatorService;
import com.risto.supermarket.discount.api.DiscountNotAvailableException;
import com.risto.supermarket.discount.api.InvalidDiscountException;
import com.risto.supermarket.discount.api.NotEmptyException;
import com.risto.supermarket.stock.api.ItemNotStockedException;
import com.risto.supermarket.stock.api.NonWeightableItemException;
import com.risto.supermarket.stock.api.UnsupportedUnitException;
import com.risto.supermarket.supermarket.AppInjector;
import com.risto.supermarket.supermarket.SupermarketTestHelper;
import com.risto.supermarket.supermarket.api.InvalidCurrencyException;
import com.risto.supermarket.supermarket.api.ShoppingCart;
import com.risto.supermarket.supermarket.api.Supermarket;

public class DiscountCalculatorTest {

	DiscountCalculatorService dcs;
	
	@Before
	public void setUp() throws Exception {
		dcs = AppInjector.getInstance().getInstance(DiscountCalculatorService.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanApplyTwoForOneDiscount() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException, DiscountNotAvailableException, InvalidCurrencyException, NotEmptyException {
		Supermarket s = SupermarketTestHelper.createSupermarket("ICA Maxi", "SEK");
		ShoppingCart sc = s.createShoppingCart();
		SupermarketTestHelper.populateCart(sc, s);

		
		List<Discount> discounts = dcs.calculateDiscountFor(sc, s.getDiscountByName("Beans 3 for 2"));
		int totalValue = discounts.stream().mapToInt(discount -> discount.getDiscountValue().getValue()).sum();
		assertEquals(50, totalValue);
	}
	
	@Test
	public void testCanApplyTwoForOnePoundDiscount() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException, DiscountNotAvailableException, InvalidCurrencyException, NotEmptyException {
		Supermarket s = SupermarketTestHelper.createSupermarket("ICA Maxi", "SEK");
		ShoppingCart sc = s.createShoppingCart();
		SupermarketTestHelper.populateCart(sc, s);

		List<Discount> discounts = dcs.calculateDiscountFor(sc, s.getDiscountByName("Coke 2 for £1"));
		int totalValue = discounts.stream().mapToInt(discount -> discount.getDiscountValue().getValue()).sum();
		assertEquals(40, totalValue);
	}
	
}
