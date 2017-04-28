package com.risto.supermarket.model.supermarket;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.risto.supermarket.model.discount.InvalidDiscountException;
import com.risto.supermarket.model.stock.ItemNotStockedException;
import com.risto.supermarket.model.stock.Money;
import com.risto.supermarket.model.stock.NonWeightableItemException;
import com.risto.supermarket.model.stock.UnsupportedUnitException;
import com.risto.supermarket.model.supermarket.ShoppingCart;
import com.risto.supermarket.model.supermarket.Supermarket;

public class ShoppingCartTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanConstructShoppingCart() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, InvalidCurrencyException {
		Supermarket s = SupermarketTestHelper.createSupermarket();
		s.createShoppingCart();
	}
	
	private ShoppingCart createShoppingCart() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException, InvalidCurrencyException {
		Supermarket s = SupermarketTestHelper.createSupermarket();
		
		ShoppingCart sc = s.createShoppingCart();
		SupermarketTestHelper.populateCart(sc, s);
		return sc;
	}
	
	private ShoppingCart createEmptyCart() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, InvalidCurrencyException {
		Supermarket s = SupermarketTestHelper.createSupermarket();
		return s.createShoppingCart();
	}
	
	@Test
	public void testCanAddItemsToCart() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException, InvalidCurrencyException {		
		ShoppingCart sc = createShoppingCart();
		assertEquals(6, sc.getItemCount());
		assertEquals(3, sc.getItemCountByName("Beans"));
		assertEquals(2, sc.getItemCountByName("Coke"));
		assertEquals(1, sc.getItemCountByName("Oranges"));
	}
	
	@Test
	public void testCanGetCartSubTotal() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException, InvalidCurrencyException {		
		ShoppingCart sc = createShoppingCart();
		Money subTotal = sc.getSubTotal();
		assertEquals(330, subTotal.getValue());
	}

	@Test
	public void testSubTotalForEmptyCartIsZero() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, InvalidCurrencyException {
		ShoppingCart empty = createEmptyCart();
		assertEquals(0, empty.getSubTotal().getValue());
	}
	
	@Test
	public void testCanGetCartSavingsTotal() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException, InvalidCurrencyException {		
		ShoppingCart sc = createShoppingCart();
		Money savingsTotal = sc.getSavingsTotal();
		assertEquals(90, savingsTotal.getValue());
	}

	@Test
	public void testCanGetCartSavingsTotalForMultipleDiscounts() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException, InvalidCurrencyException {		
		ShoppingCart sc = createShoppingCart();
		// add more items
		SupermarketTestHelper.populateCart(sc, sc.getSupermarket());
		SupermarketTestHelper.populateCart(sc, sc.getSupermarket());
		// check total savings, should be multiple of 3
		Money savingsTotal = sc.getSavingsTotal();
		assertEquals(3*90, savingsTotal.getValue());
	}

	@Test
	public void testTotalSavingsForEmptyCartIsZero() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, InvalidCurrencyException {
		ShoppingCart empty = createEmptyCart();
		assertEquals(0, empty.getSavingsTotal().getValue());
	}

	@Test
	public void testTotalSavingsIsZeroWhenNoDiscountsExist() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, InvalidCurrencyException {
		Supermarket s = new Supermarket("ICA Maxi", "SEK");
		ShoppingCart empty = s.createShoppingCart();
		assertEquals(0, empty.getSavingsTotal().getValue());
	}

	@Test
	public void testCanGetCartTotalToPay() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException, InvalidCurrencyException {
		ShoppingCart sc = createShoppingCart();
		Money totalToPay = sc.getTotalToPay();
		assertEquals(240, totalToPay.getValue());	
	}

	@Test
	public void testTotalToPayForEmptyCartIsZero() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, InvalidCurrencyException {
		ShoppingCart empty = createEmptyCart();
		assertEquals(0, empty.getTotalToPay().getValue());
	}
}
