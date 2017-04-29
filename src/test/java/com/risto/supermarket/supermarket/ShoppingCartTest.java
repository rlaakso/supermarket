package com.risto.supermarket.supermarket;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.risto.supermarket.discount.api.DiscountRepository;
import com.risto.supermarket.discount.api.InvalidDiscountException;
import com.risto.supermarket.discount.api.NotEmptyException;
import com.risto.supermarket.stock.api.ItemNotStockedException;
import com.risto.supermarket.stock.api.Money;
import com.risto.supermarket.stock.api.NonWeightableItemException;
import com.risto.supermarket.stock.api.UnsupportedUnitException;
import com.risto.supermarket.supermarket.SupermarketImpl;
import com.risto.supermarket.supermarket.api.InvalidCurrencyException;
import com.risto.supermarket.supermarket.api.ShoppingCart;
import com.risto.supermarket.supermarket.api.Supermarket;

public class ShoppingCartTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCanConstructShoppingCart() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, InvalidCurrencyException, NotEmptyException {
		Supermarket s = SupermarketTestHelper.createSupermarket("ICA Maxi", "SEK");
		s.createShoppingCart();
	}
	
	private ShoppingCart createShoppingCart() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException, InvalidCurrencyException, NotEmptyException {
		Supermarket s = SupermarketTestHelper.createSupermarket("ICA Maxi", "SEK");
		
		ShoppingCart sc = s.createShoppingCart();
		SupermarketTestHelper.populateCart(sc, s);
		return sc;
	}
	
	private ShoppingCart createEmptyCart() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, InvalidCurrencyException, NotEmptyException {
		Supermarket s = SupermarketTestHelper.createSupermarket("ICA Maxi", "SEK");
		return s.createShoppingCart();
	}
	
	@Test
	public void testCanAddItemsToCart() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException, InvalidCurrencyException, NotEmptyException {		
		ShoppingCart sc = createShoppingCart();
		assertEquals(6, sc.getItemCount());
		assertEquals(3, sc.getItemCountByName("Beans"));
		assertEquals(2, sc.getItemCountByName("Coke"));
		assertEquals(1, sc.getItemCountByName("Oranges"));
	}
	
	@Test
	public void testCanGetCartSubTotal() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException, InvalidCurrencyException, NotEmptyException {		
		ShoppingCart sc = createShoppingCart();
		Money subTotal = sc.getSubTotal();
		assertEquals(330, subTotal.getValue());
	}

	@Test
	public void testSubTotalForEmptyCartIsZero() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, InvalidCurrencyException, NotEmptyException {
		ShoppingCart empty = createEmptyCart();
		assertEquals(0, empty.getSubTotal().getValue());
	}
	
	@Test
	public void testCanGetCartSavingsTotal() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException, InvalidCurrencyException, NotEmptyException {		
		ShoppingCart sc = createShoppingCart();
		Money savingsTotal = sc.getSavingsTotal();
		assertEquals(90, savingsTotal.getValue());
	}

	@Test
	public void testCanGetCartSavingsTotalForMultipleDiscounts() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException, InvalidCurrencyException, NotEmptyException {		
		ShoppingCart sc = createShoppingCart();
		// add more items
		SupermarketTestHelper.populateCart(sc, sc.getSupermarket());
		SupermarketTestHelper.populateCart(sc, sc.getSupermarket());
		// check total savings, should be multiple of 3
		Money savingsTotal = sc.getSavingsTotal();
		assertEquals(3*90, savingsTotal.getValue());
	}

	@Test
	public void testTotalSavingsForEmptyCartIsZero() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, InvalidCurrencyException, NotEmptyException {
		ShoppingCart empty = createEmptyCart();
		assertEquals(0, empty.getSavingsTotal().getValue());
	}

	@Test
	public void testTotalSavingsIsZeroWhenNoDiscountsExist() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, InvalidCurrencyException {
		Supermarket s = new SupermarketImpl("ICA Maxi", "SEK");
		DiscountRepository discounts = AppInjector.getInstance().getInstance(DiscountRepository.class);
		discounts.clear();
		ShoppingCart empty = s.createShoppingCart();
		assertEquals(0, empty.getSavingsTotal().getValue());
	}

	@Test
	public void testCanGetCartTotalToPay() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, NonWeightableItemException, InvalidCurrencyException, NotEmptyException {
		ShoppingCart sc = createShoppingCart();
		Money totalToPay = sc.getTotalToPay();
		assertEquals(240, totalToPay.getValue());	
	}

	@Test
	public void testTotalToPayForEmptyCartIsZero() throws UnsupportedUnitException, InvalidDiscountException, ItemNotStockedException, InvalidCurrencyException, NotEmptyException {
		ShoppingCart empty = createEmptyCart();
		assertEquals(0, empty.getTotalToPay().getValue());
	}
}
