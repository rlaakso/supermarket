package com.risto.supermarket.model.discount;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.risto.supermarket.model.discount.AbstractDiscount;
import com.risto.supermarket.model.discount.DiscountCalculatorService;
import com.risto.supermarket.model.discount.DiscountNotAvailableException;
import com.risto.supermarket.model.discount.InvalidDiscountException;
import com.risto.supermarket.model.stock.ItemNotStockedException;
import com.risto.supermarket.model.stock.NonWeightableItemException;
import com.risto.supermarket.model.stock.UnsupportedUnitException;
import com.risto.supermarket.model.supermarket.InvalidCurrencyException;
import com.risto.supermarket.model.supermarket.ShoppingCart;
import com.risto.supermarket.model.supermarket.Supermarket;
import com.risto.supermarket.model.supermarket.SupermarketTestHelper;

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

		List<AbstractDiscount> discounts = DiscountCalculatorService.calculateDiscountFor(sc, s.getDiscountByName("Beans 3 for 2"));
		int totalValue = discounts.stream().mapToInt(discount -> discount.getDiscountValue().getValue()).sum();
		assertEquals(50, totalValue);
	}
	
	@Test
	public void testCanApplyTwoForOnePoundDiscount() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException, DiscountNotAvailableException, InvalidCurrencyException {
		Supermarket s = SupermarketTestHelper.createSupermarket();
		ShoppingCart sc = s.createShoppingCart();
		SupermarketTestHelper.populateCart(sc, s);

		List<AbstractDiscount> discounts = DiscountCalculatorService.calculateDiscountFor(sc, s.getDiscountByName("Coke 2 for £1"));
		int totalValue = discounts.stream().mapToInt(discount -> discount.getDiscountValue().getValue()).sum();
		assertEquals(40, totalValue);
	}
	
	@Test
	public void testConstructorIsPrivate() throws NoSuchMethodException, IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
	  Constructor<DiscountCalculatorService> constructor = DiscountCalculatorService.class.getDeclaredConstructor();
	  assertTrue(Modifier.isPrivate(constructor.getModifiers()));
	  constructor.setAccessible(true);
	  constructor.newInstance();
	}

}
